package net.pastek.chemicalscience.registers.fluids;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.pastek.chemicalscience.ChemicalScience;

public class CSFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ChemicalScience.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_POTASSIUMCHLORIDE = FLUID_TYPES.register("potassiumchloride", () -> CSFluids.FLUID_POTASSIUMCHLORIDE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_SILICIUMTETRACHLORIDE = FLUID_TYPES.register("siliciumtetrachloride", () -> CSFluids.FLUID_SILICIUMTETRACHLORIDE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_MAGNESIUMSULFATE = FLUID_TYPES.register("sulfatemagnesium", () -> CSFluids.FLUID_MAGNESIUMSULFATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_PHOSPHORICACID = FLUID_TYPES.register("phosphoricacid", () -> CSFluids.FLUID_PHOSPHORICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_CALCIUMHYDROXIDE = FLUID_TYPES.register("calciumhydroxide", () -> CSFluids.FLUID_CALCIUMHYDROXIDE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_SODIUMHYDROXIDE = FLUID_TYPES.register("sodiumhydroxide", () -> CSFluids.FLUID_SODIUMHYDROXIDE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_ARSENICTRICHLORIDE = FLUID_TYPES.register("arsenictrichloride", () -> CSFluids.FLUID_ARSENICTRICHLORIDE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_BROMINE = FLUID_TYPES.register("bromine", () -> CSFluids.FLUID_BROMINE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_CHLORINE = FLUID_TYPES.register("chlorine", () -> CSFluids.FLUID_CHLORINE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_METHANOL = FLUID_TYPES.register("methanol", () -> CSFluids.FLUID_METHANOL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_COPPERNITRATE = FLUID_TYPES.register("coppernitrate", () -> CSFluids.FLUID_COPPERNITRATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_CARBONMONOXIDE = FLUID_TYPES.register("carbonmonoxide", () -> CSFluids.FLUID_CARBONMONOXIDE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_ACETICACID = FLUID_TYPES.register("aceticacid", () -> CSFluids.FLUID_ACETICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_BENZENE = FLUID_TYPES.register("benzene", () -> CSFluids.FLUID_BENZENE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_TOLUENE = FLUID_TYPES.register("toluene", () -> CSFluids.FLUID_TOLUENE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_IRONNITRATE = FLUID_TYPES.register("ironnitrate", () -> CSFluids.FLUID_IRONNITRATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_DIESEL = FLUID_TYPES.register("diesel", () -> CSFluids.FLUID_DIESEL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_MALEICACID = FLUID_TYPES.register("maleicacid", () -> CSFluids.FLUID_MALEICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_ESCHERICHIACOLI = FLUID_TYPES.register("escherichia_coli", () -> CSFluids.FLUID_ESCHERICHIACOLI.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_TRIETHYLPHOSPHATE = FLUID_TYPES.register("triethylphosphate", () -> CSFluids.FLUID_TRIETHYLPHOSPHATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_BROMOACETICACID = FLUID_TYPES.register("bromoaceticacid", () -> CSFluids.FLUID_BROMOACETICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_ETHYLBROMOACETATE = FLUID_TYPES.register("ethylbromoacetate", () -> CSFluids.FLUID_ETHYLBROMOACETATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_BENZONITRILE = FLUID_TYPES.register("benzonitrile", () -> CSFluids.FLUID_BENZONITRILE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_SUCCINICACID = FLUID_TYPES.register("succinicacid", () -> CSFluids.FLUID_SUCCINICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_AMMONIUMSUCCINATE = FLUID_TYPES.register("ammoniumsuccinate", () -> CSFluids.FLUID_AMMONIUMSUCCINATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_SODIUMPERCHLORATE = FLUID_TYPES.register("sodiumperchlorate", () -> CSFluids.FLUID_SODIUMPERCHLORATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_PERCHLORICACID = FLUID_TYPES.register("perchloricacid", () -> CSFluids.FLUID_PERCHLORICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_TETRACHLOROMETHANE = FLUID_TYPES.register("tetrachloromethane", () -> CSFluids.FLUID_TETRACHLOROMETHANE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_CHLOROBENZENE = FLUID_TYPES.register("chlorobenzene", () -> CSFluids.FLUID_CHLOROBENZENE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_BUTANE = FLUID_TYPES.register("butane", () -> CSFluids.FLUID_BUTANE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_THIOPHENE = FLUID_TYPES.register("thiophene", () -> CSFluids.FLUID_THIOPHENE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_PALLADIUMPHOSPHATE = FLUID_TYPES.register("palladiumphosphate", () -> CSFluids.FLUID_PALLADIUMPHOSPHATE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_ROYALEMINERALPLATINUM = FLUID_TYPES.register("fluidroyalmineralplatinum", () -> CSFluids.FLUID_ROYALMINERALPLATINUM.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_ROYALEMINERALPALLADIUM = FLUID_TYPES.register("fluidroyalmineralpalladium", () -> CSFluids.FLUID_ROYALMINERALPALLADIUM.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_HYDROBROMICACID = FLUID_TYPES.register("hydrobromic", () -> CSFluids.FLUID_HYDROBROMIC_ACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_BROMOMETHANE = FLUID_TYPES.register("bromomethane", () -> CSFluids.FLUID_BROMOMETHANE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_MALONICACID = FLUID_TYPES.register("malonicacid", () -> CSFluids.FLUID_MALONICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_CHLOROACETICACID = FLUID_TYPES.register("chloroaceticacid", () -> CSFluids.FLUID_CHLOROACETICACID.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_CRUDEOIL = FLUID_TYPES.register("crudeoil", () -> CSFluids.FLUID_CRUDEOIL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_IMPUREPETROLEUMGAS = FLUID_TYPES.register("impurepetroleumgas", () -> CSFluids.FLUID_IMPUREPETROLEUMGAS.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_IMPURENAPHTA = FLUID_TYPES.register("impurenaphta", () -> CSFluids.FLUID_IMPURENAPHTA.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_IMPUREDIESEL = FLUID_TYPES.register("impurediesel", () -> CSFluids.FLUID_IMPUREDIESEL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_IMPUREHEAVYOIL = FLUID_TYPES.register("impureheavyoil", () -> CSFluids.FLUID_IMPUREHEAVYOIL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_PROPANE = FLUID_TYPES.register("propane", () -> CSFluids.FLUID_PROPANE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_METHANE = FLUID_TYPES.register("methane", () -> CSFluids.FLUID_METHANE.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUIDFLUID_NAPHTA = FLUID_TYPES.register("naphta", () -> CSFluids.FLUID_NAPHTA.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_HEAVYOIL = FLUID_TYPES.register("heavyoil", () -> CSFluids.FLUID_HEAVYOIL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_FUEL = FLUID_TYPES.register("fuel", () -> CSFluids.FLUID_FUEL.get().getFluidType());
    public static final DeferredHolder<FluidType, FluidType> FLUID_TYPE_HYDROGENSULFIDE = FLUID_TYPES.register("hydrogensulfide", () -> CSFluids.FLUID_HYDROGENSULFIDE.get().getFluidType());


    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
