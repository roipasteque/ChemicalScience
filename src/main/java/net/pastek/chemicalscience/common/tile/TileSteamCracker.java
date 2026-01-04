package net.pastek.chemicalscience.common.tile;

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
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.inventory.container.ContainerSteamCracker;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.Gas2GasRecipe;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.GasFluidItem2FluidRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.gas.GasAction;
import voltaic.api.gas.GasTank;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.types.GenericGasTile;
import voltaic.prefab.tile.types.GenericMaterialTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;

import java.util.List;

public class TileSteamCracker extends GenericGasTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileSteamCracker(BlockPos worldPosition, BlockState blockState) {
        super((BlockEntityType) CSTiles.TILE_STEAM_CRACKER.get(), worldPosition, blockState);
        addComponent(new ComponentPacketHandler(this));
        addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new MachineDirection[]{MachineDirection.BOTTOM}).voltage((double)480.0F));
        addComponent((new ComponentGasHandlerMulti(this))
                .setInputTanks(1, new int[]{MAX_TANK_CAPACITY}, new int[]{1000}, new int[]{1024}).setInputDirections(new MachineDirection[]{MachineDirection.LEFT})
                .setOutputTanks(2, new int[]{MAX_TANK_CAPACITY, MAX_TANK_CAPACITY}, new int[]{1000, 1000}, new int[]{1024, 1024}).setOutputDirections(MachineDirection.RIGHT, MachineDirection.BACK)
                .setCondensedHandler(getCondensedHandler()));
        addComponent((new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 0, 0, 1).gasInputs(1).gasOutputs(2).upgrades(3))).setDirectionsBySlot(0,MachineDirection.BOTTOM, MachineDirection.LEFT, MachineDirection.FRONT).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES).valid(machineValidator()));
        addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.steamcracker.tag(), this)).createMenu((id, player) -> new ContainerSteamCracker(id, player, (Container)this.getComponent(IComponentType.Inventory), this.getCoordsArray())));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcess).process(this::process));
    }

    private boolean canProcess(ComponentProcessor pr, int procNumber) {
        pr.consumeGasCylinder().dispenseGasCylinder().outputToGasPipe();
        Gas2GasRecipe locRecipe;
        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);
            locRecipe = (Gas2GasRecipe) pr.getRecipe(CSRecipies.STEAM_CRACKER_TYPE.get(), procNumber);
            if (locRecipe == null) return false;
        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (Gas2GasRecipe) pr.getRecipe(procNumber);
        }

        pr.setRecipe(locRecipe, procNumber);
        pr.requiredTicks.setValue((double) locRecipe.getTicks(), procNumber);
        pr.usage.setValue(locRecipe.getUsagePerTick(), procNumber);

        ComponentElectrodynamic electro = getComponent(IComponentType.Electrodynamic);
        if (electro.getJoulesStored() < pr.getUsage(procNumber)) return false;

        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        GasTank inTank = gasHandler.getInputTanks()[0];
        if (inTank.getGasAmount() < locRecipe.getGasIngredients().get(0).getGasStack().getAmount()) {
            return false;
        }

        if (gasHandler.getOutputTanks()[1].getGasAmount() > 4900) {
            return false;
        }

        if (outGasTanks[0].fill(locRecipe.getGasRecipeOutput(), GasAction.SIMULATE)
                < locRecipe.getGasRecipeOutput().getAmount()) {
            return false;
        }

        return true;
    }

    private void process(ComponentProcessor pr, int procNumber) {
        if (pr.getRecipe(procNumber) == null) return;

        ComponentInventory inv = getComponent(IComponentType.Inventory);
        Gas2GasRecipe locRecipe = (Gas2GasRecipe) pr.getRecipe(procNumber);
        ComponentGasHandlerMulti gasHandler = getComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        outGasTanks[0].fill(locRecipe.getGasRecipeOutput(), GasAction.EXECUTE);
        outGasTanks[1].fill(locRecipe.getGasBiproducts().getFirst().roll(), GasAction.EXECUTE);

        gasHandler.getInputTanks()[0].drain(
                locRecipe.getGasIngredients().getFirst().getGasStack().getAmount(),
                GasAction.EXECUTE
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
