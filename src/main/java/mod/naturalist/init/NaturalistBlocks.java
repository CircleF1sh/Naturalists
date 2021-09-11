package mod.naturalist.init;

import mod.naturalist.Naturalist;
import mod.naturalist.block.ElmSaplingBlock;
import mod.naturalist.block.MudBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class NaturalistBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Naturalist.MOD_ID);

    // Elm Blocks
    public static final RegistryObject<Block> ELM_LOG = register("elm_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GRAY).strength(2.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ELM_LEAVES = register("elm_leaves", () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> ELM_SAPLING = register("elm_sapling", () -> new ElmSaplingBlock(AbstractBlock.Properties.of(Material.PLANT).randomTicks().sound(SoundType.GRASS).noOcclusion()));

    // Mud
    public static final Block MUD_BLOCK = new MudBlock(AbstractBlock.Properties.of(Material.DIRT).strength(0.5f).sound(SoundType.SLIME_BLOCK).harvestTool(ToolType.SHOVEL).speedFactor(0.5F));
    public static final RegistryObject<Block> MUD = register("mud", () -> MUD_BLOCK);


    // use these helper methods to register blocks rather than REGISTER.register()
    // this also automatically registers block items so we don't need to do it manually
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, new Item.Properties().tab(Naturalist.GROUP));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties itemProperties) {
        return register(name, block, BlockItem::new, itemProperties);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, BiFunction<Block, Item.Properties, BlockItem> item, Item.Properties itemProperties) {
        final RegistryObject<T> registryObject = BLOCKS.register(name, block);
        if (itemProperties != null) NaturalistItems.ITEMS.register(name, () -> item == null ? new BlockItem(registryObject.get(), itemProperties) : item.apply(registryObject.get(), itemProperties));
        return registryObject;
    }
}
