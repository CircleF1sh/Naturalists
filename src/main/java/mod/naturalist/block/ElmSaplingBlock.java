package mod.naturalist.block;

import mod.naturalist.init.NaturalistFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ElmSaplingBlock extends SaplingBlock {

    public ElmSaplingBlock(Properties properties) {
        super(null, properties);
    }

    @Override
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        }
        else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, rand, pos)) {
                return;
            }
            NaturalistFeatures.ELM.get().place(world, world.getChunkSource().generator, rand, pos, null);
        }
    }
}