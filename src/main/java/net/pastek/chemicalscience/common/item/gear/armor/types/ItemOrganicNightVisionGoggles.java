package net.pastek.chemicalscience.common.item.gear.armor.types;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Consumer;

import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSArmor;
import net.pastek.chemicalscience.registers.CSDataComponentTypes;
import org.jetbrains.annotations.Nullable;

import electrodynamics.prefab.utilities.ElectroTextUtils;
import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import voltaic.api.item.IItemElectric;
import voltaic.common.item.gear.ItemVoltaicArmor;
import voltaic.prefab.item.ElectricItemProperties;

public class ItemOrganicNightVisionGoggles extends ItemVoltaicArmor implements IItemElectric {

    public static final EnumMap<Type, Integer> DEFENSE_MAP = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(Type.HELMET, 4);
        map.put(Type.CHESTPLATE, 0);
        map.put(Type.LEGGINGS, 0);
        map.put(Type.BOOTS, 0);
    });

    private final ElectricItemProperties properties;
    public static final int DURATION_SECONDS = 15;

    private static final ResourceLocation ARMOR_TEXTURE = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/organicnightvisiongoggles.png");

    public ItemOrganicNightVisionGoggles(ElectricItemProperties properties, Holder<CreativeModeTab> creativeTab) {
        super(CSArmor.ONVGS, Type.HELMET, properties, creativeTab);
        this.properties = properties;
    }

    @Override
    public void onWearingTick(ItemStack stack, Level level, Player player, int slotId, boolean isSelected) {
        super.onWearingTick(stack, level, player, slotId, isSelected);
        wearingTick(stack, level, player);
    }

    protected static void wearingTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, DURATION_SECONDS * 20, 0, false, false, false));
            /*
            if (ModList.get().isLoaded("alexmobs")) {
                player.addEffect(new MobEffectInstance(MobEffects.LAVA_VISION, DURATION_SECONDS * 20, 0, false, false, false));
            }
            */
        }
    }

    @Override
    public ElectricItemProperties getElectricProperties() {
        return properties;
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
        return 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return (int) 13.0;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return getJoulesStored(stack) < getMaximumCapacity(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        if (stack.getOrDefault(CSDataComponentTypes.ON, true)) {
            tooltip.add(ElectroTextUtils.tooltip("nightvisiongoggles.status").withStyle(ChatFormatting.GRAY).append(ElectroTextUtils.tooltip("nightvisiongoggles.on").withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    @Override
    public void addCreativeModeItems(CreativeModeTab group, List<ItemStack> items) {

        ItemStack empty = new ItemStack(this);
        IItemElectric.setEnergyStored(empty, 0);
        items.add(empty);

        ItemStack charged = new ItemStack(this);
        IItemElectric.setEnergyStored(charged, getMaximumCapacity(charged));
        items.add(charged);

    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ARMOR_TEXTURE;
    }

    @Override
    public Item getDefaultStorageBattery() {
        return ElectrodynamicsItems.ITEM_BATTERY.get();
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot, ClickAction action, Player player, SlotAccess access) {

        if (!IItemElectric.overrideOtherStackedOnMe(stack, other, slot, action, player, access)) {
            return super.overrideOtherStackedOnMe(stack, other, slot, action, player, access);
        }

        return true;

    }

}