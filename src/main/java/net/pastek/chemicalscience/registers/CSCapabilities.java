package net.pastek.chemicalscience.registers;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.ItemFlamethrower;
import voltaic.api.fluid.RestrictedFluidHandlerItemStack;
import voltaic.prefab.tile.GenericTile;
import voltaic.registers.VoltaicCapabilities;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID)
public class CSCapabilities {

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {

        event.registerItem(Capabilities.FluidHandler.ITEM, (itemStack, context) -> new RestrictedFluidHandlerItemStack(itemStack, ItemFlamethrower.MAX_CAPACITY).setValidator(ItemFlamethrower.getPredicate()), CSItems.FLAME_THROWER.get());


        CSTiles.BLOCK_ENTITY_TYPES.getEntries().forEach(entry -> {
            event.registerBlockEntity(VoltaicCapabilities.CAPABILITY_ELECTRODYNAMIC_BLOCK, (BlockEntityType<? extends GenericTile>) entry.get(), (tile, context) -> tile.getElectrodynamicCapability(context));
            event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, (BlockEntityType<? extends GenericTile>) entry.get(), (tile, context) -> tile.getFluidHandlerCapability(context));
            event.registerBlockEntity(VoltaicCapabilities.CAPABILITY_GASHANDLER_BLOCK, (BlockEntityType<? extends GenericTile>) entry.get(), (tile, context) -> tile.getGasHandlerCapability(context));
            event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType<? extends GenericTile>) entry.get(), (tile, context) -> tile.getItemHandlerCapability(context));
        });
    }
}