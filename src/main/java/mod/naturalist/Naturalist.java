package mod.naturalist;

import mod.naturalist.client.ClientEvents;
import mod.naturalist.entities.AlligatorEntity;
import mod.naturalist.init.NaturalistEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Naturalist.MOD_ID)
public class Naturalist {
    public static final String MOD_ID = "naturalist";

    public Naturalist() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::registerEntityAttributes);
        bus.addListener(this::registerClient);

        NaturalistEntities.REGISTER.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(NaturalistEntities.ALLIGATOR.get(), AlligatorEntity.registerAttributes().build());
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.init();
    }
}
