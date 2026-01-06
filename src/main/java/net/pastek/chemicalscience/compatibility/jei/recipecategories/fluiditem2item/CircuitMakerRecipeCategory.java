package net.pastek.chemicalscience.compatibility.jei.recipecategories.fluiditem2item;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2item.specificmachines.CircuitMakerRecipe;
import net.pastek.chemicalscience.compatibility.jei.CSBackgroundObject;
import net.pastek.chemicalscience.compatibility.jei.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.recipecategories.fluiditem2item.FluidItem2ItemRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.FluidGaugeObject;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.IconType;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.SlotType;

public class CircuitMakerRecipeCategory extends FluidItem2ItemRecipeCategory<CircuitMakerRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 125, CSTextures.CIRCUIT_MAKER_JEI);
    public static final ItemSlotObject INPUT_SLOT1;
    public static final ItemSlotObject INPUT_SLOT2;
    public static final ItemSlotObject INPUT_SLOT3;
    public static final ItemSlotObject INPUT_SLOT4;
    public static final ItemSlotObject INPUT_SLOT5;
    public static final ItemSlotObject OUTPUT_SLOT;
    public static final ItemSlotObject INPUT_BUCKET_SLOT;
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final FluidGaugeObject IN_GAUGE;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<CircuitMakerRecipe> RECIPE_TYPE;

    public CircuitMakerRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("circuit_maker_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setInputSlots(guiHelper,INPUT_SLOT1, INPUT_SLOT2, INPUT_SLOT3, INPUT_SLOT4, INPUT_SLOT5, INPUT_BUCKET_SLOT);
        this.setOutputSlots(guiHelper, OUTPUT_SLOT);
        this.setFluidInputs(guiHelper, IN_GAUGE);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, TIME_LABEL);
    }

    static {
        INPUT_SLOT1 = new ItemSlotObject(SlotType.NORMAL, 7, 17, RecipeIngredientRole.INPUT);
        INPUT_SLOT2 = new ItemSlotObject(SlotType.NORMAL, 43, 53, RecipeIngredientRole.INPUT);
        INPUT_SLOT3 = new ItemSlotObject(SlotType.NORMAL, 101, 53, RecipeIngredientRole.INPUT);
        INPUT_SLOT4 = new ItemSlotObject(SlotType.NORMAL, 79, 71, RecipeIngredientRole.INPUT);
        INPUT_SLOT5 = new ItemSlotObject(SlotType.NORMAL, 79, 35, RecipeIngredientRole.INPUT);
        OUTPUT_SLOT = new ItemSlotObject(SlotType.NORMAL, 151, 53, RecipeIngredientRole.OUTPUT);
        INPUT_BUCKET_SLOT = new ItemSlotObject(SlotType.NORMAL, IconType.FLUID_DARK, 43, 71, RecipeIngredientRole.INPUT);
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT, 123, 53, StartDirection.LEFT);
        IN_GAUGE = new FluidGaugeObject(9, 38);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 115, 480);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 115);
        INPUT_MACHINE = new ItemStack(CSBlocks.CIRCUIT_MAKER);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "circuit_maker_recipe", CircuitMakerRecipe.class);
    }
}
