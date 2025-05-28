package net.pastek.chemicalscience.common.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerOrganicSolarPanel;
import net.pastek.chemicalscience.common.settings.CSConstants;
import net.pastek.chemicalscience.prefab.utils.ElectricityUtils;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.*;
import voltaic.prefab.utilities.BlockEntityUtils;
import voltaic.prefab.utilities.object.CachedTileOutput;
import voltaic.prefab.utilities.object.TransferPack;
import voltaic.registers.VoltaicCapabilities;

public class TileOrganicSolarPanel extends GenericGeneratorTile {

    protected CachedTileOutput output;
    protected SingleProperty<Boolean> generating = property(new SingleProperty<>(PropertyTypes.BOOLEAN, "generating", false));
    protected SingleProperty<Double> multiplier = property(new SingleProperty<>(PropertyTypes.DOUBLE, "multiplier", 1.0));
    protected SingleProperty<Boolean> hasRedstoneSignal = property(new SingleProperty<>(PropertyTypes.BOOLEAN, "redstonesignal", false));

    public TileOrganicSolarPanel(BlockPos worldPosition, BlockState blockState) {
        this(CSTiles.TILE_ORGANICSOLARPANEL.get(), worldPosition, blockState, 2.25, SubtypeItemUpgrade.improvedsolarcell);
    }

    public TileOrganicSolarPanel(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState, double multiplier, SubtypeItemUpgrade... itemUpgrades) {
        super(type, worldPosition, blockState, multiplier, itemUpgrades);
        addComponent(new ComponentTickable(this).tickServer(this::tickServer));
        addComponent(new ComponentPacketHandler(this));
        addComponent(new ComponentElectrodynamic(this, true, false).voltage(VoltaicCapabilities.DEFAULT_VOLTAGE*2).setOutputDirections(BlockEntityUtils.MachineDirection.BOTTOM));
        addComponent(new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().upgrades(1)).validUpgrades(ContainerOrganicSolarPanel.VALID_UPGRADES).valid(machineValidator()));
        addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.organicsolarpanel.tag(), this).createMenu((id, player) -> new ContainerOrganicSolarPanel(id, player, getComponent(IComponentType.Inventory), getCoordsArray())));
    }

    protected void tickServer(ComponentTickable tickable) {
        if (hasRedstoneSignal.getValue()) {
            generating.setValue(false);
            return;
        }
        if (output == null) {
            output = new CachedTileOutput(level, worldPosition.relative(Direction.DOWN));
        }
        if (tickable.getTicks() % 40 == 0) {
            output.update(worldPosition.relative(Direction.DOWN));
            generating.setValue(level.canSeeSky(worldPosition.offset(0, 1, 0)));
        }
        if (level.isDay() && generating.getValue() && output.valid()) {
            ElectricityUtils.receivePower(output.getSafe(), Direction.UP, getProduced(), false);
        }
    }

    public TransferPack getProduced() {
        double mod = 1.0f - Mth.clamp(1.0F - (Mth.cos(level.getTimeOfDay(1f) * ((float) Math.PI * 2f)) * 2.0f + 0.2f), 0.0f, 1.0f);
        double temp = level.getBiomeManager().getBiome(getBlockPos()).value().getBaseTemperature();
        double lerped = Mth.lerp((temp + 1) / 3.0, 1.5, 3) / 3.0;
        return TransferPack.ampsVoltage(getMultiplier() * CSConstants.ORGANICSOLARPANEL_AMPERAGE * lerped * mod * (level.isRaining() || level.isThundering() ? 0.8f : 1), this.<ComponentElectrodynamic>getComponent(IComponentType.Electrodynamic).getVoltage());
    }

    public double getMultiplier() {
        return multiplier.getValue();
    }

    public void setMultiplier(double val) {
        multiplier.setValue(val);
    }

    public int getComparatorSignal() {
        return generating.getValue() ? 15 : 0;
    }
}