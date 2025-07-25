package net.pastek.chemicalscience.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import java.util.function.Supplier;

public class CSCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChemicalScience.MOD_ID);
    public static final RegistryObject<CreativeModeTab> CHEMICAL_SCIENCE_TAB = CREATIVE_MODE_TAB.register("chemicalscience_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(CSBlocks.ORGANIC_SOLAR_PANEL.get())).title(Component.translatable("creativetab.chemicalscience")).displayItems((itemDisplayParameters, output) -> {

        /** BLOCKS */
        /** Ores */
        // Overworld
        output.accept(CSBlocks.ORE_ARSENOPYRITE.get());
        output.accept(CSBlocks.ORE_MAGNESIUM.get());
        output.accept(CSBlocks.ORE_SILICON.get());
        output.accept(CSBlocks.ORE_WOLFRAMITE.get());
        output.accept(CSBlocks.ORE_COOPERITE.get());
        output.accept(CSBlocks.ORE_PYROLUSITE.get());
        output.accept(CSBlocks.ORE_OIL.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_SILICON.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_COOPERITE.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_PYROLUSITE.get());
        output.accept(CSBlocks.ORE_DEEPSLATE_OIL.get());
        // Stellaris, Ad Astra, Galacticraft
        if (ModList.get().isLoaded("ad_astra")) {output.accept(CSBlocks.ORE_ARSENOPYRITE_MOON.get());output.accept(CSBlocks.ORE_ARSENOPYRITE_MARS.get());output.accept(CSBlocks.ORE_ARSENOPYRITE_VENUS.get());output.accept(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get());output.accept(CSBlocks.ORE_COOPERITE_MOON.get());output.accept(CSBlocks.ORE_COOPERITE_MARS.get());output.accept(CSBlocks.ORE_COOPERITE_VENUS.get());output.accept(CSBlocks.ORE_COOPERITE_MERCURY.get());output.accept(CSBlocks.ORE_MAGNESIUM_MOON.get());output.accept(CSBlocks.ORE_MAGNESIUM_MARS.get());output.accept(CSBlocks.ORE_MAGNESIUM_VENUS.get());output.accept(CSBlocks.ORE_MAGNESIUM_MERCURY.get());output.accept(CSBlocks.ORE_PYROLUSITE_MOON.get());output.accept(CSBlocks.ORE_PYROLUSITE_MARS.get());output.accept(CSBlocks.ORE_PYROLUSITE_MERCURY.get());output.accept(CSBlocks.ORE_PYROLUSITE_VENUS.get());output.accept(CSBlocks.ORE_SILICON_MOON.get());output.accept(CSBlocks.ORE_SILICON_MARS.get());output.accept(CSBlocks.ORE_SILICON_VENUS.get());output.accept(CSBlocks.ORE_SILICON_MERCURY.get());output.accept(CSBlocks.ORE_WOLFRAMITE_MOON.get());output.accept(CSBlocks.ORE_WOLFRAMITE_MARS.get());output.accept(CSBlocks.ORE_WOLFRAMITE_VENUS.get());output.accept(CSBlocks.ORE_WOLFRAMITE_MERCURY.get());output.accept(CSBlocks.ORE_ALUMINUM_MOON.get());output.accept(CSBlocks.ORE_ALUMINUM_MARS.get());output.accept(CSBlocks.ORE_ALUMINUM_VENUS.get());output.accept(CSBlocks.ORE_ALUMINUM_MERCURY.get());output.accept(CSBlocks.ORE_CHROMIUM_MOON.get());output.accept(CSBlocks.ORE_CHROMIUM_MARS.get());output.accept(CSBlocks.ORE_CHROMIUM_VENUS.get());output.accept(CSBlocks.ORE_CHROMIUM_MERCURY.get());output.accept(CSBlocks.ORE_FLUORITE_MOON.get());output.accept(CSBlocks.ORE_FLUORITE_MARS.get());output.accept(CSBlocks.ORE_FLUORITE_VENUS.get());output.accept(CSBlocks.ORE_FLUORITE_MERCURY.get());output.accept(CSBlocks.ORE_LEAD_MOON.get());output.accept(CSBlocks.ORE_LEAD_MARS.get());output.accept(CSBlocks.ORE_LEAD_VENUS.get());output.accept(CSBlocks.ORE_LEAD_MERCURY.get());output.accept(CSBlocks.ORE_LITHIUM_MOON.get());output.accept(CSBlocks.ORE_LITHIUM_MARS.get());output.accept(CSBlocks.ORE_LITHIUM_VENUS.get());output.accept(CSBlocks.ORE_LITHIUM_MERCURY.get());output.accept(CSBlocks.ORE_MOLYBDENUM_MOON.get());output.accept(CSBlocks.ORE_MOLYBDENUM_MARS.get());output.accept(CSBlocks.ORE_MOLYBDENUM_VENUS.get());output.accept(CSBlocks.ORE_MOLYBDENUM_MERCURY.get());output.accept(CSBlocks.ORE_MONAZITE_MOON.get());output.accept(CSBlocks.ORE_MONAZITE_MARS.get());output.accept(CSBlocks.ORE_MONAZITE_VENUS.get());output.accept(CSBlocks.ORE_MONAZITE_MERCURY.get());output.accept(CSBlocks.ORE_NITER_MOON.get());output.accept(CSBlocks.ORE_NITER_MARS.get());output.accept(CSBlocks.ORE_NITER_VENUS.get());output.accept(CSBlocks.ORE_NITER_MERCURY.get());output.accept(CSBlocks.ORE_SALT_MOON.get());output.accept(CSBlocks.ORE_SALT_MARS.get());output.accept(CSBlocks.ORE_SALT_VENUS.get());output.accept(CSBlocks.ORE_SALT_MERCURY.get());output.accept(CSBlocks.ORE_SILVER_MOON.get());output.accept(CSBlocks.ORE_SILVER_MARS.get());output.accept(CSBlocks.ORE_SILVER_VENUS.get());output.accept(CSBlocks.ORE_SILVER_MERCURY.get());output.accept(CSBlocks.ORE_SULFUR_MOON.get());output.accept(CSBlocks.ORE_SULFUR_MARS.get());output.accept(CSBlocks.ORE_SULFUR_VENUS.get());output.accept(CSBlocks.ORE_SULFUR_MERCURY.get());output.accept(CSBlocks.ORE_SYLVITE_MOON.get());output.accept(CSBlocks.ORE_SYLVITE_MARS.get());output.accept(CSBlocks.ORE_SYLVITE_VENUS.get());output.accept(CSBlocks.ORE_SYLVITE_MERCURY.get());output.accept(CSBlocks.ORE_TIN_MOON.get());output.accept(CSBlocks.ORE_TIN_MARS.get());output.accept(CSBlocks.ORE_TIN_VENUS.get());output.accept(CSBlocks.ORE_TIN_MERCURY.get());output.accept(CSBlocks.ORE_TITANIUM_MOON.get());output.accept(CSBlocks.ORE_TITANIUM_MARS.get());output.accept(CSBlocks.ORE_TITANIUM_VENUS.get());output.accept(CSBlocks.ORE_TITANIUM_MERCURY.get());output.accept(CSBlocks.ORE_THORIUM_MOON.get());output.accept(CSBlocks.ORE_THORIUM_MARS.get());output.accept(CSBlocks.ORE_THORIUM_VENUS.get());output.accept(CSBlocks.ORE_THORIUM_MERCURY.get());output.accept(CSBlocks.ORE_URANIUM_MOON.get());output.accept(CSBlocks.ORE_URANIUM_MARS.get());output.accept(CSBlocks.ORE_URANIUM_VENUS.get());output.accept(CSBlocks.ORE_URANIUM_MERCURY.get());output.accept(CSBlocks.ORE_VANADIUM_MOON.get());output.accept(CSBlocks.ORE_VANADIUM_MARS.get());output.accept(CSBlocks.ORE_VANADIUM_VENUS.get());output.accept(CSBlocks.ORE_VANADIUM_MERCURY.get());}
        /** Ressource Blocks */
        output.accept(CSBlocks.MAGNESIUM_BLOCK.get());
        output.accept(CSBlocks.SILICON_BLOCK.get());
        output.accept(CSBlocks.MANGANESE_BLOCK.get());
        output.accept(CSBlocks.TUNGSTEN_BLOCK.get());
        output.accept(CSBlocks.PLATINUM_BLOCK.get());
        /** Construction Blocks */
        // Magnesium alloy
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_BLOCK.get());
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_LAMP.get());
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_STAIR.get());
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_SLAB.get());
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_DOOR.get());
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_TRAPDOOR.get());
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_FENCE.get());
        // Manganese alloy
        output.accept(CSBlocks.MANGANESE_GRATE.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_GRATE.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_GLASS.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_HOLLOW.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_GRATE_HOLLOW.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_GLASS_HOLLOW.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_SLAB.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_GRATE_SLAB.get());
        output.accept(CSBlocks.MANGANESE_SCAFFOLDING_GLASS_SLAB.get());
        output.accept(CSBlocks.MANGANESE_LADDER.get());
        // Halide Lamps
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_WHITE.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_RED.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_GREEN.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_BLUE.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_WHITE.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_RED.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_GREEN.get());
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_BLUE.get());
        // Symbols
        output.accept(CSBlocks.SYMBOL_BIOHAZARD.get());
        output.accept(CSBlocks.SYMBOL_RADIATION.get());
        output.accept(CSBlocks.SYMBOL_ELECTRICAL.get());
        output.accept(CSBlocks.SYMBOL_DANGER.get());
        output.accept(CSBlocks.SYMBOL_FLAMMABLE.get());
        output.accept(CSBlocks.SYMBOL_TOXIC.get());
        output.accept(CSBlocks.SYMBOL_CORROSIVE.get());
        output.accept(CSBlocks.SYMBOL_PRESSURE.get());
        output.accept(CSBlocks.SYMBOL_EXPLOSIVE.get());
        // Storage
        output.accept(CSBlocks.RACK_MANGANESE.get());
        output.accept(CSBlocks.RACK_STEEL.get());
        // Laboratory Decoration
        output.accept(CSBlocks.LABORATORY_BENCH.get());
        output.accept(CSBlocks.LABORATORY_SUPPORT.get());
        output.accept(CSBlocks.LABORATORY_SINK.get());
        output.accept(CSBlocks.LABORATORY_STORAGE.get());
        // Asphalt
        output.accept(CSBlocks.ASPHALT_BLOCK.get());
        output.accept(CSBlocks.ASPHALT_STAIR.get());
        output.accept(CSBlocks.ASPHALT_SLAB.get());
        output.accept(CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK.get());
        output.accept(CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK.get());
        output.accept(CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK.get());
        output.accept(CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK.get());
        // Radiation Shielding
        output.accept(CSBlocks.CONCRETE_SHIELDING.get());
        output.accept(CSBlocks.TANTALUM_SHIELDING.get());
        output.accept(CSBlocks.GLASS_SHIELDING.get());
        output.accept(CSBlocks.ADVANCED_GLASS_SHIELDING.get());
        /** Machines */
        output.accept(CSBlocks.ORGANIC_SOLAR_PANEL.get());
        /* output.accept(CSBlocks.FUEL_CELL.get( );*/
        output.accept(CSBlocks.CIRCUIT_MAKER.get());

        /** ITEMS */
        /** Raw Materials */
        output.accept(CSItems.RAW_ORE_ARSENOPYRITE.get());
        output.accept(CSItems.RAW_ORE_SILICON.get());
        output.accept(CSItems.RAW_ORE_WOLFRAMITE.get());
        output.accept(CSItems.RAW_ORE_COOPERITE.get());
        output.accept(CSItems.RAW_ORE_PYROLUSITE.get());
        /** Ingots */
        output.accept(CSItems.INGOT_BORON.get());
        output.accept(CSItems.INGOT_BORON_CARBIDE.get());
        output.accept(CSItems.INGOT_BERYLLIUM.get());
        output.accept(CSItems.INGOT_MAGNESIUM.get());
        output.accept(CSItems.INGOT_MAGNESIUM_ALUMINUM.get());
        output.accept(CSItems.INGOT_SILICON.get());
        output.accept(CSItems.INGOT_MANGANESE.get());
        output.accept(CSItems.INGOT_MANGANESE_ALUMINUM.get());
        output.accept(CSItems.INGOT_NICKEL.get());
        output.accept(CSItems.INGOT_ZINC.get());
        output.accept(CSItems.INGOT_GALLIUMARSENIDE.get());
        output.accept(CSItems.INGOT_GERMANIUM.get());
        output.accept(CSItems.INGOT_NIOBIUM.get());
        output.accept(CSItems.INGOT_NIOBIUM_TITANIUM.get());
        output.accept(CSItems.INGOT_TANTALUM.get());
        output.accept(CSItems.INGOT_TUNGSTEN.get());
        output.accept(CSItems.INGOT_TUNGSTEN_CARBIDE.get());
        output.accept(CSItems.INGOT_MANGANIN.get());
        output.accept(CSItems.INGOT_PLATINUM.get());
        output.accept(CSItems.INGOT_PALLADIUM.get());
        /** Nuggets */
        output.accept(CSItems.NUGGET_MANGANESEALUMINUM.get());
        output.accept(CSItems.NUGGET_TUNGSTEN.get());
        /** Dusts */
        // Dust
        output.accept(CSItems.DUST_BORON.get());
        output.accept(CSItems.DUST_BERYLLIUM.get());
        output.accept(CSItems.DUST_ACTIVATEDCARBON.get());
        output.accept(CSItems.DUST_MAGNESIUM.get());
        output.accept(CSItems.DUST_SILICON.get());
        output.accept(CSItems.DUST_PHOSPHORUS.get());
        output.accept(CSItems.DUST_POTASSIUM.get());
        output.accept(CSItems.DUST_CALCIUM.get());
        output.accept(CSItems.DUST_SCANDIUM.get());
        output.accept(CSItems.DUST_COBALT.get());
        output.accept(CSItems.DUST_NICKEL.get());
        output.accept(CSItems.DUST_ZINC.get());
        output.accept(CSItems.DUST_GALLIUM.get());
        output.accept(CSItems.DUST_GERMANIUM.get());
        output.accept(CSItems.DUST_ARSENIC.get());
        output.accept(CSItems.DUST_STRONTIUM.get());
        output.accept(CSItems.DUST_YTTRIUM.get());
        output.accept(CSItems.DUST_NIOBIUM.get());
        output.accept(CSItems.DUST_TECHNETIUM.get());
        output.accept(CSItems.DUST_RUTHENIUM.get());
        output.accept(CSItems.DUST_RHODIUM.get());
        output.accept(CSItems.DUST_PALLADIUM.get());
        output.accept(CSItems.DUST_INDIUM.get());
        output.accept(CSItems.DUST_IODINE.get());
        output.accept(CSItems.DUST_BARIUM.get());
        output.accept(CSItems.DUST_LANTHANUM.get());
        output.accept(CSItems.DUST_CERIUM.get());
        output.accept(CSItems.DUST_PRASEODYMIUM.get());
        output.accept(CSItems.DUST_NEODYMIUM.get());
        output.accept(CSItems.DUST_PROMETHIUM.get());
        output.accept(CSItems.DUST_SAMARIUM.get());
        output.accept(CSItems.DUST_EUROPIUM.get());
        output.accept(CSItems.DUST_GADOLINIUM.get());
        output.accept(CSItems.DUST_TERBIUM.get());
        output.accept(CSItems.DUST_DYSPROSIUM.get());
        output.accept(CSItems.DUST_HOLMIUM.get());
        output.accept(CSItems.DUST_ERBIUM.get());
        output.accept(CSItems.DUST_THULIUM.get());
        output.accept(CSItems.DUST_YTTERBIUM.get());
        output.accept(CSItems.DUST_LUTECIUM.get());
        output.accept(CSItems.DUST_TANTALUM.get());
        output.accept(CSItems.DUST_TUNGSTEN.get());
        output.accept(CSItems.DUST_PLATINUM.get());
        output.accept(CSItems.DUST_BISMUTH.get());
        // Impure Dust
        output.accept(CSItems.IMPURE_DUST_BORON.get());
        output.accept(CSItems.IMPURE_DUST_BERYLLIUM.get());
        output.accept(CSItems.IMPURE_DUST_MAGNESIUM.get());
        output.accept(CSItems.IMPURE_DUST_SILICON.get());
        output.accept(CSItems.IMPURE_DUST_POTASSIUM.get());
        output.accept(CSItems.IMPURE_DUST_CALCIUM.get());
        output.accept(CSItems.IMPURE_DUST_SCANDIUM.get());
        output.accept(CSItems.IMPURE_DUST_MANGANESEOXIDE.get());
        output.accept(CSItems.IMPURE_DUST_COBALT.get());
        output.accept(CSItems.IMPURE_DUST_NICKEL.get());
        output.accept(CSItems.IMPURE_DUST_ZINC.get());
        output.accept(CSItems.IMPURE_DUST_GALLIUM.get());
        output.accept(CSItems.IMPURE_DUST_ARSENIC.get());
        output.accept(CSItems.IMPURE_DUST_ARSENOPYRITE.get());
        output.accept(CSItems.IMPURE_DUST_NIOBIUM.get());
        output.accept(CSItems.IMPURE_DUST_PALLADIUM.get());
        output.accept(CSItems.IMPURE_DUST_IODINE.get());
        output.accept(CSItems.IMPURE_DUST_CERIUM.get());
        output.accept(CSItems.IMPURE_DUST_TANTALUM.get());
        output.accept(CSItems.IMPURE_DUST_TUNGSTEN.get());
        output.accept(CSItems.IMPURE_DUST_PLATINUM.get());
        output.accept(CSItems.IMPURE_DUST_BISMUTH.get());
        /** Crystals */
        output.accept(CSItems.CRYSTAL_MAGNESIUM.get());
        output.accept(CSItems.CRYSTAL_MAGNESIUMCHLORIDE.get());
        output.accept(CSItems.CRYSTAL_POTASSIUMBROMIDE.get());
        output.accept(CSItems.CRYSTAL_ACETIC_ANHYDRIDE.get());
        /** Compound Dust */
        // Oxides
        output.accept(CSItems.DUST_CALCIUMOXIDE.get());
        output.accept(CSItems.DUST_MANGANESEOXIDE.get());
        output.accept(CSItems.DUST_IRONOXIDE.get());
        output.accept(CSItems.DUST_IRONTETROXIDE.get());
        output.accept(CSItems.DUST_URANIUMOXIDE.get());
        output.accept(CSItems.DUST_PLUTONIUMOXIDE.get());
        // Other
        output.accept(CSItems.DUST_MONAZITE.get());
        output.accept(CSItems.DUST_PLUTONIUMHYDROXIDE.get());
        output.accept(CSItems.DUST_TUNGSTEN_CARBIDE.get());
        output.accept(CSItems.DUST_PHOSPHORUS_CHLORIDE.get());
        output.accept(CSItems.DUST_PALLADIUM_CHLORIDE.get());
        output.accept(CSItems.DUST_PLATINUM_CHLORIDE.get());
        output.accept(CSItems.DUST_IRONARSENIDE.get());
        output.accept(CSItems.DUST_CHROMIUM_BROMIDE.get());

        // Organic
        output.accept(CSItems.DUST_UREA.get());
        output.accept(CSItems.DUST_DIMETHYLUREA.get());
        output.accept(CSItems.DUST_CAFFEINE.get());
        output.accept(CSItems.DUST_AMMONIUMCARBONATE.get());
        output.accept(CSItems.DUST_AMMONIUMDIURANATE.get());
        output.accept(CSItems.DUST_SUCCINIMIDE.get());
        output.accept(CSItems.DUST_NBROMOSUCCINIMIDE.get());
        output.accept(CSItems.DUST_TEREPHTHALOYLCHLORIDE.get());
        output.accept(CSItems.DUST_NITROCHLOROBENZENE.get());
        output.accept(CSItems.DUST_PARAPHENYLENEDIAMINE.get());
        /** Plates */
        output.accept(CSItems.PLATE_BORONCARBIDE.get());
        output.accept(CSItems.PLATE_BERYLLIUM.get());
        output.accept(CSItems.PLATE_SILICON.get());
        output.accept(CSItems.PLATE_NIOBIUM.get());
        output.accept(CSItems.PLATE_TANTALUM.get());
        output.accept(CSItems.PLATE_TUNGSTEN.get());
        /** Catalysts */
        output.accept(CSItems.COPPER_ZINC_ALUMINATE_CATALYST.get());
        output.accept(CSItems.IRON_ON_CARBON_CATALYST.get());
        output.accept(CSItems.PALLADIUM_ON_CARBON_CATALYST.get());
        output.accept(CSItems.MOLYBDENUM_SULFUR_CATALYST.get());
        output.accept(CSItems.RUTHENIUM_SULFUR_CATALYST.get());
        output.accept(CSItems.SILICA_ALUMINA_CATALYST.get());
        output.accept(CSItems.TITANIUM_MAGNESIUM_CATALYST.get());
        output.accept(CSItems.SULFONATED_POLYSTYRENE_CATALYST.get());
        output.accept(CSItems.RHODIUM_MANGANESE_BROMINE_CATALYST.get());
        /** Materials */
        // Chromatography Cards
        output.accept(CSItems.CHROMOTOGRAPHYCARD_CARBONMONOXIDE.get());
        output.accept(CSItems.CHROMOTOGRAPHYCARD_METHANE.get());
        output.accept(CSItems.CHROMOTOGRAPHYCARD_HELIUM.get());
        output.accept(CSItems.CHROMOTOGRAPHYCARD_NEON.get());
        output.accept(CSItems.CHROMOTOGRAPHYCARD_KRYPTON.get());
        output.accept(CSItems.CHROMOTOGRAPHYCARD_XENON.get());
        output.accept(CSItems.CHROMOTOGRAPHYCARD_RADON.get());
        // Gas Samples
        output.accept(CSItems.CARBON_SAMPLE_HELIUM.get());
        output.accept(CSItems.CARBON_SAMPLE_NEON.get());
        output.accept(CSItems.CARBON_SAMPLE_ARGON.get());
        output.accept(CSItems.CARBON_SAMPLE_KRYPTON.get());
        output.accept(CSItems.CARBON_SAMPLE_XENON.get());
        output.accept(CSItems.CARBON_SAMPLE_RADON.get());
        // Polymer
        output.accept(CSItems.DPP_POLYMER.get());
        output.accept(CSItems.DTT_POLYMER.get());
        output.accept(CSItems.DPPDTT_POLYMER.get());
        output.accept(CSItems.POLYPROPYLENE.get());
        output.accept(CSItems.POLYSTYRENE.get());
        output.accept(CSItems.PVC.get());
        output.accept(CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER.get());
        // Misc
        output.accept(CSItems.COIL_NIOBIUM_TITANIUM.get());
        output.accept(CSItems.ORGANIC_SOLAR_PANEL_PLATE.get());
        output.accept(CSItems.RAW_BORON_COMPOSITE.get());
        output.accept(CSItems.PLATING_BORON_COMPOSITE.get());
        output.accept(CSItems.RADIATIONSHIELDING_GLASS_DUST.get());
        output.accept(CSItems.RADIATIONSHIELDING_ADVANCEDGLASS_DUST.get());
        output.accept(CSItems.TRINITROTOLUENE.get());
        output.accept(CSItems.ASPHALT.get());
        output.accept(CSItems.CERAMIC_PASTE.get());
        output.accept(CSItems.PETRI_DISH.get());
        output.accept(CSItems.CULTURE_MEDIUM.get());
        output.accept(CSItems.E_COLI.get());
        output.accept(CSItems.CLOSTRIDIUM.get());
        output.accept(CSItems.SODA.get());
        /** Equipment */
        // Tools
        output.accept(CSItems.TUNGSTENCARBIDE_SWORD.get());
        output.accept(CSItems.TUNGSTENCARBIDE_PICKAXE.get());
        output.accept(CSItems.TUNGSTENCARBIDE_AXE.get());
        output.accept(CSItems.TUNGSTENCARBIDE_SHOVEL.get());
        output.accept(CSItems.TUNGSTENCARBIDE_HOE.get());


    }).build());
    public static final Supplier<CreativeModeTab> CHEMICAL_SCIENCE_PERIODICTABLE_TAB = CREATIVE_MODE_TAB.register("chemicalscienceperiodictable_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(CSBlocks.ELEMENT_MG.get())).title(Component.translatable("creativetab.chemicalscienceperiodictable")).displayItems((itemDisplayParameters, output) -> {

        output.accept(CSBlocks.ELEMENT_H.get());
        output.accept(CSBlocks.ELEMENT_HE.get());
        output.accept(CSBlocks.ELEMENT_LI.get());
        output.accept(CSBlocks.ELEMENT_BE.get());
        output.accept(CSBlocks.ELEMENT_B.get());
        output.accept(CSBlocks.ELEMENT_C.get());
        output.accept(CSBlocks.ELEMENT_N.get());
        output.accept(CSBlocks.ELEMENT_O.get());
        output.accept(CSBlocks.ELEMENT_F.get());
        output.accept(CSBlocks.ELEMENT_NE.get());
        output.accept(CSBlocks.ELEMENT_NA.get());
        output.accept(CSBlocks.ELEMENT_MG.get());
        output.accept(CSBlocks.ELEMENT_AL.get());
        output.accept(CSBlocks.ELEMENT_SI.get());
        output.accept(CSBlocks.ELEMENT_P.get());
        output.accept(CSBlocks.ELEMENT_S.get());
        output.accept(CSBlocks.ELEMENT_CL.get());
        output.accept(CSBlocks.ELEMENT_AR.get());
        output.accept(CSBlocks.ELEMENT_K.get());
        output.accept(CSBlocks.ELEMENT_CA.get());
        output.accept(CSBlocks.ELEMENT_SC.get());
        output.accept(CSBlocks.ELEMENT_TI.get());
        output.accept(CSBlocks.ELEMENT_V.get());
        output.accept(CSBlocks.ELEMENT_CR.get());
        output.accept(CSBlocks.ELEMENT_MN.get());
        output.accept(CSBlocks.ELEMENT_FE.get());
        output.accept(CSBlocks.ELEMENT_CO.get());
        output.accept(CSBlocks.ELEMENT_NI.get());
        output.accept(CSBlocks.ELEMENT_CU.get());
        output.accept(CSBlocks.ELEMENT_ZN.get());
        output.accept(CSBlocks.ELEMENT_GA.get());
        output.accept(CSBlocks.ELEMENT_GE.get());
        output.accept(CSBlocks.ELEMENT_AS.get());
        output.accept(CSBlocks.ELEMENT_SE.get());
        output.accept(CSBlocks.ELEMENT_BR.get());
        output.accept(CSBlocks.ELEMENT_KR.get());
        output.accept(CSBlocks.ELEMENT_RB.get());
        output.accept(CSBlocks.ELEMENT_SR.get());
        output.accept(CSBlocks.ELEMENT_Y.get());
        output.accept(CSBlocks.ELEMENT_ZR.get());
        output.accept(CSBlocks.ELEMENT_NB.get());
        output.accept(CSBlocks.ELEMENT_MO.get());
        output.accept(CSBlocks.ELEMENT_TC.get());
        output.accept(CSBlocks.ELEMENT_RU.get());
        output.accept(CSBlocks.ELEMENT_RH.get());
        output.accept(CSBlocks.ELEMENT_PD.get());
        output.accept(CSBlocks.ELEMENT_AG.get());
        output.accept(CSBlocks.ELEMENT_CD.get());
        output.accept(CSBlocks.ELEMENT_IN.get());
        output.accept(CSBlocks.ELEMENT_SN.get());
        output.accept(CSBlocks.ELEMENT_SB.get());
        output.accept(CSBlocks.ELEMENT_TE.get());
        output.accept(CSBlocks.ELEMENT_I.get());
        output.accept(CSBlocks.ELEMENT_XE.get());
        output.accept(CSBlocks.ELEMENT_CS.get());
        output.accept(CSBlocks.ELEMENT_BA.get());
        output.accept(CSBlocks.ELEMENT_LA.get());
        output.accept(CSBlocks.ELEMENT_CE.get());
        output.accept(CSBlocks.ELEMENT_PR.get());
        output.accept(CSBlocks.ELEMENT_ND.get());
        output.accept(CSBlocks.ELEMENT_PM.get());
        output.accept(CSBlocks.ELEMENT_SM.get());
        output.accept(CSBlocks.ELEMENT_EU.get());
        output.accept(CSBlocks.ELEMENT_GD.get());
        output.accept(CSBlocks.ELEMENT_TB.get());
        output.accept(CSBlocks.ELEMENT_DY.get());
        output.accept(CSBlocks.ELEMENT_HO.get());
        output.accept(CSBlocks.ELEMENT_ER.get());
        output.accept(CSBlocks.ELEMENT_TM.get());
        output.accept(CSBlocks.ELEMENT_YB.get());
        output.accept(CSBlocks.ELEMENT_LU.get());
        output.accept(CSBlocks.ELEMENT_HF.get());
        output.accept(CSBlocks.ELEMENT_TA.get());
        output.accept(CSBlocks.ELEMENT_W.get());
        output.accept(CSBlocks.ELEMENT_RE.get());
        output.accept(CSBlocks.ELEMENT_OS.get());
        output.accept(CSBlocks.ELEMENT_IR.get());
        output.accept(CSBlocks.ELEMENT_PT.get());
        output.accept(CSBlocks.ELEMENT_AU.get());
        output.accept(CSBlocks.ELEMENT_HG.get());
        output.accept(CSBlocks.ELEMENT_TL.get());
        output.accept(CSBlocks.ELEMENT_PB.get());
        output.accept(CSBlocks.ELEMENT_BI.get());
        output.accept(CSBlocks.ELEMENT_PO.get());
        output.accept(CSBlocks.ELEMENT_AT.get());
        output.accept(CSBlocks.ELEMENT_RN.get());
        output.accept(CSBlocks.ELEMENT_FR.get());
        output.accept(CSBlocks.ELEMENT_RA.get());
        output.accept(CSBlocks.ELEMENT_AC.get());
        output.accept(CSBlocks.ELEMENT_TH.get());
        output.accept(CSBlocks.ELEMENT_PA.get());
        output.accept(CSBlocks.ELEMENT_U.get());
        output.accept(CSBlocks.ELEMENT_NP.get());
        output.accept(CSBlocks.ELEMENT_PU.get());
        output.accept(CSBlocks.ELEMENT_AM.get());
        output.accept(CSBlocks.ELEMENT_CM.get());
        output.accept(CSBlocks.ELEMENT_BK.get());
        output.accept(CSBlocks.ELEMENT_CF.get());
        output.accept(CSBlocks.ELEMENT_ES.get());
        output.accept(CSBlocks.ELEMENT_FM.get());
        output.accept(CSBlocks.ELEMENT_MD.get());
        output.accept(CSBlocks.ELEMENT_NO.get());
        output.accept(CSBlocks.ELEMENT_LR.get());
        output.accept(CSBlocks.ELEMENT_RF.get());
        output.accept(CSBlocks.ELEMENT_DB.get());
        output.accept(CSBlocks.ELEMENT_SG.get());
        output.accept(CSBlocks.ELEMENT_BH.get());
        output.accept(CSBlocks.ELEMENT_HS.get());
        output.accept(CSBlocks.ELEMENT_MT.get());
        output.accept(CSBlocks.ELEMENT_DS.get());
        output.accept(CSBlocks.ELEMENT_RG.get());
        output.accept(CSBlocks.ELEMENT_CN.get());
        output.accept(CSBlocks.ELEMENT_NH.get());
        output.accept(CSBlocks.ELEMENT_FL.get());
        output.accept(CSBlocks.ELEMENT_MC.get());
        output.accept(CSBlocks.ELEMENT_LV.get());
        output.accept(CSBlocks.ELEMENT_TS.get());
        output.accept(CSBlocks.ELEMENT_OG.get());

    }).build());
    public static void register(IEventBus eventBus) {CREATIVE_MODE_TAB.register(eventBus);}}