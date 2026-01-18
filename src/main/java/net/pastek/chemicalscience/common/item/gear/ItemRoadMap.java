package net.pastek.chemicalscience.common.item.gear;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.pastek.chemicalscience.common.inventory.container.ContainerRoadMap;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import voltaic.common.item.ItemVoltaic;
import voltaic.prefab.utilities.VoltaicTextUtils;

public class ItemRoadMap extends ItemVoltaic {

    private static final String LINK = "https://wiki.aurilis.dev";
    private static final Component CONTAINER_TITLE = Component.translatable("container.roadmap");

    public ItemRoadMap(Properties properties, Holder<CreativeModeTab> creativeTab) {
        super(properties, creativeTab);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flag) {
        tooltips.add(CSTextUtils.tooltip("roadmapname").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add(CSTextUtils.tooltip("info.roadmapuse").withStyle(ChatFormatting.GREEN));
        super.appendHoverText(stack, context, tooltips, flag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand handIn) {
        if (world.isClientSide) {
            if (player.isShiftKeyDown()) {
                player.sendSystemMessage(VoltaicTextUtils.chatMessage("guidebookclick").withStyle(ChatFormatting.BOLD, ChatFormatting.RED).withStyle(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, LINK))));
                return InteractionResultHolder.pass(player.getItemInHand(handIn));
            }
        } else if(!player.isShiftKeyDown()) {
            player.openMenu(getMenuProvider(world, player));
        }
        return super.use(world, player, handIn);
    }

    public MenuProvider getMenuProvider(Level world, Player player) {
        return new SimpleMenuProvider((id, inv, play) -> new ContainerRoadMap(id, player.getInventory()), CONTAINER_TITLE);
    }

}