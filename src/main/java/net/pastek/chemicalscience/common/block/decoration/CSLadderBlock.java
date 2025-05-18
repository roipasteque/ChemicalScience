package net.pastek.chemicalscience.common.block.decoration;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.ItemAbility;
import net.pastek.chemicalscience.registers.CSBlocks;

import javax.annotation.Nullable;


public class CSLadderBlock extends LadderBlock {
    public CSLadderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(CSBlocks.MANGANESE_LADDER)) {
                return CSBlocks.MANGANESE_SCAFFOLDING.get().defaultBlockState();
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }



}