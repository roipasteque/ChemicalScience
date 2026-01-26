package net.pastek.chemicalscience.client.render.gear;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;

import java.util.Comparator;
import java.util.List;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, value = Dist.CLIENT)
public class ClientNightVisionHandler {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        if (isWearingActiveGoggles(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, true, false, false));
        } else {
            if (player.hasEffect(MobEffects.NIGHT_VISION)) {
                MobEffectInstance effect = player.getEffect(MobEffects.NIGHT_VISION);
                if (effect != null && !effect.isVisible()) {
                    player.removeEffect(MobEffects.NIGHT_VISION);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiLayerEvent.Post event) {
        if (event.getName() != VanillaGuiLayers.HOTBAR) return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || !isWearingActiveGoggles(player)) return;

        int width = mc.getWindow().getGuiScaledWidth();
        int height = mc.getWindow().getGuiScaledHeight();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        event.getGuiGraphics().fill(0, 0, width, height, 0x44052b05);

        drawVignette(event, width, height);
        drawBiometricRadar(event, mc, player);

        RenderSystem.disableBlend();
    }

    private static void drawVignette(RenderGuiLayerEvent.Post event, int width, int height) {
        event.getGuiGraphics().fillGradient(0, 0, width, height / 4, 0xAA000000, 0x00000000);
        event.getGuiGraphics().fillGradient(0, height - (height / 4), width, height, 0x00000000, 0xAA000000);
    }

    private static void drawBiometricRadar(RenderGuiLayerEvent.Post event, Minecraft mc, Player player) {
        assert mc.level != null;
        List<LivingEntity> targets = mc.level.getEntitiesOfClass(LivingEntity.class,
                        player.getBoundingBox().inflate(30.0D),
                        e -> e != player)
                .stream()
                .sorted(Comparator.comparingDouble(player::distanceToSqr))
                .limit(5)
                .toList();

        int yOffset = 10;
        event.getGuiGraphics().drawString(mc.font, "--- BIOMETRIC SCAN ---", 10, yOffset, 0x00FF00);

        for (LivingEntity target : targets) {
            yOffset += 12;
            String name = target.getType().getDescription().getString();
            int distance = (int) Math.sqrt(player.distanceToSqr(target));

            String text = "> " + name.toUpperCase() + " [" + distance + "m]";
            event.getGuiGraphics().drawString(mc.font, text, 15, yOffset, 0x00FF00);
        }
    }

    private static boolean isWearingActiveGoggles(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        return ItemOrganicNightVisionGoggles.canWork(helmet);
    }
}