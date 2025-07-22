package net.pastek.chemicalscience.client;

import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSPotions;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class CSClientEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, CSItems.CRYSTAL_POTASSIUMBROMIDE.get(), CSPotions.SEDATIVE);
    }
}