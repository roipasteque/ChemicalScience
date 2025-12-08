package net.pastek.chemicalscience;

import net.minecraft.resources.ResourceLocation;
import net.pastek.chemicalscience.client.CSClientRegister;
import net.pastek.chemicalscience.registers.UnifiedCSRegister;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ChemicalScience.MOD_ID)
public class ChemicalScience {
    public static final String MOD_ID = "chemicalscience";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public ChemicalScience(IEventBus EventBus) {
        EventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        UnifiedCSRegister.register(EventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
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