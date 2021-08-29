package com.circle.naturalists.client;

import com.circle.naturalists.Naturalists;
import com.circle.naturalists.client.renderer.CrocodileRenderer;
import com.circle.naturalists.init.NaturalistsEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Naturalists.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(NaturalistsEntities.CROCODILE.get(), CrocodileRenderer::new);
    }
}
