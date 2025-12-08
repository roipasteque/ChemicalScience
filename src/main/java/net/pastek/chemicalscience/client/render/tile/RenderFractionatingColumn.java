package net.pastek.chemicalscience.client.render.tile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.render.multiblock.BakedObjModel;
import net.pastek.chemicalscience.client.render.multiblock.ObjModelManager;
import net.pastek.chemicalscience.client.render.multiblock.ObjModelRenderer;
import net.pastek.chemicalscience.common.tile.TileFractionatingColumn;

@OnlyIn(Dist.CLIENT)
public class RenderFractionatingColumn implements BlockEntityRenderer<TileFractionatingColumn> {

    public RenderFractionatingColumn(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(TileFractionatingColumn tile, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if(tile.isFormed.getValue() == true) {

            BakedObjModel model = ObjModelManager.INSTANCE.get(
                    ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "models/multiblock/mixer.obj")
            );

            if (model == null) return;

            poseStack.pushPose();

            poseStack.translate(0.5 + tile.getFacing().getStepX() / 2.0, 0.5 + tile.getFacing().getStepY() / 2.0, 0.5 + tile.getFacing().getStepZ() / 2.0);
            poseStack.scale(1f, 1f, 1f);
            poseStack.mulPose(Axis.YP.rotationDegrees(tile.getFacing().toYRot()));

            ObjModelRenderer.render(model, poseStack, buffer, packedLight, packedOverlay);

            poseStack.popPose();
        }
    }
}

