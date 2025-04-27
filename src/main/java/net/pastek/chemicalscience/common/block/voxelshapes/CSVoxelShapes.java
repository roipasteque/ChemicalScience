package net.pastek.chemicalscience.common.block.voxelshapes;

import java.util.stream.Stream;

import net.minecraft.world.phys.shapes.Shapes;
import voltaic.common.block.voxelshapes.VoxelShapeProvider;

public class CSVoxelShapes {

    public static void init() {

    }

    public static final VoxelShapeProvider ORGANIC_SOLAR_PANEL = VoxelShapeProvider.createOmni(
            Stream.of(
                    Shapes.box(0, 0, 0, 1, 0.2, 1)
            ).reduce(Shapes::or).get()
    );
}