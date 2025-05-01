package net.pastek.chemicalscience.client.guidebook;


import net.minecraft.network.chat.MutableComponent;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.guidebook.chapters.*;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.graphics.ImageWrapperObject;

public class ModuleChemicalScience extends Module {

    private static final ImageWrapperObject LOGO = new ImageWrapperObject(0, 0, 0, 0, 32, 32, 32, 32, ChemicalScience.rl("textures/screen/guidebook/chemicalsciencelogo.png"));

    @Override
    public ImageWrapperObject getLogo() {
        return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
        return CSTextUtils.guidebook(ChemicalScience.MOD_ID);
    }

    @Override
    public void addChapters() {
        chapters.add(new ChapterIntroduction(this));
        chapters.add(new ChapterGeneralChemistry(this));
        chapters.add(new ChapterOrganicChemistry(this));
        chapters.add(new ChapterOres(this));
        chapters.add(new ChapterMolecules(this));

    }

}