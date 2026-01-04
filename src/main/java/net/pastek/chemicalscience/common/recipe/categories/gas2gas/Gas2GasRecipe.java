package net.pastek.chemicalscience.common.recipe.categories.gas2gas;

import com.mojang.datafixers.util.Pair;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.recipeutils.*;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentProcessor;

import java.util.List;

public abstract class Gas2GasRecipe extends AbstractMaterialRecipe {

    private List<GasIngredient> gasIngredients;
    private GasStack outputStack;

    public Gas2GasRecipe(String group, List<GasIngredient> inputGases, GasStack outputGas, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
        gasIngredients = inputGases;
        outputStack = outputGas;
    }

    @Override
    public boolean matchesRecipe(ComponentProcessor pr, int procNumber) {
        Pair<List<Integer>, Boolean> gasPair = areGasesValid(getGasIngredients(), pr.getHolder().<ComponentGasHandlerMulti>getComponent(IComponentType.GasHandler).getInputTanks());
        if (gasPair.getSecond()) {
            setGasArrangement(gasPair.getFirst());
            return true;
        }

        return false;
    }

    @Override
    public List<GasIngredient> getGasIngredients() {
        return gasIngredients;
    }

    @Override
    public GasStack getGasRecipeOutput() {
        return outputStack;
    }

    public interface Factory<T extends Gas2GasRecipe> {

        T create(String group, List<GasIngredient> inputGases, GasStack outputGas, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts);

    }

}