package net.pastek.chemicalscience.registers.gases;

import electrodynamics.registers.ElectrodynamicsItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import voltaic.api.gas.Gas;
import voltaic.registers.VoltaicGases;

public class CSGases {
    public static final DeferredRegister<Gas> GASES = DeferredRegister.create(VoltaicGases.GAS_REGISTRY_KEY, ChemicalScience.MOD_ID);

    public static final DeferredHolder<Gas, Gas> CHLORINE = GASES.register("chlorine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("chlorine"), 239, CSFluids.FLUID_CHLORINE));
    public static final DeferredHolder<Gas, Gas> CARBON_MONOXIDE = GASES.register("carbonmonoxide", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("carbonmonoxide"), 81, CSFluids.FLUID_CARBONMONOXIDE));
    public static final DeferredHolder<Gas, Gas> BROMINE = GASES.register("bromine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("bromine"), 331, CSFluids.FLUID_BROMINE));
    public static final DeferredHolder<Gas, Gas> BUTANE = GASES.register("butane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("butane"), 272, CSFluids.FLUID_BUTANE));
    public static final DeferredHolder<Gas, Gas> BROMOMETHANE = GASES.register("bromomethane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("bromomethane"), 179, CSFluids.FLUID_BROMOMETHANE));
    public static final DeferredHolder<Gas, Gas> IMPUREPETROLEUMGAS = GASES.register("impurepetroleumgas", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("impurepetroleumgas"), 310, CSFluids.FLUID_IMPUREPETROLEUMGAS));
    public static final DeferredHolder<Gas, Gas> IMPURENAPHTA = GASES.register("impurenaphta", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("impurenaphta"), 447, CSFluids.FLUID_IMPURENAPHTA));
    public static final DeferredHolder<Gas, Gas> PROPANE = GASES.register("propane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("propane"), 231, CSFluids.FLUID_PROPANE));
    public static final DeferredHolder<Gas, Gas> METHANE = GASES.register("methane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("methane"), 112, CSFluids.FLUID_METHANE));
    public static final DeferredHolder<Gas, Gas> HYDROGENSULFIDE = GASES.register("hydrogensulfide", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("hydrogensulfide"), 213, CSFluids.FLUID_HYDROGENSULFIDE));





    public static void register(IEventBus eventBus) {
        GASES.register(eventBus);
    }
}