package com.circle.naturalists.client.model;

import com.circle.naturalists.entities.CrocodileEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CrocodileModel<T extends CrocodileEntity> extends EntityModel<T> {
    public ModelRenderer Body;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer BackRightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer Tail;
    public ModelRenderer Head;
    public ModelRenderer FarLeftSpine;
    public ModelRenderer FarRightSpine;
    public ModelRenderer LeftSpine;
    public ModelRenderer RightSpine;
    public ModelRenderer RightFoot;
    public ModelRenderer LeftFoot;
    public ModelRenderer BackRightFoot;
    public ModelRenderer BackLeftFoot;
    public ModelRenderer RightTailSpine;
    public ModelRenderer LeftTailSpine;
    public ModelRenderer TopJaw;
    public ModelRenderer BottomJaw;
    public ModelRenderer Teeth;

    public CrocodileModel() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.LeftArm = new ModelRenderer(this, 96, 47);
        this.LeftArm.setPos(6.0F, 2.0F, -5.0F);
        this.LeftArm.texOffs(3, 0).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.BackRightFoot = new ModelRenderer(this, 22, 0);
        this.BackRightFoot.setPos(0.0F, 7.0F, 0.0F);
        this.BackRightFoot.addBox(-2.5F, 0.0F, -5.5F, 5.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.TopJaw = new ModelRenderer(this, 44, 40);
        this.TopJaw.setPos(0.0F, 1.0F, -7.5F);
        this.TopJaw.addBox(-4.0F, -2.0F, -4.5F, 8.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 95, 62);
        this.LeftFoot.setPos(0.0F, 7.0F, 0.0F);
        this.LeftFoot.addBox(-2.5F, 0.0F, -5.5F, 5.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftTailSpine = new ModelRenderer(this, 0, 0);
        this.LeftTailSpine.setPos(2.3F, -4.5F, 11.5F);
        this.LeftTailSpine.addBox(0.0F, -3.0F, -11.5F, 0.0F, 3.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 64, 88);
        this.LeftLeg.setPos(6.0F, 2.0F, 5.5F);
        this.LeftLeg.texOffs(43, 0).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RightSpine = new ModelRenderer(this, 0, 0);
        this.RightSpine.setPos(-2.0F, -5.0F, 0.0F);
        this.RightSpine.addBox(0.0F, -1.0F, -9.5F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.RightTailSpine = new ModelRenderer(this, 29, 8);
        this.RightTailSpine.setPos(-2.3F, -4.5F, 11.5F);
        this.RightTailSpine.addBox(0.0F, -3.0F, -11.5F, 0.0F, 3.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 5, 75);
        this.Body.setPos(0.0F, 14.0F, 0.0F);
        this.Body.addBox(-7.0F, -5.0F, -9.5F, 13.0F, 10.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.BottomJaw = new ModelRenderer(this, 0, 32);
        this.BottomJaw.setPos(0.0F, 3.0F, 3.0F);
        this.BottomJaw.texOffs(0, 10).addBox(-4.5F, 0.0F, -16.0F, 9.0F, 2.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 60, 3);
        this.Head.setPos(-0.5F, -2.0F, -12.5F);
        this.Head.texOffs(16, 0).addBox(-4.5F, -3.0F, -3.0F, 9.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.FarLeftSpine = new ModelRenderer(this, 0, -6);
        this.FarLeftSpine.setPos(5.1F, -5.0F, 0.0F);
        this.FarLeftSpine.addBox(0.0F, -1.0F, -9.5F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.FarRightSpine = new ModelRenderer(this, 0, -3);
        this.FarRightSpine.setPos(-6.1F, -5.0F, 0.0F);
        this.FarRightSpine.addBox(0.0F, -1.0F, -9.5F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Teeth = new ModelRenderer(this, 64, 24);
        this.Teeth.setPos(0.0F, -1.0F, -11.0F);
        this.Teeth.texOffs(16, 0).addBox(-4.5F, 0.0F, -5.0F, 9.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 53, 90);
        this.Tail.setPos(-0.5F, 3.0F, 9.5F);
        this.Tail.addBox(-3.5F, -4.5F, 0.0F, 7.0F, 9.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 23, 0);
        this.BackRightLeg.setPos(-7.0F, 2.0F, 5.5F);
        this.BackRightLeg.texOffs(23, 0).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 61, 62);
        this.RightArm.setPos(-7.0F, 2.0F, -5.0F);
        this.RightArm.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LeftSpine = new ModelRenderer(this, 0, -10);
        this.LeftSpine.setPos(2.0F, -5.0F, 0.0F);
        this.LeftSpine.addBox(0.0F, -1.0F, -9.5F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 75, 65);
        this.RightFoot.setPos(0.0F, 7.0F, 0.0F);
        this.RightFoot.addBox(-2.5F, 0.0F, -5.5F, 5.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.BackLeftFoot = new ModelRenderer(this, 86, 102);
        this.BackLeftFoot.setPos(0.0F, 7.0F, 0.0F);
        this.BackLeftFoot.addBox(-2.5F, 0.0F, -5.5F, 5.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.LeftArm);
        this.BackRightLeg.addChild(this.BackRightFoot);
        this.Head.addChild(this.TopJaw);
        this.LeftArm.addChild(this.LeftFoot);
        this.Tail.addChild(this.LeftTailSpine);
        this.Body.addChild(this.LeftLeg);
        this.Body.addChild(this.RightSpine);
        this.Tail.addChild(this.RightTailSpine);
        this.Head.addChild(this.BottomJaw);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.FarLeftSpine);
        this.Body.addChild(this.FarRightSpine);
        this.BottomJaw.addChild(this.Teeth);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.BackRightLeg);
        this.Body.addChild(this.RightArm);
        this.Body.addChild(this.LeftSpine);
        this.RightArm.addChild(this.RightFoot);
        this.LeftLeg.addChild(this.BackLeftFoot);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.Body).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}