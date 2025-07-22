package net.pastek.chemicalscience.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2item.CircuitMakerRecipe;
import voltaic.common.recipe.VoltaicRecipeType;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipeSerializer;

public class CSRecipies {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER;
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES;
    public static final RegistryObject<RecipeType<CircuitMakerRecipe>> CIRCUIT_MAKER_TYPE;
    public static final RegistryObject<RecipeSerializer<?>> CIRCUIT_MAKER_SERIALIZER;

    static {
        RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "chemicalscience");
        RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, "chemicalscience");

        CIRCUIT_MAKER_TYPE = RECIPE_TYPES.register("circuit_maker_recipe", VoltaicRecipeType::new);

        CIRCUIT_MAKER_SERIALIZER = RECIPE_SERIALIZER.register("circuit_maker_recipe", () -> new FluidItem2ItemRecipeSerializer(CircuitMakerRecipe::new));
    }

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
        RECIPE_SERIALIZER.register(eventBus);
    }
}
