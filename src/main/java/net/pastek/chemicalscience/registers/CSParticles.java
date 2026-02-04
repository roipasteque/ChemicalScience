package net.pastek.chemicalscience.registers;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import org.jetbrains.annotations.NotNull;

public class CSParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ChemicalScience.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, ParticleType<DustParticleOptions>> COLORED_FLAME =
            PARTICLES.register("colored_flame", () -> new ParticleType<>(false) {
                @Override
                public @NotNull MapCodec<DustParticleOptions> codec() {
                    return DustParticleOptions.CODEC;
                }

                @Override
                public @NotNull StreamCodec<? super RegistryFriendlyByteBuf, DustParticleOptions> streamCodec() {
                    return DustParticleOptions.STREAM_CODEC;
                }
            });
}
