package net.pastek.chemicalscience.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
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
        withExistingParent(CSItems.DUST_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_magnesium");
        withExistingParent(CSItems.DUST_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_silicon");
        withExistingParent(CSItems.DUST_MONAZITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_monazite");
        withExistingParent(CSItems.DUST_ARSENOPYRITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_arsenopyrite");
        withExistingParent(CSItems.DUST_GALLIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_gallium");
        withExistingParent(CSItems.DUST_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_tungsten");
        withExistingParent(CSItems.DUST_IRONOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ironoxide");
        withExistingParent(CSItems.DUST_CALCIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_calciumoxide");
        withExistingParent(CSItems.DUST_CERIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ceriumoxide");
        withExistingParent(CSItems.DUST_URANIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_uraniumoxide");
        withExistingParent(CSItems.DUST_PLUTONIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_plutoniumoxide");
        withExistingParent(CSItems.DUST_PLUTONIUMHYDROXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_plutoniumhydroxide");
        withExistingParent(CSItems.DUST_UREA.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_urea");
        withExistingParent(CSItems.DUST_DIMETHYLUREA.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_dimethylurea");
        withExistingParent(CSItems.DUST_CAFFEINE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_caffeine");
        withExistingParent(CSItems.DUST_PLATINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_platinum");
        withExistingParent(CSItems.DUST_PLATINUM_CHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_platinumchloride");
        withExistingParent(CSItems.DUST_PALLADIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_palladium");
        withExistingParent(CSItems.DUST_PALLADIUM_CHLORIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_palladiumchloride");
        withExistingParent(CSItems.DUST_RUTHENIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ruthenium");
        withExistingParent(CSItems.DUST_CHROMIUM_BROMIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_chromiumbromide");
        withExistingParent(CSItems.DUST_AMMONIUMCARBONATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ammoniumcarbonate");
        withExistingParent(CSItems.DUST_AMMONIUMDIURANATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_ammoniumdiuranate");
        withExistingParent(CSItems.DUST_SUCCINIMIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_succinimide");
        withExistingParent(CSItems.DUST_NBROMOSUCCINIMIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/dust_nbromosuccinimide");
        withExistingParent(CSItems.IMPURE_DUST_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_magnesium");
        withExistingParent(CSItems.IMPURE_DUST_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_silicon");
        withExistingParent(CSItems.IMPURE_DUST_CERIUMOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_ceriumoxide");
        withExistingParent(CSItems.IMPURE_DUST_ARSENOPYRITE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_arsenopyrite");
        withExistingParent(CSItems.IMPURE_DUST_GALLIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_gallium");
        withExistingParent(CSItems.IMPURE_DUST_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_tungsten");
        withExistingParent(CSItems.IMPURE_DUST_PLATINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_platinum");
        withExistingParent(CSItems.IMPURE_DUST_PALLADIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/dust/impuredust_palladium");

        // Ingots
        withExistingParent(CSItems.INGOT_MAGNESIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_magnesium");
        withExistingParent(CSItems.INGOT_MAGNESIUM_ALUMINUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_magnesiumaluminum");
        withExistingParent(CSItems.INGOT_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_silicon");
        withExistingParent(CSItems.INGOT_GALLIUMARSENIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_galliumarsenide");
        withExistingParent(CSItems.INGOT_TUNGSTEN.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/ingot/ingot_tungsten");
        // Plates
        withExistingParent(CSItems.PLATE_SILICON.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/plate/plate_silicon");
        // Materials
        withExistingParent(CSItems.ASPHALT.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/asphalt");
        withExistingParent(CSItems.TRINITROTOLUENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/materials/trinitrotoluene");
        // Polymer
        withExistingParent(CSItems.DPP_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_dpp");
        withExistingParent(CSItems.DTT_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_dtt");
        withExistingParent(CSItems.DPPDTT_POLYMER.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_dppdtt");
        withExistingParent(CSItems.POLYPROPYLENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_propylene");
        withExistingParent(CSItems.POLYSTYRENE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_styrene");
        withExistingParent(CSItems.PVC.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/polymer/polymer_vinylchloride");

        // Catalyst
        withExistingParent(CSItems.COPPER_ZINC_ALUMINATE_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/copper_aluminate_catalyst");
        withExistingParent(CSItems.IRON_ON_CARBON_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/iron_carbon_catalyst");
        withExistingParent(CSItems.PALLADIUM_ON_CARBON_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/palladium_carbon_catalyst");
        withExistingParent(CSItems.MOLYBDENUM_SULFUR_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/molybdenum_sulfur_catalyst");
        withExistingParent(CSItems.RUTHENIUM_SULFUR_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/ruthenium_sulfur_catalyst");
        withExistingParent(CSItems.SILICA_ALUMINA_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/silica_alumina_catalyst");
        withExistingParent(CSItems.TITANIUM_MAGNESIUM_CATALYST.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/catalyst/titanium_magnesium_catalyst");

        // Armor
        withExistingParent(CSItems.ORGANICNIGHTVISIONGOGGLES.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/armor/organicnightvisiongoggles");

        //Misc
        withExistingParent(CSItems.CHROMOTOGRAPHYCARD_CARBONMONOXIDE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chromotographycard/chromotographycardcarbonmonoxide");
        withExistingParent(CSItems.ORGANIC_SOLAR_PANEL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/organicsolarpanelplate");
        withExistingParent(CSItems.PETRI_DISH.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/petri_dish");
        withExistingParent(CSItems.CULTURE_MEDIUM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/culture_medium");
        withExistingParent(CSItems.E_COLI.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/escherichia_coli");
        withExistingParent(CSItems.SODA.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/soda");
        withExistingParent(CSItems.PARACETAMOL.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/paracetamol");


        //Blocks
        withExistingParent(CSBlocks.MAGNESIUM_GA9Z1_DOOR.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/misc/door_magnesium");
    }
}
