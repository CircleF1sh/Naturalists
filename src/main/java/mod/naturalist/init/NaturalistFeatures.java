package mod.naturalist.init;

import mod.naturalist.Naturalist;
import mod.naturalist.world.feature.MudFeature;
import mod.naturalist.world.tree.ElmFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NaturalistFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Naturalist.MOD_ID);

    public static final RegistryObject<ElmFeature> ELM = FEATURES.register("elm", ElmFeature::new);
    public static final RegistryObject<MudFeature> MUD = FEATURES.register("mud", MudFeature::new);

}
