package net.pastek.chemicalscience.registers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class CSProperties {

    public static final FoodProperties SODA = new FoodProperties.Builder().nutrition(4).saturationModifier(0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800), 1.0f)
            .build();

    public static final FoodProperties E_COLI = new FoodProperties.Builder().nutrition(1).saturationModifier(0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 4), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 80), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 80), 1.0f)
            .build();

    public static final FoodProperties PARACETAMOL = new FoodProperties.Builder().nutrition(0).saturationModifier(0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 3), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

}
