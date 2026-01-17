package net.pastek.chemicalscience.compatibility.jei.recipecategories.gasfluiditem2gasfluid;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.specificmachines.HDSUnitRecipe;
import net.pastek.chemicalscience.prefab.screen.CSBackgroundObject;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.FluidGaugeObject;
import voltaic.compatibility.jei.utils.gui.types.gasgauge.GasGaugeObject;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.SlotType;

public class HDSUnitRecipeCategory extends GasFluidItem2FluidRecipeCategory<HDSUnitRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 80, CSTextures.HDS_UNIT_JEI);
    public static final ItemSlotObject INPUT_CAT_SLOT;
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final FluidGaugeObject IN_FLUID_GAUGE;
    public static final FluidGaugeObject OUT_FLUID_GAUGE;
    public static final GasGaugeObject IN_GAS_GAUGE;
    public static final GasGaugeObject OUT_GAS_GAUGE;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<HDSUnitRecipe> RECIPE_TYPE;

    public HDSUnitRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("hds_unit_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setInputSlots(guiHelper,INPUT_CAT_SLOT);
        this.setFluidInputs(guiHelper, IN_FLUID_GAUGE);
        this.setFluidOutputs(guiHelper, OUT_FLUID_GAUGE);
        this.setGasInputs(guiHelper, IN_GAS_GAUGE);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, TIME_LABEL);
    }

    static {
        INPUT_CAT_SLOT = new ItemSlotObject(SlotType.NORMAL, 79, 5, RecipeIngredientRole.CATALYST);
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT_BIG, 56, 21, StartDirection.LEFT);
        IN_FLUID_GAUGE = new FluidGaugeObject(9, 5);
        IN_GAS_GAUGE = new GasGaugeObject(27, 5);
        OUT_FLUID_GAUGE = new FluidGaugeObject(135, 5);
        OUT_GAS_GAUGE = new GasGaugeObject(153, 5);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 69, 480);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 69);
        INPUT_MACHINE = new ItemStack(CSBlocks.HDS_UNIT);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "hds_unit_recipe", HDSUnitRecipe.class);
    }
}
