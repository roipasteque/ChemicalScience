package net.pastek.chemicalscience.common.recipe.categories.misc;

import java.util.ArrayList;
import java.util.List;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.fluids.FluidStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.recipe.CSCountableIngredient;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.recipeutils.AbstractMaterialRecipe;
import voltaic.common.recipe.recipeutils.CountableIngredient;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentProcessor;

public class ChemicalBenchRecipe extends AbstractMaterialRecipe {

    public static final String RECIPE_GROUP = "chemical_bench_recipe";
    public static final ResourceLocation RECIPE_ID = ChemicalScience.rl(RECIPE_GROUP);

    private List<CSCountableIngredient> itemIngredients;
    private List<FluidIngredient> fluidIngredients;
    private List<GasIngredient> gasIngredients;
    private ItemStack itemOutput;
    private FluidStack fluidOutput;
    private GasStack gasOutput;

    public ChemicalBenchRecipe(String recipeGroup, List<CSCountableIngredient> inputItems, List<FluidIngredient> inputFluids, List<GasIngredient> inputGases, ItemStack itemOutput, FluidStack fluidOutput, GasStack gasOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(recipeGroup, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);

        if (inputItems.isEmpty() && inputGases.isEmpty() && inputFluids.isEmpty()) {
            throw new RuntimeException("You have created a chemical bench recipe with no inputs");
        }
        if (itemOutput.isEmpty() && fluidOutput.isEmpty() && gasOutput.isEmpty()) {
            throw new RuntimeException("You have created a chemical bench recipe with no outputs");
        }

        this.itemIngredients = inputItems;
        this.fluidIngredients = inputFluids;
        this.gasIngredients = inputGases;
        this.itemOutput = itemOutput;
        this.fluidOutput = fluidOutput;
        this.gasOutput = gasOutput;
    }

    @Override
    public boolean matchesRecipe(ComponentProcessor pr, int index) {
        int valid = 0b000;
        ComponentInventory inv = pr.getHolder().getComponent(IComponentType.Inventory);

        List<ItemStack> availableInputs = new ArrayList<>(inv.getInputsForProcessor(index));

        List<CSCountableIngredient> catalystReqs = itemIngredients.stream()
                .filter(CSCountableIngredient::isCatalyst)
                .toList();

        List<CountableIngredient> consumableReqs = itemIngredients.stream()
                .filter(i -> !i.isCatalyst())
                .map(CSCountableIngredient::ingredient)
                .toList();

        for (CSCountableIngredient req : catalystReqs) {
            boolean matchFound = false;
            for (int i = 0; i < availableInputs.size(); i++) {
                ItemStack stackInSlot = availableInputs.get(i);

                if (!stackInSlot.isEmpty() && req.ingredient().test(stackInSlot)) {
                    availableInputs.set(i, ItemStack.EMPTY);
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                return false;
            }
        }

        if (!consumableReqs.isEmpty()) {
            Pair<List<Integer>, Boolean> itemPair = areItemsValid(consumableReqs, availableInputs);
            if (itemPair.getSecond()) {
                setItemArrangement(index, itemPair.getFirst());
                valid |= 1 << 2;
            } else {
                return false;
            }
        } else {
            valid |= 1 << 2;
        }

        if (hasFluidInputs()) {
            Pair<List<Integer>, Boolean> fluidPair = areFluidsValid(getFluidIngredients(),
                    pr.getHolder().<ComponentFluidHandlerMulti>getComponent(IComponentType.FluidHandler).getInputTanks());
            if (fluidPair.getSecond()) {
                setFluidArrangement(fluidPair.getFirst());
                valid |= 1 << 1;
            } else {
                return false;
            }
        }

        if (hasGasInputs()) {
            Pair<List<Integer>, Boolean> gasPair = areGasesValid(getGasIngredients(),
                    pr.getHolder().<ComponentGasHandlerMulti>getComponent(IComponentType.GasHandler).getInputTanks());
            if (gasPair.getSecond()) {
                setGasArrangement(gasPair.getFirst());
                valid |= 1 << 0;
            } else {
                return false;
            }
        }

        return valid > 0;
    }

    public boolean hasItemInputs() {
        return getCountedIngredients().size() > 0;
    }

    public boolean hasFluidInputs() {
        return getFluidIngredients().size() > 0;
    }

    public boolean hasGasInputs() {
        return getGasIngredients().size() > 0;
    }

    public List<CSCountableIngredient> getCountedIngredients() {
        return itemIngredients;
    }

    @Override
    public List<FluidIngredient> getFluidIngredients() {
        return fluidIngredients;
    }

    @Override
    public List<GasIngredient> getGasIngredients() {
        return gasIngredients;
    }

    public boolean hasItemOutput() {
        return !getItemRecipeOutput().isEmpty();
    }

    public boolean hasFluidOutput() {
        return !getFluidRecipeOutput().isEmpty();
    }

    public boolean hasGasOutput() {
        return !getGasRecipeOutput().isEmpty();
    }

    @Override
    public ItemStack getItemRecipeOutput() {
        return itemOutput;
    }

    @Override
    public FluidStack getFluidRecipeOutput() {
        return fluidOutput;
    }

    @Override
    public GasStack getGasRecipeOutput() {
        return gasOutput;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CSRecipies.CHEMICAL_BENCH_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CSRecipies.CHEMICAL_BENCH_TYPE.get();
    }

    public String CSgetGroup() {
        return this.getGroup();
    }
}