package net.pastek.chemicalscience;

import net.minecraft.resources.ResourceLocation;
import net.pastek.chemicalscience.client.CSClientRegister;
import net.pastek.chemicalscience.registers.*;
import net.pastek.chemicalscience.registers.fluids.CSFluidTypes;
import net.pastek.chemicalscience.registers.fluids.CSFluids;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.pastek.chemicalscience.registers.gases.CSGases;

@Mod(ChemicalScience.MOD_ID)
public class ChemicalScience {
    public static final String MOD_ID = "chemicalscience";

    public ChemicalScience(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        CSCreativeTabs.register(modEventBus);
        CSItems.register(modEventBus);
        CSBlocks.register(modEventBus);
        CSMenuTypes.register(modEventBus);
        CSTiles.register(modEventBus);
        CSFluids.register(modEventBus);
        CSFluidTypes.register(modEventBus);
        CSGases.register(modEventBus);
        CSDataComponentTypes.register(modEventBus);
        CSArmor.register(modEventBus);
        CSPotions.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(CSClientRegister::setup);
        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, path);
    }
}