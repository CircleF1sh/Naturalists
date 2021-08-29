package com.circle.naturalists;

import com.circle.naturalists.client.ClientEvents;
import com.circle.naturalists.entities.CrocodileEntity;
import com.circle.naturalists.init.NaturalistsEntities;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;


@Mod(Naturalists.MOD_ID)
public class Naturalists
{

    public static final String MOD_ID = "naturalists";
    public static final List<Runnable> CALLBACKS = new ArrayList<>();

    public Naturalists() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
                bus.addListener(this::setup);
                bus.addListener(this::registerEntityAttributes);
                bus.addListener(this::registerClient);

        NaturalistsEntities.REGISTER.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(NaturalistsEntities.CROCODILE.get(), CrocodileEntity.registerAttributes().build());
        });
    }
    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.init();
        CALLBACKS.forEach(Runnable::run);
        CALLBACKS.clear();
    }
}
