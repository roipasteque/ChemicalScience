package net.pastek.chemicalscience.compatibility.jei.recipecategories.fluiditem2fluid;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2fluid.specificmachines.CatalyticReformerRecipe;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.specificmachines.HDSUnitRecipe;
import net.pastek.chemicalscience.compatibility.jei.CSBackgroundObject;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.gasfluiditem2gasfluid.GasFluidItem2FluidRecipeCategory;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.recipecategories.fluiditem2fluid.FluidItem2FluidRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.FluidGaugeObject;
import voltaic.compatibility.jei.utils.gui.types.gasgauge.GasGaugeObject;
import voltaic.compatibility.jei.utils.label.types.BiproductPercentWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.SlotType;

public class CatalyticReformerRecipeCategory extends FluidItem2FluidRecipeCategory<CatalyticReformerRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 80, CSTextures.CATALYTIC_REFORMER_JEI);
    public static final ItemSlotObject INPUT_CAT_SLOT;
    public static final ItemSlotObject OUTPUT_SLOT;
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final FluidGaugeObject IN_FLUID_GAUGE;
    public static final FluidGaugeObject OUT_FLUID_GAUGE;
    public static final FluidGaugeObject OUT_FLUIDBI_GAUGE;
    public static final GasGaugeObject OUT_GASBI_GAUGE;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final BiproductPercentWrapperElectroRecipe ITEM_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<CatalyticReformerRecipe> RECIPE_TYPE;

    public CatalyticReformerRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("catalytic_reformer_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setInputSlots(guiHelper,INPUT_CAT_SLOT);
        this.setOutputSlots(guiHelper, OUTPUT_SLOT);
        this.setFluidInputs(guiHelper, IN_FLUID_GAUGE);
        this.setFluidOutputs(guiHelper, OUT_FLUID_GAUGE, OUT_FLUIDBI_GAUGE);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, ITEM_LABEL, TIME_LABEL);
    }

    static {
        INPUT_CAT_SLOT = new ItemSlotObject(SlotType.NORMAL, 42, 21, RecipeIngredientRole.CATALYST);
        OUTPUT_SLOT = new ItemSlotObject(SlotType.NORMAL, 96, 21, RecipeIngredientRole.OUTPUT);
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT, 67, 22, StartDirection.LEFT);
        IN_FLUID_GAUGE = new FluidGaugeObject(25, 7);
        OUT_FLUID_GAUGE = new FluidGaugeObject(116, 7);
        OUT_FLUIDBI_GAUGE = new FluidGaugeObject(134, 7);
        OUT_GASBI_GAUGE = new GasGaugeObject(152, 7);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 69, 480);
        ITEM_LABEL = new BiproductPercentWrapperElectroRecipe(95, 40, BiproductPercentWrapperElectroRecipe.BiproductType.ITEM, 0);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 69);
        INPUT_MACHINE = new ItemStack(CSBlocks.CATALYTIC_REFORMER);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "catalytic_reformer_recipe", CatalyticReformerRecipe.class);
    }
}
