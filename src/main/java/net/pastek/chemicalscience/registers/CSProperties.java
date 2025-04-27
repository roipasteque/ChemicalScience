package net.pastek.chemicalscience.registers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class CSProperties {

    public static final FoodProperties SODA = new FoodProperties.Builder().nutrition(4).saturationModifier(0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800), 1.0f)
            .fast()
            .build();
}
