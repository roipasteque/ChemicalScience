package net.pastek.chemicalscience.prefab.screen.component;

import java.util.function.DoubleSupplier;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.ChemicalScience;
import voltaic.api.screen.ITexture;
import voltaic.prefab.screen.component.ScreenComponentGeneric;

// If it works well enough do not touch it

@OnlyIn(Dist.CLIENT)
public class ScreenComponentOn extends ScreenComponentGeneric {
    public static final ResourceLocation TEXTURE = ChemicalScience.rl("textures/screen/component/lightning.png");
    private final ProgressBars bar;

    public ScreenComponentOn(ProgressBars progressBar, int x, int y) {
        super(progressBar.off, x, y);
        this.bar = progressBar;
    }

    public void renderBackground(GuiGraphics graphics, int xAxis, int yAxis, int guiWidth, int guiHeight) {
        super.renderBackground(graphics, xAxis, yAxis, guiWidth, guiHeight);
        ProgressTextures on = this.bar.on;
        graphics.blit(on.getLocation(), guiWidth + this.xLocation, guiHeight + this.yLocation, (float)on.textureU(), (float)on.textureV(), (int)((double)on.textureWidth()), on.textureHeight(), on.imageWidth(), on.imageHeight());
    }

    public static enum ProgressBars {
        LIGHTNING(ScreenComponentOn.ProgressTextures.LIGHTNING_OFF, ScreenComponentOn.ProgressTextures.LIGHTNING_ON);

        public final ProgressTextures off;
        public final ProgressTextures on;

        private ProgressBars(ProgressTextures off, ProgressTextures on) {
            this.off = off;
            this.on = on;
        }
    }

    public static enum ProgressTextures implements ITexture {
        LIGHTNING_ON(22, 16, 0, 0, 44, 16, "lightning"),
        LIGHTNING_OFF(22, 16, 22, 0, 44, 16, "lightning");

        private final int textureWidth;
        private final int textureHeight;
        private final int textureU;
        private final int textureV;
        private final int imageWidth;
        private final int imageHeight;
        private final ResourceLocation loc;

        private ProgressTextures(int textureWidth, int textureHeight, int textureU, int textureV, int imageWidth, int imageHeight, String name) {
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
            this.textureU = textureU;
            this.textureV = textureV;
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.loc = ChemicalScience.rl("textures/screen/component/" + name + ".png");
        }

        public ResourceLocation getLocation() {
            return this.loc;
        }

        public int imageHeight() {
            return this.imageHeight;
        }

        public int imageWidth() {
            return this.imageWidth;
        }

        public int textureHeight() {
            return this.textureHeight;
        }

        public int textureU() {
            return this.textureU;
        }

        public int textureV() {
            return this.textureV;
        }

        public int textureWidth() {
            return this.textureWidth;
        }
    }
}
