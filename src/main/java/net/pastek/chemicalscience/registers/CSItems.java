package net.pastek.chemicalscience.registers;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.food.ItemSoda;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;
import voltaic.prefab.item.ElectricItemProperties;
import voltaic.prefab.utilities.object.TransferPack;


public class CSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChemicalScience.MOD_ID);

    // Raw ores
    public static final DeferredItem<Item> RAW_ORE_SILICON= ITEMS.register("rawore_silicon",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_ARSENOPYRITE= ITEMS.register("rawore_arsenopyrite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_WOLFRAMITE= ITEMS.register("rawore_wolframite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_COOPERITE= ITEMS.register("rawore_cooperite",
            () -> new Item(new Item.Properties()));

    // Crystals
    public static final DeferredItem<Item> CRYSTAL_MAGNESIUM= ITEMS.register("crystal_magnesium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYSTAL_ACETIC_ANHYDRIDE= ITEMS.register("crystal_aceticanhydride",
            () -> new Item(new Item.Properties()));

    // Dusts
    public static final DeferredItem<Item> DUST_MAGNESIUM= ITEMS.register("dust_magnesium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SILICON= ITEMS.register("dust_silicon",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CERIUMOXIDE= ITEMS.register("dust_ceriumoxide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_MONAZITE= ITEMS.register("dust_monazite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CALCIUMOXIDE= ITEMS.register("dust_calciumoxide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ARSENOPYRITE= ITEMS.register("dust_arsenopyrite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_GALLIUM= ITEMS.register("dust_gallium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TUNGSTEN= ITEMS.register("dust_tungsten",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_IRONOXIDE= ITEMS.register("dust_ironoxide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_UREA= ITEMS.register("dust_urea",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_DIMETHYLUREA= ITEMS.register("dust_dimethylurea",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CAFFEINE= ITEMS.register("dust_caffeine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PLATINUM= ITEMS.register("dust_platinum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PLATINUM_CHLORIDE= ITEMS.register("dust_platinumchloride",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PALLADIUM= ITEMS.register("dust_palladium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PALLADIUM_CHLORIDE= ITEMS.register("dust_palladiumchloride",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_RUTHENIUM= ITEMS.register("dust_ruthenium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CHROMIUM_BROMIDE= ITEMS.register("dust_chromiumbromide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_AMMONIUMCARBONATE= ITEMS.register("dust_ammoniumcarbonate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SUCCINIMIDE= ITEMS.register("dust_succinimide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_NBROMOSUCCINIMIDE= ITEMS.register("dust_nbromosuccinimide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_MAGNESIUM= ITEMS.register("impuredust_magnesium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_SILICON= ITEMS.register("impuredust_silicon",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_CERIUMOXIDE= ITEMS.register("impuredust_ceriumoxide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_ARSENOPYRITE= ITEMS.register("impuredust_arsenopyrite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_GALLIUM= ITEMS.register("impuredust_gallium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_TUNGSTEN= ITEMS.register("impuredust_tungsten",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_PLATINUM= ITEMS.register("impuredust_platinum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_PALLADIUM= ITEMS.register("impuredust_palladium",
            () -> new Item(new Item.Properties()));



    // Ingots
    public static final DeferredItem<Item> INGOT_MAGNESIUM= ITEMS.register("ingot_magnesium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_MAGNESIUM_ALUMINUM= ITEMS.register("ingot_magnesiumaluminum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_SILICON= ITEMS.register("ingot_silicon",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_GALLIUMARSENIDE= ITEMS.register("ingot_galliumarsenide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_TUNGSTEN= ITEMS.register("ingot_tungsten",
            () -> new Item(new Item.Properties()));

    // Plates
    public static final DeferredItem<Item> PLATE_SILICON= ITEMS.register("plate_silicon",
            () -> new Item(new Item.Properties()));

    // Polymer
    public static final DeferredItem<Item> DPP_POLYMER= ITEMS.register("dpp_polymer",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DTT_POLYMER= ITEMS.register("dtt_polymer",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DPPDTT_POLYMER= ITEMS.register("dppdtt_polymer",
            () -> new Item(new Item.Properties()));

    // Catalysts
    public static final DeferredItem<Item> COPPER_ZINC_ALUMINATE_CATALYST= ITEMS.register("copper_aluminate_catalyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRON_ON_CARBON_CATALYST= ITEMS.register("iron_carbon_catalyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALLADIUM_ON_CARBON_CATALYST= ITEMS.register("palladium_carbon_catalyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOLYBDENUM_SULFUR_CATALYST= ITEMS.register("molybdenum_sulfur_catalyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUTHENIUM_SULFUR_CATALYST= ITEMS.register("ruthenium_sulfur_catalyst",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILICA_ALUMINA_CATALYST= ITEMS.register("silica_alumina_catalyst",
            () -> new Item(new Item.Properties()));

    // Armor
    public static final DeferredItem<Item> ORGANICNIGHTVISIONGOGGLES= ITEMS.register("organicnightvisiongoggles",
            () -> new ItemOrganicNightVisionGoggles((ElectricItemProperties) new ElectricItemProperties().capacity(1.0).extract(TransferPack.joulesVoltage(1.0 / (120.0 * 20.0), 120)).receive(TransferPack.joulesVoltage(1.0 / (120.0 * 20.0), 120)).stacksTo(1), CSCreativeTabs.CHEMICAL_SCIENCE_TAB));

    // Misc
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_CARBONMONOXIDE= ITEMS.register("chromotographycardcarbonmonoxide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORGANIC_SOLAR_PANEL_PLATE= ITEMS.register("organicsolarpanelplate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ASPHALT= ITEMS.register("asphalt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PETRI_DISH= ITEMS.register("petri_dish",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CULTURE_MEDIUM= ITEMS.register("culture_medium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> E_COLI= ITEMS.register("escherichia_coli",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SODA= ITEMS.register("soda",
            () -> new ItemSoda(new Item.Properties().food(CSProperties.SODA).stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}