package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerFuelCell;
import net.pastek.chemicalscience.common.settings.CSConstants;
import net.pastek.chemicalscience.prefab.utils.ElectricityUtils;
import net.pastek.chemicalscience.registers.CSTags;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.electricity.generator.IElectricGenerator;
import voltaic.common.network.utils.FluidUtilities;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentElectrodynamic;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentPacketHandler;
import voltaic.prefab.tile.components.type.ComponentTickable;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.types.GenericMaterialTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;
import voltaic.prefab.utilities.object.CachedTileOutput;
import voltaic.prefab.utilities.object.TransferPack;
import voltaic.registers.VoltaicCapabilities;

public class TileFuelCell extends GenericMaterialTile implements IElectricGenerator, ITickableSound {
    public static final int TANK_CAPACITY = 5000;
    public SingleProperty<Boolean> running;
    public SingleProperty<Integer> burnTime;
    private CachedTileOutput output;
    private SingleProperty<Double> multiplier;
    private SingleProperty<Boolean> hasRedstoneSignal;
    private boolean isSoundPlaying;

    public TileFuelCell(BlockPos worldPosition, BlockState blockState) {
        super(CSTiles.TILE_FUELCELL.get(), worldPosition, blockState);
        this.running = (SingleProperty)this.property(new SingleProperty(PropertyTypes.BOOLEAN, "running", false));
        this.burnTime = (SingleProperty)this.property(new SingleProperty(PropertyTypes.INTEGER, "burnTime", 0));
        this.hasRedstoneSignal = (SingleProperty)this.property(new SingleProperty(PropertyTypes.BOOLEAN, "redstonesignal", false));
        this.isSoundPlaying = false;
        this.addComponent((new ComponentTickable(this)).tickServer(this::tickServer).tickClient(this::tickClient));
        this.addComponent(new ComponentPacketHandler(this));
        this.addComponent(new ComponentElectrodynamic(this, true, false).voltage(VoltaicCapabilities.DEFAULT_VOLTAGE*2).setOutputDirections(MachineDirection.LEFT));
        this.addComponent(new ComponentInventory(this, InventoryBuilder.newInv().bucketInputs(1)).valid((slot, stack, i) -> {return stack.getCapability(FluidHandler.ITEM) != null;}));
        this.addComponent(new ComponentFluidHandlerMulti(this).setInputTanks(1, arr(TANK_CAPACITY)).setInputFluidTags(CSTags.Fluids.HYDROGEN).setInputDirections(MachineDirection.RIGHT));
        this.addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.fuelcell.tag(), this)).createMenu((id, player) -> {return new ContainerFuelCell(id, player, (Container)this.getComponent(IComponentType.Inventory), this.getCoordsArray());}));
    }

    protected void tickServer(ComponentTickable tickable) {
        if ((Boolean)this.hasRedstoneSignal.getValue()) {
            this.running.setValue(false);
        } else {
            Direction facing = this.getFacing();
            if (this.output == null) {
                this.output = new CachedTileOutput(this.level, this.worldPosition.relative(facing.getClockWise()));
            }

            if (tickable.getTicks() % 40L == 0L) {
                this.output.update(this.worldPosition.relative(facing.getClockWise()));
            }

            ComponentFluidHandlerMulti handler = (ComponentFluidHandlerMulti)this.getComponent(IComponentType.FluidHandler);
            FluidUtilities.drainItem(this, handler.getInputTanks());
            FluidTank tank = handler.getInputTanks()[0];
            if ((Integer)this.burnTime.getValue() <= 0) {
                this.running.setValue(false);
                if (tank.getFluidAmount() > 0) {
                        tank.drain(new FluidStack(tank.getFluid().getFluid(), 1), FluidAction.EXECUTE);
                        this.running.setValue(true);
                        this.burnTime.setValue(3);
                }
            } else {
                this.running.setValue(true);
            }

            if ((Integer)this.burnTime.getValue() > 0) {
                this.burnTime.setValue((Integer)this.burnTime.getValue() - 1);
            }

            if ((Boolean)this.running.getValue() && (Integer)this.burnTime.getValue() > 0 && this.output.valid()) {
                ElectricityUtils.receivePower((BlockEntity)this.output.getSafe(), facing.getClockWise().getOpposite(), this.getProduced(), false);
            }

        }
    }

    protected void tickClient(ComponentTickable tickable) {
        if ((Boolean)this.running.getValue()) {
            if (this.level.random.nextDouble() < 0.15) {
                this.level.addParticle(ParticleTypes.BUBBLE, (double)this.worldPosition.getX() + this.level.random.nextDouble(), (double)this.worldPosition.getY() + this.level.random.nextDouble(), (double)this.worldPosition.getZ() + this.level.random.nextDouble(), 0.0, 0.0, 0.0);
            }

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
        return (Boolean)this.running.getValue();
    }

    public void setMultiplier(double val) {
        this.multiplier.setValue(val);
    }

    public double getMultiplier() {
        return (Double)this.multiplier.getValue();
    }

    public TransferPack getProduced() {
        return TransferPack.joulesVoltage(CSConstants.FUEL_CELL_JOULES_PER_TICK, 240);
    }

    public int getComparatorSignal() {
        return (Boolean)this.running.getValue() ? 15 : 0;
    }

    public void onNeightborChanged(BlockPos neighbor, boolean blockStateTrigger) {
        if (!this.level.isClientSide) {
            this.hasRedstoneSignal.setValue(this.level.hasNeighborSignal(this.getBlockPos()));
        }
    }
}
