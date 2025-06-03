package net.pastek.chemicalscience.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.datagen.utils.client.BaseBlockstateProvider;

public class CSBlockStateProvider extends BaseBlockstateProvider {

    public CSBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper, ChemicalScience.MOD_ID);
    }

    @Override
    protected void registerStatesAndModels() {
        // Ores
        blockWithItem(CSBlocks.ORE_MAGNESIUM);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_MAGNESIUM);
        blockWithItem(CSBlocks.ORE_SILICON);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_SILICON);
        blockWithItem(CSBlocks.ORE_ARSENOPYRITE);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE);
        blockWithItem(CSBlocks.ORE_WOLFRAMITE);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE);
        blockWithItem(CSBlocks.ORE_COOPERITE);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_COOPERITE);
        blockWithItem(CSBlocks.ORE_PYROLUSITE);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_PYROLUSITE);
        blockWithItem(CSBlocks.ORE_OIL);
        blockWithItem(CSBlocks.ORE_DEEPSLATE_OIL);

        //Stellaris
        blockWithItem(CSBlocks.ORE_ARSENOPYRITE_MOON);blockWithItem(CSBlocks.ORE_ARSENOPYRITE_MARS);blockWithItem(CSBlocks.ORE_ARSENOPYRITE_VENUS);blockWithItem(CSBlocks.ORE_ARSENOPYRITE_MERCURY);blockWithItem(CSBlocks.ORE_COOPERITE_MOON);blockWithItem(CSBlocks.ORE_COOPERITE_MARS);blockWithItem(CSBlocks.ORE_COOPERITE_VENUS);blockWithItem(CSBlocks.ORE_COOPERITE_MERCURY);blockWithItem(CSBlocks.ORE_MAGNESIUM_MOON);blockWithItem(CSBlocks.ORE_MAGNESIUM_MARS);blockWithItem(CSBlocks.ORE_MAGNESIUM_VENUS);blockWithItem(CSBlocks.ORE_MAGNESIUM_MERCURY);blockWithItem(CSBlocks.ORE_PYROLUSITE_MOON);blockWithItem(CSBlocks.ORE_PYROLUSITE_MARS);blockWithItem(CSBlocks.ORE_PYROLUSITE_VENUS);blockWithItem(CSBlocks.ORE_PYROLUSITE_MERCURY);blockWithItem(CSBlocks.ORE_SILICON_MOON);blockWithItem(CSBlocks.ORE_SILICON_MARS);blockWithItem(CSBlocks.ORE_SILICON_VENUS);blockWithItem(CSBlocks.ORE_SILICON_MERCURY);blockWithItem(CSBlocks.ORE_WOLFRAMITE_MOON);blockWithItem(CSBlocks.ORE_WOLFRAMITE_MARS);blockWithItem(CSBlocks.ORE_WOLFRAMITE_VENUS);blockWithItem(CSBlocks.ORE_WOLFRAMITE_MERCURY);blockWithItem(CSBlocks.ORE_ALUMINUM_MOON);blockWithItem(CSBlocks.ORE_ALUMINUM_MARS);blockWithItem(CSBlocks.ORE_ALUMINUM_VENUS);blockWithItem(CSBlocks.ORE_ALUMINUM_MERCURY);blockWithItem(CSBlocks.ORE_CHROMIUM_MOON);blockWithItem(CSBlocks.ORE_CHROMIUM_MARS);blockWithItem(CSBlocks.ORE_CHROMIUM_VENUS);blockWithItem(CSBlocks.ORE_CHROMIUM_MERCURY);blockWithItem(CSBlocks.ORE_FLUORITE_MOON);blockWithItem(CSBlocks.ORE_FLUORITE_MARS);blockWithItem(CSBlocks.ORE_FLUORITE_VENUS);blockWithItem(CSBlocks.ORE_FLUORITE_MERCURY);blockWithItem(CSBlocks.ORE_LEAD_MOON);blockWithItem(CSBlocks.ORE_LEAD_MARS);blockWithItem(CSBlocks.ORE_LEAD_VENUS);blockWithItem(CSBlocks.ORE_LEAD_MERCURY);blockWithItem(CSBlocks.ORE_LITHIUM_MOON);blockWithItem(CSBlocks.ORE_LITHIUM_MARS);blockWithItem(CSBlocks.ORE_LITHIUM_VENUS);blockWithItem(CSBlocks.ORE_LITHIUM_MERCURY);blockWithItem(CSBlocks.ORE_MOLYBDENUM_MOON);blockWithItem(CSBlocks.ORE_MOLYBDENUM_MARS);blockWithItem(CSBlocks.ORE_MOLYBDENUM_VENUS);blockWithItem(CSBlocks.ORE_MOLYBDENUM_MERCURY);blockWithItem(CSBlocks.ORE_MONAZITE_MOON);blockWithItem(CSBlocks.ORE_MONAZITE_MARS);blockWithItem(CSBlocks.ORE_MONAZITE_VENUS);blockWithItem(CSBlocks.ORE_MONAZITE_MERCURY);blockWithItem(CSBlocks.ORE_NITER_MOON);blockWithItem(CSBlocks.ORE_NITER_MARS);blockWithItem(CSBlocks.ORE_NITER_VENUS);blockWithItem(CSBlocks.ORE_NITER_MERCURY);blockWithItem(CSBlocks.ORE_SALT_MOON);blockWithItem(CSBlocks.ORE_SALT_MARS);blockWithItem(CSBlocks.ORE_SALT_VENUS);blockWithItem(CSBlocks.ORE_SALT_MERCURY);blockWithItem(CSBlocks.ORE_SILVER_MOON);blockWithItem(CSBlocks.ORE_SILVER_MARS);blockWithItem(CSBlocks.ORE_SILVER_VENUS);blockWithItem(CSBlocks.ORE_SILVER_MERCURY);blockWithItem(CSBlocks.ORE_SULFUR_MOON);blockWithItem(CSBlocks.ORE_SULFUR_MARS);blockWithItem(CSBlocks.ORE_SULFUR_VENUS);blockWithItem(CSBlocks.ORE_SULFUR_MERCURY);blockWithItem(CSBlocks.ORE_SYLVITE_MOON);blockWithItem(CSBlocks.ORE_SYLVITE_MARS);blockWithItem(CSBlocks.ORE_SYLVITE_VENUS);blockWithItem(CSBlocks.ORE_SYLVITE_MERCURY);blockWithItem(CSBlocks.ORE_TIN_MOON);blockWithItem(CSBlocks.ORE_TIN_MARS);blockWithItem(CSBlocks.ORE_TIN_VENUS);blockWithItem(CSBlocks.ORE_TIN_MERCURY);blockWithItem(CSBlocks.ORE_TITANIUM_MOON);blockWithItem(CSBlocks.ORE_TITANIUM_MARS);blockWithItem(CSBlocks.ORE_TITANIUM_VENUS);blockWithItem(CSBlocks.ORE_TITANIUM_MERCURY);blockWithItem(CSBlocks.ORE_THORIUM_MOON);blockWithItem(CSBlocks.ORE_THORIUM_MARS);blockWithItem(CSBlocks.ORE_THORIUM_VENUS);blockWithItem(CSBlocks.ORE_THORIUM_MERCURY);blockWithItem(CSBlocks.ORE_URANIUM_MOON);blockWithItem(CSBlocks.ORE_URANIUM_MARS);blockWithItem(CSBlocks.ORE_URANIUM_VENUS);blockWithItem(CSBlocks.ORE_URANIUM_MERCURY);blockWithItem(CSBlocks.ORE_VANADIUM_MOON);blockWithItem(CSBlocks.ORE_VANADIUM_MARS);blockWithItem(CSBlocks.ORE_VANADIUM_VENUS);blockWithItem(CSBlocks.ORE_VANADIUM_MERCURY);

        // Ressource Block
        blockWithItem(CSBlocks.MAGNESIUM_BLOCK);
        blockWithItem(CSBlocks.SILICON_BLOCK);
        blockWithItem(CSBlocks.MANGANESE_BLOCK);
        blockWithItem(CSBlocks.TUNGSTEN_BLOCK);
        blockWithItem(CSBlocks.PLATINUM_BLOCK);

        // Decorative
        buildingBlockWithItem(CSBlocks.MAGNESIUM_GA9Z1_BLOCK);
        stairsBlock(CSBlocks.MAGNESIUM_GA9Z1_STAIR.get(), CSTexture("metal_building_blocks", "block_magnesiumaluminum"));
        blockItem(CSBlocks.MAGNESIUM_GA9Z1_STAIR);
        slabBlock(CSBlocks.MAGNESIUM_GA9Z1_SLAB.get(), blockTexture(CSBlocks.MAGNESIUM_GA9Z1_BLOCK.get()), CSTexture("metal_building_blocks", "block_magnesiumaluminum"));
        blockItem(CSBlocks.MAGNESIUM_GA9Z1_SLAB);
        buildingBlockWithItem(CSBlocks.MAGNESIUM_GA9Z1_LAMP);
        doorBlockWithRenderType(CSBlocks.MAGNESIUM_GA9Z1_DOOR.get(), modLoc("block/metal_building_blocks/door_magnesium_bottom"), modLoc("block/metal_building_blocks/door_magnesium_top"), "cutout");
        trapdoorBlockWithRenderType(CSBlocks.MAGNESIUM_GA9Z1_TRAPDOOR.get(), modLoc("block/metal_building_blocks/trapdoor_magnesium"), true, "cutout");
        blockItem(CSBlocks.MAGNESIUM_GA9Z1_TRAPDOOR, "block/", "_bottom");
        fenceBlock(CSBlocks.MAGNESIUM_GA9Z1_FENCE.get(), CSTexture("metal_building_blocks", "block_magnesiumaluminum"));
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_HOLLOW);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_GRATE_HOLLOW);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_GLASS_HOLLOW);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING);
        blockItem(CSBlocks.MANGANESE_GRATE);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_GRATE);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_GLASS);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_SLAB);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_GRATE_SLAB);
        blockItem(CSBlocks.MANGANESE_SCAFFOLDING_GLASS_SLAB);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_WHITE);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_RED);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_GREEN);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_BLUE);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_STEEL_WHITE);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_STEEL_RED);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_STEEL_GREEN);
        blockItem(CSBlocks.METAL_HALIDE_LAMP_STEEL_BLUE);

        blockItem(CSBlocks.SYMBOL_BIOHAZARD);
        blockItem(CSBlocks.SYMBOL_RADIATION);
        blockItem(CSBlocks.SYMBOL_DANGER);
        blockItem(CSBlocks.SYMBOL_ELECTRICAL);
        blockItem(CSBlocks.SYMBOL_FLAMMABLE);
        blockItem(CSBlocks.SYMBOL_TOXIC);
        blockItem(CSBlocks.SYMBOL_CORROSIVE);
        blockItem(CSBlocks.SYMBOL_PRESSURE);
        blockItem(CSBlocks.SYMBOL_EXPLOSIVE);

        blockWithItem(CSBlocks.ASPHALT_BLOCK);
        stairsBlock(CSBlocks.ASPHALT_STAIR.get(),blockTexture(CSBlocks.ASPHALT_BLOCK.get()));blockItem(CSBlocks.ASPHALT_STAIR);
        slabBlock(CSBlocks.ASPHALT_SLAB.get(), blockTexture(CSBlocks.ASPHALT_BLOCK.get()), blockTexture(CSBlocks.ASPHALT_BLOCK.get()));blockItem(CSBlocks.ASPHALT_SLAB);
        logBlock(((RotatedPillarBlock) CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK.get()));blockItem(CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK);
        logBlock(((RotatedPillarBlock) CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK.get()));blockItem(CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK);
        logBlock(((RotatedPillarBlock) CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK.get()));blockItem(CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK);
        logBlock(((RotatedPillarBlock) CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK.get()));blockItem(CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK);

        blockWithItem(CSBlocks.CONCRETE_SHIELDING);
        blockWithItem(CSBlocks.TANTALUM_SHIELDING);
        glassBlock(CSBlocks.GLASS_SHIELDING, modLoc("block/radiationshielding_glass"), true);
        glassBlock(CSBlocks.ADVANCED_GLASS_SHIELDING, modLoc("block/radiationshielding_advancedglass"), true);

        horrRotatedBlock(CSBlocks.ORGANIC_SOLAR_PANEL, existingBlock(CSBlocks.ORGANIC_SOLAR_PANEL), true);
        horrRotatedBlock(CSBlocks.FUEL_CELL, existingBlock(CSBlocks.FUEL_CELL), true);
        horrRotatedBlock(CSBlocks.RACK_MANGANESE, existingBlock(CSBlocks.RACK_MANGANESE), true);
        horrRotatedBlock(CSBlocks.RACK_STEEL, existingBlock(CSBlocks.RACK_STEEL), true);
        horrRotatedBlock(CSBlocks.LABORATORY_BENCH, existingBlock(CSBlocks.LABORATORY_BENCH), true);
        horrRotatedBlock(CSBlocks.LABORATORY_STORAGE, existingBlock(CSBlocks.LABORATORY_STORAGE), true);
        blockItem(CSBlocks.LABORATORY_SUPPORT);
        blockItem(CSBlocks.LABORATORY_SINK);

        // Periodic table
        blockWithItem(CSBlocks.ELEMENT_H);
        blockWithItem(CSBlocks.ELEMENT_HE);
        blockWithItem(CSBlocks.ELEMENT_LI);
        blockWithItem(CSBlocks.ELEMENT_BE);
        blockWithItem(CSBlocks.ELEMENT_B);
        blockWithItem(CSBlocks.ELEMENT_C);
        blockWithItem(CSBlocks.ELEMENT_N);
        blockWithItem(CSBlocks.ELEMENT_O);
        blockWithItem(CSBlocks.ELEMENT_F);
        blockWithItem(CSBlocks.ELEMENT_NE);
        blockWithItem(CSBlocks.ELEMENT_NA);
        blockWithItem(CSBlocks.ELEMENT_MG);
        blockWithItem(CSBlocks.ELEMENT_AL);
        blockWithItem(CSBlocks.ELEMENT_SI);
        blockWithItem(CSBlocks.ELEMENT_P);
        blockWithItem(CSBlocks.ELEMENT_S);
        blockWithItem(CSBlocks.ELEMENT_CL);
        blockWithItem(CSBlocks.ELEMENT_AR);
        blockWithItem(CSBlocks.ELEMENT_K);
        blockWithItem(CSBlocks.ELEMENT_CA);
        blockWithItem(CSBlocks.ELEMENT_SC);
        blockWithItem(CSBlocks.ELEMENT_TI);
        blockWithItem(CSBlocks.ELEMENT_V);
        blockWithItem(CSBlocks.ELEMENT_CR);
        blockWithItem(CSBlocks.ELEMENT_MN);
        blockWithItem(CSBlocks.ELEMENT_FE);
        blockWithItem(CSBlocks.ELEMENT_CO);
        blockWithItem(CSBlocks.ELEMENT_NI);
        blockWithItem(CSBlocks.ELEMENT_CU);
        blockWithItem(CSBlocks.ELEMENT_ZN);
        blockWithItem(CSBlocks.ELEMENT_GA);
        blockWithItem(CSBlocks.ELEMENT_GE);
        blockWithItem(CSBlocks.ELEMENT_AS);
        blockWithItem(CSBlocks.ELEMENT_SE);
        blockWithItem(CSBlocks.ELEMENT_BR);
        blockWithItem(CSBlocks.ELEMENT_KR);
        blockWithItem(CSBlocks.ELEMENT_RB);
        blockWithItem(CSBlocks.ELEMENT_SR);
        blockWithItem(CSBlocks.ELEMENT_Y);
        blockWithItem(CSBlocks.ELEMENT_ZR);
        blockWithItem(CSBlocks.ELEMENT_NB);
        blockWithItem(CSBlocks.ELEMENT_MO);
        blockWithItem(CSBlocks.ELEMENT_TC);
        blockWithItem(CSBlocks.ELEMENT_RU);
        blockWithItem(CSBlocks.ELEMENT_RH);
        blockWithItem(CSBlocks.ELEMENT_PD);
        blockWithItem(CSBlocks.ELEMENT_AG);
        blockWithItem(CSBlocks.ELEMENT_CD);
        blockWithItem(CSBlocks.ELEMENT_IN);
        blockWithItem(CSBlocks.ELEMENT_SN);
        blockWithItem(CSBlocks.ELEMENT_SB);
        blockWithItem(CSBlocks.ELEMENT_TE);
        blockWithItem(CSBlocks.ELEMENT_I);
        blockWithItem(CSBlocks.ELEMENT_XE);
        blockWithItem(CSBlocks.ELEMENT_CS);
        blockWithItem(CSBlocks.ELEMENT_BA);
        blockWithItem(CSBlocks.ELEMENT_LA);
        blockWithItem(CSBlocks.ELEMENT_CE);
        blockWithItem(CSBlocks.ELEMENT_PR);
        blockWithItem(CSBlocks.ELEMENT_ND);
        blockWithItem(CSBlocks.ELEMENT_PM);
        blockWithItem(CSBlocks.ELEMENT_SM);
        blockWithItem(CSBlocks.ELEMENT_EU);
        blockWithItem(CSBlocks.ELEMENT_GD);
        blockWithItem(CSBlocks.ELEMENT_TB);
        blockWithItem(CSBlocks.ELEMENT_DY);
        blockWithItem(CSBlocks.ELEMENT_HO);
        blockWithItem(CSBlocks.ELEMENT_ER);
        blockWithItem(CSBlocks.ELEMENT_TM);
        blockWithItem(CSBlocks.ELEMENT_YB);
        blockWithItem(CSBlocks.ELEMENT_LU);
        blockWithItem(CSBlocks.ELEMENT_HF);
        blockWithItem(CSBlocks.ELEMENT_TA);
        blockWithItem(CSBlocks.ELEMENT_W);
        blockWithItem(CSBlocks.ELEMENT_RE);
        blockWithItem(CSBlocks.ELEMENT_OS);
        blockWithItem(CSBlocks.ELEMENT_IR);
        blockWithItem(CSBlocks.ELEMENT_PT);
        blockWithItem(CSBlocks.ELEMENT_AU);
        blockWithItem(CSBlocks.ELEMENT_HG);
        blockWithItem(CSBlocks.ELEMENT_TL);
        blockWithItem(CSBlocks.ELEMENT_PB);
        blockWithItem(CSBlocks.ELEMENT_BI);
        blockWithItem(CSBlocks.ELEMENT_PO);
        blockWithItem(CSBlocks.ELEMENT_AT);
        blockWithItem(CSBlocks.ELEMENT_RN);
        blockWithItem(CSBlocks.ELEMENT_FR);
        blockWithItem(CSBlocks.ELEMENT_RA);
        blockWithItem(CSBlocks.ELEMENT_AC);
        blockWithItem(CSBlocks.ELEMENT_TH);
        blockWithItem(CSBlocks.ELEMENT_PA);
        blockWithItem(CSBlocks.ELEMENT_U);
        blockWithItem(CSBlocks.ELEMENT_NP);
        blockWithItem(CSBlocks.ELEMENT_PU);
        blockWithItem(CSBlocks.ELEMENT_AM);
        blockWithItem(CSBlocks.ELEMENT_CM);
        blockWithItem(CSBlocks.ELEMENT_BK);
        blockWithItem(CSBlocks.ELEMENT_CF);
        blockWithItem(CSBlocks.ELEMENT_ES);
        blockWithItem(CSBlocks.ELEMENT_FM);
        blockWithItem(CSBlocks.ELEMENT_MD);
        blockWithItem(CSBlocks.ELEMENT_NO);
        blockWithItem(CSBlocks.ELEMENT_LR);
        blockWithItem(CSBlocks.ELEMENT_RF);
        blockWithItem(CSBlocks.ELEMENT_DB);
        blockWithItem(CSBlocks.ELEMENT_SG);
        blockWithItem(CSBlocks.ELEMENT_BH);
        blockWithItem(CSBlocks.ELEMENT_HS);
        blockWithItem(CSBlocks.ELEMENT_MT);
        blockWithItem(CSBlocks.ELEMENT_DS);
        blockWithItem(CSBlocks.ELEMENT_RG);
        blockWithItem(CSBlocks.ELEMENT_CN);
        blockWithItem(CSBlocks.ELEMENT_NH);
        blockWithItem(CSBlocks.ELEMENT_FL);
        blockWithItem(CSBlocks.ELEMENT_MC);
        blockWithItem(CSBlocks.ELEMENT_LV);
        blockWithItem(CSBlocks.ELEMENT_TS);
        blockWithItem(CSBlocks.ELEMENT_OG);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        String path = deferredBlock.getId().getPath();

        if (path.startsWith("ore_")) {
            ModelFile model = models().cubeAll(path, modLoc("block/ores/" + path));
            simpleBlockWithItem(deferredBlock.get(), model);
        } else if (path.startsWith("block_element_")) {
            ModelFile model = models().cubeAll(path, modLoc("block/periodic_table/" + path));
            simpleBlockWithItem(deferredBlock.get(), model);
        } else {
            simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
        }
    }

    private void buildingBlockWithItem(DeferredBlock<?> deferredBlock) {
        String path = deferredBlock.getId().getPath();

            ModelFile model = models().cubeAll(path, modLoc("block/metal_building_blocks/" + path));
            simpleBlockWithItem(deferredBlock.get(), model);
    }

    public ResourceLocation CSTexture(String folder, String texture) {
        return ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "block/" + folder + "/" + texture);
    }


    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("chemicalscience:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String loc, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("chemicalscience:" + loc + deferredBlock.getId().getPath() + appendix));
    }

}