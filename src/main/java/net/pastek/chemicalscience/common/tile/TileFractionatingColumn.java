package net.pastek.chemicalscience.common.tile;

import java.util.List;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.items.IItemHandler;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerFractionatingColumn;
import net.pastek.chemicalscience.common.recipe.categories.fluid2fluid.specificmachines.FractionatingColumnRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import org.jetbrains.annotations.Nullable;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

import voltaic.api.IWrenchItem;
import voltaic.api.electricity.ICapabilityElectrodynamic;
import voltaic.api.gas.IGasHandler;
import voltaic.api.multiblock.assemblybased.Multiblock;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.api.multiblock.assemblybased.TileMultiblockController;
import voltaic.api.multiblock.assemblybased.TileMultiblockSlave;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.common.network.utils.FluidUtilities;
import voltaic.common.network.utils.GasUtilities;
import voltaic.common.recipe.VoltaicRecipe;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.tile.components.*;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.tile.components.utils.IComponentFluidHandler;
import voltaic.prefab.tile.components.utils.IComponentGasHandler;
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
                .setOutputTanks(4, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY).setRecipeType(CSRecipies.FRACTIONATING_COLUMN_TYPE.get()));
        addComponent(new ComponentGasHandlerSimple(this, "", 5000, 1000, 10).setOutputDirections(BlockEntityUtils.MachineDirection.RIGHT));
        addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.fractionatingcolumn.tag(), this)
                .createMenu((id, player) -> new ContainerFractionatingColumn(id, player, getComponent(IComponentType.Inventory), getCoordsArray())));
        addComponent(new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().bucketInputs(1).bucketOutputs(4).gasOutputs(1)).valid(machineValidator()));
        addComponent(new ComponentProcessor(this).canProcess((component, procNumber) -> component.outputToFluidPipe().consumeBucket().dispenseBucket().canProcessFluidItem2FluidRecipe(procNumber, CSRecipies.FRACTIONATING_COLUMN_TYPE.get())).process(ComponentProcessor::processFluidItem2FluidRecipe));
    }


    public void tickClient(ComponentTickable tickable) {
        if (!this.<ComponentProcessor>getComponent(IComponentType.Processor).isActive(0)) {
            return;
        }

        if (level.random.nextDouble() < 0.15) {
            level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, worldPosition.getX() + level.random.nextDouble(), worldPosition.getY() + level.random.nextDouble() * 0.4 + 12, worldPosition.getZ() + 1, 0.0D, 0.0D, 0.0D);
        }

    }

    @Override
    public void tickServer(ComponentTickable tickable) {
        super.tickServer(tickable);

        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        ComponentElectrodynamic electro = getComponent(IComponentType.Electrodynamic);

        FluidUtilities.drainItem(this, fluidHandler.getInputTanks());
        FluidUtilities.fillItem(this, fluidHandler.getOutputTanks());
        GasUtilities.fillItem(this, gasHandler.getOutputTanks());

        outputToPipe();

        if (currRecipe == null) {
            for (RecipeHolder<FractionatingColumnRecipe> recipe : getLevel().getRecipeManager()
                    .getAllRecipesFor(CSRecipies.FRACTIONATING_COLUMN_TYPE.get())) {
                if (testRecipe(recipe.value(), fluidHandler.getInputTanks())) {
                    currRecipe = recipe.value();
                    break;
                }
            }
        } else if (!testRecipe(currRecipe, fluidHandler.getInputTanks())) {
            currRecipe = null;
        }

        if (currRecipe == null || electro.getJoulesStored() <= 0 || (!fluidHandler.getOutputTanks()[0].isEmpty()
                && !fluidHandler.getOutputTanks()[0].getFluid().is(currRecipe.getFluidRecipeOutput().getFluid()))) {
            operatingTicks.setValue(0.0);
            isActive.setValue(false);
            processAmount.setValue(0);
            neededTicks.setValue(0.0);
            return;
        }

        double energySatisfaction = electro.getJoulesStored()
                / 2;

        if (energySatisfaction < 1) {
            neededTicks.setValue(1.0 / energySatisfaction);
            processAmount.setValue(1);
        } else {
            neededTicks.setValue(0.0);
            operatingTicks.setValue(0.0);
            processAmount.setValue((int) energySatisfaction);
        }

        int room = fluidHandler.getOutputTanks()[0].getCapacity() - fluidHandler.getOutputTanks()[0].getFluidAmount();

        if (room <= 0) {
            isActive.setValue(false);
            return;
        }

        int amtToProcess = Math.min(room, processAmount.getValue());

        electro.setJoulesStored(0);

        isActive.setValue(true);

        if (neededTicks.getValue() > 0 && operatingTicks.getValue() < neededTicks.getValue()) {
            operatingTicks.setValue(operatingTicks.getValue() + 1.0);
            return;
        }

        operatingTicks.setValue(0.0);

        fluidHandler.getInputTanks()[0].drain(amtToProcess, IFluidHandler.FluidAction.EXECUTE);
        fluidHandler.getOutputTanks()[0].fill(
                new FluidStack(currRecipe.getFluidRecipeOutput().getFluidHolder(), amtToProcess),
                IFluidHandler.FluidAction.EXECUTE);
    }


    private static boolean testRecipe(FractionatingColumnRecipe recipe, FluidTank[] inputTanks) {
        Pair<List<Integer>, Boolean> pair = VoltaicRecipe.areFluidsValid(recipe.getFluidIngredients(), inputTanks);
        if (pair.getSecond()) { recipe.setFluidArrangement(pair.getFirst()); return true; }
        return false;
    }

    private void outputToPipe() {
        ComponentFluidHandlerMulti component = getComponent(IComponentType.FluidHandler);
        Direction[] outputDirections = component.outputDirections;
        Direction facing = getFacing();
        for (Direction relative : outputDirections) {
            Direction dir = BlockEntityUtils.getRelativeSide(facing, relative);
            BlockEntity faceTile = getLevel().getBlockEntity(getBlockPos().relative(dir).offset(2,0,2));
            if (faceTile==null) continue;
            IFluidHandler handler = getLevel().getCapability(Capabilities.FluidHandler.BLOCK, faceTile.getBlockPos(), faceTile.getBlockState(), faceTile, dir.getOpposite());
            if (handler==null) continue;
            for (FluidTank tank : component.getOutputTanks()) {
                FluidStack f = tank.getFluid();
                int accepted = handler.fill(f, IFluidHandler.FluidAction.EXECUTE);
                tank.drain(new FluidStack(f.getFluid(), accepted), IFluidHandler.FluidAction.EXECUTE);
            }
        }
    }

    @Override public @Nullable IFluidHandler getFluidHandlerCapability(@Nullable Direction side){ return null; }
    @Nullable @Override public IFluidHandler getSlaveFluidHandlerCapability(TileMultiblockSlave slave, @Nullable Direction side) {if (slave.index.getValue() != 12 && slave.index.getValue() != 29 && slave.index.getValue() != 47 && slave.index.getValue() != 65 && slave.index.getValue() != 83) {return null;}return this.<IComponentFluidHandler>getComponent(IComponentType.FluidHandler).getCapability(side, CapabilityInputType.NONE);}
    @Override public @Nullable IGasHandler getGasHandlerCapability(@Nullable Direction side){ return null; }
    @Nullable @Override public IGasHandler getSlaveGasHandlerCapability(TileMultiblockSlave slave, @Nullable Direction side) {if (slave.index.getValue() != 101) {return null;}return this.<IComponentGasHandler>getComponent(IComponentType.GasHandler).getCapability(side, CapabilityInputType.NONE);}
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
