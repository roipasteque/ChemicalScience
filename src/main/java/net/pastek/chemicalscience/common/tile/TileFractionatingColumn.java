package net.pastek.chemicalscience.common.tile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerFractionatingColumn;
import net.pastek.chemicalscience.common.recipe.categories.fluid2fluid.specificmachines.FractionatingColumnRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

import voltaic.api.IWrenchItem;
import voltaic.api.electricity.ICapabilityElectrodynamic;
import voltaic.api.multiblock.assemblybased.Multiblock;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.api.multiblock.assemblybased.TileMultiblockController;
import voltaic.api.multiblock.assemblybased.TileMultiblockSlave;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.common.network.utils.FluidUtilities;
import voltaic.common.recipe.categories.fluid2fluid.Fluid2FluidRecipe;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.tile.components.*;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.tile.components.utils.IComponentFluidHandler;
import voltaic.prefab.utilities.BlockEntityUtils;
import voltaic.registers.VoltaicCapabilities;

public class TileFractionatingColumn extends TileMultiblockController {
    public static final ResourceLocation ID = ChemicalScience.rl("fractionatingcolumn");
    public static final ResourceKey<Multiblock> RESOURCE_KEY = Multiblock.makeKey(ID);
    public static final int MAX_INPUT_TANK_CAPACITY = 5000, MAX_OUTPUT_TANK_CAPACITY = 5000;

    public final SingleProperty<Integer> processAmount = property(new SingleProperty<>(PropertyTypes.INTEGER, "processamount", 0));
    public final SingleProperty<Double> operatingTicks = property(new SingleProperty<>(PropertyTypes.DOUBLE, "operatingticks", 0.0));
    public final SingleProperty<Double> neededTicks = property(new SingleProperty<>(PropertyTypes.DOUBLE, "neededticks", 0.0));
    public final SingleProperty<Boolean> isActive = property(new SingleProperty<>(PropertyTypes.BOOLEAN, "isactive", false));

    private @Nullable FractionatingColumnRecipe currRecipe = null;

