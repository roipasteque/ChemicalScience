package net.pastek.chemicalscience.common.block.subtype;

import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.pastek.chemicalscience.common.block.voxelshapes.CSVoxelShapes;
import net.pastek.chemicalscience.common.tile.TileFuelCell;
import net.pastek.chemicalscience.common.tile.TileRackM;
import net.pastek.chemicalscience.common.tile.TileRackS;
import net.pastek.chemicalscience.common.tile.TileLabBench;
import net.pastek.chemicalscience.common.tile.TileLabStorage;
import voltaic.api.ISubtype;
import voltaic.api.multiblock.subnodebased.parent.IMultiblockParentBlock;
import voltaic.api.tile.IMachine;
import voltaic.api.tile.MachineProperties;
import voltaic.common.block.voxelshapes.VoxelShapeProvider;
import net.pastek.chemicalscience.common.tile.TileOrganicSolarPanel;

public enum SubtypeChemicalMachine implements ISubtype, IMachine {


    organicsolarpanel(true, TileOrganicSolarPanel::new, MachineProperties.builder().setShapeProvider(CSVoxelShapes.ORGANIC_SOLAR_PANEL)),
    fuelcell(true, TileFuelCell::new, MachineProperties.builder().setShapeProvider(CSVoxelShapes.CUBE)),
    rackm(true, TileRackM::new, MachineProperties.builder().setShapeProvider(CSVoxelShapes.CUBE)),
    racks(true, TileRackS::new, MachineProperties.builder().setShapeProvider(CSVoxelShapes.CUBE)),
    labbench(true, TileLabBench::new, MachineProperties.builder().setShapeProvider(CSVoxelShapes.CUBE)),
    labstorage(true, TileLabStorage::new, MachineProperties.builder().setShapeProvider(CSVoxelShapes.CUBE));


    private final BlockEntityType.BlockEntitySupplier<BlockEntity> blockEntitySupplier;
    private final boolean showInItemGroup;
    private final MachineProperties properties;

    private SubtypeChemicalMachine(boolean showInItemGroup, BlockEntityType.BlockEntitySupplier<BlockEntity> blockEntitySupplier) {
        this(showInItemGroup, blockEntitySupplier, MachineProperties.DEFAULT);
    }

    private SubtypeChemicalMachine(boolean showInItemGroup, BlockEntityType.BlockEntitySupplier<BlockEntity> blockEntitySupplier, MachineProperties properties) {
        this.showInItemGroup = showInItemGroup;
        this.blockEntitySupplier = blockEntitySupplier;
        this.properties = properties;
    }

    @Override
    public BlockEntityType.BlockEntitySupplier<BlockEntity> getBlockEntitySupplier() {
        return blockEntitySupplier;
    }

    @Override
    public int getLitBrightness() {
        return properties.litBrightness;
    }

    @Override
    public RenderShape getRenderShape() {
        return properties.renderShape;
    }

    @Override
    public boolean isMultiblock() {
        return properties.isMultiblock;
    }

    @Override
    public boolean propegatesLightDown() {
        return properties.propegatesLightDown;
    }

    @Override
    public String tag() {
        return name();
    }

    @Override
    public String forgeTag() {
        return tag();
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public boolean isPlayerStorable() {
        return false;
    }

    @Override
    public IMultiblockParentBlock.SubnodeWrapper getSubnodes() {
        return properties.wrapper;
    }

    @Override
    public VoxelShapeProvider getVoxelShapeProvider() {
        return properties.provider;
    }

    @Override
    public boolean usesLit() {
        return properties.usesLit;
    }

    public boolean showInItemGroup() {
        return showInItemGroup;
    }
}