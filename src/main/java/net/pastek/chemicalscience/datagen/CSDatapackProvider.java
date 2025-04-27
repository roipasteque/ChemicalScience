package net.pastek.chemicalscience.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.worldgen.CSBiomeModifiers;
import net.pastek.chemicalscience.worldgen.CSConfiguredFeatures;
import net.pastek.chemicalscience.worldgen.CSPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CSDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CSConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CSPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CSBiomeModifiers::bootstrap);

    public CSDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ChemicalScience.MOD_ID));
    }
}