package mod.naturalist.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BassModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer Body;
    public ModelRenderer Mouth;
    public ModelRenderer Tail;
    public ModelRenderer DorsalFin;
    public ModelRenderer AnalFin;
    public ModelRenderer LeftVentralFin;
    public ModelRenderer RightVentralFin;
    public ModelRenderer LeftPectoralFin;
    public ModelRenderer RightPectoralFin;
    public ModelRenderer TailFin;

    public BassModel() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.AnalFin = new ModelRenderer(this, 4, 24);
        this.AnalFin.setPos(0.0F, 2.5F, 6.0F);
        this.AnalFin.addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.DorsalFin = new ModelRenderer(this, 38, 0);
        this.DorsalFin.setPos(0.0F, -3.0F, 1.5F);
        this.DorsalFin.addBox(0.0F, -2.0F, -4.5F, 0.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.TailFin = new ModelRenderer(this, 15, 17);
        this.TailFin.setPos(0.0F, -0.5F, 3.5F);
        this.TailFin.addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 25, 0);
        this.Tail.setPos(0.0F, -1.5F, 6.5F);
        this.Tail.addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 0, 0);
        this.Mouth.setPos(0.0F, 2.0F, -6.5F);
        this.Mouth.addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.RightVentralFin = new ModelRenderer(this, 44, 0);
        this.RightVentralFin.setPos(-2.0F, 2.9F, -2.0F);
        this.RightVentralFin.addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightVentralFin, 0.27366763203903305F, 0.0F, 0.0F);
        this.RightPectoralFin = new ModelRenderer(this, 32, 20);
        this.RightPectoralFin.mirror = true;
        this.RightPectoralFin.setPos(-2.5F, 0.0F, -3.5F);
        this.RightPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightPectoralFin, 0.0F, -0.23457224414434488F, 0.0F);
        this.LeftVentralFin = new ModelRenderer(this, 44, 0);
        this.LeftVentralFin.setPos(2.0F, 2.9F, -2.0F);
        this.LeftVentralFin.addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftVentralFin, 0.27366763203903305F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setPos(0.0F, 21.0F, 0.0F);
        this.Body.addBox(-2.5F, -3.0F, -6.5F, 5.0F, 6.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.LeftPectoralFin = new ModelRenderer(this, 32, 20);
        this.LeftPectoralFin.setPos(2.5F, 0.0F, -3.5F);
        this.LeftPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftPectoralFin, 0.0F, 0.23457224414434488F, 0.0F);
        this.Body.addChild(this.AnalFin);
        this.Body.addChild(this.DorsalFin);
        this.Tail.addChild(this.TailFin);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Mouth);
        this.Body.addChild(this.RightVentralFin);
        this.Body.addChild(this.RightPectoralFin);
        this.Body.addChild(this.LeftVentralFin);
        this.Body.addChild(this.LeftPectoralFin);
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
