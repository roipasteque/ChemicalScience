package net.pastek.chemicalscience.compatibility.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.registration.IExtraIngredientRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import net.pastek.chemicalscience.registers.gases.CSGases;
import org.jetbrains.annotations.NotNull;
import voltaic.api.gas.Gas;
import voltaic.api.gas.GasStack;
import voltaic.compatibility.jei.utils.ingredients.VoltaicJeiTypes;
import voltaic.registers.VoltaicGases;

@JeiPlugin
public class CSJEIPlugin implements IModPlugin {

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "jei");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }


    @Override
    public void registerExtraIngredients(IExtraIngredientRegistration registration) {
        List<FluidStack> fluids = new ArrayList<>();
        for (DeferredHolder<Fluid, ? extends Fluid> fluid : CSFluids.FLUIDS.getEntries()) {
            fluids.add(new FluidStack(fluid.get(), 1000));
        }
        registration.addExtraIngredients(NeoForgeTypes.FLUID_STACK, fluids);

        List<GasStack> gases = new ArrayList<>();
        for(DeferredHolder<Gas, ? extends Gas> gas : CSGases.GASES.getEntries()) {
            if(gas.get() == VoltaicGases.EMPTY.value()) {
                continue;
            }

            gases.add(new GasStack(gas.get(), 1000, Gas.ROOM_TEMPERATURE, Gas.PRESSURE_AT_SEA_LEVEL));
        }
        registration.addExtraIngredients(VoltaicJeiTypes.GAS_STACK, gases);
    }
}