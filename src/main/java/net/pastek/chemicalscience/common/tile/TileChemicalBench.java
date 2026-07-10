package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerChemicalBench;
import net.pastek.chemicalscience.common.recipe.CSCountableIngredient;
import net.pastek.chemicalscience.common.recipe.categories.misc.ChemicalBenchRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import org.jetbrains.annotations.Nullable;
import voltaic.api.IWrenchItem;
import voltaic.api.electricity.ICapabilityElectrodynamic;
import voltaic.api.gas.GasAction;
import voltaic.api.gas.GasStack;
import voltaic.api.gas.GasTank;
import voltaic.api.multiblock.assemblybased.Multiblock;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.api.multiblock.assemblybased.TileMultiblockController;
import voltaic.api.multiblock.assemblybased.TileMultiblockSlave;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.common.network.utils.FluidUtilities;
import voltaic.common.network.utils.GasUtilities;
import voltaic.common.recipe.recipeutils.*;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.GenericTile;
import voltaic.prefab.tile.components.CapabilityInputType;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.utilities.BlockEntityUtils;
import voltaic.registers.VoltaicCapabilities;

import java.util.List;
import java.util.function.BiConsumer;

public class TileChemicalBench extends TileMultiblockController implements ITickableSound {
    public static final ResourceLocation ID = ChemicalScience.rl("chemicalbench");
    public static final ResourceKey<Multiblock> RESOURCE_KEY = Multiblock.makeKey(ID);
    public static final int GAS_TANK_CAPACITY = 5000, FLUID_TANK_CAPACITY = 5000;
    public final SingleProperty<FluidStack> condensedFluidFromGas;

    private boolean isSoundPlaying = false;
    public final SingleProperty<Double> operatingTicks = property(new SingleProperty<>(PropertyTypes.DOUBLE, "operatingticks", 0.0));
    public final SingleProperty<Boolean> isActive = property(new SingleProperty<>(PropertyTypes.BOOLEAN, "isactive", false));

