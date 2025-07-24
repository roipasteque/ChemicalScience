package net.pastek.chemicalscience.common.recipe.categories.fluiditem2item;

import java.util.List;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipe;
import voltaic.common.recipe.recipeutils.CountableIngredient;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;

public class CircuitMakerRecipe extends FluidItem2ItemRecipe {
    public static final String RECIPE_GROUP = "circuit_maker_recipe";
    public static final ResourceLocation RECIPE_ID = new ResourceLocation(ChemicalScience.MOD_ID, "circuit_maker_recipe");

    public CircuitMakerRecipe(ResourceLocation group, List<CountableIngredient> inputItems, List<FluidIngredient> inputFluids, ItemStack itemOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, inputItems, inputFluids, itemOutput, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return null;
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) CSRecipies.CIRCUIT_MAKER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType)CSRecipies.CIRCUIT_MAKER_TYPE.get();
    }
}
