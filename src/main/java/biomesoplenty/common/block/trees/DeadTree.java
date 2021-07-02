package biomesoplenty.common.block.trees;

import biomesoplenty.common.world.gen.feature.BOPFeatures;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class DeadTree extends TreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeConfiguration> getFeature(Random random)
   {
      return random.nextInt(10) == 0 ? BOPFeatures.DYING_TREE : BOPFeatures.SMALL_DEAD_TREE;
   }
}