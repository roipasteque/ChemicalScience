package net.pastek.chemicalscience.client.sound.flamethrower;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public class FlamethrowerSoundInstance extends AbstractTickableSoundInstance {
    private final Player player;

    public FlamethrowerSoundInstance(Player player, SoundEvent sound, boolean looping) {
        super(sound, SoundSource.PLAYERS, player.getRandom());
        this.player = player;
        this.looping = looping;
        this.delay = 0;
        this.volume = 0.6f;
        this.x = (float) player.getX();
        this.y = (float) player.getY();
        this.z = (float) player.getZ();
    }

    @Override
    public void tick() {
        if (this.player.isRemoved() || !this.player.isUsingItem()) {
            this.stop();
            return;
        }
        this.x = (float) this.player.getX();
        this.y = (float) this.player.getY();
        this.z = (float) this.player.getZ();
    }

    public void forceStop() {
        this.stop();
    }
}