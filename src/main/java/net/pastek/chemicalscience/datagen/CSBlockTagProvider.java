package net.pastek.chemicalscience.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CSBlockTagProvider extends BlockTagsProvider {
    public CSBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChemicalScience.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                // Ores
                // Overworld
                .add(CSBlocks.ORE_MAGNESIUM.get())
                .add(CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get())
                .add(CSBlocks.ORE_SILICON.get())
                .add(CSBlocks.ORE_DEEPSLATE_SILICON.get())
                .add(CSBlocks.ORE_ARSENOPYRITE.get())
                .add(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get())
                .add(CSBlocks.ORE_WOLFRAMITE.get())
                .add(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get())
                .add(CSBlocks.ORE_COOPERITE.get())
                .add(CSBlocks.ORE_DEEPSLATE_COOPERITE.get())
                .add(CSBlocks.ORE_OIL.get())
                .add(CSBlocks.ORE_DEEPSLATE_OIL.get())
                // Stellaris
               .add(CSBlocks.ORE_ARSENOPYRITE_MOON.get()).add(CSBlocks.ORE_ARSENOPYRITE_MARS.get()).add(CSBlocks.ORE_ARSENOPYRITE_VENUS.get()).add(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get()).add(CSBlocks.ORE_COOPERITE_MOON.get()).add(CSBlocks.ORE_COOPERITE_MARS.get()).add(CSBlocks.ORE_COOPERITE_VENUS.get()).add(CSBlocks.ORE_COOPERITE_MERCURY.get()).add(CSBlocks.ORE_MAGNESIUM_MOON.get()).add(CSBlocks.ORE_MAGNESIUM_MARS.get()).add(CSBlocks.ORE_MAGNESIUM_VENUS.get()).add(CSBlocks.ORE_MAGNESIUM_MERCURY.get()).add(CSBlocks.ORE_SILICON_MOON.get()).add(CSBlocks.ORE_SILICON_MARS.get()).add(CSBlocks.ORE_SILICON_VENUS.get()).add(CSBlocks.ORE_SILICON_MERCURY.get()).add(CSBlocks.ORE_WOLFRAMITE_MOON.get()).add(CSBlocks.ORE_WOLFRAMITE_MARS.get()).add(CSBlocks.ORE_WOLFRAMITE_VENUS.get()).add(CSBlocks.ORE_WOLFRAMITE_MERCURY.get()).add(CSBlocks.ORE_ALUMINUM_MOON.get()).add(CSBlocks.ORE_ALUMINUM_MARS.get()).add(CSBlocks.ORE_ALUMINUM_VENUS.get()).add(CSBlocks.ORE_ALUMINUM_MERCURY.get()).add(CSBlocks.ORE_CHROMIUM_MOON.get()).add(CSBlocks.ORE_CHROMIUM_MARS.get()).add(CSBlocks.ORE_CHROMIUM_VENUS.get()).add(CSBlocks.ORE_CHROMIUM_MERCURY.get()).add(CSBlocks.ORE_FLUORITE_MOON.get()).add(CSBlocks.ORE_FLUORITE_MARS.get()).add(CSBlocks.ORE_FLUORITE_VENUS.get()).add(CSBlocks.ORE_FLUORITE_MERCURY.get()).add(CSBlocks.ORE_LEAD_MOON.get()).add(CSBlocks.ORE_LEAD_MARS.get()).add(CSBlocks.ORE_LEAD_VENUS.get()).add(CSBlocks.ORE_LEAD_MERCURY.get()).add(CSBlocks.ORE_LITHIUM_MOON.get()).add(CSBlocks.ORE_LITHIUM_MARS.get()).add(CSBlocks.ORE_LITHIUM_VENUS.get()).add(CSBlocks.ORE_LITHIUM_MERCURY.get()).add(CSBlocks.ORE_MOLYBDENUM_MOON.get()).add(CSBlocks.ORE_MOLYBDENUM_MARS.get()).add(CSBlocks.ORE_MOLYBDENUM_VENUS.get()).add(CSBlocks.ORE_MOLYBDENUM_MERCURY.get()).add(CSBlocks.ORE_MONAZITE_MOON.get()).add(CSBlocks.ORE_MONAZITE_MARS.get()).add(CSBlocks.ORE_MONAZITE_VENUS.get()).add(CSBlocks.ORE_MONAZITE_MERCURY.get()).add(CSBlocks.ORE_NITER_MOON.get()).add(CSBlocks.ORE_NITER_MARS.get()).add(CSBlocks.ORE_NITER_VENUS.get()).add(CSBlocks.ORE_NITER_MERCURY.get()).add(CSBlocks.ORE_SALT_MOON.get()).add(CSBlocks.ORE_SALT_MARS.get()).add(CSBlocks.ORE_SALT_VENUS.get()).add(CSBlocks.ORE_SALT_MERCURY.get()).add(CSBlocks.ORE_SILVER_MOON.get()).add(CSBlocks.ORE_SILVER_MARS.get()).add(CSBlocks.ORE_SILVER_VENUS.get()).add(CSBlocks.ORE_SILVER_MERCURY.get()).add(CSBlocks.ORE_SULFUR_MOON.get()).add(CSBlocks.ORE_SULFUR_MARS.get()).add(CSBlocks.ORE_SULFUR_VENUS.get()).add(CSBlocks.ORE_SULFUR_MERCURY.get()).add(CSBlocks.ORE_SYLVITE_MOON.get()).add(CSBlocks.ORE_SYLVITE_MARS.get()).add(CSBlocks.ORE_SYLVITE_VENUS.get()).add(CSBlocks.ORE_SYLVITE_MERCURY.get()).add(CSBlocks.ORE_TIN_MOON.get()).add(CSBlocks.ORE_TIN_MARS.get()).add(CSBlocks.ORE_TIN_VENUS.get()).add(CSBlocks.ORE_TIN_MERCURY.get()).add(CSBlocks.ORE_TITANIUM_MOON.get()).add(CSBlocks.ORE_TITANIUM_MARS.get()).add(CSBlocks.ORE_TITANIUM_VENUS.get()).add(CSBlocks.ORE_TITANIUM_MERCURY.get()).add(CSBlocks.ORE_THORIUM_MOON.get()).add(CSBlocks.ORE_THORIUM_MARS.get()).add(CSBlocks.ORE_THORIUM_VENUS.get()).add(CSBlocks.ORE_THORIUM_MERCURY.get()).add(CSBlocks.ORE_URANIUM_MOON.get()).add(CSBlocks.ORE_URANIUM_MARS.get()).add(CSBlocks.ORE_URANIUM_VENUS.get()).add(CSBlocks.ORE_URANIUM_MERCURY.get()).add(CSBlocks.ORE_VANADIUM_MOON.get()).add(CSBlocks.ORE_VANADIUM_MARS.get()).add(CSBlocks.ORE_VANADIUM_VENUS.get()).add(CSBlocks.ORE_VANADIUM_MERCURY.get())
                // Ressource Block
                .add(CSBlocks.MAGNESIUM_BLOCK.get())
                .add(CSBlocks.SILICON_BLOCK.get())
                .add(CSBlocks.TUNGSTEN_BLOCK.get())
                // Decorative
                .add(CSBlocks.MAGNESIUM_GA9Z1_BLOCK.get())
                .add(CSBlocks.MAGNESIUM_GA9Z1_LAMP.get())
                .add(CSBlocks.MAGNESIUM_GA9Z1_SLAB.get())
                .add(CSBlocks.MAGNESIUM_GA9Z1_STAIR.get())

                .add(CSBlocks.ASPHALT_BLOCK.get())
                .add(CSBlocks.ASPHALT_STAIR.get())
                .add(CSBlocks.ASPHALT_SLAB.get())
                .add(CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK.get())
                .add(CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK.get())
                .add(CSBlocks.MARKED_CROSS_WHITE_ASPHALT_BLOCK.get())
                .add(CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK.get())
                .add(CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK.get())
                .add(CSBlocks.MARKED_CROSS_YELLOW_ASPHALT_BLOCK.get())
                // Machines
                .add(CSBlocks.ORGANIC_SOLAR_PANEL.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(CSBlocks.ORGANIC_SOLAR_PANEL.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(CSBlocks.ORE_MAGNESIUM.get())
                .add(CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get())
                .add(CSBlocks.ORE_OIL.get())
                .add(CSBlocks.ORE_DEEPSLATE_OIL.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                // Ores
                // Overworld
                .add(CSBlocks.ORE_SILICON.get())
                .add(CSBlocks.ORE_DEEPSLATE_SILICON.get())
                .add(CSBlocks.ORE_ARSENOPYRITE.get())
                .add(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get())
                .add(CSBlocks.ORE_WOLFRAMITE.get())
                .add(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get())
                // Stellaris
                .add(CSBlocks.ORE_ARSENOPYRITE_MOON.get()).add(CSBlocks.ORE_ARSENOPYRITE_MARS.get()).add(CSBlocks.ORE_ARSENOPYRITE_VENUS.get()).add(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get()).add(CSBlocks.ORE_COOPERITE_MOON.get()).add(CSBlocks.ORE_COOPERITE_MARS.get()).add(CSBlocks.ORE_COOPERITE_VENUS.get()).add(CSBlocks.ORE_COOPERITE_MERCURY.get()).add(CSBlocks.ORE_MAGNESIUM_MOON.get()).add(CSBlocks.ORE_MAGNESIUM_MARS.get()).add(CSBlocks.ORE_MAGNESIUM_VENUS.get()).add(CSBlocks.ORE_MAGNESIUM_MERCURY.get()).add(CSBlocks.ORE_SILICON_MOON.get()).add(CSBlocks.ORE_SILICON_MARS.get()).add(CSBlocks.ORE_SILICON_VENUS.get()).add(CSBlocks.ORE_SILICON_MERCURY.get()).add(CSBlocks.ORE_WOLFRAMITE_MOON.get()).add(CSBlocks.ORE_WOLFRAMITE_MARS.get()).add(CSBlocks.ORE_WOLFRAMITE_VENUS.get()).add(CSBlocks.ORE_WOLFRAMITE_MERCURY.get()).add(CSBlocks.ORE_ALUMINUM_MOON.get()).add(CSBlocks.ORE_ALUMINUM_MARS.get()).add(CSBlocks.ORE_ALUMINUM_VENUS.get()).add(CSBlocks.ORE_ALUMINUM_MERCURY.get()).add(CSBlocks.ORE_CHROMIUM_MOON.get()).add(CSBlocks.ORE_CHROMIUM_MARS.get()).add(CSBlocks.ORE_CHROMIUM_VENUS.get()).add(CSBlocks.ORE_CHROMIUM_MERCURY.get()).add(CSBlocks.ORE_FLUORITE_MOON.get()).add(CSBlocks.ORE_FLUORITE_MARS.get()).add(CSBlocks.ORE_FLUORITE_VENUS.get()).add(CSBlocks.ORE_FLUORITE_MERCURY.get()).add(CSBlocks.ORE_LEAD_MOON.get()).add(CSBlocks.ORE_LEAD_MARS.get()).add(CSBlocks.ORE_LEAD_VENUS.get()).add(CSBlocks.ORE_LEAD_MERCURY.get()).add(CSBlocks.ORE_LITHIUM_MOON.get()).add(CSBlocks.ORE_LITHIUM_MARS.get()).add(CSBlocks.ORE_LITHIUM_VENUS.get()).add(CSBlocks.ORE_LITHIUM_MERCURY.get()).add(CSBlocks.ORE_MOLYBDENUM_MOON.get()).add(CSBlocks.ORE_MOLYBDENUM_MARS.get()).add(CSBlocks.ORE_MOLYBDENUM_VENUS.get()).add(CSBlocks.ORE_MOLYBDENUM_MERCURY.get()).add(CSBlocks.ORE_MONAZITE_MOON.get()).add(CSBlocks.ORE_MONAZITE_MARS.get()).add(CSBlocks.ORE_MONAZITE_VENUS.get()).add(CSBlocks.ORE_MONAZITE_MERCURY.get()).add(CSBlocks.ORE_NITER_MOON.get()).add(CSBlocks.ORE_NITER_MARS.get()).add(CSBlocks.ORE_NITER_VENUS.get()).add(CSBlocks.ORE_NITER_MERCURY.get()).add(CSBlocks.ORE_SALT_MOON.get()).add(CSBlocks.ORE_SALT_MARS.get()).add(CSBlocks.ORE_SALT_VENUS.get()).add(CSBlocks.ORE_SALT_MERCURY.get()).add(CSBlocks.ORE_SILVER_MOON.get()).add(CSBlocks.ORE_SILVER_MARS.get()).add(CSBlocks.ORE_SILVER_VENUS.get()).add(CSBlocks.ORE_SILVER_MERCURY.get()).add(CSBlocks.ORE_SULFUR_MOON.get()).add(CSBlocks.ORE_SULFUR_MARS.get()).add(CSBlocks.ORE_SULFUR_VENUS.get()).add(CSBlocks.ORE_SULFUR_MERCURY.get()).add(CSBlocks.ORE_SYLVITE_MOON.get()).add(CSBlocks.ORE_SYLVITE_MARS.get()).add(CSBlocks.ORE_SYLVITE_VENUS.get()).add(CSBlocks.ORE_SYLVITE_MERCURY.get()).add(CSBlocks.ORE_TIN_MOON.get()).add(CSBlocks.ORE_TIN_MARS.get()).add(CSBlocks.ORE_TIN_VENUS.get()).add(CSBlocks.ORE_TIN_MERCURY.get()).add(CSBlocks.ORE_TITANIUM_MOON.get()).add(CSBlocks.ORE_TITANIUM_MARS.get()).add(CSBlocks.ORE_TITANIUM_VENUS.get()).add(CSBlocks.ORE_TITANIUM_MERCURY.get()).add(CSBlocks.ORE_THORIUM_MOON.get()).add(CSBlocks.ORE_THORIUM_MARS.get()).add(CSBlocks.ORE_THORIUM_VENUS.get()).add(CSBlocks.ORE_THORIUM_MERCURY.get()).add(CSBlocks.ORE_URANIUM_MOON.get()).add(CSBlocks.ORE_URANIUM_MARS.get()).add(CSBlocks.ORE_URANIUM_VENUS.get()).add(CSBlocks.ORE_URANIUM_MERCURY.get()).add(CSBlocks.ORE_VANADIUM_MOON.get()).add(CSBlocks.ORE_VANADIUM_MARS.get()).add(CSBlocks.ORE_VANADIUM_VENUS.get()).add(CSBlocks.ORE_VANADIUM_MERCURY.get());

        // Ressource Block
                // Decorative

    }
}