    public TileChemicalBench(BlockPos pos, BlockState state) {
        super(CSTiles.TILE_CHEMICAL_BENCH.get(), pos, state);
        addComponent(new ComponentElectrodynamic(this, false, true).setInputDirections(BlockEntityUtils.MachineDirection.BOTTOM).voltage(VoltaicCapabilities.DEFAULT_VOLTAGE*2));
        addComponent(new ComponentFluidHandlerMulti(this).setInputDirections(BlockEntityUtils.MachineDirection.RIGHT)
                .setInputTanks(4, FLUID_TANK_CAPACITY, FLUID_TANK_CAPACITY, FLUID_TANK_CAPACITY, FLUID_TANK_CAPACITY)
                .setOutputTanks(4, FLUID_TANK_CAPACITY, FLUID_TANK_CAPACITY, FLUID_TANK_CAPACITY, FLUID_TANK_CAPACITY)
                .setRecipeType(CSRecipies.CHEMICAL_BENCH_TYPE.get()));
        addComponent(new ComponentGasHandlerMulti(this).setInputDirections(BlockEntityUtils.MachineDirection.RIGHT)
                .setInputTanks(4, new int[]{GAS_TANK_CAPACITY, GAS_TANK_CAPACITY, GAS_TANK_CAPACITY, GAS_TANK_CAPACITY}, new int[]{1000, 1000, 1000, 1000}, new int[]{1024, 1024, 1024, 1024})
                .setOutputTanks(4, new int[]{GAS_TANK_CAPACITY, GAS_TANK_CAPACITY, GAS_TANK_CAPACITY, GAS_TANK_CAPACITY}, new int[]{1000, 1000, 1000, 1000}, new int[]{1024, 1024, 1024, 1024})
                .setCondensedHandler(getCondensedHandler()));
        addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.chemicalbench.tag(), this).createMenu((id, player) -> new ContainerChemicalBench(id, player, getComponent(IComponentType.Inventory), getCoordsArray())));
        addComponent(new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().processors(1, 6, 1, 5).bucketInputs(4).bucketOutputs(4).gasInputs(4).gasOutputs(4).upgrades(3)).validUpgrades(ContainerChemicalBench.VALID_UPGRADES).valid(machineValidator()));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcessChemicalBench).process(this::process));
        condensedFluidFromGas = (SingleProperty)this.property(new SingleProperty(PropertyTypes.FLUID_STACK, "condensedfluidfromgas", FluidStack.EMPTY));
    }

    public boolean canProcessChemicalBench(ComponentProcessor pr, int procNumber) {
        boolean canProcess = canProcess(pr,procNumber);
        if (BlockEntityUtils.isLit(this) ^ canProcess) {
            BlockEntityUtils.updateLit(this, canProcess);
        }

        return canProcess;
    }

    private boolean canProcess(ComponentProcessor pr, int procNumber) {
        ChemicalBenchRecipe locRecipe;

        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);

            locRecipe = (ChemicalBenchRecipe) pr.getRecipe(CSRecipies.CHEMICAL_BENCH_TYPE.get(), procNumber);
            if (locRecipe == null) return false;

            pr.setRecipe(locRecipe, procNumber);
            pr.requiredTicks.setValue((double) locRecipe.getTicks(), procNumber);
            pr.usage.setValue(locRecipe.getUsagePerTick(), procNumber);

        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (ChemicalBenchRecipe) pr.getRecipe(procNumber);
        }

        ComponentElectrodynamic electro = getComponent(IComponentType.Electrodynamic);
        if (electro.getJoulesStored() < pr.getUsage(procNumber)) return false;

        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        List<FluidIngredient> fluidInputs = locRecipe.getFluidIngredients();
        for (int i = 0; i < fluidInputs.size(); i++) {
            if (fluidHandler.getInputTanks()[i].getFluidAmount() < fluidInputs.get(i).getFluidStack().getAmount()) {
                return false;
            }
        }

        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        List<GasIngredient> gasInputs = locRecipe.getGasIngredients();
        for (int i = 0; i < gasInputs.size(); i++) {
            if (gasHandler.getInputTanks()[i].getGasAmount() < gasInputs.get(i).getGasStack().getAmount()) {
                return false;
            }
        }

        if (!locRecipe.getFluidRecipeOutput().isEmpty()) {
            if (fluidHandler.getOutputTanks()[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.SIMULATE) < locRecipe.getFluidRecipeOutput().getAmount()) {
                return false;
            }
        }

        if (!locRecipe.getGasRecipeOutput().isEmpty()) {
            if (gasHandler.getOutputTanks()[0].fill(locRecipe.getGasRecipeOutput(), GasAction.SIMULATE) < locRecipe.getGasRecipeOutput().getAmount()) {
                return false;
            }
        }

        if (locRecipe.hasFluidBiproducts()) {
            FluidTank[] biFluidTanks = java.util.Arrays.copyOfRange(fluidHandler.getOutputTanks(), 1, fluidHandler.getOutputTanks().length);
            if (!ComponentProcessor.roomInBiproductFluidTanks(biFluidTanks, locRecipe.getFullFluidBiStacks())) {
                return false;
            }
        }

        if (locRecipe.hasGasBiproducts()) {
            GasTank[] biGasTanks = java.util.Arrays.copyOfRange(gasHandler.getOutputTanks(), 1, gasHandler.getOutputTanks().length);
            if (!ComponentProcessor.roomInBiproductGasTanks(biGasTanks, locRecipe.getFullGasBiStacks())) {
                return false;
            }
        }

        return true;
    }

    private void process(ComponentProcessor pr, int procNumber) {
        if (pr.getRecipe(procNumber) == null) {
            return;
        }
        ChemicalBenchRecipe locRecipe = (ChemicalBenchRecipe) pr.getRecipe(procNumber);

        ComponentInventory inv = getComponent(IComponentType.Inventory);
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);

        if (locRecipe.hasItemBiproducts()) {
            List<ProbableItem> itemBi = locRecipe.getItemBiproducts();
            int index = 0;
            for (int slot : inv.getBiprodSlotsForProcessor(procNumber)) {
                ItemStack rolledStack = itemBi.get(index).roll().copy();
                if (!rolledStack.isEmpty()) {
                    ItemStack currentStack = inv.getItem(slot);
                    if (currentStack.isEmpty()) {
                        inv.setItem(slot, rolledStack);
                    } else if (ItemStack.isSameItemSameComponents(currentStack, rolledStack)) {
                        currentStack.grow(rolledStack.getCount());
                        inv.setItem(slot, currentStack);
                    }
                }
                index++;
                if (index >= itemBi.size()) break;
            }
        }

        if (locRecipe.hasFluidBiproducts()) {
            List<ProbableFluid> fluidBi = locRecipe.getFluidBiproducts();
            FluidTank[] outTanks = fluidHandler.getOutputTanks();
            for (int i = 0; i < fluidBi.size(); i++) {
                outTanks[i + 1].fill(fluidBi.get(i).roll(), IFluidHandler.FluidAction.EXECUTE);
            }
        }

        if (locRecipe.hasGasBiproducts()) {
            List<ProbableGas> gasBi = locRecipe.getGasBiproducts();
            GasTank[] outTanks = gasHandler.getOutputTanks();
            for (int i = 0; i < gasBi.size(); i++) {
                outTanks[i + 1].fill(gasBi.get(i).roll(), GasAction.EXECUTE);
            }
        }

        if (locRecipe.hasItemOutput()) {
            int outputSlot = inv.getOutputSlots().get(procNumber);
            ItemStack outputStack = locRecipe.getItemRecipeOutput().copy();
            if (inv.getItem(outputSlot).isEmpty()) {
                inv.setItem(outputSlot, outputStack);
            } else {
                inv.getItem(outputSlot).grow(outputStack.getCount());
            }
        }

        if (locRecipe.hasFluidOutput()) {
            fluidHandler.getOutputTanks()[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.EXECUTE);
        }

        if (locRecipe.hasGasOutput()) {
            gasHandler.getOutputTanks()[0].fill(locRecipe.getGasRecipeOutput(), GasAction.EXECUTE);
        }

        if (locRecipe.hasItemInputs()) {
            List<Integer> inputSlots = inv.getInputSlotsForProcessor(procNumber);
            List<CSCountableIngredient> recipeIngs = locRecipe.getCountedIngredients();

            for (CSCountableIngredient wrap : recipeIngs) {
                if (!wrap.isCatalyst()) {
                    int amountToConsume = wrap.ingredient().getStackSize();
                    for (int slotIndex : inputSlots) {
                        ItemStack stackInSlot = inv.getItem(slotIndex);
                        if (!stackInSlot.isEmpty() && wrap.ingredient().test(stackInSlot)) {
                            stackInSlot.shrink(amountToConsume);
                            inv.setItem(slotIndex, stackInSlot);
                            break;
                        }
                    }
                }
            }
        }

        if (locRecipe.hasFluidInputs()) {
            FluidTank[] tanks = fluidHandler.getInputTanks();
            List<FluidIngredient> fluidIngs = locRecipe.getFluidIngredients();
            List<Integer> tankOrientation = locRecipe.getFluidArrangement();
            for (int i = 0; i < tankOrientation.size(); i++) {
                tanks[tankOrientation.get(i)].drain(fluidIngs.get(i).getFluidStack().getAmount(), IFluidHandler.FluidAction.EXECUTE);
            }
        }

        if (locRecipe.hasGasInputs()) {
            GasTank[] tanks = gasHandler.getInputTanks();
            List<GasIngredient> gasIngs = locRecipe.getGasIngredients();
            List<Integer> tankOrientation = locRecipe.getGasArrangement();
            for (int i = 0; i < tankOrientation.size(); i++) {
                tanks[tankOrientation.get(i)].drain(gasIngs.get(i).getGasStack().getAmount(), GasAction.EXECUTE);
            }
        }

        pr.dispenseExperience(inv, locRecipe.getXp());
        pr.setChanged();
    }

    @Override
    public void tickServer(ComponentTickable tickable) {
        super.tickServer(tickable);
        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);

        FluidUtilities.drainItem(this, fluidHandler.getInputTanks());
        FluidUtilities.fillItem(this, fluidHandler.getOutputTanks());
        GasUtilities.drainItem(this, gasHandler.getInputTanks());
        GasUtilities.fillItem(this, gasHandler.getOutputTanks());
    }

    public BiConsumer<GasTank, GenericTile> getCondensedHandler() {
        return (tank, tile) -> {
            GasStack tankGas = tank.getGas().copy();
            tank.setGas(GasStack.EMPTY);
            if (!tankGas.isEmpty()) {
                Fluid condensedFluid = tankGas.getGas().getCondensedFluid();
                if (!condensedFluid.isSame(Fluids.EMPTY)) {
                    tankGas.bringPressureTo(1);
                    FluidStack currentCondensate = (FluidStack)this.condensedFluidFromGas.getValue();
                    if (currentCondensate.getFluid().isSame(condensedFluid)) {
                        int room = Math.max(0, 10000 - currentCondensate.getAmount());
                        int taken = Math.min(room, tankGas.getAmount());
                        currentCondensate.setAmount(currentCondensate.getAmount() + taken);
                        this.condensedFluidFromGas.setValue(currentCondensate);
                    } else {
                        FluidStack newFluid = new FluidStack(condensedFluid, Math.min(tankGas.getAmount(), 10000));
                        this.condensedFluidFromGas.setValue(newFluid);
                    }

                }
            }
        };
    }

    public void tickClient(ComponentTickable tickable) {
        if (this.shouldPlaySound()) {

            if (!this.isSoundPlaying) {
                this.isSoundPlaying = true;
                SoundBarrierMethods.playTileSound((SoundEvent) ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
            }

        }
    }

    public void setNotPlaying() {
        this.isSoundPlaying = false;
    }

    public boolean shouldPlaySound() {
        return ((ComponentProcessor)this.getComponent(IComponentType.Processor)).isActive(0);
    }

    @Override public @Nullable IFluidHandler getFluidHandlerCapability(@Nullable Direction side){ return null; }
    @Override public @Nullable ICapabilityElectrodynamic getElectrodynamicCapability(@Nullable Direction side){ return null; }
    @Nullable @Override public ICapabilityElectrodynamic getSlaveCapabilityElectrodynamic(TileMultiblockSlave slave, @Nullable Direction side) {if (slave.index.getValue() != 1) {return null;}return this.<ComponentElectrodynamic>getComponent(IComponentType.Electrodynamic).getCapability(side, CapabilityInputType.NONE);}
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
