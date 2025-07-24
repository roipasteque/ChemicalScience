package net.pastek.chemicalscience.common.item.gear;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSTags;

import java.util.List;


public class CSToolTiers {
    public static final Tier TUNGSTENCARBIDE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2130, 10.0f, 2.0f, 5, CSTags.Blocks.NEEDS_TUNGSTEN_TOOL, () -> Ingredient.of(CSItems.INGOT_TUNGSTEN_CARBIDE.get())),
            new ResourceLocation(ChemicalScience.MOD_ID, "tungsten"), List.of(Tiers.DIAMOND), List.of());

}
