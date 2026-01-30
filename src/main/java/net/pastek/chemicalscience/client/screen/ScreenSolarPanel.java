package net.pastek.chemicalscience.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.common.inventory.container.ContainerOrganicSolarPanel;
import net.pastek.chemicalscience.common.packet.PacketTransparencyTogglePayload;
import net.pastek.chemicalscience.common.tile.TileOrganicSolarPanel;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import voltaic.api.electricity.formatting.ChatFormatter;
import voltaic.api.electricity.formatting.DisplayUnits;
import voltaic.prefab.screen.GenericScreen;
import voltaic.prefab.screen.component.button.ScreenComponentButton;
import voltaic.prefab.screen.component.types.ScreenComponentMultiLabel;
import voltaic.prefab.screen.component.types.guitab.ScreenComponentElectricInfo;
import voltaic.prefab.screen.component.utils.AbstractScreenComponentInfo;
import voltaic.prefab.utilities.math.Color;
import voltaic.prefab.utilities.object.TransferPack;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class ScreenSolarPanel extends GenericScreen<ContainerOrganicSolarPanel> {

    public ScreenSolarPanel(ContainerOrganicSolarPanel container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        addComponent(new ScreenComponentElectricInfo(-AbstractScreenComponentInfo.SIZE + 1, 2));
        addComponent(new ScreenComponentMultiLabel(0, 0, graphics -> {
            TileOrganicSolarPanel panel = menu.getSafeHost();
            if (panel == null) {
                return;
            }
            TransferPack transfer = panel.getProduced();
            graphics.drawString(font, CSTextUtils.gui("machine.current", ChatFormatter.getChatDisplayShort(transfer.getAmps(), DisplayUnits.AMPERE)), inventoryLabelX + 60, inventoryLabelY - 48, Color.TEXT_GRAY.color(), false);
            graphics.drawString(font, CSTextUtils.gui("machine.output", ChatFormatter.getChatDisplayShort(transfer.getWatts(), DisplayUnits.WATT)), inventoryLabelX + 60, inventoryLabelY - 35, Color.TEXT_GRAY.color(), false);
            graphics.drawString(font, CSTextUtils.gui("machine.voltage", ChatFormatter.getChatDisplayShort(transfer.getVoltage(), DisplayUnits.VOLTAGE)), inventoryLabelX + 60, inventoryLabelY - 22, Color.TEXT_GRAY.color(), false);
        }));



        addComponent(new ScreenComponentButton<>(75, 20, 40, 20)
                .setLabel(Component.translatable("component.chemicalscience.osp.transparency.toggle"))
                .setOnPress(button -> {
                    TileOrganicSolarPanel panel = menu.getSafeHost();
                    if (panel != null) {
                        Objects.requireNonNull(Minecraft.getInstance().getConnection())
                                .send(new PacketTransparencyTogglePayload(panel.getBlockPos()));
                    }
                })
        );

    }
}