package net.pastek.chemicalscience.client.render.multiblock;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class ObjModelRenderer {

    public static void render(BakedObjModel model, PoseStack stack,
                              MultiBufferSource buffer, int light, int overlay) {

        if (model == null) return;

        PoseStack.Pose pose = stack.last();
        Matrix4f mat = pose.pose();
        Matrix3f normMat = pose.normal();

        for (BakedObjModel.Mesh mesh : model.meshes()) {

            ResourceLocation tex = mesh.texture;
            if (tex == null)
                tex = ResourceLocation.fromNamespaceAndPath("chemicalscience",
                        "textures/multiblock/mixer.png");

            VertexConsumer vc = buffer.getBuffer(RenderType.entityCutout(tex));

            for (BakedObjModel.Face face : mesh.faces) {

                for (int i = 0; i < 3; i++) {
                    BakedObjModel.Vertex v = face.vertices[i];

                    Vector3f pos = new Vector3f(v.pos);
                    mat.transformPosition(pos);

                    Vector3f n = new Vector3f(v.normal);
                    normMat.transform(n);

                    vc.addVertex(pos.x, pos.y, pos.z)
                            .setColor(255, 255, 255, 255)
                            .setUv(v.uv.x, v.uv.y)
                            .setOverlay(overlay)
                            .setLight(light)
                            .setNormal(n.x, n.y, n.z);
                }
            }
        }
    }
}
