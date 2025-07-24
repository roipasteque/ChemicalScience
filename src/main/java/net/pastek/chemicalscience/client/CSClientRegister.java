package net.pastek.chemicalscience.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.guidebook.ModuleChemicalScience;
import net.pastek.chemicalscience.client.render.tile.RenderLabStorage;
import net.pastek.chemicalscience.client.render.tile.RenderRackM;
import net.pastek.chemicalscience.client.render.tile.RenderRackS;
import net.pastek.chemicalscience.client.screen.*;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import net.pastek.chemicalscience.registers.CSPotions;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.client.guidebook.ScreenGuidebook;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ChemicalScience.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CSClientRegister {


    public static void setup() {
        ScreenGuidebook.addGuidebookModule(new ModuleChemicalScience());
        BrewingRecipeRegistry.addRecipe(new net.kaupenjoe.tutorialmod.util.CSPotionsRecipe(Potions.AWKWARD, CSItems.CRYSTAL_POTASSIUMBROMIDE.get(), CSPotions.SEDATIVE.get()));

        MenuScreens.register(CSMenuTypes.CONTAINER_SOLARPANEL.get(), ScreenSolarPanel::new);
        MenuScreens.register(CSMenuTypes.CONTAINER_CIRCUIT_MAKER.get(), ScreenCircuitMaker::new);
        MenuScreens.register(CSMenuTypes.CONTAINER_RACK_M.get(), ScreenRackM::new);
        MenuScreens.register(CSMenuTypes.CONTAINER_RACK_S.get(), ScreenRackS::new);
        MenuScreens.register(CSMenuTypes.CONTAINER_LAB_BENCH.get(), ScreenLabBench::new);
        MenuScreens.register(CSMenuTypes.CONTAINER_LAB_STORAGE.get(), ScreenLabStorage::new);
    }

    @SubscribeEvent
    public static void registerEntities(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(CSTiles.TILE_RACK_M.get(), RenderRackM::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_RACK_S.get(), RenderRackS::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_LAB_STORAGE.get(), RenderLabStorage::new);
    }
}