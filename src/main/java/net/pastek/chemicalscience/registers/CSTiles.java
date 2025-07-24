package net.pastek.chemicalscience.registers;

import com.google.common.collect.Sets;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.tile.*;

public class CSTiles {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ChemicalScience.MOD_ID);

    public static final RegistryObject<BlockEntityType<TileOrganicSolarPanel>> TILE_ORGANICSOLARPANEL = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.organicsolarpanel.tag(), () -> new BlockEntityType<>(TileOrganicSolarPanel::new, Sets.newHashSet(CSBlocks.ORGANIC_SOLAR_PANEL.get()), null));
    public static final RegistryObject<BlockEntityType<TileRackM>> TILE_RACK_M = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.rackm.tag(), () -> new BlockEntityType<>(TileRackM::new, Sets.newHashSet(CSBlocks.RACK_MANGANESE.get()), null));
    public static final RegistryObject<BlockEntityType<TileRackS>> TILE_RACK_S = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.racks.tag(), () -> new BlockEntityType<>(TileRackS::new, Sets.newHashSet(CSBlocks.RACK_STEEL.get()), null));
    public static final RegistryObject<BlockEntityType<TileLabBench>> TILE_LAB_BENCH = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.labbench.tag(), () -> new BlockEntityType<>(TileLabBench::new, Sets.newHashSet(CSBlocks.LABORATORY_BENCH.get()), null));
    public static final RegistryObject<BlockEntityType<TileLabStorage>> TILE_LAB_STORAGE = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.labstorage.tag(), () -> new BlockEntityType<>(TileLabStorage::new, Sets.newHashSet(CSBlocks.LABORATORY_STORAGE.get()), null));
    public static final RegistryObject<BlockEntityType<TileCircuitMaker>> TILE_CIRCUIT_MAKER = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.circuitmaker.tag(), () -> new BlockEntityType<>(TileCircuitMaker::new, Sets.newHashSet(CSBlocks.CIRCUIT_MAKER.get()), null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}