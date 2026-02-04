package net.pastek.chemicalscience.registers;

import net.neoforged.bus.api.IEventBus;
import net.pastek.chemicalscience.registers.fluids.CSFluidTypes;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import net.pastek.chemicalscience.registers.gases.CSGases;
import voltaic.common.blockitem.BlockItemDescriptable;
import voltaic.prefab.utilities.VoltaicTextUtils;

public class UnifiedCSRegister {

    public static void register(IEventBus eventBus) {
        CSBlocks.BLOCKS.register(eventBus);
        CSTiles.BLOCK_ENTITY_TYPES.register(eventBus);
        CSItems.ITEMS.register(eventBus);
        CSFluids.FLUIDS.register(eventBus);
        CSFluidTypes.FLUID_TYPES.register(eventBus);
        CSEntities.ENTITIES.register(eventBus);
        CSGases.GASES.register(eventBus);
        CSPotions.POTIONS.register(eventBus);
        CSMenuTypes.MENU_TYPES.register(eventBus);
        CSSounds.SOUNDS.register(eventBus);
        CSCreativeTabs.CREATIVE_MODE_TAB.register(eventBus);
        CSRecipies.RECIPE_TYPES.register(eventBus);
        CSRecipies.RECIPE_SERIALIZER.register(eventBus);
        CSDataComponentTypes.DATA_COMPONENT_TYPES.register(eventBus);
        CSArmor.ARMOR_MATERIALS.register(eventBus);
        CSParticles.PARTICLES.register(eventBus);
    }

    static {
        BlockItemDescriptable.addDescription(CSBlocks.ORGANIC_SOLAR_PANEL, VoltaicTextUtils.voltageTooltip(240));
        BlockItemDescriptable.addDescription(CSBlocks.FUEL_CELL, VoltaicTextUtils.voltageTooltip(240));
        BlockItemDescriptable.addDescription(CSBlocks.CIRCUIT_MAKER, VoltaicTextUtils.voltageTooltip(480));
    }

}
