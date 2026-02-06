package net.pastek.chemicalscience.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;

public class CSSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, ChemicalScience.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_FLAMETHROWER_START = sound("flamethrower_start");
    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_FLAMETHROWER_LOOP = sound("flamethrower_loop");

    private static DeferredHolder<SoundEvent, SoundEvent> sound(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createFixedRangeEvent(ChemicalScience.rl(name), 16.0F));
    }
}
