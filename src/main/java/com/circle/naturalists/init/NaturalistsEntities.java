package com.circle.naturalists.init;

import com.circle.naturalists.Naturalists;
import com.circle.naturalists.entities.CrocodileEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NaturalistsEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Naturalists.MOD_ID);

    public static final RegistryObject<EntityType<CrocodileEntity>> CROCODILE = REGISTER.register("crocodile",
            () -> EntityType.Builder.of(CrocodileEntity::new, EntityClassification.AMBIENT)
                    .sized(1.1F, 1.4F)
                    .build(new ResourceLocation(Naturalists.MOD_ID, "crocodile").toString()));
}
