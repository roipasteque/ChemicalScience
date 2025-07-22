package net.pastek.chemicalscience.common.item.gear;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.SimpleTier;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSTags;


public class CSToolTiers {
    public static final Tier TUNGSTENCARBIDE = new SimpleTier(CSTags.Blocks.NEEDS_TUNGSTEN_TOOL,
            2130, 10.0f, 2.0f, 5, () -> Ingredient.of(new ItemLike[]{CSItems.INGOT_TUNGSTEN_CARBIDE}));

}
