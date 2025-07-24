package net.pastek.chemicalscience.registers;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2item.CircuitMakerRecipe;
import voltaic.common.recipe.VoltaicRecipeType;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipeSerializer;

public class CSRecipies {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER;
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES;
    public static final RegistryObject<RecipeType<CircuitMakerRecipe>> CIRCUIT_MAKER_TYPE;
    public static final RegistryObject<RecipeSerializer<?>> CIRCUIT_MAKER_SERIALIZER;

    static {
        RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ChemicalScience.MOD_ID);
        RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, ChemicalScience.MOD_ID);

        CIRCUIT_MAKER_TYPE = RECIPE_TYPES.register(CircuitMakerRecipe.RECIPE_GROUP, VoltaicRecipeType::new);

        CIRCUIT_MAKER_SERIALIZER = RECIPE_SERIALIZER.register(CircuitMakerRecipe.RECIPE_GROUP, () -> new FluidItem2ItemRecipeSerializer<>(CircuitMakerRecipe::new));
    }

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
        RECIPE_SERIALIZER.register(eventBus);
    }
}
