package net.pastek.chemicalscience.common.block.decoration;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.pastek.chemicalscience.registers.CSBlocks;

import javax.annotation.Nullable;


public class CSLadderBlock extends LadderBlock {
    public CSLadderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(CSBlocks.MANGANESE_LADDER.get())) {
                return CSBlocks.MANGANESE_SCAFFOLDING.get().defaultBlockState();
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }





}