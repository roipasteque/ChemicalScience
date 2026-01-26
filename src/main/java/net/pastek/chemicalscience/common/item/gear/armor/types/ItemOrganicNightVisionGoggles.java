package net.pastek.chemicalscience.common.item.gear.armor.types;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSArmor;
import net.pastek.chemicalscience.registers.CSDataComponentTypes;
import electrodynamics.prefab.utilities.ElectroTextUtils;
import electrodynamics.registers.ElectrodynamicsItems;
import voltaic.api.item.IItemElectric;
import voltaic.common.item.gear.ItemVoltaicArmor;
import voltaic.prefab.item.ElectricItemProperties;

import java.util.EnumMap;
import java.util.List;

public class ItemOrganicNightVisionGoggles extends ItemVoltaicArmor implements IItemElectric {

    public static final ResourceLocation ARMOR_TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/organicnightvisiongoggles.png");
    private final ElectricItemProperties properties;
    public static final EnumMap<Type, Integer> DEFENSE_MAP = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(Type.HELMET, 4);
        map.put(Type.CHESTPLATE, 0);
        map.put(Type.LEGGINGS, 0);
        map.put(Type.BOOTS, 0);
    });

    public ItemOrganicNightVisionGoggles(ElectricItemProperties properties, net.minecraft.core.Holder<CreativeModeTab> creativeTab) {
        super(CSArmor.ONVGS, Type.HELMET, properties, creativeTab);
        this.properties = properties;
    }

    @Override
    public void onWearingTick(ItemStack stack, Level level, Player player, int slotId, boolean isSelected) {
        super.onWearingTick(stack, level, player, slotId, isSelected);
    }

    public static boolean canWork(ItemStack stack) {
        return stack.getItem() instanceof ItemOrganicNightVisionGoggles &&
                stack.getOrDefault(CSDataComponentTypes.ON, true);
    }

    @Override
    public ElectricItemProperties getElectricProperties() {
        return properties;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        if (stack.getOrDefault(CSDataComponentTypes.ON, true)) {
            tooltip.add(ElectroTextUtils.tooltip("nightvisiongoggles.status")
                    .withStyle(ChatFormatting.GRAY)
                    .append(ElectroTextUtils.tooltip("nightvisiongoggles.on").withStyle(ChatFormatting.GREEN)));
        } else {
            tooltip.add(ElectroTextUtils.tooltip("nightvisiongoggles.status")
                    .withStyle(ChatFormatting.GRAY)
                    .append(ElectroTextUtils.tooltip("nightvisiongoggles.off").withStyle(ChatFormatting.RED)));
        }
    }

    @Override
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return ARMOR_TEXTURE_LOCATION;
    }

    @Override
    public Item getDefaultStorageBattery() {
        return ElectrodynamicsItems.ITEM_BATTERY.get();
    }
}