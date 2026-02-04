package net.pastek.chemicalscience.client.sound.flamethrower;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.pastek.chemicalscience.common.item.gear.ItemFlamethrower;

import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(value = Dist.CLIENT)
public class FlamethrowerAudioHandler {

    private static final Map<Integer, FlamethrowerSoundInstance> ACTIVE_SOUNDS = new HashMap<>();

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        var level = Minecraft.getInstance().level;
        if (level == null) return;

        for (Player player : level.players()) {
            int id = player.getId();
            boolean isUsingFlamethrower = player.isUsingItem() && player.getUseItem().getItem() instanceof ItemFlamethrower;

            if (isUsingFlamethrower) {
                if (!ACTIVE_SOUNDS.containsKey(id) || ACTIVE_SOUNDS.get(id).isStopped()) {
                    FlamethrowerSoundInstance sound = new FlamethrowerSoundInstance(player, ElectrodynamicsSounds.SOUND_JETPACK.get());
                    Minecraft.getInstance().getSoundManager().play(sound);
                    ACTIVE_SOUNDS.put(id, sound);
                }
            } else {
                if (ACTIVE_SOUNDS.containsKey(id)) {
                    ACTIVE_SOUNDS.remove(id);
                }
            }
        }

        ACTIVE_SOUNDS.entrySet().removeIf(entry -> entry.getValue().isStopped());
    }
}