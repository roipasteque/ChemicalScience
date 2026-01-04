package net.pastek.chemicalscience.common.recipe.categories.gas2gas.specificmachines;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.Gas2GasRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.recipeutils.*;

import java.util.List;

public class SteamCrackerRecipe extends Gas2GasRecipe {
    public static final String RECIPE_GROUP = "steam_cracker_recipe";
    public static final ResourceLocation RECIPE_ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "steam_cracker_recipe");

    public SteamCrackerRecipe(String group, List<GasIngredient> inputGases, GasStack gasOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, inputGases, gasOutput, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) CSRecipies.STEAM_CRACKER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) CSRecipies.STEAM_CRACKER_TYPE.get();
    }
}
