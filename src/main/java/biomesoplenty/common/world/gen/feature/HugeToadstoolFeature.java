package biomesoplenty.common.world.gen.feature;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.block.IBlockPosQuery;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class HugeToadstoolFeature extends Feature<NoneFeatureConfiguration>
{
    protected IBlockPosQuery placeOn = (world, pos) -> world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.MYCELIUM;
    protected IBlockPosQuery replace = (world, pos) -> world.getBlockState(pos).canBeReplacedByLeaves(world, pos) || world.getBlockState(pos).getBlock() instanceof BushBlock;

    public HugeToadstoolFeature(Codec<NoneFeatureConfiguration> deserializer)
    {
        super(deserializer);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random rand, BlockPos startPos, NoneFeatureConfiguration config) {
        while (startPos.getY() > 1 && this.replace.matches(world, startPos)) {
            startPos = startPos.below();
        }

        if (!this.placeOn.matches(world, startPos.offset(0, 0, 0))) {
            // Abandon if we can't place the tree on this block
            return false;
        }

        if (!this.checkSpace(world, startPos.above())) {
            // Abandon if there isn't enough room
            return false;
        }

        BlockPos pos = startPos.above();

        int height = 2 + rand.nextInt(3);
        int radius = 2;

        for (int y = 0; y < height; y++) {
            this.setBlock(world, pos.above(y), Blocks.MUSHROOM_STEM.defaultBlockState());
        }

        for (int x = -(radius-1); x <= (radius-1); x++)
        {
            for (int z = -(radius-1); z <= (radius-1); z++)
            {
                this.setBlock(world, pos.offset(x, height, z), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                this.setBlock(world, pos.offset(x, height+1, z), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                this.setBlock(world, pos.offset(x, height+2, z), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            }
        }

        this.setBlock(world, pos.offset(0, height+3, 0), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
        this.setBlock(world, pos.offset(1, height+3, 0), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
        this.setBlock(world, pos.offset(-1, height+3, 0), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
        this.setBlock(world, pos.offset(0, height+3, 1), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
        this.setBlock(world, pos.offset(0, height+3, -1), BOPBlocks.toadstool_block.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));

        return true;
    }

    public boolean setBlock(LevelAccessor world, BlockPos pos, BlockState state)
    {
        if (this.replace.matches(world, pos))
        {
            super.setBlock(world, pos, state);
            return true;
        }
        return false;
    }

    public boolean checkSpace(LevelAccessor world, BlockPos pos)
    {
        for (int y = 0; y <= 8; y++)
        {
            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= 2; z++)
                {
                    BlockPos pos1 = pos.offset(x, y, z);
                    if (pos1.getY() >= 255 || !this.replace.matches(world, pos1))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}