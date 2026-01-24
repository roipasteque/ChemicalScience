package net.pastek.chemicalscience.common.recipe.categories.fluid2item.specificmachines;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.common.recipe.categories.fluid2item.Fluid2ItemRecipe;
import voltaic.common.recipe.recipeutils.*;

import java.util.List;

public class SpinCoaterRecipe extends Fluid2ItemRecipe {
    public static final String RECIPE_GROUP = "spin_coater_recipe";
    public static final ResourceLocation RECIPE_ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "spin_coater_recipe");

    public SpinCoaterRecipe(String group, List<FluidIngredient> inputFluids, ItemStack itemOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, inputFluids, itemOutput, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) CSRecipies.SPIN_COATER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType)CSRecipies.SPIN_COATER_TYPE.get();
    }
}
