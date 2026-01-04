package net.pastek.chemicalscience.common.recipe.categories.fluiditem2fluid.specificmachines;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.fluids.FluidStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.common.recipe.categories.fluiditem2fluid.FluidItem2FluidRecipe;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipe;
import voltaic.common.recipe.recipeutils.*;

import java.util.List;

public class CatalyticReformerRecipe extends FluidItem2FluidRecipe {
    public static final String RECIPE_GROUP = "catalytic_reformer_recipe";
    public static final ResourceLocation RECIPE_ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "catalytic_reformer_recipe");

    public CatalyticReformerRecipe(String group, List<CountableIngredient> inputItems, List<FluidIngredient> inputFluids, FluidStack fluidOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, inputItems, inputFluids, fluidOutput, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) CSRecipies.CATALYTIC_REFORMER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType)CSRecipies.CATALYTIC_REFORMER_TYPE.get();
    }
}
