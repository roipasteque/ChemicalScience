package net.pastek.chemicalscience.registers;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;

public class CSPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, ChemicalScience.MOD_ID);

    public static final Holder<Potion> SEDATIVE = POTIONS.register("sedative",
            () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 4), new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}