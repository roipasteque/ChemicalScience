package net.pastek.chemicalscience.client.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.common.inventory.container.ContainerCatalyticReformer;
import net.pastek.chemicalscience.common.tile.TileCatalyticReformer;
import voltaic.prefab.screen.component.types.ScreenComponentProgress;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.gauges.ScreenComponentFluidGauge;
import voltaic.prefab.screen.component.types.gauges.ScreenComponentGasGauge;
import voltaic.prefab.screen.component.types.guitab.ScreenComponentElectricInfo;
import voltaic.prefab.screen.component.types.wrapper.WrapperInventoryIO;
import voltaic.prefab.screen.types.GenericMaterialScreen;
import voltaic.prefab.tile.GenericTile;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentProcessor;

@OnlyIn(Dist.CLIENT)
public class ScreenCatalyticReformer extends GenericMaterialScreen<ContainerCatalyticReformer> {
    public ScreenCatalyticReformer(ContainerCatalyticReformer container, Inventory playerInventory, Component title) {
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
            TileCatalyticReformer boiler = container.getSafeHost();
            return boiler != null ? ((ComponentFluidHandlerMulti)boiler.getComponent(IComponentType.FluidHandler)).getInputTanks()[0] : null;
        }, 18, 11));

        this.addComponent(new ScreenComponentFluidGauge(() -> {
            TileCatalyticReformer boiler = container.getSafeHost();
            return boiler != null ? ((ComponentFluidHandlerMulti)boiler.getComponent(IComponentType.FluidHandler)).getOutputTanks()[0] : null;
        }, 98, 11));

        this.addComponent(new ScreenComponentFluidGauge(() -> {
            TileCatalyticReformer boiler = container.getSafeHost();
            return boiler != null ? ((ComponentFluidHandlerMulti)boiler.getComponent(IComponentType.FluidHandler)).getOutputTanks()[1] : null;
        }, 118, 11));

        this.addComponent(new ScreenComponentGasGauge(() -> {
            TileCatalyticReformer boiler = container.getSafeHost();
            return boiler != null ? ((ComponentGasHandlerMulti)boiler.getComponent(IComponentType.GasHandler)).getOutputTanks()[0] : null;
        }, 138, 11));

        this.addComponent(new ScreenComponentElectricInfo(-25, 2));
        new WrapperInventoryIO(this, -25, 28, 75, 82, 8, 72);
    }
}
