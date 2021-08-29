package com.circle.naturalists.client.renderer;

import com.circle.naturalists.Naturalists;
import com.circle.naturalists.client.model.CrocodileModel;
import com.circle.naturalists.entities.CrocodileEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class CrocodileRenderer extends MobRenderer<CrocodileEntity, CrocodileModel<CrocodileEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Naturalists.MOD_ID, "textures/entity/crocodile.png");

    public CrocodileRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new CrocodileModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrocodileEntity p_110775_1_) {
        return TEXTURE;
    }
}
