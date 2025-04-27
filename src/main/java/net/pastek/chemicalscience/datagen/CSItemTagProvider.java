package net.pastek.chemicalscience.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CSItemTagProvider extends ItemTagsProvider {
    public CSItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                             CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ChemicalScience.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CSTags.Items.TRANSFORMABLE_ITEMS);
                // Raw ores
                // Crystals
                // Dusts
                // Ingots
                // Materials
    }
}
