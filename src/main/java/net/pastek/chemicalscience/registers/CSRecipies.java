package net.pastek.chemicalscience.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.common.recipe.categories.fluid2fluid.specificmachines.FractionatingColumnRecipe;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2item.CircuitMakerRecipe;
import voltaic.common.recipe.VoltaicRecipeType;
import voltaic.common.recipe.categories.fluid2fluid.Fluid2FluidRecipeSerializer;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipeSerializer;

public class CSRecipies {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER;
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES;
    public static final DeferredHolder<RecipeType<?>, RecipeType<CircuitMakerRecipe>> CIRCUIT_MAKER_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<FractionatingColumnRecipe>> FRACTIONATING_COLUMN_TYPE;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> CIRCUIT_MAKER_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> FRACTIONATING_COLUMN_SERIALIZER;

    static {
        RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "chemicalscience");
        RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, "chemicalscience");

        CIRCUIT_MAKER_TYPE = RECIPE_TYPES.register("circuit_maker_recipe", VoltaicRecipeType::new);
        FRACTIONATING_COLUMN_TYPE = RECIPE_TYPES.register("fractionating_column_recipe", VoltaicRecipeType::new);

        CIRCUIT_MAKER_SERIALIZER = RECIPE_SERIALIZER.register("circuit_maker_recipe", () -> new FluidItem2ItemRecipeSerializer(CircuitMakerRecipe::new));
        FRACTIONATING_COLUMN_SERIALIZER = RECIPE_SERIALIZER.register("fractionating_column_recipe", () -> new Fluid2FluidRecipeSerializer(FractionatingColumnRecipe::new));
    }
}
