package biomesoplenty.common.world.gen.feature;

import biomesoplenty.common.util.block.IBlockPosQuery;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SmallDripleafBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class BigDripleafFeature extends Feature<NoneFeatureConfiguration>
{
	public BigDripleafFeature(Codec<NoneFeatureConfiguration> deserializer)
	{
		super(deserializer);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext)
	{
		WorldGenLevel world = featurePlaceContext.level();
		ChunkGenerator chunkGenerator = featurePlaceContext.chunkGenerator();
		Random rand = featurePlaceContext.random();
		BlockPos pos = featurePlaceContext.origin();
		NoneFeatureConfiguration config = featurePlaceContext.config();
		int i = 0;

		for(int j = 0; j < 32; ++j)
		{
			BlockPos blockpos = pos.offset(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			if (world.getBlockState(blockpos.below()).is(BlockTags.DIRT))
			{
				int max_height = rand.nextInt(3) + 1;
				Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);

				for (int k = 0; k < max_height; k++)
				{
					if (this.isAir(world, blockpos.above(k)) || world.getBlockState(blockpos.above(k)).getMaterial() == Material.WATER || world.getBlockState(blockpos.above(k)).getBlock() == Blocks.BIG_DRIPLEAF || world.getBlockState(blockpos.above(k)).getBlock() instanceof BushBlock)
					{
						if (this.isAir(world, blockpos.above(k-1)) || world.getBlockState(blockpos.above(k-1)).getMaterial() == Material.WATER || world.getBlockState(blockpos.above(k-1)).getBlock() == Blocks.BIG_DRIPLEAF || world.getBlockState(blockpos.above(k-1)).getBlock() instanceof BushBlock)
						{
							world.setBlock(blockpos.above(k-1), copyWaterloggedFrom(world, blockpos.above(k-1), Blocks.BIG_DRIPLEAF_STEM.defaultBlockState().setValue(SmallDripleafBlock.FACING, direction)), 2);
						}

						world.setBlock(blockpos.above(k), copyWaterloggedFrom(world, blockpos.above(k), Blocks.BIG_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING, direction)), 2);
					}
					else
					{
						break;
					}
				}

				++i;
			}
		}

		return i > 0;
	}

	public static BlockState copyWaterloggedFrom(LevelReader p_182454_, BlockPos p_182455_, BlockState p_182456_)
	{
		return p_182456_.hasProperty(BlockStateProperties.WATERLOGGED) ? p_182456_.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(p_182454_.isWaterAt(p_182455_))) : p_182456_;
	}
}