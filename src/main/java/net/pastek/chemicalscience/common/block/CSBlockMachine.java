package net.pastek.chemicalscience.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import voltaic.api.tile.IMachine;
import voltaic.common.block.BlockMachine;
import voltaic.common.block.states.VoltaicBlockStates;

import java.util.List;

public class CSBlockMachine extends BlockMachine {
    protected final IMachine machine;
    private final int voltage;
    private final Component description;

    public CSBlockMachine(IMachine machine, int voltage, Component description) {
        super(machine);
        this.machine = machine;
        this.voltage = voltage;
        this.description = description;
        if (machine.usesLit()) {
            this.registerDefaultState(this.stateDefinition.any().setValue(VoltaicBlockStates.LIT, false));
        }

    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

        if (voltage > 0) {
            tooltipComponents.add(Component.translatable("tooltip.chemicalscience.machine.voltage")
                    .withStyle(ChatFormatting.DARK_GRAY)
                    .append(Component.literal(voltage + "V")
                            .withStyle(ChatFormatting.GRAY)));
        }

        if (description != null) {
            if (description.getString().equalsIgnoreCase("multiblock")) {
                tooltipComponents.add(Component.translatable("tooltip.chemicalscience.machine.multiblock.info").withStyle(ChatFormatting.GREEN));
                tooltipComponents.add(Component.translatable("tooltip.chemicalscience.machine.multiblock.help").withStyle(ChatFormatting.GRAY));
            } else {
                tooltipComponents.add(description.copy().withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
