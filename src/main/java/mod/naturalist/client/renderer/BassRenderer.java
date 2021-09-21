package mod.naturalist.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.naturalist.Naturalist;
import mod.naturalist.client.model.BassModel;
import mod.naturalist.entities.BassEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class BassRenderer extends MobRenderer<BassEntity, BassModel<BassEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Naturalist.MOD_ID, "textures/entity/bass.png");

    public BassRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new BassModel<>(), 0.15F);
    }

    public ResourceLocation getTextureLocation(BassEntity entity) {
        return TEXTURE;
    }

    protected void setupRotations(BassEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f));
        if (!entityLiving.isInWater()) {
            matrixStackIn.translate((double)0.1F, (double)0.1F, (double)-0.1F);
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }
}