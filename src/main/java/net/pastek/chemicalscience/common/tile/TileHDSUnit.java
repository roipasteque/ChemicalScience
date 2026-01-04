package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.inventory.container.ContainerHDSUnit;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.GasFluidItem2FluidRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.gas.GasAction;
import voltaic.api.gas.GasTank;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.types.GenericGasTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;


public class TileHDSUnit extends GenericGasTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileHDSUnit(BlockPos worldPosition, BlockState blockState) {
        super((BlockEntityType) CSTiles.TILE_HDS_UNIT.get(), worldPosition, blockState);
        addComponent(new ComponentPacketHandler(this));
        addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new MachineDirection[]{MachineDirection.BOTTOM}).voltage((double)480.0F));
        addComponent((new ComponentFluidHandlerMulti(this))
                .setInputTanks(1, new int[]{5000}).setInputDirections(new MachineDirection[]{MachineDirection.LEFT})
                .setOutputTanks(1, new int[]{5000}).setOutputDirections(new MachineDirection[]{MachineDirection.RIGHT})
                .setRecipeType((RecipeType) CSRecipies.HDS_UNIT_TYPE.get()));
        addComponent((new ComponentGasHandlerMulti(this))
                .setInputTanks(1, new int[]{5000}, new int[]{1000}, new int[]{1024}).setInputDirections(new MachineDirection[]{MachineDirection.FRONT})
                .setOutputTanks(1, new int[]{5000}, new int[]{1000}, new int[]{1024}).setOutputDirections(new MachineDirection[]{MachineDirection.BACK})
                .setCondensedHandler(getCondensedHandler()));
        addComponent((new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 1, 0, 0).bucketInputs(1).gasInputs(1).upgrades(3))).setDirectionsBySlot(0, MachineDirection.TOP).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES).valid(machineValidator()));
        addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.hdsunit.tag(), this)).createMenu((id, player) -> new ContainerHDSUnit(id, player, (Container)this.getComponent(IComponentType.Inventory), this.getCoordsArray())));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcess).process(this::process));
    }

    protected void tickClient(ComponentTickable tickable) {
        if (this.shouldPlaySound()) {
            if (this.level.random.nextDouble() < 0.15) {
                Direction direction = this.getFacing();
                double d4 = this.level.random.nextDouble();
                double d5 = direction.getAxis() == Direction.Axis.X ? (double)(direction.getStepX() * (direction.getStepX() == -1 ? 0 : 1)) : d4;
                double d6 = this.level.random.nextDouble();
                double d7 = direction.getAxis() == Direction.Axis.Z ? (double)(direction.getStepZ() * (direction.getStepZ() == -1 ? 0 : 1)) : d4;
                this.level.addParticle(ParticleTypes.SMOKE, (double)this.worldPosition.getX() + d5, (double)this.worldPosition.getY() + d6, (double)this.worldPosition.getZ() + d7, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            if (!this.isSoundPlaying) {
                this.isSoundPlaying = true;
                SoundBarrierMethods.playTileSound((SoundEvent)ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
            }

        }
    }

    private boolean canProcess(ComponentProcessor pr, int procNumber) {
        pr.consumeBucket().consumeGasCylinder().dispenseGasCylinder().dispenseBucket().outputToGasPipe().outputToFluidPipe();
        GasFluidItem2FluidRecipe locRecipe;
        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);
            locRecipe = (GasFluidItem2FluidRecipe) pr.getRecipe(CSRecipies.HDS_UNIT_TYPE.get(), procNumber);
            if (locRecipe == null) return false;
        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (GasFluidItem2FluidRecipe) pr.getRecipe(procNumber);
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
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        GasTank inGasTank = gasHandler.getInputTanks()[0];
        if (inGasTank.getGasAmount() < locRecipe.getGasIngredients().get(0).getGasStack().getAmount()) {
            return false;
        }



        if (locRecipe.hasGasBiproducts()) {
            GasTank[] biGasTanksOnly = java.util.Arrays.copyOfRange(outGasTanks, 1, outGasTanks.length);
            if (!ComponentProcessor.roomInBiproductGasTanks(biGasTanksOnly, locRecipe.getFullGasBiStacks())) {
                return false;
            }
        }

        return true;
    }

    private void process(ComponentProcessor pr, int procNumber) {
        if (pr.getRecipe(procNumber) == null) return;

        GasFluidItem2FluidRecipe locRecipe = (GasFluidItem2FluidRecipe) pr.getRecipe(procNumber);
        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        FluidTank[] outTanks = fluidHandler.getOutputTanks();
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        outTanks[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.EXECUTE);
        outGasTanks[0].fill(locRecipe.getGasBiproducts().getFirst().roll(), GasAction.EXECUTE);


        fluidHandler.getInputTanks()[0].drain(
                locRecipe.getFluidIngredients().getFirst().getFluidStack().getAmount(),
                IFluidHandler.FluidAction.EXECUTE
        );

        gasHandler.getInputTanks()[0].drain(
                locRecipe.getGasIngredients().getFirst().getGasStack().getAmount(),
                GasAction.EXECUTE
        );

        pr.setChanged();
    }



    public void setNotPlaying() {
        this.isSoundPlaying = false;
    }

    public boolean shouldPlaySound() {
        return ((ComponentProcessor)this.getComponent(IComponentType.Processor)).isActive(0);
    }

    public int getComparatorSignal() {
        return ((ComponentProcessor)this.getComponent(IComponentType.Processor)).isActive(0) ? 15 : 0;
    }
}
