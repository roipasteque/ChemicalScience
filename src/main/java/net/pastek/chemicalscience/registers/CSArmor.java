package net.pastek.chemicalscience.registers;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemBulletProofVest;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;

public class CSArmor {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries, ChemicalScience.MOD_ID);

    public static final RegistryObject<ArmorMaterial> ONVGS = register("organic_nightvisiongoggles", ItemOrganicNightVisionGoggles.DEFENSE_MAP, 0, 0, 0, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.EMPTY, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/nightvisiongogglesoff.png"));
    public static final RegistryObject<ArmorMaterial> BULLETPROOFVEST = register("bulletproofvest", ItemBulletProofVest.DEFENSE_MAP, 5, 4, 0F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER::get), ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/bulletproofvest.png"));


    private static RegistryObject<ArmorMaterial> register(String name, Map<ArmorItem.Type, Integer> slotMap, int enchantValue, float toughness, float knockbackResistance, Holder<SoundEvent> sound, Supplier<Ingredient> repairIngredient, ResourceLocation texture) {
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(slotMap, enchantValue, sound, repairIngredient, List.of(new ArmorMaterial.Layer(texture)), toughness, knockbackResistance));
    }

    public static void register(IEventBus bus) {
        ARMOR_MATERIALS.register(bus);
    }
}