package net.pastek.chemicalscience.registers;

import com.google.common.collect.Sets;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.tile.TileOrganicSolarPanel;
import net.pastek.chemicalscience.common.tile.TileFuelCell;
import net.pastek.chemicalscience.common.tile.TileRackM;
import net.pastek.chemicalscience.common.tile.TileRackS;

public class CSTiles {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ChemicalScience.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<TileOrganicSolarPanel>> TILE_ORGANICSOLARPANEL = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.organicsolarpanel.tag(), () -> new BlockEntityType<>(TileOrganicSolarPanel::new, Sets.newHashSet(CSBlocks.ORGANIC_SOLAR_PANEL.get()), null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<TileFuelCell>> TILE_FUELCELL = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.fuelcell.tag(), () -> new BlockEntityType<>(TileFuelCell::new, Sets.newHashSet(CSBlocks.FUEL_CELL.get()), null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<TileRackM>> TILE_RACK_M = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.rackm.tag(), () -> new BlockEntityType<>(TileRackM::new, Sets.newHashSet(CSBlocks.RACK_MANGANESE.get()), null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<TileRackS>> TILE_RACK_S = BLOCK_ENTITY_TYPES.register(SubtypeChemicalMachine.racks.tag(), () -> new BlockEntityType<>(TileRackS::new, Sets.newHashSet(CSBlocks.RACK_STEEL.get()), null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}