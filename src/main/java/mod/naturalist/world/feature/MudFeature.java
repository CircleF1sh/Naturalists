package mod.naturalist.world.feature;

import mod.naturalist.Naturalist;
import mod.naturalist.init.NaturalistBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class MudFeature extends Feature<NoFeatureConfig> {

    public MudFeature() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator chunk, Random rand, BlockPos pos, NoFeatureConfig p_241855_5_) {
        if (!reader.getBlockState(pos).is(Blocks.CLAY)/* && (reader.getBlockState(pos.above()).is(Blocks.WATER) || reader.getBlockState(pos.north()).is(Blocks.WATER) || reader.getBlockState(pos.south()).is(Blocks.WATER) || reader.getBlockState(pos.east()).is(Blocks.WATER) || reader.getBlockState(pos.west()).is(Blocks.WATER))*/) {
            reader.setBlock(pos, NaturalistBlocks.MUD.get().defaultBlockState(), 2);
            Naturalist.LOGGER.debug("success?");
            return true;
        }
        return false;
    }
}
