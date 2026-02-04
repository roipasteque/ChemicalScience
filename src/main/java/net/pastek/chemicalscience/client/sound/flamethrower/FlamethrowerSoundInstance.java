package net.pastek.chemicalscience.client.sound.flamethrower;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.pastek.chemicalscience.common.item.gear.ItemFlamethrower;

public class FlamethrowerSoundInstance extends AbstractTickableSoundInstance {
    private final LivingEntity entity;

    public FlamethrowerSoundInstance(LivingEntity entity, SoundEvent sound) {
        super(sound, SoundSource.PLAYERS, entity.getRandom());
        this.entity = entity;
        this.looping = true;
        this.delay = 0;
        this.volume = 0.5f;
        this.pitch = 1.0f;

        this.x = entity.getX();
        this.y = entity.getY();
        this.z = entity.getZ();
    }

    @Override
    public void tick() {
        if (this.entity.isRemoved() || !this.entity.isUsingItem() || !(this.entity.getUseItem().getItem() instanceof ItemFlamethrower)) {
            this.stop();
            return;
        }

        this.x = this.entity.getX();
        this.y = this.entity.getY();
        this.z = this.entity.getZ();
    }
}