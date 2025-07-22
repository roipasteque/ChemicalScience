package net.pastek.chemicalscience.registers.gases;

import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import voltaic.api.gas.Gas;
import voltaic.prefab.utilities.math.Color;
import voltaic.registers.VoltaicRegistries;

public class CSGases {
    public static final DeferredRegister<Gas> GASES = DeferredRegister.create(VoltaicRegistries.GAS_REGISTRY_KEY, ChemicalScience.MOD_ID);

    /** Hydrocarbons */
    public static final RegistryObject<Gas> METHANE = GASES.register("methane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("methane"), 112, new Color(255, 255, 255, 180), CSFluids.FLUID_METHANE::get));
    public static final RegistryObject<Gas> ETHYLENE = GASES.register("ethylene", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("ethylene"), 170, new Color(255, 255, 255, 180), CSFluids.FLUID_ETHYLENE::get));
    public static final RegistryObject<Gas> PROPANE = GASES.register("propane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("propane"), 231, new Color(255, 255, 255, 180), CSFluids.FLUID_PROPANE::get));
    public static final RegistryObject<Gas> PROPYLENE = GASES.register("propylene", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("propylene"), 226, new Color(255, 255, 255, 180), CSFluids.FLUID_PROPYLENE::get));
    public static final RegistryObject<Gas> BUTANE = GASES.register("butane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("butane"), 272, new Color(255, 255, 255, 180), CSFluids.FLUID_BUTANE::get));

    /** Petroleum */
    public static final RegistryObject<Gas> IMPUREPETROLEUMGAS = GASES.register("impurepetroleumgas", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("impurepetroleumgas"), 310, new Color(155, 155, 155, 180), CSFluids.FLUID_IMPUREPETROLEUMGAS::get));
    public static final RegistryObject<Gas> IMPURENAPHTA = GASES.register("impurenaphta", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("impurenaphta"), 447, new Color(155, 155, 155, 180), CSFluids.FLUID_IMPURENAPHTA::get));

    /** Misc */
    public static final RegistryObject<Gas> CARBON_MONOXIDE = GASES.register("carbonmonoxide", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("carbonmonoxide"), 81, new Color(255, 255, 255, 180), CSFluids.FLUID_CARBONMONOXIDE::get));
    public static final RegistryObject<Gas> HYDROGENSULFIDE = GASES.register("hydrogensulfide", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("hydrogensulfide"), 213, new Color(255, 255, 225, 180), CSFluids.FLUID_HYDROGENSULFIDE::get));

    /** Halides */
    public static final RegistryObject<Gas> CHLORINE = GASES.register("chlorine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("chlorine"), 239, new Color(225, 255, 0, 180), CSFluids.FLUID_CHLORINE::get));
    public static final RegistryObject<Gas> VINYLCHLORIDE = GASES.register("vinylchloride", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("vinylchloride"), 260, new Color(255, 255, 255, 180), CSFluids.FLUID_VINYLCHLORIDE::get));
    public static final RegistryObject<Gas> BROMINE = GASES.register("bromine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("bromine"), 331, new Color(255, 0, 30, 180), CSFluids.FLUID_BROMINE::get));
    public static final RegistryObject<Gas> BROMOMETHANE = GASES.register("bromomethane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("bromomethane"), 179, new Color(255, 255, 255, 180), CSFluids.FLUID_BROMOMETHANE::get));

    /** Noble gases */
    public static final RegistryObject<Gas> HELIUM = GASES.register("helium", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("helium"), 4, new Color(255, 255, 255, 255), CSFluids.FLUID_HELIUM::get));
    public static final RegistryObject<Gas> NEON = GASES.register("neon", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("neon"), 27, new Color(255, 255, 255, 255), CSFluids.FLUID_NEON::get));
    public static final RegistryObject<Gas> KRYPTON = GASES.register("krypton", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("krypton"), 120, new Color(255, 255, 255, 255), CSFluids.FLUID_KRYPTON::get));
    public static final RegistryObject<Gas> XENON = GASES.register("xenon", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("xenon"), 165, new Color(255, 255, 255, 255), CSFluids.FLUID_XENON::get));
    public static final RegistryObject<Gas> RADON = GASES.register("radon", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER::get, CSTextUtils.gas("radon"), 212, new Color(255, 255, 255, 255), CSFluids.FLUID_RADON::get));

    public static void register(IEventBus eventBus) {
        GASES.register(eventBus);
    }
}