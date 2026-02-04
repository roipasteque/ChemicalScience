package net.pastek.chemicalscience.registers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.entity.projectile.EntityFlameStream;

public class CSEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ChemicalScience.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<EntityFlameStream>> ENTITY_FLAMESTREAM = ENTITIES.register("flamestream",
            () -> EntityType.Builder.<EntityFlameStream>of(EntityFlameStream::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("flamestream"));
}