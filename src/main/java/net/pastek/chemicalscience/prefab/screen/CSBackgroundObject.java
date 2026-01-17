package net.pastek.chemicalscience.prefab.screen;

import voltaic.api.screen.ITexture;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;

public class CSBackgroundObject extends BackgroundObject {

    private final ITexture texture;

    public CSBackgroundObject(int width, int height, ITexture texture) {
        super(width, height);
        this.texture = texture;
    }

    @Override
    public ITexture getTexture() {
        return this.texture;
    }
}