    public TileFractionatingColumn(BlockPos pos, BlockState state) {
        super(CSTiles.TILE_FRACTIONATING_COLUMN.get(), pos, state);
        addComponent(new ComponentElectrodynamic(this, false, true).setInputDirections(BlockEntityUtils.MachineDirection.BACK).voltage(VoltaicCapabilities.DEFAULT_VOLTAGE*4));
        addComponent(new ComponentFluidHandlerMulti(this).setInputDirections(BlockEntityUtils.MachineDirection.RIGHT)
                .setInputTanks(1, arr(MAX_INPUT_TANK_CAPACITY)).setOutputDirections(BlockEntityUtils.MachineDirection.LEFT)
                .setOutputTanks(5, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY).setRecipeType(CSRecipies.FRACTIONATING_COLUMN_TYPE.get()));
        addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.fractionatingcolumn.tag(), this).createMenu((id, player) -> new ContainerFractionatingColumn(id, player, getComponent(IComponentType.Inventory), getCoordsArray())));
        addComponent(new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().bucketInputs(1).bucketOutputs(5).upgrades(3)).validUpgrades(ContainerFractionatingColumn.VALID_UPGRADES).valid(machineValidator()));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcess).process(this::process));
    }

    private boolean canProcess(ComponentProcessor pr, int procNumber) {
        outputToPipe();
        Fluid2FluidRecipe locRecipe;
        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);
            locRecipe = (Fluid2FluidRecipe) pr.getRecipe(CSRecipies.FRACTIONATING_COLUMN_TYPE.get(), procNumber);
            if (locRecipe == null) return false;
        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (Fluid2FluidRecipe) pr.getRecipe(procNumber);
        }

        pr.setRecipe(locRecipe, procNumber);
        pr.requiredTicks.setValue((double) locRecipe.getTicks(), procNumber);
        pr.usage.setValue(locRecipe.getUsagePerTick(), procNumber);

        ComponentElectrodynamic electro = getComponent(IComponentType.Electrodynamic);
        if (electro.getJoulesStored() < pr.getUsage(procNumber)) return false;

        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        FluidTank[] outTanks = fluidHandler.getOutputTanks();

        FluidTank inTank = fluidHandler.getInputTanks()[0];
        if (inTank.getFluidAmount() < locRecipe.getFluidIngredients().get(0).getFluidStack().getAmount()) {
            return false;
        }

        if (outTanks[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.SIMULATE)
                < locRecipe.getFluidRecipeOutput().getAmount()) {
            return false;
        }

        if (locRecipe.hasFluidBiproducts()) {
            FluidTank[] biTanksOnly = java.util.Arrays.copyOfRange(outTanks, 1, outTanks.length);
            if (!ComponentProcessor.roomInBiproductFluidTanks(biTanksOnly, locRecipe.getFullFluidBiStacks())) {
                return false;
            }
        }

        return true;
    }

    private void process(ComponentProcessor pr, int procNumber) {
        if (pr.getRecipe(procNumber) == null) return;

        Fluid2FluidRecipe locRecipe = (Fluid2FluidRecipe) pr.getRecipe(procNumber);
        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        FluidTank[] outTanks = fluidHandler.getOutputTanks();

        outTanks[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.EXECUTE);

        if (locRecipe.hasFluidBiproducts()) {
            List<ProbableFluid> fluidBi = locRecipe.getFluidBiproducts();
            for (int i = 0; i < fluidBi.size(); i++) {
                outTanks[i + 1].fill(fluidBi.get(i).roll(), IFluidHandler.FluidAction.EXECUTE);
            }
        }

        fluidHandler.getInputTanks()[0].drain(
                locRecipe.getFluidIngredients().getFirst().getFluidStack().getAmount(),
                IFluidHandler.FluidAction.EXECUTE
        );

        pr.setChanged();
    }

    @Override
    public void tickServer(ComponentTickable tickable) {
        super.tickServer(tickable);

        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);

        FluidUtilities.drainItem(this, fluidHandler.getInputTanks());
        FluidUtilities.fillItem(this, fluidHandler.getOutputTanks());
    }

    private void outputToPipe() {
        ComponentFluidHandlerMulti component = getComponent(IComponentType.FluidHandler);
        Direction facing = getFacing();

        Direction[] outputDirections = component.outputDirections;
        int[] yOffsets = {2, 4, 6, 8, 10};
        FluidTank[] tanks = component.getOutputTanks();

        for (Direction relative : outputDirections) {
            Direction direction = BlockEntityUtils.getRelativeSide(facing, relative);

            for (int tankIndex = 0; tankIndex < yOffsets.length; tankIndex++) {
                if (tankIndex >= tanks.length) break;

                Vec3 offset = getOffset(facing);
                BlockPos pipePos = getBlockPos().relative(direction).offset((int)offset.x, yOffsets[tankIndex], (int)offset.z);
                BlockEntity faceTile = getLevel().getBlockEntity(pipePos);

                if (faceTile == null) continue;

                IFluidHandler handler = getLevel().getCapability(
                        Capabilities.FluidHandler.BLOCK,
                        faceTile.getBlockPos(),
                        faceTile.getBlockState(),
                        faceTile,
                        direction.getOpposite()
                );

                if (handler == null) continue;

                FluidTank fluidTank = tanks[tankIndex];
                FluidStack tankFluid = fluidTank.getFluid();

                if (!tankFluid.isEmpty()) {
                    int amtAccepted = handler.fill(tankFluid, IFluidHandler.FluidAction.EXECUTE);
                    FluidStack taken = new FluidStack(tankFluid.getFluid(), amtAccepted);
                    fluidTank.drain(taken, IFluidHandler.FluidAction.EXECUTE);
                }
            }
        }
    }

    private static Vec3 getOffset(Direction facing) {
        return switch (facing) {
            case SOUTH -> new Vec3( 1, 0, -1);
            case WEST  -> new Vec3( 1, 0,  1);
            case EAST  -> new Vec3( -1, 0, -1);
            case NORTH -> new Vec3( -1, 0,  1);
            default -> Vec3.ZERO;
        };
    }

    @Override public @Nullable IFluidHandler getFluidHandlerCapability(@Nullable Direction side){ return null; }
    @Nullable @Override public IFluidHandler getSlaveFluidHandlerCapability(TileMultiblockSlave slave, @Nullable Direction side) {if (slave.index.getValue() != 12 && slave.index.getValue() != 29 && slave.index.getValue() != 47 && slave.index.getValue() != 65 && slave.index.getValue() != 83 && slave.index.getValue() != 101) {return null;}return this.<IComponentFluidHandler>getComponent(IComponentType.FluidHandler).getCapability(side, CapabilityInputType.NONE);}
    @Override public @Nullable ICapabilityElectrodynamic getElectrodynamicCapability(@Nullable Direction side){ return null; }
    @Nullable @Override public ICapabilityElectrodynamic getSlaveCapabilityElectrodynamic(TileMultiblockSlave slave, @Nullable Direction side) {if (slave.index.getValue() != 8) {return null;}return this.<ComponentElectrodynamic>getComponent(IComponentType.Electrodynamic).getCapability(side, CapabilityInputType.NONE);}
    @Override public @Nullable IItemHandler getItemHandlerCapability(@Nullable Direction side){ return null; }

    @Override
    public ItemInteractionResult useWithItem(ItemStack used, Player player, InteractionHand hand, BlockHitResult hit) {
        if(!level.isClientSide() && hit.getBlockPos().equals(getBlockPos()) && used.getItem() instanceof IWrenchItem){
            checkFormed();
            if(isFormed.getValue()) formMultiblock(); else destroyMultiblock();
            return ItemInteractionResult.CONSUME;
        }
        return super.useWithItem(used, player, hand, hit);
    }

    @Override
    public InteractionResult useWithoutItem(Player player, BlockHitResult hit){ return isFormed.getValue() ? super.useWithoutItem(player, hit) : InteractionResult.FAIL; }

    @Override
    public void formMultiblock() {
        Direction facing = this.getFacing().getOpposite();
        List<MultiblockSlaveNode> nodes = Multiblock.getNodes(this.level, this.getResourceKey(), facing);
        int index = 0;

        for (MultiblockSlaveNode node : nodes) {
            BlockPos nodePos = this.getBlockPos().offset(node.offset());
            this.slavePositions.addValue(nodePos, index);

            BlockState placedState = node.placeState().setValue(VoltaicBlockStates.FACING, this.getFacing());
            this.level.setBlockAndUpdate(nodePos, placedState);

            TileMultiblockSlave slave = (TileMultiblockSlave) this.level.getBlockEntity(nodePos);
            if (slave != null) {
                BlockState disguise = node.replaceState();
                if (disguise != null) {
                    slave.setDisguise(disguise);
                } else {
                    slave.setDisguise(Blocks.AIR.defaultBlockState());
                }

                slave.controller.setValue(this.getBlockPos());
                slave.index.setValue(index);
                slave.renderModel.setValue(node.model());
                this.slaveList.add(slave);
            } else {
                ChemicalScience.LOGGER.warn("Failed to get TileMultiblockSlave at {}", nodePos);
            }

            ++index;
        }

        this.level.playSound((Player) null, this.getBlockPos(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }



    @Override public ResourceLocation getMultiblockId(){ return ID; }
    @Override public ResourceKey<Multiblock> getResourceKey(){ return RESOURCE_KEY; }
}
