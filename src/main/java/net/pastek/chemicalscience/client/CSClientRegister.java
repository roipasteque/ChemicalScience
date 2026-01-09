package net.pastek.chemicalscience.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.guidebook.ModuleChemicalScience;
import net.pastek.chemicalscience.client.model.armor.BulletProofVest;
import net.pastek.chemicalscience.client.model.armor.OrganicNightVisionGoggles;
import net.pastek.chemicalscience.client.render.tile.RenderFractionatingColumn;
import net.pastek.chemicalscience.client.render.tile.RenderLabStorage;
import net.pastek.chemicalscience.client.render.tile.RenderRackM;
import net.pastek.chemicalscience.client.render.tile.RenderRackS;
import net.pastek.chemicalscience.client.screen.*;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import net.pastek.chemicalscience.registers.CSTiles;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import org.jetbrains.annotations.NotNull;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.misc.SWBFClientExtensions;
import voltaic.common.fluid.SimpleWaterBasedFluidType;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, value = {Dist.CLIENT})
public class CSClientRegister {

    public static final LayerDefinition ORGANIC_NIGHT_VISION_GOGGLES = OrganicNightVisionGoggles.createBodyLayer();
    public static final LayerDefinition BULLETPROOF_VEST = BulletProofVest.createBodyLayer(3, false);

    public static final ModelResourceLocation FRACTIONATINGCOLUMN_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/fractionating_column"));


    public static void setup() {
        ScreenGuidebook.addGuidebookModule(new ModuleChemicalScience());
    }

    @SubscribeEvent
    public static void registerMenus(RegisterMenuScreensEvent event) {
        event.register(CSMenuTypes.CONTAINER_SOLARPANEL.get(), ScreenSolarPanel::new);
        event.register(CSMenuTypes.CONTAINER_FUELCELL.get(), ScreenFuelCell::new);
        event.register(CSMenuTypes.CONTAINER_CIRCUIT_MAKER.get(), ScreenCircuitMaker::new);
        event.register(CSMenuTypes.CONTAINER_HDS_UNIT.get(), ScreenHDSUnit::new);
        event.register(CSMenuTypes.CONTAINER_STEAM_CRACKER.get(), ScreenSteamCracker::new);
        event.register(CSMenuTypes.CONTAINER_CATALYTIC_REFORMER.get(), ScreenCatalyticReformer::new);
        event.register(CSMenuTypes.CONTAINER_FRACTIONATING_COLUMN.get(), ScreenFractionatingColumn::new);
        event.register(CSMenuTypes.CONTAINER_RACK_M.get(), ScreenRackM::new);
        event.register(CSMenuTypes.CONTAINER_RACK_S.get(), ScreenRackS::new);
        event.register(CSMenuTypes.CONTAINER_LAB_BENCH.get(), ScreenLabBench::new);
        event.register(CSMenuTypes.CONTAINER_LAB_STORAGE.get(), ScreenLabStorage::new);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {

        //Organic Night Vision Goggles
        event.registerItem(new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> properties) {
                OrganicNightVisionGoggles<LivingEntity> model = new OrganicNightVisionGoggles<>(CSClientRegister.ORGANIC_NIGHT_VISION_GOGGLES.bakeRoot());

                model.crouching = properties.crouching;
                model.riding = properties.riding;
                model.young = properties.young;

                return model;
            }
        }, CSItems.ORGANICNIGHTVISIONGOGGLES);

        //BulletProof Vest
        event.registerItem(new IClientItemExtensions() {
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> properties) {
                BulletProofVest<LivingEntity> model;
                model = new BulletProofVest<>(CSClientRegister.BULLETPROOF_VEST.bakeRoot(), armorSlot);

                model.crouching = properties.crouching;
                model.riding = properties.riding;
                model.young = properties.young;
                return model;
            }
        }, CSItems.BULLETPROOF_VEST);



        CSFluids.FLUIDS.getEntries().forEach((fluid) -> {
            event.registerFluidType(new SWBFClientExtensions((SimpleWaterBasedFluidType) fluid.get().getFluidType()), fluid.get().getFluidType());
        });
    }

    @SubscribeEvent
    public static void registerEntities(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(CSTiles.TILE_RACK_M.get(), RenderRackM::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_RACK_S.get(), RenderRackS::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_LAB_STORAGE.get(), RenderLabStorage::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_FRACTIONATING_COLUMN.get(), RenderFractionatingColumn::new);
    }

    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterAdditional event) {
        event.register(FRACTIONATINGCOLUMN_MODEL);
    }
}