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
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.tile.types.GenericMaterialTile;
import voltaic.prefab.utilities.BlockEntityUtils;

public class TileCircuitMaker extends GenericMaterialTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileCircuitMaker(BlockPos worldPosition, BlockState blockState) {
        super((BlockEntityType) CSTiles.TILE_CIRCUIT_MAKER.get(), worldPosition, blockState);
        this.addComponent(new ComponentPacketHandler(this));
        this.addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        this.addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new BlockEntityUtils.MachineDirection[]{BlockEntityUtils.MachineDirection.BACK}).voltage((double)480.0F));
        this.addComponent((new ComponentFluidHandlerMulti(this)).setInputTanks(1, new int[]{5000}).setInputDirections(new BlockEntityUtils.MachineDirection[]{BlockEntityUtils.MachineDirection.RIGHT}).setRecipeType((RecipeType) CSRecipies.CIRCUIT_MAKER_TYPE.get()));
        this.addComponent((new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().processors(1, 5, 1, 0).bucketInputs(1).upgrades(3))).setSlotsByDirection(BlockEntityUtils.MachineDirection.TOP, 0, 1, 2, 3, 4).setDirectionsBySlot(5, BlockEntityUtils.MachineDirection.BOTTOM, BlockEntityUtils.MachineDirection.LEFT, BlockEntityUtils.MachineDirection.FRONT).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES).valid(machineValidator()));
        this.addComponent((new ComponentProcessor(this)).canProcess((component, procNumber) -> component.consumeBucket().canProcessFluidItem2ItemRecipe(procNumber, (RecipeType) CSRecipies.CIRCUIT_MAKER_TYPE.get())).process(ComponentProcessor::processFluidItem2ItemRecipe));
        this.addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.circuitmaker.tag(), this)).createMenu((id, player) -> new ContainerCircuitMaker(id, player, (Container)this.getComponent(IComponentType.Inventory), this.getCoordsArray())));
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
