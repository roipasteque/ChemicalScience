package net.pastek.chemicalscience.compatibility.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.screen.ScreenCircuitMaker;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2item.CircuitMakerRecipe;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.fluiditem2item.CircuitMakerRecipeCategory;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import net.pastek.chemicalscience.registers.gases.CSGases;
import org.jetbrains.annotations.NotNull;
import voltaic.api.gas.Gas;
import voltaic.api.gas.GasStack;
import voltaic.compatibility.jei.utils.ingredients.VoltaicJeiTypes;
import voltaic.registers.VoltaicGases;

@JeiPlugin
public class CSJEIPlugin implements IModPlugin {

    public static final ResourceLocation ID = new ResourceLocation(ChemicalScience.MOD_ID, "jei");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(CircuitMakerRecipeCategory.INPUT_MACHINE, new RecipeType[]{CircuitMakerRecipeCategory.RECIPE_TYPE});
    }

    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        ClientLevel world = (ClientLevel) Objects.requireNonNull(mc.level);
        RecipeManager recipeManager = world.getRecipeManager();
        registration.addRecipes(CircuitMakerRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.CIRCUIT_MAKER_TYPE.get()));
    }

    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new IRecipeCategory[]{new CircuitMakerRecipeCategory(guiHelper)});
    }

    public void registerGuiHandlers(IGuiHandlerRegistration registry) {
        registry.addRecipeClickArea(ScreenCircuitMaker.class, 85, 35, 22, 15, new RecipeType[]{CircuitMakerRecipeCategory.RECIPE_TYPE});
    }

        @Override
    public void registerExtraIngredients(IExtraIngredientRegistration registration) {
        List<FluidStack> fluids = new ArrayList<>();
        for (RegistryObject<Fluid> fluid : CSFluids.FLUIDS.getEntries()) {
            fluids.add(new FluidStack(fluid.get(), 1000));
        }
        registration.addExtraIngredients(ForgeTypes.FLUID_STACK, fluids);

        List<GasStack> gases = new ArrayList<>();
        for(RegistryObject<Gas> gas : CSGases.GASES.getEntries()) {
            if(gas.get() == VoltaicGases.EMPTY.get()) {
                continue;
            }

            gases.add(new GasStack(gas.get(), 1000, Gas.ROOM_TEMPERATURE, Gas.PRESSURE_AT_SEA_LEVEL));
        }
        registration.addExtraIngredients(VoltaicJeiTypes.GAS_STACK, gases);
    }
}