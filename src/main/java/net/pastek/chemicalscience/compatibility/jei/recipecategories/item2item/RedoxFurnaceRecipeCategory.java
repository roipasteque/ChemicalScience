package net.pastek.chemicalscience.compatibility.jei.recipecategories.item2item;

import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.item2item.specificmachines.RedoxFurnaceRecipe;
import net.pastek.chemicalscience.prefab.screen.CSBackgroundObject;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.compatibility.jei.recipecategories.item2item.Item2ItemRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.ScreenComponentSlot.SlotType;

public class RedoxFurnaceRecipeCategory extends Item2ItemRecipeCategory<RedoxFurnaceRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 80, CSTextures.REDOX_FURNACE_JEI);
    public static final ItemSlotObject INPUT_SLOT_1;
    public static final ItemSlotObject INPUT_SLOT_2;
    public static final ItemSlotObject OUTPUT_SLOT_1;
    public static final ItemSlotObject OUTPUT_SLOT_2;
    public static final ItemSlotObject OUTPUT_SLOT_3;
    public static final ItemSlotObject OUTPUT_SLOT_4;
    public static final ItemSlotObject OUTPUT_SLOT_5;
    public static final ItemSlotObject OUTPUT_SLOT_6;
    public static final ArrowAnimatedObject ANIM_RIGHT_ARROW;
    public static final PowerLabelWrapperElectroRecipe POWER_LABEL;
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL;
    public static ItemStack INPUT_MACHINE;
    public static final RecipeType<RedoxFurnaceRecipe> RECIPE_TYPE;

    public RedoxFurnaceRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, CSTextUtils.jeiTranslated("circuit_maker_recipe"), INPUT_MACHINE, BACK_WRAP, RECIPE_TYPE, 50);
        this.setInputSlots(guiHelper,INPUT_SLOT_1, INPUT_SLOT_2);
        this.setOutputSlots(guiHelper, OUTPUT_SLOT_1, OUTPUT_SLOT_2, OUTPUT_SLOT_3, OUTPUT_SLOT_4, OUTPUT_SLOT_5, OUTPUT_SLOT_6);
        this.setAnimatedArrows(guiHelper, ANIM_RIGHT_ARROW);
        this.setLabels( POWER_LABEL, TIME_LABEL);
    }

    static {
        INPUT_SLOT_1 = new ItemSlotObject(SlotType.NORMAL, 7, 36, RecipeIngredientRole.INPUT);
        INPUT_SLOT_2 = new ItemSlotObject(SlotType.NORMAL, 25, 36, RecipeIngredientRole.INPUT);
        OUTPUT_SLOT_1 = new ItemSlotObject(SlotType.NORMAL, 115, 18, RecipeIngredientRole.OUTPUT);
        OUTPUT_SLOT_2 = new ItemSlotObject(SlotType.NORMAL, 133, 18, RecipeIngredientRole.OUTPUT);
        OUTPUT_SLOT_3 = new ItemSlotObject(SlotType.NORMAL, 151, 18, RecipeIngredientRole.OUTPUT);
        OUTPUT_SLOT_4 = new ItemSlotObject(SlotType.NORMAL, 115, 36, RecipeIngredientRole.OUTPUT);
        OUTPUT_SLOT_5 = new ItemSlotObject(SlotType.NORMAL, 133, 36, RecipeIngredientRole.OUTPUT);
        OUTPUT_SLOT_6 = new ItemSlotObject(SlotType.NORMAL, 151, 36, RecipeIngredientRole.OUTPUT);
        ANIM_RIGHT_ARROW = new ArrowAnimatedObject(ProgressBars.PROGRESS_ARROW_RIGHT, 68, 18, StartDirection.LEFT);
        POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 69, 960);
        TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 69);
        INPUT_MACHINE = new ItemStack(CSBlocks.REDOX_FURNACE);
        RECIPE_TYPE = RecipeType.create("chemicalscience", "redox_furnace_recipe", RedoxFurnaceRecipe.class);
    }
}
