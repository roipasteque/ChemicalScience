package net.pastek.chemicalscience.client;

import electrodynamics.client.model.armor.ModelNightVisionGoggles;
import electrodynamics.compatibility.mekanism.MekanismClientHandler;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.guidebook.ModuleChemicalScience;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import voltaic.Voltaic;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.misc.SWBFClientExtensions;
import voltaic.common.fluid.SimpleWaterBasedFluidType;
import net.pastek.chemicalscience.client.screen.ScreenSolarPanel;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientRegister {

    public static final LayerDefinition ORGANIC_NIGHT_VISION_GOGGLES = ModelNightVisionGoggles.createBodyLayer();

    public static void setup() {
        ScreenGuidebook.addGuidebookModule(new ModuleChemicalScience());
    }

    @SubscribeEvent
    public static void registerMenus(RegisterMenuScreensEvent event) {

        event.register(CSMenuTypes.CONTAINER_SOLARPANEL.get(), ScreenSolarPanel::new);

        if(ModList.get().isLoaded(Voltaic.MEKANISM_ID)) {
            MekanismClientHandler.registerMenus(event);
        }
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {

        //Organic Night Vision Goggles
        event.registerItem(new IClientItemExtensions() {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> properties) {
                ModelNightVisionGoggles<LivingEntity> model = new ModelNightVisionGoggles<>(ClientRegister.ORGANIC_NIGHT_VISION_GOGGLES.bakeRoot());

                model.crouching = properties.crouching;
                model.riding = properties.riding;
                model.young = properties.young;

                return model;
            }
        }, CSItems.ORGANICNIGHTVISIONGOGGLES);


        CSFluids.FLUIDS.getEntries().forEach((fluid) -> {
            event.registerFluidType(new SWBFClientExtensions((SimpleWaterBasedFluidType) fluid.get().getFluidType()), fluid.get().getFluidType());
        });
    }
}