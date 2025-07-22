package net.pastek.chemicalscience;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pastek.chemicalscience.client.CSClientRegister;
import net.pastek.chemicalscience.registers.*;
import net.pastek.chemicalscience.registers.fluids.CSFluidTypes;
import net.pastek.chemicalscience.registers.fluids.CSFluids;

import net.pastek.chemicalscience.registers.gases.CSGases;

@Mod(ChemicalScience.MOD_ID)
public class ChemicalScience {
    public static final String MOD_ID = "chemicalscience";

    public ChemicalScience() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        CSCreativeTabs.register(modEventBus);
        CSItems.register(modEventBus);
        CSBlocks.register(modEventBus);
        CSMenuTypes.register(modEventBus);
        CSTiles.register(modEventBus);
        CSFluids.register(modEventBus);
        CSFluidTypes.register(modEventBus);
        CSGases.register(modEventBus);
        CSDataComponentTypes.register(modEventBus);
        CSRecipies.register(modEventBus);
        CSArmor.register(modEventBus);
        CSPotions.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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