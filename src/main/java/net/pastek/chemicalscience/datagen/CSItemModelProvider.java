package net.pastek.chemicalscience.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
import net.pastek.chemicalscience.registers.CSItems;

public class CSItemModelProvider extends ItemModelProvider {
    public CSItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChemicalScience.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Raw ores
        withExistingParent(CSItems.RAW_ORE_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/rawore/rawore_silicon");
        withExistingParent(CSItems.RAW_ORE_ARSENOPYRITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/rawore/rawore_arsenopyrite");
        withExistingParent(CSItems.RAW_ORE_WOLFRAMITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/rawore/rawore_wolframite");
        withExistingParent(CSItems.RAW_ORE_COOPERITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/rawore/rawore_cooperite");
        withExistingParent(CSItems.RAW_ORE_PYROLUSITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/rawore/rawore_pyrolusite");


        // Crystals
        withExistingParent(CSItems.CRYSTAL_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/crystal/crystal_magnesium");
        withExistingParent(CSItems.CRYSTAL_ACETIC_ANHYDRIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/crystal/crystal_aceticanhydride");
        withExistingParent(CSItems.CRYSTAL_MAGNESIUMCHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/crystal/crystal_magnesiumchloride");

        // Dusts
        withExistingParent(CSItems.DUST_BORON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_boron");
        withExistingParent(CSItems.DUST_ACTIVATEDCARBON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_activatedcarbon");
        withExistingParent(CSItems.DUST_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_magnesium");
        withExistingParent(CSItems.DUST_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_silicon");
        withExistingParent(CSItems.DUST_PHOSPHORUS.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_phosphorus");
        withExistingParent(CSItems.DUST_PHOSPHORUS_CHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_phosphoruschloride");
        withExistingParent(CSItems.DUST_MONAZITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_monazite");
        withExistingParent(CSItems.DUST_ARSENOPYRITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_arsenopyrite");
        withExistingParent(CSItems.DUST_GALLIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_gallium");
        withExistingParent(CSItems.DUST_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_tungsten");
        withExistingParent(CSItems.DUST_IRONOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ironoxide");
        withExistingParent(CSItems.DUST_CALCIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_calciumoxide");
        withExistingParent(CSItems.DUST_CERIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ceriumoxide");
        withExistingParent(CSItems.DUST_MANGANESEOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_manganeseoxide");
        withExistingParent(CSItems.DUST_URANIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_uraniumoxide");
        withExistingParent(CSItems.DUST_PLUTONIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_plutoniumoxide");
        withExistingParent(CSItems.DUST_PLUTONIUMHYDROXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_plutoniumhydroxide");
        withExistingParent(CSItems.DUST_LANTHANUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_lanthanum");
        withExistingParent(CSItems.DUST_PRASEODYMIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_praseodymium");
        withExistingParent(CSItems.DUST_NEODYMIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_neodymium");
        withExistingParent(CSItems.DUST_PROMETHIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_promethium");
        withExistingParent(CSItems.DUST_SAMARIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_samarium");
        withExistingParent(CSItems.DUST_EUROPIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_europium");
        withExistingParent(CSItems.DUST_GADOLINIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_gadolinium");
        withExistingParent(CSItems.DUST_TERBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_terbium");
        withExistingParent(CSItems.DUST_DYSPROSIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_dysprosium");
        withExistingParent(CSItems.DUST_HOLMIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_holmium");
        withExistingParent(CSItems.DUST_ERBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_erbium");
        withExistingParent(CSItems.DUST_THULIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_thulium");
        withExistingParent(CSItems.DUST_YTTERBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ytterbium");
        withExistingParent(CSItems.DUST_LUTECIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_lutecium");
        withExistingParent(CSItems.DUST_STRONTIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_strontium");
        withExistingParent(CSItems.DUST_BARIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_barium");
        withExistingParent(CSItems.DUST_NIOBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_niobium");
        withExistingParent(CSItems.DUST_TECHNETIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_technetium");
        withExistingParent(CSItems.DUST_RHODIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_rhodium");
        withExistingParent(CSItems.DUST_UREA.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_urea");
        withExistingParent(CSItems.DUST_DIMETHYLUREA.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_dimethylurea");
        withExistingParent(CSItems.DUST_CAFFEINE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_caffeine");
        withExistingParent(CSItems.DUST_PLATINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_platinum");
        withExistingParent(CSItems.DUST_PLATINUM_CHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_platinumchloride");
        withExistingParent(CSItems.DUST_PALLADIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_palladium");
        withExistingParent(CSItems.DUST_PALLADIUM_CHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_palladiumchloride");
        withExistingParent(CSItems.DUST_RUTHENIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ruthenium");
        withExistingParent(CSItems.DUST_CHROMIUM_BROMIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_chromiumbromide");
        withExistingParent(CSItems.DUST_TUNGSTEN_CARBIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_tungstencarbide");
        withExistingParent(CSItems.DUST_AMMONIUMCARBONATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ammoniumcarbonate");
        withExistingParent(CSItems.DUST_AMMONIUMDIURANATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ammoniumdiuranate");
        withExistingParent(CSItems.DUST_SUCCINIMIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_succinimide");
        withExistingParent(CSItems.DUST_NBROMOSUCCINIMIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_nbromosuccinimide");
        withExistingParent(CSItems.DUST_TEREPHTHALOYLCHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_terephthaloylchloride");
        withExistingParent(CSItems.DUST_NITROCHLOROBENZENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_nitrochlorobenzene");
        withExistingParent(CSItems.DUST_PARAPHENYLENEDIAMINE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_paraphenylenediamine");
        withExistingParent(CSItems.IMPURE_DUST_BORON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_boron");
        withExistingParent(CSItems.IMPURE_DUST_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_magnesium");
        withExistingParent(CSItems.IMPURE_DUST_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_silicon");
        withExistingParent(CSItems.IMPURE_DUST_CERIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_ceriumoxide");
        withExistingParent(CSItems.IMPURE_DUST_MANGANESEOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_manganeseoxide");
        withExistingParent(CSItems.IMPURE_DUST_ARSENOPYRITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_arsenopyrite");
        withExistingParent(CSItems.IMPURE_DUST_GALLIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_gallium");
        withExistingParent(CSItems.IMPURE_DUST_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_tungsten");
        withExistingParent(CSItems.IMPURE_DUST_PLATINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_platinum");
        withExistingParent(CSItems.IMPURE_DUST_PALLADIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_palladium");
        withExistingParent(CSItems.IMPURE_DUST_NIOBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_niobium");


        // Ingots
        withExistingParent(CSItems.INGOT_BORON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_boron");
        withExistingParent(CSItems.INGOT_BORON_CARBIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_boroncarbide");
        withExistingParent(CSItems.INGOT_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_magnesium");
        withExistingParent(CSItems.INGOT_MAGNESIUM_ALUMINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_magnesiumaluminum");
        withExistingParent(CSItems.INGOT_MANGANESE_ALUMINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_manganesealuminum");
        withExistingParent(CSItems.INGOT_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_silicon");
        withExistingParent(CSItems.INGOT_GALLIUMARSENIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_galliumarsenide");
        withExistingParent(CSItems.INGOT_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_tungsten");
        withExistingParent(CSItems.INGOT_TUNGSTEN_CARBIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_tungstencarbide");
        withExistingParent(CSItems.INGOT_MANGANESE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_manganese");
        withExistingParent(CSItems.INGOT_MANGANIN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_manganin");
        withExistingParent(CSItems.INGOT_PLATINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_platinum");
        withExistingParent(CSItems.INGOT_PALLADIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_palladium");
        withExistingParent(CSItems.INGOT_NIOBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_niobium");
        withExistingParent(CSItems.INGOT_NIOBIUM_TITANIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_niobiumtitanium");


        // Nuggets
        withExistingParent(CSItems.NUGGET_MANGANESEALUMINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/nugget/nugget_manganesealuminum");

        // Plates
        withExistingParent(CSItems.PLATE_BORONCARBIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/plate/plate_boroncarbide");
        withExistingParent(CSItems.PLATE_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/plate/plate_silicon");
        withExistingParent(CSItems.PLATE_NIOBIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/plate/plate_niobium");
        withExistingParent(CSItems.PLATE_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/plate/plate_tungsten");


        // Materials
        withExistingParent(CSItems.COIL_NIOBIUM_TITANIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/niobiumtitaniumcoil");
        withExistingParent(CSItems.ASPHALT.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/asphalt");
        withExistingParent(CSItems.TRINITROTOLUENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/trinitrotoluene");
        withExistingParent(CSItems.RAW_BORON_COMPOSITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/boroncompositeplatingraw");
        withExistingParent(CSItems.PLATING_BORON_COMPOSITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/boroncompositeplating");
        // Polymer
        withExistingParent(CSItems.DPP_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_dpp");
        withExistingParent(CSItems.DTT_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_dtt");
        withExistingParent(CSItems.DPPDTT_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_dppdtt");
        withExistingParent(CSItems.POLYPROPYLENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_propylene");
        withExistingParent(CSItems.POLYSTYRENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_styrene");
        withExistingParent(CSItems.PVC.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_vinylchloride");
        withExistingParent(CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_paraphenyleneterephthalamide");

        // Catalyst
        withExistingParent(CSItems.COPPER_ZINC_ALUMINATE_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/copper_aluminate_catalyst");
        withExistingParent(CSItems.IRON_ON_CARBON_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/iron_carbon_catalyst");
        withExistingParent(CSItems.PALLADIUM_ON_CARBON_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/palladium_carbon_catalyst");
        withExistingParent(CSItems.MOLYBDENUM_SULFUR_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/molybdenum_sulfur_catalyst");
        withExistingParent(CSItems.RUTHENIUM_SULFUR_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/ruthenium_sulfur_catalyst");
        withExistingParent(CSItems.SILICA_ALUMINA_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/silica_alumina_catalyst");
        withExistingParent(CSItems.TITANIUM_MAGNESIUM_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/titanium_magnesium_catalyst");
        withExistingParent(CSItems.SULFONATED_POLYSTYRENE_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/sulfonated_polystyrene_catalyst");
        withExistingParent(CSItems.RHODIUM_MANGANESE_BROMINE_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/rhodium_manganese_bromine_catalyst");


        // Armor
        withExistingParent(CSItems.ORGANICNIGHTVISIONGOGGLES.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/armor/organicnightvisiongoggles");
        withExistingParent(CSItems.BULLETPROOF_VEST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/armor/bulletproofvest");

        // Tools
        withExistingParent(CSItems.TUNGSTENCARBIDE_SWORD.getId().toString(), mcLoc("item/handheld")).texture("layer0", "item/tools/sword_tungstencarbide");
        withExistingParent(CSItems.TUNGSTENCARBIDE_PICKAXE.getId().toString(), mcLoc("item/handheld")).texture("layer0", "item/tools/pickaxe_tungstencarbide");
        withExistingParent(CSItems.TUNGSTENCARBIDE_AXE.getId().toString(), mcLoc("item/handheld")).texture("layer0", "item/tools/axe_tungstencarbide");
        withExistingParent(CSItems.TUNGSTENCARBIDE_SHOVEL.getId().toString(), mcLoc("item/handheld")).texture("layer0", "item/tools/shovel_tungstencarbide");
        withExistingParent(CSItems.TUNGSTENCARBIDE_HOE.getId().toString(), mcLoc("item/handheld")).texture("layer0", "item/tools/hoe_tungstencarbide");


        //Misc
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_CARBONMONOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardcarbonmonoxide");
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_METHANE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardmethane");
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_HELIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardhelium");
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_NEON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardneon");
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_KRYPTON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardkrypton");
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_XENON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardxenon");
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_RADON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardradon");
        withExistingParent(CSItems.CARBON_SAMPLE_HELIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/carbonsamplehelium");
        withExistingParent(CSItems.CARBON_SAMPLE_NEON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/carbonsampleneon");
        withExistingParent(CSItems.CARBON_SAMPLE_ARGON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/carbonsampleargon");
        withExistingParent(CSItems.CARBON_SAMPLE_KRYPTON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/carbonsamplekrypton");
        withExistingParent(CSItems.CARBON_SAMPLE_XENON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/carbonsamplexenon");
        withExistingParent(CSItems.CARBON_SAMPLE_RADON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/carbonsampleradon");

        withExistingParent(CSItems.ORGANIC_SOLAR_PANEL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/organicsolarpanelplate");
        withExistingParent(CSItems.PETRI_DISH.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/petri_dish");
        withExistingParent(CSItems.CULTURE_MEDIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/culture_medium");
        withExistingParent(CSItems.E_COLI.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/escherichia_coli");
        withExistingParent(CSItems.SODA.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/soda");
        withExistingParent(CSItems.PARACETAMOL.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/paracetamol");


        //Blocks
        withExistingParent(CSBlocks.MAGNESIUM_GA9Z1_DOOR.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/door_magnesium");
        withExistingParent(CSBlocks.MANGANESE_LADDER.getId().toString(), mcLoc("item/generated")).texture("layer0", "block/metal_building_blocks/ladder_manganese");
    }

}
