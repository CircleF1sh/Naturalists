package mod.naturalist.client.renderer;

import mod.naturalist.Naturalist;
import mod.naturalist.client.model.AlligatorModel;
import mod.naturalist.entities.AlligatorEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AlligatorRenderer extends MobRenderer<AlligatorEntity, AlligatorModel> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Naturalist.MOD_ID, "textures/entity/alligator.png");

    public AlligatorRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new AlligatorModel(), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(AlligatorEntity entity) {
        return TEXTURE;
    }
}
