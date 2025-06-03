package net.pastek.chemicalscience.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
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

        tag(CSTags.Items.HAZARD_SYMBOL)
                .add(
                        CSBlocks.SYMBOL_BIOHAZARD.get().asItem(),
                        CSBlocks.SYMBOL_RADIATION.get().asItem(),
                        CSBlocks.SYMBOL_DANGER.get().asItem(),
                        CSBlocks.SYMBOL_ELECTRICAL.get().asItem(),
                        CSBlocks.SYMBOL_FLAMMABLE.get().asItem(),
                        CSBlocks.SYMBOL_TOXIC.get().asItem(),
                        CSBlocks.SYMBOL_CORROSIVE.get().asItem(),
                        CSBlocks.SYMBOL_PRESSURE.get().asItem(),
                        CSBlocks.SYMBOL_EXPLOSIVE.get().asItem()
                );
    }
}
