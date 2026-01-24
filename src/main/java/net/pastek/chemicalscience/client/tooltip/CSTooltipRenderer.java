package net.pastek.chemicalscience.client.tooltip;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;
import net.pastek.chemicalscience.common.item.CSTooltipItem;

public class CSTooltipRenderer implements ClientTooltipComponent {
    private final ResourceLocation texture;
    private final int width;
    private final int height;

    public CSTooltipRenderer(CSTooltipItem.ImageTooltipComponent data) {
        this.texture = data.image();
        this.width = data.width();
        this.height = data.height();
    }

    @Override
    public int getHeight() {
        return height + 4;
    }

    @Override
    public int getWidth(Font font) {
        return width;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        guiGraphics.blit(this.texture, x, y, 0, 0, width, height, width, height);
    }
}