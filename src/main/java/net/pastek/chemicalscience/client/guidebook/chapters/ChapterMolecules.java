package net.pastek.chemicalscience.client.guidebook.chapters;

import electrodynamics.prefab.utilities.ElectroTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import net.pastek.chemicalscience.registers.CSItems;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.OnKeyPress;
import voltaic.client.guidebook.utils.pagedata.OnTooltip;
import voltaic.client.guidebook.utils.pagedata.graphics.AbstractGraphicWrapper;
import voltaic.client.guidebook.utils.pagedata.graphics.ImageWrapperObject;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.compatibility.jei.JeiBuffer;


public class ChapterMolecules extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F, CSItems.PALLADIUM_ON_CARBON_CATALYST.get());

    public ChapterMolecules(Module module) {
        super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
        return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
        return CSTextUtils.guidebook("chapter.molecules");
    }

    @Override
    public void addData() {
        //Caffeine
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CAFFEINE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_CAFFEINE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.caffeine"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_CAFFEINE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/caffeine.png")));

        //Calcium Oxide
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CALCIUMOXIDE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_CALCIUMOXIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.calciumoxide"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_CALCIUMOXIDE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/calciumoxide.png")));

        //Cerium Oxide
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CERIUMOXIDE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_CERIUMOXIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.ceriumoxide"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_CERIUMOXIDE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/ceriumoxide.png")));

        //Chromium Bromide
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CHROMIUM_BROMIDE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_CHROMIUM_BROMIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.chromiumbromide"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_CHROMIUM_BROMIDE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/chromiumbromide.png")));

        //Dimethyl Urea
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_DIMETHYLUREA.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_DIMETHYLUREA.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.dimethylurea"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_DIMETHYLUREA.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/dimethylurea.png")));

        //Iron Arsenide
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_ARSENOPYRITE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_ARSENOPYRITE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.ironarsenide"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_ARSENOPYRITE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/ironarsenide.png")));

        //Iron Oxide
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_IRONOXIDE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_IRONOXIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.ironoxide"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_IRONOXIDE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/ironoxide.png")));

        //Magnesium Sulfate
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.CRYSTAL_MAGNESIUM.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.CRYSTAL_MAGNESIUM.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.magnesiumsulfate"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.CRYSTAL_MAGNESIUM.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/magnesiumsulfate.png")));

        //Palladium Chloride
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_PALLADIUM_CHLORIDE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_PALLADIUM_CHLORIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.palladiumchloride"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_PALLADIUM_CHLORIDE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/palladiumchloride.png")));

        //Platinum Chloride
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_PLATINUM_CHLORIDE.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_PLATINUM_CHLORIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.platinumchloride"))).onTooltip(new OnTooltip() {
            @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_PLATINUM_CHLORIDE.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/platinumchloride.png")));

        //Urea
        pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_UREA.get(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSItems.DUST_UREA.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
                CSTextUtils.guidebook("chapter.molecules.urea"))).onTooltip(new OnTooltip() {
        @Override public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {if (JeiBuffer.isJeiInstalled()) {graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);}}}).onKeyPress(new OnKeyPress() {@Override public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {}@Override public Object getJeiLookup() {return new ItemStack(CSItems.DUST_UREA.get());}}));
        pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75,
                ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/molecules/urea.png")));
    }

}