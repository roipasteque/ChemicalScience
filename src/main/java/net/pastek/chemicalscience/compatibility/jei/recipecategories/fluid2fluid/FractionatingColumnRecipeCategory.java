package net.pastek.chemicalscience.compatibility.jei.recipecategories.fluid2fluid;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.fluid2fluid.specificmachines.FractionatingColumnRecipe;
import net.pastek.chemicalscience.prefab.screen.CSBackgroundObject;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.recipecategories.fluid2fluid.Fluid2FluidRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.FluidGaugeObject;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.IconType;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.SlotType;

public class FractionatingColumnRecipeCategory extends Fluid2FluidRecipeCategory<FractionatingColumnRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 125, CSTextures.FRACTIONATING_COLUMN_JEI);
    public static final ItemSlotObject INPUT_BUCKET_SLOT;
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final FluidGaugeObject IN_GAUGE;
    public static final FluidGaugeObject OUT_GAUGE_1;
    public static final FluidGaugeObject OUT_GAUGE_2;
    public static final FluidGaugeObject OUT_GAUGE_3;
    public static final FluidGaugeObject OUT_GAUGE_4;
    public static final FluidGaugeObject OUT_GAUGE_5;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<FractionatingColumnRecipe> RECIPE_TYPE;

    public FractionatingColumnRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("fractionating_column_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setInputSlots(guiHelper, INPUT_BUCKET_SLOT);
        this.setFluidInputs(guiHelper, IN_GAUGE);
        this.setFluidOutputs(guiHelper, OUT_GAUGE_1, OUT_GAUGE_2, OUT_GAUGE_3, OUT_GAUGE_4, OUT_GAUGE_5);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, TIME_LABEL);
    }

    static {
        INPUT_BUCKET_SLOT = new ItemSlotObject(SlotType.NORMAL, IconType.FLUID_DARK, 7, 71, RecipeIngredientRole.INPUT);
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT, 39, 33, StartDirection.LEFT);
        IN_GAUGE = new FluidGaugeObject(9, 17);
        OUT_GAUGE_1 = new FluidGaugeObject(77, 17);
        OUT_GAUGE_2 = new FluidGaugeObject(95, 17);
        OUT_GAUGE_3 = new FluidGaugeObject(113, 17);
        OUT_GAUGE_4 = new FluidGaugeObject(131, 17);
        OUT_GAUGE_5 = new FluidGaugeObject(149, 17);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 115, 480);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 115);
        INPUT_MACHINE = new ItemStack(CSBlocks.FRACTIONATING_COLUMN);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "fractionating_column_recipe", FractionatingColumnRecipe.class);
    }
}
