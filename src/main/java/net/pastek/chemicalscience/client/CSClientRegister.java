package net.pastek.chemicalscience.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
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
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.guidebook.ModuleChemicalScience;
import net.pastek.chemicalscience.client.model.armor.BulletProofVest;
import net.pastek.chemicalscience.client.model.armor.OrganicNightVisionGoggles;
import net.pastek.chemicalscience.client.render.tile.*;
import net.pastek.chemicalscience.client.roadmap.ScreenRoadMap;
import net.pastek.chemicalscience.client.screen.*;
import net.pastek.chemicalscience.client.tooltip.CSTooltipRenderer;
import net.pastek.chemicalscience.common.item.CSTooltipItem;
import net.pastek.chemicalscience.common.packet.PacketToggleNightVisionMode;
import net.pastek.chemicalscience.common.packet.PacketTransparencyTogglePayload;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import net.pastek.chemicalscience.registers.CSTiles;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.misc.SWBFClientExtensions;
import voltaic.common.fluid.SimpleWaterBasedFluidType;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, value = {Dist.CLIENT})
public class CSClientRegister {

    public static final LayerDefinition ORGANIC_NIGHT_VISION_GOGGLES = OrganicNightVisionGoggles.createBodyLayer();
    public static final LayerDefinition BULLETPROOF_VEST = BulletProofVest.createBodyLayer(3, false);

    public static final ModelResourceLocation FRACTIONATINGCOLUMN_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/fractionating_column"));
    public static final ModelResourceLocation CHEMICALBENCH_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/chemical_bench"));
    public static final ModelResourceLocation REDOXFURNACE_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/redox_furnace"));

    public static void setup() {
        ScreenGuidebook.addGuidebookModule(new ModuleChemicalScience());
    }

    @SubscribeEvent
    public static void registerMenus(RegisterMenuScreensEvent event) {
        event.register(CSMenuTypes.CONTAINER_ROADMAP.get(), ScreenRoadMap::new);

        event.register(CSMenuTypes.CONTAINER_SOLARPANEL.get(), ScreenSolarPanel::new);
        event.register(CSMenuTypes.CONTAINER_FUELCELL.get(), ScreenFuelCell::new);
        event.register(CSMenuTypes.CONTAINER_CIRCUIT_MAKER.get(), ScreenCircuitMaker::new);
        event.register(CSMenuTypes.CONTAINER_HDS_UNIT.get(), ScreenHDSUnit::new);
        event.register(CSMenuTypes.CONTAINER_STEAM_CRACKER.get(), ScreenSteamCracker::new);
        event.register(CSMenuTypes.CONTAINER_CATALYTIC_REFORMER.get(), ScreenCatalyticReformer::new);
        event.register(CSMenuTypes.CONTAINER_SPIN_COATER.get(), ScreenSpinCoater::new);
        event.register(CSMenuTypes.CONTAINER_FRACTIONATING_COLUMN.get(), ScreenFractionatingColumn::new);
        event.register(CSMenuTypes.CONTAINER_CHEMICAL_BENCH.get(), ScreenChemicalBench::new);
        event.register(CSMenuTypes.CONTAINER_REDOX_FURNACE.get(), ScreenRedoxFurnace::new);
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
        event.registerBlockEntityRenderer(CSTiles.TILE_CHEMICAL_BENCH.get(), RenderChemicalBench::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_REDOX_FURNACE.get(), RenderRedoxFurnace::new);
    }

    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterAdditional event) {
        event.register(FRACTIONATINGCOLUMN_MODEL);
        event.register(CHEMICALBENCH_MODEL);
        event.register(REDOXFURNACE_MODEL);
    }

    @SubscribeEvent
    public static void onRegisterTooltipFactories(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(CSTooltipItem.ImageTooltipComponent.class,
                CSTooltipRenderer::new);
    }

    public static final KeyMapping TOGGLE_MODE_KEY = new KeyMapping(
            "key.chemicalscience.toggle_goggles",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_N,
            "category.chemicalscience.keys"
    );

    @SubscribeEvent
    public static void RegisterKeyMapingsEvent(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_MODE_KEY);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (TOGGLE_MODE_KEY.consumeClick()) {
            PacketDistributor.sendToServer(new PacketToggleNightVisionMode());
        }
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(ChemicalScience.MOD_ID);
        registrar.playToServer(
                PacketTransparencyTogglePayload.TYPE,
                PacketTransparencyTogglePayload.STREAM_CODEC,
                PacketTransparencyTogglePayload::handleData
        );
    }
}