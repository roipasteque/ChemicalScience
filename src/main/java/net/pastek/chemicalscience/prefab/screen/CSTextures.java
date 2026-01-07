package net.pastek.chemicalscience.prefab.screen;

import net.minecraft.resources.ResourceLocation;
import net.pastek.chemicalscience.ChemicalScience;
import voltaic.api.screen.ITexture;

public enum CSTextures implements ITexture {

    CATALYST_ICON(
            0, 0,
            18, 18,
            18, 18,
            ChemicalScience.rl("textures/screen/component/icon/catalyst.png")
    ),

    CIRCUIT_MAKER_JEI(
            0, 0,
            176, 125,
            256, 256,
            ChemicalScience.rl("textures/screen/jei/background/circuitmaker.png")
    ),

    HDS_UNIT_JEI(
            0, 0,
            176, 125,
            256, 256,
            ChemicalScience.rl("textures/screen/jei/background/hdsunit.png")
    ),

    FRACTIONATING_COLUMN_JEI(
            0, 0,
            176, 125,
            256, 256,
            ChemicalScience.rl("textures/screen/jei/background/fractionatingcolumn.png")
    );

    private final int u;
    private final int v;
    private final int width;
    private final int height;
    private final int imageWidth;
    private final int imageHeight;
    private final ResourceLocation loc;

    CSTextures(int u, int v, int width, int height, int imageWidth, int imageHeight, ResourceLocation loc) {
        this.u = u;
        this.v = v;
        this.width = width;
        this.height = height;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.loc = loc;
    }
    @Override public int textureU() { return u; }
    @Override public int textureV() { return v; }
    @Override public int textureWidth() { return width; }
    @Override public int textureHeight() { return height; }
    @Override public int imageWidth() { return imageWidth; }
    @Override public int imageHeight() { return imageHeight; }
    @Override public ResourceLocation getLocation() { return loc; }
}
