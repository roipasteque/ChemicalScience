package net.pastek.chemicalscience.client.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.tile.TileCircuitMaker;
import voltaic.prefab.screen.component.types.ScreenComponentProgress;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.gauges.ScreenComponentFluidGauge;
import voltaic.prefab.screen.component.types.guitab.ScreenComponentElectricInfo;
import voltaic.prefab.screen.component.types.wrapper.WrapperInventoryIO;
import voltaic.prefab.screen.types.GenericMaterialScreen;
import voltaic.prefab.tile.GenericTile;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentProcessor;

@OnlyIn(Dist.CLIENT)
public class ScreenCircuitMaker extends GenericMaterialScreen<ContainerCircuitMaker> {
    public ScreenCircuitMaker(ContainerCircuitMaker container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.addComponent(new ScreenComponentProgress(ProgressBars.PROGRESS_ARROW_RIGHT, () -> {
            GenericTile furnace = (GenericTile)container.getSafeHost();
            if (furnace != null) {
                ComponentProcessor processor = (ComponentProcessor)furnace.getComponent(IComponentType.Processor);
                if (processor.isActive(0)) {
                    return ((Double[])processor.operatingTicks.getValue())[0] / ((Double[])processor.requiredTicks.getValue())[0];
                }
            }

            return (double)0.0F;
        }, 78, 31));

        this.addComponent(new ScreenComponentFluidGauge(() -> {
            TileCircuitMaker boiler = (TileCircuitMaker)container.getSafeHost();
            return boiler != null ? ((ComponentFluidHandlerMulti)boiler.getComponent(IComponentType.FluidHandler)).getInputTanks()[0] : null;
        }, 21, 18));
        new WrapperInventoryIO(this, -25, 28, 75, 82, 8, 72);
    }
}
