package net.pastek.chemicalscience.compatibility.jei.recipecategories.fluid2item;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.fluid2item.specificmachines.SpinCoaterRecipe;
import net.pastek.chemicalscience.prefab.screen.CSBackgroundObject;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.recipecategories.fluid2item.Fluid2ItemRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.FluidGaugeObject;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.IconType;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.SlotType;

public class SpinCoaterRecipeCategory extends Fluid2ItemRecipeCategory<SpinCoaterRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 80, CSTextures.SPIN_COATER_JEI);
    public static final ItemSlotObject OUTPUT_SLOT;
    public static final ItemSlotObject INPUT_BUCKET_SLOT;
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final FluidGaugeObject IN_GAUGE;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<SpinCoaterRecipe> RECIPE_TYPE;

    public SpinCoaterRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("spin_coater_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setInputSlots(guiHelper, INPUT_BUCKET_SLOT);
        this.setOutputSlots(guiHelper, OUTPUT_SLOT);
        this.setFluidInputs(guiHelper, IN_GAUGE);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, TIME_LABEL);
    }

    static {
        OUTPUT_SLOT = new ItemSlotObject(SlotType.NORMAL, 127, 20, RecipeIngredientRole.OUTPUT);
        INPUT_BUCKET_SLOT = new ItemSlotObject(SlotType.NORMAL, IconType.FLUID_DARK, 37, 38, RecipeIngredientRole.INPUT);
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT_BIG, 55, 21, StartDirection.LEFT);
        IN_GAUGE = new FluidGaugeObject(21, 7);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 69, 480);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 69);
        INPUT_MACHINE = new ItemStack(CSBlocks.SPIN_COATER);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "spin_coater_recipe", SpinCoaterRecipe.class);
    }
}
