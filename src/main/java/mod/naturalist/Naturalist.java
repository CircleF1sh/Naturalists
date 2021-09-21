package mod.naturalist;

import mod.naturalist.client.ClientEvents;
import mod.naturalist.entities.AlligatorEntity;
import mod.naturalist.init.NaturalistBlocks;
import mod.naturalist.init.NaturalistEntities;
import mod.naturalist.init.NaturalistFeatures;
import mod.naturalist.init.NaturalistItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(Naturalist.MOD_ID)
public class Naturalist {
    public static final List<Runnable> CALLBACKS = new ArrayList<>();
    public static final String MOD_ID = "naturalist";
    public  static final ItemGroup GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.OAK_SAPLING);
        }
    };
    public static ConfiguredFeature<?, ?> MUD_CONFIGURED;
    public static final Logger LOGGER = LogManager.getLogger();

    public Naturalist() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::setup);
        bus.addListener(this::registerEntityAttributes);
        bus.addListener(this::registerClient);

        forgeBus.addListener(this::onBiomeLoading);

        NaturalistEntities.ENTITIES.register(bus);
        NaturalistBlocks.BLOCKS.register(bus);
        NaturalistItems.ITEMS.register(bus);
        NaturalistFeatures.FEATURES.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
         MUD_CONFIGURED = register("mud_configured", NaturalistFeatures.MUD.get().configured(NoFeatureConfig.INSTANCE));
         MUD_CONFIGURED.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(100, 1.0F, 1)));
    }

    private void onBiomeLoading(BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();
        if (category.equals(Biome.Category.SWAMP)) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.TOP_LAYER_MODIFICATION).add(() -> Naturalist.MUD_CONFIGURED);
        }
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(NaturalistEntities.ALLIGATOR.get(), AlligatorEntity.registerAttributes().build());
        GlobalEntityTypeAttributes.put(NaturalistEntities.BASS.get(), AbstractGroupFishEntity.createAttributes().build());
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.init();
        CALLBACKS.forEach(Runnable::run);
        CALLBACKS.clear();

    }

    // use this for ConfiguredFeature registry
    private static <FC extends IFeatureConfig > ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }

}
