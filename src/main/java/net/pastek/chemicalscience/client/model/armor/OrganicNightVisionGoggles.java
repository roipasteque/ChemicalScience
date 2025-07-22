package net.pastek.chemicalscience.client.model.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;
import org.jetbrains.annotations.NotNull;
import voltaic.client.model.armor.GenericArmorModel;

public class OrganicNightVisionGoggles<T extends LivingEntity> extends GenericArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"bulletproofvest"), "main");

    public OrganicNightVisionGoggles(ModelPart root) {
        super(root);
        this.parentHead.visible = true;
        this.parentChest.visible = false;
        this.parentRightArm.visible = false;
        this.parentLeftArm.visible = false;
        this.parentRightLeg.visible = false;
        this.parentLeftLeg.visible = false;

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition part = meshdefinition.getRoot();

        part.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        part.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 2).addBox(-3.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 8).addBox(-1.0F, -5.0F, -4.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 16).addBox(-4.25F, -5.0F, -4.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.5F, -5.0F, -3.25F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(3.5F, -5.0F, -3.25F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(16, 11).addBox(2.25F, -5.0F, -4.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(0.25F, -5.0F, 3.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 0).addBox(-4.25F, -5.0F, 3.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 14).addBox(-1.25F, -5.0F, 3.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(1.0F, -5.0F, -7.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        part.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int light) {
        if (this.parentHead.visible) {
            this.parentHead.render(poseStack, this.getCustomConsumer(RenderType.entityTranslucent(ItemOrganicNightVisionGoggles.ARMOR_TEXTURE_LOCATION)), packedLight, packedOverlay);
        }
        if (this.parentChest.visible) {
            this.parentChest.render(poseStack, buffer, packedLight, packedOverlay);
            this.parentRightArm.render(poseStack, buffer, packedLight, packedOverlay);
            this.parentLeftArm.render(poseStack, buffer, packedLight, packedOverlay);
        }
        if (this.parentRightLeg.visible) {
            this.parentRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
            this.parentLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
        }
    }
}