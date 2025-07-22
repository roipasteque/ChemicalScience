package net.pastek.chemicalscience.registers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;

public class CSPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ChemicalScience.MOD_ID);

    public static final RegistryObject<Potion> SEDATIVE = POTIONS.register("sedative",
            () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 4), new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}