package mod.naturalist.client;

import mod.naturalist.Naturalist;
import mod.naturalist.client.renderer.AlligatorRenderer;
import mod.naturalist.init.NaturalistBlocks;
import mod.naturalist.init.NaturalistEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Naturalist.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    public static void init() {
        RenderTypeLookup.setRenderLayer(NaturalistBlocks.ELM_SAPLING.get(), RenderType.cutout());

        RenderingRegistry.registerEntityRenderingHandler(NaturalistEntities.ALLIGATOR.get(), AlligatorRenderer::new);
    }
}
