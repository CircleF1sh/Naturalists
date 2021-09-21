package mod.naturalist.init;

import mod.naturalist.Naturalist;
import mod.naturalist.entities.AlligatorEntity;
import mod.naturalist.entities.BassEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NaturalistEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Naturalist.MOD_ID);

    public static final RegistryObject<EntityType<AlligatorEntity>> ALLIGATOR = register("alligator",
            EntityType.Builder.of(AlligatorEntity::new, EntityClassification.AMBIENT)
                    .sized(1.1F, 1.4F));

    public static final RegistryObject<EntityType<BassEntity>> BASS = register("bass",
            EntityType.Builder.of(BassEntity::new, EntityClassification.WATER_AMBIENT)
                    .sized(0.7F, 0.85F));

    // use this helper method to register entities rather than REGISTER.register()
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(Naturalist.MOD_ID + "." + name));
    }
}
