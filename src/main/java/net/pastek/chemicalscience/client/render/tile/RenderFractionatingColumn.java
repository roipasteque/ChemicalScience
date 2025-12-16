package net.pastek.chemicalscience.client.render.tile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.client.CSClientRegister;
import net.pastek.chemicalscience.common.tile.TileFractionatingColumn;

@OnlyIn(Dist.CLIENT)
public class RenderFractionatingColumn implements BlockEntityRenderer<TileFractionatingColumn> {

    public RenderFractionatingColumn(BlockEntityRendererProvider.Context context) {}

    private BakedModel cachedModel = null;
    private boolean modelLoadAttempted = false;

    @Override
    public void render(TileFractionatingColumn tile, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        if (tile.isFormed.getValue() == true) {

            if (!modelLoadAttempted) {
                cachedModel = Minecraft.getInstance().getModelManager().getModel(CSClientRegister.FRACTIONATINGCOLUMN_MODEL);
                modelLoadAttempted = true;

                if (cachedModel == Minecraft.getInstance().getModelManager().getMissingModel()) {
                    System.err.println("ERROR: Missing Multiblock Model at: " + CSClientRegister.FRACTIONATINGCOLUMN_MODEL);
                    cachedModel = null;
                    return;
                }
            }

            if (cachedModel == null) return;

            poseStack.pushPose();

            poseStack.mulPose(Axis.YP.rotationDegrees(tile.getFacing().toYRot()));
            poseStack.translate(0.5, -1, -0.5);

            BlockState state = tile.getBlockState();

            Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                    poseStack.last(),
                    buffer.getBuffer(RenderType.cutout()),
                    state,
                    cachedModel,
                    1.0f, 1.0f, 1.0f,
                    packedLight,
                    packedOverlay
            );

            poseStack.popPose();
        }
    }
}