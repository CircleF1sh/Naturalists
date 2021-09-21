package mod.naturalist.init;

import mod.naturalist.Naturalist;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class NaturalistItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Naturalist.MOD_ID);

    public static final RegistryObject<Item> BASS_BUCKET = ITEMS.register("bass_bucket",
            () -> new FishBucketItem(NaturalistEntities.BASS, () -> Fluids.WATER, new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_MISC)));


}
