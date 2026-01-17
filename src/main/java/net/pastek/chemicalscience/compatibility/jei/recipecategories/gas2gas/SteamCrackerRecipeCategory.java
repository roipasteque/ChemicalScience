package net.pastek.chemicalscience.compatibility.jei.recipecategories.gas2gas;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.specificmachines.SteamCrackerRecipe;
import net.pastek.chemicalscience.prefab.screen.CSBackgroundObject;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.gasgauge.GasGaugeObject;
import voltaic.compatibility.jei.utils.label.types.BiproductPercentWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;

public class SteamCrackerRecipeCategory extends Gas2GasRecipeCategory<SteamCrackerRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 80, CSTextures.STEAM_CRACKER_JEI);
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final GasGaugeObject IN_GAS_GAUGE;
    public static final GasGaugeObject OUT_GAS_GAUGE;
    public static final GasGaugeObject OUT_GASBI_GAUGE;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final BiproductPercentWrapperElectroRecipe ITEM_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<SteamCrackerRecipe> RECIPE_TYPE;

    public SteamCrackerRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("steam_cracker_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setGasInputs(guiHelper, IN_GAS_GAUGE);
        this.setGasOutputs(guiHelper, OUT_GAS_GAUGE, OUT_GASBI_GAUGE);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, ITEM_LABEL, TIME_LABEL);
    }

    static {
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT, 67, 22, StartDirection.LEFT);
        IN_GAS_GAUGE = new GasGaugeObject(25, 7);
        OUT_GAS_GAUGE = new GasGaugeObject(116, 7);
        OUT_GASBI_GAUGE = new GasGaugeObject(134, 7);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 69, 480);
        ITEM_LABEL = new BiproductPercentWrapperElectroRecipe(90, 40, BiproductPercentWrapperElectroRecipe.BiproductType.ITEM, 0);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 69);
        INPUT_MACHINE = new ItemStack(CSBlocks.STEAM_CRACKER);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "steam_cracker_recipe", SteamCrackerRecipe.class);
    }
}
