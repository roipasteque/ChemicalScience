package net.pastek.chemicalscience.common.block.voxelshapes;

import java.util.stream.Stream;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import voltaic.common.block.voxelshapes.VoxelShapeProvider;

public class CSVoxelShapes {

    public static void init() {

    }

    public static final VoxelShapeProvider ORGANIC_SOLAR_PANEL = VoxelShapeProvider.createOmni(
            Stream.of(
                    Shapes.box(0, 0, 0, 1, 0.2, 1)
            ).reduce(Shapes::or).get()
    );

    public static final VoxelShapeProvider CUBE = VoxelShapeProvider.createOmni(
            Stream.of(
                    Shapes.box(0, 0, 0, 1, 1, 1)
            ).reduce(Shapes::or).get()
    );

    public static final VoxelShape SCAFFOLDING_HOLLOW =
            Stream.of(
                    Block.box(1, 0, 0, 15, 16, 1),
                    Block.box(0, 0, 0, 1, 16, 16),
                    Block.box(15, 0, 0, 16, 16, 16),
                    Block.box(1, 0, 15, 15, 16, 16)
            ).reduce(Shapes::or).get();


    // Wohin gehst du, wohin?
    public static final VoxelShape SCAFFOLDING_OPEN_EAST =
            Stream.of(
                    Block.box(1, 0, 15, 5, 16, 16),
                    Block.box(1, 0, 0, 5, 16, 1),
                    Block.box(0, 0, 0, 1, 16, 16)
            ).reduce(Shapes::or).get();

    // Ich geh mit mir von Ost nach Süd

    public static final VoxelShape SCAFFOLDING_OPEN_SOUTH =
            Stream.of(
                    Block.box(0, 0, 1, 1, 16, 5),
                    Block.box(15, 0, 1, 16, 16, 5),
                    Block.box(0, 0, 0, 16, 16, 1)
            ).reduce(Shapes::or).get();

    // Ich geh mit mir von Süd nach West

    public static final VoxelShape SCAFFOLDING_OPEN_WEST =
            Stream.of(
                    Block.box(11, 0, 0, 15, 16, 1),
                    Block.box(11, 0, 15, 15, 16, 16),
                    Block.box(15, 0, 0, 16, 16, 16)
            ).reduce(Shapes::or).get();

    // Ich geh mit mir von West nach Nord

    public static final VoxelShape SCAFFOLDING_OPEN_NORTH =
            Stream.of(
                    Block.box(15, 0, 11, 16, 16, 15),
                    Block.box(0, 0, 11, 1, 16, 15),
                    Block.box(0, 0, 15, 16, 16, 16)
            ).reduce(Shapes::or).get();
}
