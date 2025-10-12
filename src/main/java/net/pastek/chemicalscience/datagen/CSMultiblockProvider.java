package net.pastek.chemicalscience.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.registers.ElectrodynamicsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.tile.TileFractionatingColumn;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.datagen.utils.server.multiblock.BaseMultiblockProvider;
import voltaic.registers.VoltaicBlocks;

public class CSMultiblockProvider extends BaseMultiblockProvider {

    public CSMultiblockProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, ChemicalScience.MOD_ID);
    }

    @Override
    protected void gather() {

        BlockState slave = VoltaicBlocks.BLOCK_MULTIBLOCK_SLAVE.get().defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false);
        BlockState scaffold = ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState();

        ResourceLocation fcBottomcenter = ChemicalScience.rl("multiblock/fc_bottomcenter");
        ResourceLocation fcBottomcorner = ChemicalScience.rl("multiblock/fc_bottomcorner");
        ResourceLocation fcBottomseparator = ChemicalScience.rl("multiblock/fc_bottomcenter");
        ResourceLocation fcBottomside = ChemicalScience.rl("multiblock/fc_bottomside");
        ResourceLocation fcFluidin = ChemicalScience.rl("multiblock/fc_fluidin");
        ResourceLocation fcFluidout = ChemicalScience.rl("multiblock/fc_fluidout");
        ResourceLocation fcGasout = ChemicalScience.rl("multiblock/fc_gasout");
        ResourceLocation fcGauge = ChemicalScience.rl("multiblock/fc_gauge");
        ResourceLocation fcMetal = ChemicalScience.rl("multiblock/fc_metal");
        ResourceLocation fcPowerin = ChemicalScience.rl("multiblock/fc_powerin");
        ResourceLocation fcScaffold = ChemicalScience.rl("multiblock/fc_scaffold");
        ResourceLocation fcSeparator = ChemicalScience.rl("multiblock/fc_separator");
        ResourceLocation fcVent = ChemicalScience.rl("multiblock/fc_vent");


        /** Fractionating Column */
        addMultiblock(TileFractionatingColumn.ID, List.of(

                //Bottom - Power input
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(0, -1, 0), Shapes.block(), fcBottomside),
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(1, -1, 0), Shapes.block(), fcBottomcorner),
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(-1, -1, 0), Shapes.block(), fcBottomcorner),
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(1, -1, -1), Shapes.block(), fcBottomside),
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(-1, -1, -1), Shapes.block(), fcBottomside),
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(1, -1, -2), Shapes.block(), fcBottomcorner),
                new MultiblockSlaveNode(slave, scaffold, MultiblockSlaveNode.NOTAG, new Vec3i(-1, -1, -2), Shapes.block(), fcBottomcorner),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.electricarcfurnace).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, -1, -1), Shapes.block(), fcBottomcenter),
                new MultiblockSlaveNode(slave, Blocks.GOLD_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, -1, -2), Shapes.block(), fcPowerin)


        ));


    }

}