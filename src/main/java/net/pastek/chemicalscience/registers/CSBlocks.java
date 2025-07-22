package net.pastek.chemicalscience.registers;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.decoration.*;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import voltaic.common.block.BlockMachine;
import voltaic.common.blockitem.BlockItemDescriptable;
import voltaic.prefab.utilities.VoltaicTextUtils;

import java.util.function.Supplier;

public class CSBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChemicalScience.MOD_ID);

    // Ores
    // Overworld
    public static final RegistryObject<Block> ORE_MAGNESIUM = registerBlock("ore_magnesium", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(0, 3)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_MAGNESIUM = registerBlock("ore_deepslate_magnesium", () -> new DropExperienceBlock( BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(0, 3)));
    public static final RegistryObject<Block> ORE_SILICON = registerBlock("ore_silicon", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(3, 8)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_SILICON = registerBlock("ore_deepslate_silicon", () -> new DropExperienceBlock( BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE), UniformInt.of(3, 8)));
    public static final RegistryObject<Block> ORE_ARSENOPYRITE = registerBlock("ore_arsenopyrite", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_ARSENOPYRITE = registerBlock("ore_deepslate_arsenopyrite", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ORE_WOLFRAMITE = registerBlock("ore_wolframite", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_WOLFRAMITE = registerBlock("ore_deepslate_wolframite", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ORE_COOPERITE = registerBlock("ore_cooperite", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_COOPERITE = registerBlock("ore_deepslate_cooperite", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ORE_PYROLUSITE = registerBlock("ore_pyrolusite", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_PYROLUSITE = registerBlock("ore_deepslate_pyrolusite", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> ORE_OIL = registerBlock("ore_sourcerock", () -> new Block(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ORE_DEEPSLATE_OIL = registerBlock("ore_deepslate_sourcerock", () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));


    // Stellaris, Ad Astra, Galacticraft
    public static final RegistryObject<Block> ORE_ARSENOPYRITE_MOON = registerBlock("ore_arsenopyrite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ARSENOPYRITE_MARS = registerBlock("ore_arsenopyrite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ARSENOPYRITE_VENUS = registerBlock("ore_arsenopyrite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ARSENOPYRITE_MERCURY = registerBlock("ore_arsenopyrite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_COOPERITE_MOON = registerBlock("ore_cooperite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_COOPERITE_MARS = registerBlock("ore_cooperite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_COOPERITE_VENUS = registerBlock("ore_cooperite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_COOPERITE_MERCURY = registerBlock("ore_cooperite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MAGNESIUM_MOON = registerBlock("ore_magnesium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MAGNESIUM_MARS = registerBlock("ore_magnesium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MAGNESIUM_VENUS = registerBlock("ore_magnesium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MAGNESIUM_MERCURY = registerBlock("ore_magnesium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_PYROLUSITE_MOON = registerBlock("ore_pyrolusite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_PYROLUSITE_MARS = registerBlock("ore_pyrolusite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_PYROLUSITE_VENUS = registerBlock("ore_pyrolusite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_PYROLUSITE_MERCURY = registerBlock("ore_pyrolusite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILICON_MOON = registerBlock("ore_silicon_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILICON_MARS = registerBlock("ore_silicon_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILICON_VENUS = registerBlock("ore_silicon_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILICON_MERCURY = registerBlock("ore_silicon_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_WOLFRAMITE_MOON = registerBlock("ore_wolframite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_WOLFRAMITE_MARS = registerBlock("ore_wolframite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_WOLFRAMITE_VENUS = registerBlock("ore_wolframite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_WOLFRAMITE_MERCURY = registerBlock("ore_wolframite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ALUMINUM_MOON = registerBlock("ore_aluminum_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ALUMINUM_MARS = registerBlock("ore_aluminum_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ALUMINUM_VENUS = registerBlock("ore_aluminum_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_ALUMINUM_MERCURY = registerBlock("ore_aluminum_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_CHROMIUM_MOON = registerBlock("ore_chromium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_CHROMIUM_MARS = registerBlock("ore_chromium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_CHROMIUM_VENUS = registerBlock("ore_chromium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_CHROMIUM_MERCURY = registerBlock("ore_chromium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_FLUORITE_MOON = registerBlock("ore_fluorite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_FLUORITE_MARS = registerBlock("ore_fluorite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_FLUORITE_VENUS = registerBlock("ore_fluorite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_FLUORITE_MERCURY = registerBlock("ore_fluorite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LEAD_MOON = registerBlock("ore_lead_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LEAD_MARS = registerBlock("ore_lead_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LEAD_VENUS = registerBlock("ore_lead_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LEAD_MERCURY = registerBlock("ore_lead_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LITHIUM_MOON = registerBlock("ore_lithium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LITHIUM_MARS = registerBlock("ore_lithium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LITHIUM_VENUS = registerBlock("ore_lithium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_LITHIUM_MERCURY = registerBlock("ore_lithium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MOLYBDENUM_MOON = registerBlock("ore_molybdenum_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MOLYBDENUM_MARS = registerBlock("ore_molybdenum_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MOLYBDENUM_VENUS = registerBlock("ore_molybdenum_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MOLYBDENUM_MERCURY = registerBlock("ore_molybdenum_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MONAZITE_MOON = registerBlock("ore_monazite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MONAZITE_MARS = registerBlock("ore_monazite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MONAZITE_VENUS = registerBlock("ore_monazite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_MONAZITE_MERCURY = registerBlock("ore_monazite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_NITER_MOON = registerBlock("ore_niter_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_NITER_MARS = registerBlock("ore_niter_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_NITER_VENUS = registerBlock("ore_niter_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_NITER_MERCURY = registerBlock("ore_niter_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SALT_MOON = registerBlock("ore_salt_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SALT_MARS = registerBlock("ore_salt_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SALT_VENUS = registerBlock("ore_salt_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SALT_MERCURY = registerBlock("ore_salt_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILVER_MOON = registerBlock("ore_silver_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILVER_MARS = registerBlock("ore_silver_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILVER_VENUS = registerBlock("ore_silver_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SILVER_MERCURY = registerBlock("ore_silver_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SULFUR_MOON = registerBlock("ore_sulfur_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SULFUR_MARS = registerBlock("ore_sulfur_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SULFUR_VENUS = registerBlock("ore_sulfur_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SULFUR_MERCURY = registerBlock("ore_sulfur_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SYLVITE_MOON = registerBlock("ore_sylvite_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SYLVITE_MARS = registerBlock("ore_sylvite_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SYLVITE_VENUS = registerBlock("ore_sylvite_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_SYLVITE_MERCURY = registerBlock("ore_sylvite_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TIN_MOON = registerBlock("ore_tin_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TIN_MARS = registerBlock("ore_tin_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TIN_VENUS = registerBlock("ore_tin_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TIN_MERCURY = registerBlock("ore_tin_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TITANIUM_MOON = registerBlock("ore_titanium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TITANIUM_MARS = registerBlock("ore_titanium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TITANIUM_VENUS = registerBlock("ore_titanium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_TITANIUM_MERCURY = registerBlock("ore_titanium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_THORIUM_MOON = registerBlock("ore_thorium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_THORIUM_MARS = registerBlock("ore_thorium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_THORIUM_VENUS = registerBlock("ore_thorium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_THORIUM_MERCURY = registerBlock("ore_thorium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_URANIUM_MOON = registerBlock("ore_uranium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_URANIUM_MARS = registerBlock("ore_uranium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_URANIUM_VENUS = registerBlock("ore_uranium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_URANIUM_MERCURY = registerBlock("ore_uranium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_VANADIUM_MOON = registerBlock("ore_vanadium_moon", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_VANADIUM_MARS = registerBlock("ore_vanadium_mars", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_VANADIUM_VENUS = registerBlock("ore_vanadium_venus", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> ORE_VANADIUM_MERCURY = registerBlock("ore_vanadium_mercury", () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    // Ressource Block
    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("block_magnesium",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("block_silicon",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBlock("block_manganese",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("block_tungsten",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("block_platinum",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    // Decorative
    public static final RegistryObject<Block> MAGNESIUM_GA9Z1_BLOCK = registerBlock("block_magnesiumaluminum",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final RegistryObject<Block> MAGNESIUM_GA9Z1_LAMP = registerBlock("lamp_magnesiumaluminum",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER).lightLevel(BlockState -> 15)));
    public static final RegistryObject<StairBlock> MAGNESIUM_GA9Z1_STAIR = registerBlock("stair_magnesiumaluminum",
            () -> new StairBlock(CSBlocks.MAGNESIUM_GA9Z1_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final RegistryObject<SlabBlock> MAGNESIUM_GA9Z1_SLAB = registerBlock("slab_magnesiumaluminum",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final RegistryObject<DoorBlock> MAGNESIUM_GA9Z1_DOOR = registerBlock("door_magnesiumaluminum",
            () -> new DoorBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.BIRCH));
    public static final RegistryObject<TrapDoorBlock> MAGNESIUM_GA9Z1_TRAPDOOR = registerBlock("trapdoor_magnesiumaluminum",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.BIRCH));
    public static final RegistryObject<FenceBlock> MAGNESIUM_GA9Z1_FENCE = registerBlock("fence_magnesiumaluminum",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> MANGANESE_GRATE = registerBlock("grate_manganese",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<CSLadderBlock> MANGANESE_LADDER = registerBlock("ladder_manganese",
            () -> new CSLadderBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> MANGANESE_SCAFFOLDING = registerBlock("scaffolding_manganese",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> MANGANESE_SCAFFOLDING_HOLLOW = registerBlock("scaffolding_manganese_hollow",
            () -> new CSScaffoldingHollow(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<SlabBlock> MANGANESE_SCAFFOLDING_SLAB = registerBlock("slab_scaffolding_manganese",
            () -> new SlabBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> MANGANESE_SCAFFOLDING_GRATE = registerBlock("scaffolding_grate_manganese",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> MANGANESE_SCAFFOLDING_GRATE_HOLLOW = registerBlock("scaffolding_grate_manganese_hollow",
            () -> new CSScaffoldingOpen(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<SlabBlock> MANGANESE_SCAFFOLDING_GRATE_SLAB = registerBlock("slab_scaffolding_grate_manganese",
            () -> new SlabBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> MANGANESE_SCAFFOLDING_GLASS = registerBlock("scaffolding_glass_manganese",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> MANGANESE_SCAFFOLDING_GLASS_HOLLOW = registerBlock("scaffolding_glass_manganese_hollow",
            () -> new CSScaffoldingHollow(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<SlabBlock> MANGANESE_SCAFFOLDING_GLASS_SLAB = registerBlock("slab_scaffolding_glass_manganese",
            () -> new SlabBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_STEEL_WHITE = registerBlock("metalhalidelamp_sw",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(3f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_STEEL_RED = registerBlock("metalhalidelamp_sr",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(3f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_STEEL_GREEN = registerBlock("metalhalidelamp_sg",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(3f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_STEEL_BLUE = registerBlock("metalhalidelamp_sb",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(3f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_MANGANESE_WHITE = registerBlock("metalhalidelamp_mw",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_MANGANESE_RED = registerBlock("metalhalidelamp_mr",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_MANGANESE_GREEN = registerBlock("metalhalidelamp_mg",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> METAL_HALIDE_LAMP_MANGANESE_BLUE = registerBlock("metalhalidelamp_mb",
            () -> new CSHalideLamp(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).strength(2f).lightLevel(BlockState -> 15)));
    public static final RegistryObject<Block> RACK_MANGANESE = registerBlock("rack_manganese", () -> new BlockMachine(SubtypeChemicalMachine.rackm));
    public static final RegistryObject<Block> RACK_STEEL = registerBlock("rack_steel", () -> new BlockMachine(SubtypeChemicalMachine.racks));
    public static final RegistryObject<Block> LABORATORY_BENCH = registerBlock("laboratory_bench", () -> new BlockMachine(SubtypeChemicalMachine.labbench));
    public static final RegistryObject<Block> LABORATORY_SUPPORT = registerBlock("laboratory_support",
            () -> new CSLabSupport(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f)));
    public static final RegistryObject<Block> LABORATORY_SINK = registerBlock("laboratory_sink",
            () -> new CSLabSink(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f).noOcclusion()));
    public static final RegistryObject<Block> LABORATORY_STORAGE = registerBlock("laboratory_storage", () -> new BlockMachine(SubtypeChemicalMachine.labstorage));

    public static final RegistryObject<Block> ASPHALT_BLOCK = registerBlock("block_asphalt",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<StairBlock> ASPHALT_STAIR = registerBlock("stair_asphalt",
            () -> new StairBlock(CSBlocks.ASPHALT_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<SlabBlock> ASPHALT_SLAB = registerBlock("slab_asphalt",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARKED_LINE_WHITE_ASPHALT_BLOCK = registerBlock("block_marked_white_line_asphalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARKED_DOT_WHITE_ASPHALT_BLOCK = registerBlock("block_marked_white_dot_asphalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARKED_LINE_YELLOW_ASPHALT_BLOCK = registerBlock("block_marked_yellow_line_asphalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARKED_DOT_YELLOW_ASPHALT_BLOCK = registerBlock("block_marked_yellow_dot_asphalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> CONCRETE_SHIELDING = registerBlock("radiationshielding_concrete",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS).explosionResistance(9)));
    public static final RegistryObject<Block> TANTALUM_SHIELDING = registerBlock("radiationshielding_tantalum",
            () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.COPPER).explosionResistance(30)));
    public static final RegistryObject<Block> GLASS_SHIELDING = registerBlock("radiationshielding_glass",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).noLootTable().sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ADVANCED_GLASS_SHIELDING = registerBlock("radiationshielding_advancedglass",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).noLootTable().sound(SoundType.GLASS).explosionResistance(15).noOcclusion()));

    public static final RegistryObject<Block> SYMBOL_BIOHAZARD = registerBlock("symbol_biohazard",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_RADIATION = registerBlock("symbol_radiation",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_ELECTRICAL = registerBlock("symbol_electrical",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_DANGER = registerBlock("symbol_danger",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_FLAMMABLE = registerBlock("symbol_flammable",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_TOXIC = registerBlock("symbol_toxic",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_CORROSIVE = registerBlock("symbol_corrosive",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_PRESSURE = registerBlock("symbol_pressure",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> SYMBOL_EXPLOSIVE = registerBlock("symbol_explosive",
            () -> new CSSymbol(BlockBehaviour.Properties.of().instabreak().sound(SoundType.SCAFFOLDING)));

    // periodic table
    public static final RegistryObject<Block> ELEMENT_H =  registerBlock("block_element_h",  () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_HE = registerBlock("block_element_he", () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ELEMENT_LI = registerBlock("block_element_li", () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELEMENT_BE = registerBlock("block_element_be", () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ELEMENT_B =  registerBlock("block_element_b",  () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ELEMENT_C =  registerBlock("block_element_c",  () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_N =  registerBlock("block_element_n",  () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_O =  registerBlock("block_element_o",  () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_F =  registerBlock("block_element_f",  () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_NE = registerBlock("block_element_ne", () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ELEMENT_NA = registerBlock("block_element_na", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELEMENT_MG = registerBlock("block_element_mg", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ELEMENT_AL = registerBlock("block_element_al", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_SI = registerBlock("block_element_si", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ELEMENT_P =  registerBlock("block_element_p",  () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_S =  registerBlock("block_element_s",  () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_CL = registerBlock("block_element_cl", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_AR = registerBlock("block_element_ar", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ELEMENT_K =  registerBlock("block_element_k",  () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELEMENT_CA = registerBlock("block_element_ca", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ELEMENT_SC = registerBlock("block_element_sc", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_TI = registerBlock("block_element_ti", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_V =  registerBlock("block_element_v",  () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_CR = registerBlock("block_element_cr", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_MN = registerBlock("block_element_mn", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_FE = registerBlock("block_element_fe", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_CO = registerBlock("block_element_co", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_NI = registerBlock("block_element_ni", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_CU = registerBlock("block_element_cu", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_ZN = registerBlock("block_element_zn", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_GA = registerBlock("block_element_ga", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_GE = registerBlock("block_element_ge", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ELEMENT_AS = registerBlock("block_element_as", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ELEMENT_SE = registerBlock("block_element_se", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_BR = registerBlock("block_element_br", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_KR = registerBlock("block_element_kr", () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ELEMENT_RB = registerBlock("block_element_rb", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELEMENT_SR = registerBlock("block_element_sr", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ELEMENT_Y =  registerBlock("block_element_y",  () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_ZR = registerBlock("block_element_zr", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_NB = registerBlock("block_element_nb", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_MO = registerBlock("block_element_mo", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_TC = registerBlock("block_element_tc", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_RU = registerBlock("block_element_ru", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_RH = registerBlock("block_element_rh", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_PD = registerBlock("block_element_pd", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_AG = registerBlock("block_element_ag", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_CD = registerBlock("block_element_cd", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_IN = registerBlock("block_element_in", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_SN = registerBlock("block_element_sn", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_SB = registerBlock("block_element_sb", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ELEMENT_TE = registerBlock("block_element_te", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ELEMENT_I =  registerBlock("block_element_i",  () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ELEMENT_XE = registerBlock("block_element_xe", () -> new Block(BlockBehaviour.Properties.of().strength(5f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ELEMENT_CS = registerBlock("block_element_cs", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELEMENT_BA = registerBlock("block_element_ba", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ELEMENT_LA = registerBlock("block_element_la", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_CE = registerBlock("block_element_ce", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_PR = registerBlock("block_element_pr", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_ND = registerBlock("block_element_nd", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_PM = registerBlock("block_element_pm", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_SM = registerBlock("block_element_sm", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_EU = registerBlock("block_element_eu", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_GD = registerBlock("block_element_gd", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_TB = registerBlock("block_element_tb", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_DY = registerBlock("block_element_dy", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_HO = registerBlock("block_element_ho", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_ER = registerBlock("block_element_er", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_TM = registerBlock("block_element_tm", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_YB = registerBlock("block_element_yb", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_LU = registerBlock("block_element_lu", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ELEMENT_HF = registerBlock("block_element_hf", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_TA = registerBlock("block_element_ta", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_W =  registerBlock("block_element_w",  () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_RE = registerBlock("block_element_re", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_OS = registerBlock("block_element_os", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_IR = registerBlock("block_element_ir", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_PT = registerBlock("block_element_pt", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_AU = registerBlock("block_element_au", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_HG = registerBlock("block_element_hg", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_TL = registerBlock("block_element_tl", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_PB = registerBlock("block_element_pb", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_BI = registerBlock("block_element_bi", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_PO = registerBlock("block_element_po", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_AT = registerBlock("block_element_at", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_RN = registerBlock("block_element_rn", () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ELEMENT_FR = registerBlock("block_element_fr", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ELEMENT_RA = registerBlock("block_element_ra", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ELEMENT_AC = registerBlock("block_element_ac", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_TH = registerBlock("block_element_th", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_PA = registerBlock("block_element_pa", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_U =  registerBlock("block_element_u",  () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_NP = registerBlock("block_element_np", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_PU = registerBlock("block_element_pu", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_AM = registerBlock("block_element_am", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_CM = registerBlock("block_element_cm", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_BK = registerBlock("block_element_bk", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_CF = registerBlock("block_element_cf", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_ES = registerBlock("block_element_es", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_FM = registerBlock("block_element_fm", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_MD = registerBlock("block_element_md", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_NO = registerBlock("block_element_no", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_LR = registerBlock("block_element_lr", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> ELEMENT_RF = registerBlock("block_element_rf", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_DB = registerBlock("block_element_db", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_SG = registerBlock("block_element_sg", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_BH = registerBlock("block_element_bh", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_HS = registerBlock("block_element_hs", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_MT = registerBlock("block_element_mt", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_DS = registerBlock("block_element_ds", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_RG = registerBlock("block_element_rg", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_CN = registerBlock("block_element_cn", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_NH = registerBlock("block_element_nh", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_FL = registerBlock("block_element_fl", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_MC = registerBlock("block_element_mc", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_LV = registerBlock("block_element_lv", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_TS = registerBlock("block_element_ts", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ELEMENT_OG = registerBlock("block_element_og", () -> new Block(BlockBehaviour.Properties.of().strength(7f).sound(SoundType.AMETHYST)));

    // Misc
    public static final RegistryObject<Block> ORGANIC_SOLAR_PANEL = registerBlock("organicsolarpanel", () -> new BlockMachine(SubtypeChemicalMachine.organicsolarpanel));
    public static final RegistryObject<Block> FUEL_CELL = registerBlock("fuelcell", () -> new BlockMachine(SubtypeChemicalMachine.fuelcell));
    public static final RegistryObject<Block> CIRCUIT_MAKER = registerBlock("circuitmaker", () -> new BlockMachine(SubtypeChemicalMachine.circuitmaker));


    static { BlockItemDescriptable.addDescription(ORGANIC_SOLAR_PANEL, VoltaicTextUtils.voltageTooltip(240)); }
    static { BlockItemDescriptable.addDescription(FUEL_CELL, VoltaicTextUtils.voltageTooltip(240)); }
    static { BlockItemDescriptable.addDescription(CIRCUIT_MAKER, VoltaicTextUtils.voltageTooltip(480)); }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        CSItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}