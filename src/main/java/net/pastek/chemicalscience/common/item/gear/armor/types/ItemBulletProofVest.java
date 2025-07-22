package net.pastek.chemicalscience.common.item.gear.armor.types;

import java.util.EnumMap;
import java.util.function.Consumer;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSArmor;
import net.pastek.chemicalscience.registers.CSCreativeTabs;
import org.jetbrains.annotations.Nullable;
import voltaic.common.item.gear.ItemVoltaicArmor;

public class ItemBulletProofVest extends ItemVoltaicArmor {
    public static final EnumMap<ArmorItem.Type, Integer> DEFENSE_MAP = Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
        map.put(Type.HELMET, 0);
        map.put(Type.CHESTPLATE, 14);
        map.put(Type.LEGGINGS, 0);
        map.put(Type.BOOTS, 0);
    });

    public static final ResourceLocation ARMOR_TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/bulletproofvest.png");

    public ItemBulletProofVest(ArmorItem.Type slot) {
        super(CSArmor.BULLETPROOFVEST, Type.CHESTPLATE, (new Item.Properties()).stacksTo(1).durability(830), CSCreativeTabs.CHEMICAL_SCIENCE_TAB);
    }

    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
        return 0;
    }

    public boolean isEnchantable(ItemStack stack) {
        return true;
    }


    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return ARMOR_TEXTURE_LOCATION;
    }
}
