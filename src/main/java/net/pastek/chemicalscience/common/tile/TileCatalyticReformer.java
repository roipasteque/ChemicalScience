package net.pastek.chemicalscience.common.tile;

import com.llamalad7.mixinextras.lib.apache.commons.ObjectUtils;
import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCatalyticReformer;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.gas.GasAction;
import voltaic.api.gas.GasStack;
import voltaic.api.gas.GasTank;
import voltaic.common.recipe.categories.fluiditem2fluid.FluidItem2FluidRecipe;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipe;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.types.GenericGasTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;

import java.util.List;

public class TileCatalyticReformer extends GenericGasTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileCatalyticReformer(BlockPos worldPosition, BlockState blockState) {
        super((BlockEntityType) CSTiles.TILE_CATALYTIC_REFORMER.get(), worldPosition, blockState);
        addComponent(new ComponentPacketHandler(this));
        addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new MachineDirection[]{MachineDirection.BOTTOM}).voltage((double)480.0F));
        addComponent((new ComponentFluidHandlerMulti(this))
                .setInputTanks(1, MAX_TANK_CAPACITY).setInputDirections(new MachineDirection[]{MachineDirection.RIGHT})
                .setOutputTanks(2, MAX_TANK_CAPACITY, MAX_TANK_CAPACITY).setOutputDirections(new MachineDirection[]{MachineDirection.LEFT})
                .setRecipeType((RecipeType) CSRecipies.CATALYTIC_REFORMER_TYPE.get()));
        addComponent((new ComponentGasHandlerMulti(this))
                .setOutputTanks(1, new int[]{5000}, new int[]{1000}, new int[]{1024}).setOutputDirections(new MachineDirection[]{MachineDirection.TOP})
                .setCondensedHandler(getCondensedHandler()));
        addComponent((new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 1, 0, 1).bucketInputs(1).bucketOutputs(2).gasOutputs(1).upgrades(3))).setDirectionsBySlot(1, MachineDirection.FRONT).validUpgrades(ContainerCatalyticReformer.VALID_UPGRADES).valid(machineValidator()));
        addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.catalyticreformer.tag(), this)).createMenu((id, player) -> new ContainerCatalyticReformer(id, player, (Container)this.getComponent(IComponentType.Inventory), this.getCoordsArray())));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcess).process(this::process));
    }

    protected void tickClient(ComponentTickable tickable) {
        if (this.shouldPlaySound()) {
            ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
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
                SoundBarrierMethods.playTileSound((SoundEvent) ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
            }

        }
    }

    private boolean canProcess(ComponentProcessor pr, int procNumber) {
        pr.consumeBucket().dispenseGasCylinder().dispenseBucket().outputToGasPipe().outputToFluidPipe();
        FluidItem2FluidRecipe locRecipe;
        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);
            locRecipe = (FluidItem2FluidRecipe) pr.getRecipe(CSRecipies.CATALYTIC_REFORMER_TYPE.get(), procNumber);
            if (locRecipe == null) return false;
        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (FluidItem2FluidRecipe) pr.getRecipe(procNumber);
        }

        pr.setRecipe(locRecipe, procNumber);
        pr.requiredTicks.setValue((double) locRecipe.getTicks(), procNumber);
        pr.usage.setValue(locRecipe.getUsagePerTick(), procNumber);

        ComponentElectrodynamic electro = getComponent(IComponentType.Electrodynamic);
        if (electro.getJoulesStored() < pr.getUsage(procNumber)) return false;

        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        FluidTank[] outFluidTanks = fluidHandler.getOutputTanks();
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);

        FluidTank inTank0 = fluidHandler.getInputTanks()[0];
        if (inTank0.getFluidAmount() < locRecipe.getFluidIngredients().getFirst().getFluidStack().getAmount()) {
            return false;
        }

        if (outFluidTanks[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.SIMULATE)
                < locRecipe.getFluidRecipeOutput().getAmount()) {
            return false;
        }

        if (gasHandler.getOutputTanks()[0].getGasAmount() > 4900) {
            return false;
        }

        if (locRecipe.hasFluidBiproducts()) {
            FluidTank[] biFluidTanksOnly = java.util.Arrays.copyOfRange(outFluidTanks, 0, outFluidTanks.length);
            return ComponentProcessor.roomInBiproductFluidTanks(biFluidTanksOnly, locRecipe.getFullFluidBiStacks());
        }

        return true;
    }

    private void process(ComponentProcessor pr, int procNumber) {
        if (pr.getRecipe(procNumber) == null) return;

        ComponentInventory inv = getComponent(IComponentType.Inventory);
        FluidItem2FluidRecipe locRecipe = (FluidItem2FluidRecipe) pr.getRecipe(procNumber);
        ComponentFluidHandlerMulti fluidHandler = getComponent(IComponentType.FluidHandler);
        FluidTank[] outFluidTanks = fluidHandler.getOutputTanks();
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        outFluidTanks[0].fill(locRecipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.EXECUTE);
        outFluidTanks[1].fill(locRecipe.getFluidBiproducts().getFirst().roll(), IFluidHandler.FluidAction.EXECUTE);
        outGasTanks[0].fill(locRecipe.getGasBiproducts().getFirst().roll(), GasAction.EXECUTE);


        fluidHandler.getInputTanks()[0].drain(
                locRecipe.getFluidIngredients().getFirst().getFluidStack().getAmount(),
                IFluidHandler.FluidAction.EXECUTE
        );

        if (locRecipe.hasItemBiproducts()) {
            List<ProbableItem> itemBi = locRecipe.getItemBiproducts();
            int index = 0;
            for (int slot : inv.getBiprodSlotsForProcessor(procNumber)) {
                ItemStack stack = inv.getItem(slot);
                if (stack.isEmpty()) {
                    inv.setItem(slot, itemBi.get(index).roll().copy());
                } else {
                    stack.grow(itemBi.get(index).roll().getCount());
                    inv.setItem(slot, stack);
                }
                index++;
                if(index >= itemBi.size()) {
                    break;
                }
            }

        }

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
