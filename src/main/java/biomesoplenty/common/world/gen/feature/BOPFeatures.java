/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world.gen.feature;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.world.gen.feature.tree.*;
import biomesoplenty.core.BiomesOPlenty;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class BOPFeatures
{
	//Standard Trees
	public static final Feature<TreeConfiguration> ORIGIN_TREE = register("origin_tree", new BasicTreeFeature.Builder().leaves(BOPBlocks.origin_leaves.defaultBlockState()).minHeight(5).maxHeight(8).create());
	public static final Feature<TreeConfiguration> FLOWERING_OAK_TREE = register("flowering_oak_tree", new BasicTreeFeature.Builder().altLeaves(BOPBlocks.flowering_oak_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> RAINBOW_BIRCH_TREE = register("rainbow_birch_tree", new BasicTreeFeature.Builder().log(Blocks.BIRCH_LOG.defaultBlockState()).leaves(BOPBlocks.rainbow_birch_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> YELLOW_AUTUMN_TREE = register("yellow_autumn_tree", new BasicTreeFeature.Builder().log(Blocks.BIRCH_LOG.defaultBlockState()).leaves(BOPBlocks.yellow_autumn_leaves.defaultBlockState()).minHeight(5).maxHeight(8).create());
	public static final Feature<TreeConfiguration> ORANGE_AUTUMN_TREE = register("orange_autumn_tree", new BasicTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.defaultBlockState()).leaves(BOPBlocks.orange_autumn_leaves.defaultBlockState()).minHeight(5).maxHeight(8).create());
	public static final Feature<TreeConfiguration> MAPLE_TREE = register("maple_tree", new BasicTreeFeature.Builder().leaves(BOPBlocks.maple_leaves.defaultBlockState()).minHeight(5).maxHeight(10).create());
	public static final Feature<TreeConfiguration> PINK_CHERRY_TREE = register("pink_cherry_tree", new BasicTreeFeature.Builder().log(BOPBlocks.cherry_log.defaultBlockState()).leaves(BOPBlocks.pink_cherry_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> WHITE_CHERRY_TREE = register("white_cherry_tree", new BasicTreeFeature.Builder().log(BOPBlocks.cherry_log.defaultBlockState()).leaves(BOPBlocks.white_cherry_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> JACARANDA_TREE = register("jacaranda_tree", new BasicTreeFeature.Builder().log(BOPBlocks.jacaranda_log.defaultBlockState()).leaves(BOPBlocks.jacaranda_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> SMALL_DEAD_TREE = register("small_dead_tree", new BasicTreeFeature.Builder().log(BOPBlocks.dead_log.defaultBlockState()).leaves(BOPBlocks.dead_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> MAGIC_TREE = register("magic_tree", new PoplarTreeFeature.Builder().log(BOPBlocks.magic_log.defaultBlockState()).leaves(BOPBlocks.magic_leaves.defaultBlockState()).minHeight(8).maxHeight(12).create());

	//Big Trees
	public static final Feature<TreeConfiguration> BIG_OAK_TREE = register("big_oak_tree", new BigTreeFeature.Builder().create());
	public static final Feature<TreeConfiguration> BIG_ORIGIN_TREE = register("big_origin_tree", new BigTreeFeature.Builder().leaves(BOPBlocks.origin_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_FLOWERING_OAK_TREE = register("big_flowering_oak_tree", new BigTreeFeature.Builder().altLeaves(BOPBlocks.flowering_oak_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_RAINBOW_BIRCH_TREE = register("big_rainbow_birch_tree", new BigTreeFeature.Builder().log(Blocks.BIRCH_LOG.defaultBlockState()).leaves(BOPBlocks.rainbow_birch_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_YELLOW_AUTUMN_TREE = register("big_yellow_autumn_tree", new BigTreeFeature.Builder().log(Blocks.BIRCH_LOG.defaultBlockState()).leaves(BOPBlocks.yellow_autumn_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_ORANGE_AUTUMN_TREE = register("big_orange_autumn_tree", new BigTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.defaultBlockState()).leaves(BOPBlocks.orange_autumn_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_MAPLE_TREE = register("big_maple_tree", new BigTreeFeature.Builder().leaves(BOPBlocks.maple_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_PINK_CHERRY_TREE = register("big_pink_cherry_tree", new BigTreeFeature.Builder().log(BOPBlocks.cherry_log.defaultBlockState()).leaves(BOPBlocks.pink_cherry_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_WHITE_CHERRY_TREE = register("big_white_cherry_tree", new BigTreeFeature.Builder().log(BOPBlocks.cherry_log.defaultBlockState()).leaves(BOPBlocks.white_cherry_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_JACARANDA_TREE = register("big_jacaranda_tree", new BigTreeFeature.Builder().log(BOPBlocks.jacaranda_log.defaultBlockState()).leaves(BOPBlocks.jacaranda_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> BIG_MAGIC_TREE = register("big_magic_tree", new PoplarTreeFeature.Builder().log(BOPBlocks.magic_log.defaultBlockState()).leaves(BOPBlocks.magic_leaves.defaultBlockState()).minHeight(16).maxHeight(20).create());

	public static final Feature<TreeConfiguration> GIANT_TREE = register("giant_tree", new BigTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.defaultBlockState()).leaves(Blocks.DARK_OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true)).minHeight(15).maxHeight(20).trunkWidth(4).create());

	//Conifer Trees
	public static final Feature<TreeConfiguration> TALL_SPRUCE_TREE = register("tall_spruce_tree", new TaigaTreeFeature.Builder().log(Blocks.SPRUCE_LOG.defaultBlockState()).leaves(Blocks.SPRUCE_LEAVES.defaultBlockState()).maxHeight(13).create());
	public static final Feature<TreeConfiguration> ALPS_SPRUCE_TREE = register("alps_spruce_tree", new TaigaTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.STONE).log(Blocks.SPRUCE_LOG.defaultBlockState()).leaves(Blocks.SPRUCE_LEAVES.defaultBlockState()).maxHeight(13).create());
	public static final Feature<TreeConfiguration> FIR_TREE_SMALL = register("fir_tree_small", new TaigaTreeFeature.Builder().log(BOPBlocks.fir_log.defaultBlockState()).leaves(BOPBlocks.fir_leaves.defaultBlockState()).minHeight(5).maxHeight(11).create());
	public static final Feature<TreeConfiguration> FIR_TREE = register("fir_tree", new TaigaTreeFeature.Builder().log(BOPBlocks.fir_log.defaultBlockState()).leaves(BOPBlocks.fir_leaves.defaultBlockState()).minHeight(5).maxHeight(28).create());
	public static final Feature<TreeConfiguration> FIR_TREE_LARGE = register("fir_tree_large", new TaigaTreeFeature.Builder().log(BOPBlocks.fir_log.defaultBlockState()).leaves(BOPBlocks.fir_leaves.defaultBlockState()).minHeight(20).maxHeight(40).trunkWidth(2).create());
	public static final Feature<TreeConfiguration> UMBRAN_TREE = register("umbran_tree", new TaigaTreeFeature.Builder().log(BOPBlocks.umbran_log.defaultBlockState()).leaves(BOPBlocks.umbran_leaves.defaultBlockState()).maxHeight(20).create());
	public static final Feature<TreeConfiguration> TALL_UMBRAN_TREE = register("tall_umbran_tree", new TaigaTreeFeature.Builder().log(BOPBlocks.umbran_log.defaultBlockState()).leaves(BOPBlocks.umbran_leaves.defaultBlockState()).minHeight(20).maxHeight(30).trunkWidth(2).create());

	//Poplar Trees
	public static final Feature<TreeConfiguration> SPRUCE_POPLAR = register("spruce_poplar", new PoplarTreeFeature.Builder().log(Blocks.SPRUCE_LOG.defaultBlockState()).leaves(Blocks.SPRUCE_LEAVES.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> DARK_OAK_POPLAR = register("dark_oak_poplar", new PoplarTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.defaultBlockState()).leaves(Blocks.DARK_OAK_LEAVES.defaultBlockState()).create());

	//Swamp Trees
	public static final Feature<TreeConfiguration> CYPRESS_TREE = register("cypress_tree", new CypressTreeFeature.Builder().create());
	public static final Feature<TreeConfiguration> CYPRESS_TREE_MEDIUM = register("cypress_tree_medium", new CypressTreeFeature.Builder().minHeight(15).maxHeight(25).trunkWidth(2).create());
	public static final Feature<TreeConfiguration> TALL_SWAMP_TREE = register("tall_swamp_tree", new BasicTreeFeature.Builder().vine(Blocks.VINE.defaultBlockState()).minHeight(8).maxHeight(12).maxLeavesRadius(2).leavesOffset(0).create());
	public static final Feature<TreeConfiguration> WILLOW_TREE = register("willow_tree", new BasicTreeFeature.Builder().log(BOPBlocks.willow_log.defaultBlockState()).leaves(BOPBlocks.willow_leaves.defaultBlockState()).vine(BOPBlocks.willow_vine.defaultBlockState()).minHeight(6).maxHeight(10).maxLeavesRadius(2).leavesOffset(0).create());

	//Sparse Trees
	public static final Feature<TreeConfiguration> SPARSE_ACACIA_TREE = register("sparse_acacia_tree", new BigTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.orange_sand).log(Blocks.ACACIA_LOG.defaultBlockState()).leaves(Blocks.ACACIA_LEAVES.defaultBlockState()).maxHeight(8).foliageHeight(1).create());
	public static final Feature<TreeConfiguration> SPARSE_OAK_TREE = register("sparse_oak_tree", new BigTreeFeature.Builder().maxHeight(10).foliageHeight(2).create());
	public static final Feature<TreeConfiguration> DYING_TREE = register("dying_tree", new BigTreeFeature.Builder().log(BOPBlocks.dead_log.defaultBlockState()).leaves(BOPBlocks.dead_leaves.defaultBlockState()).maxHeight(10).foliageHeight(2).create());
	public static final Feature<TreeConfiguration> DYING_TREE_WASTELAND = register("dying_tree_wasteland", new BigTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.dried_salt).log(BOPBlocks.dead_log.defaultBlockState()).leaves(BOPBlocks.dead_leaves.defaultBlockState()).maxHeight(10).foliageHeight(1).create());

	//Bushes/Twiglets
	public static final Feature<TreeConfiguration> BUSH = register("bush", new BushTreeFeature.Builder().create());
	public static final Feature<TreeConfiguration> SPRUCE_BUSH = register("spruce_bush", new BushTreeFeature.Builder().log(Blocks.SPRUCE_LOG.defaultBlockState()).leaves(Blocks.SPRUCE_LEAVES.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> ACACIA_BUSH = register("acacia_bush", new BushTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.orange_sand).log(Blocks.ACACIA_LOG.defaultBlockState()).leaves(Blocks.ACACIA_LEAVES.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> FLOWERING_BUSH = register("flowering_bush", new BushTreeFeature.Builder().altLeaves(BOPBlocks.flowering_oak_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> HELLBARK_TREE = register("hellbark_tree", new BushTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.NETHERRACK || world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING)).log(BOPBlocks.hellbark_log.defaultBlockState()).leaves(BOPBlocks.hellbark_leaves.defaultBlockState()).create());

	public static final Feature<TreeConfiguration> TWIGLET_TREE = register("twiglet_tree", new TwigletTreeFeature.Builder().minHeight(1).maxHeight(2).create());
	public static final Feature<TreeConfiguration> TALL_TWIGLET_TREE = register("tall_twiglet_tree", new TwigletTreeFeature.Builder().minHeight(2).maxHeight(4).create());
	public static final Feature<TreeConfiguration> SPRUCE_TWIGLET_TREE = register("spruce_twiglet_tree", new TwigletTreeFeature.Builder().log(Blocks.SPRUCE_LOG.defaultBlockState()).leaves(Blocks.SPRUCE_LEAVES.defaultBlockState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeConfiguration> JUNGLE_TWIGLET_TREE = register("jungle_twiglet_tree", new TwigletTreeFeature.Builder().log(Blocks.JUNGLE_LOG.defaultBlockState()).leaves(Blocks.JUNGLE_LEAVES.defaultBlockState()).minHeight(1).maxHeight(2).trunkFruit(Blocks.COCOA.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> DARK_OAK_TWIGLET_TREE = register("dark_oak_twiglet_tree", new TwigletTreeFeature.Builder().log(Blocks.DARK_OAK_LOG.defaultBlockState()).leaves(Blocks.DARK_OAK_LEAVES.defaultBlockState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeConfiguration> ACACIA_TWIGLET_TREE = register("acacia_twiglet_tree", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.RED_SAND).log(Blocks.ACACIA_LOG.defaultBlockState()).leaves(Blocks.ACACIA_LEAVES.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> ACACIA_TWIGLET_SMALL = register("acacia_twiglet_small", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == BOPBlocks.orange_sand).log(Blocks.ACACIA_LOG.defaultBlockState()).leaves(Blocks.ACACIA_LEAVES.defaultBlockState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeConfiguration> ACACIA_TWIGLET = register("acacia_twiglet", new TwigletTreeFeature.Builder().log(Blocks.ACACIA_LOG.defaultBlockState()).leaves(Blocks.ACACIA_LEAVES.defaultBlockState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeConfiguration> MAPLE_TWIGLET_TREE = register("maple_twiglet_tree", new TwigletTreeFeature.Builder().minHeight(1).maxHeight(2).leaves(BOPBlocks.maple_leaves.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> DEAD_TWIGLET_TREE_SMALL = register("dead_twiglet_tree_small", new TwigletTreeFeature.Builder().minHeight(1).maxHeight(1).leaves(BOPBlocks.dead_leaves.defaultBlockState()).log(BOPBlocks.dead_log.defaultBlockState()).create());
	public static final Feature<TreeConfiguration> DEAD_TWIGLET_TREE = register("dead_twiglet_tree", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.defaultBlockState()).leafChance(0.05F, 0.25F).leaves(BOPBlocks.dead_leaves.defaultBlockState()).log(BOPBlocks.dead_log.defaultBlockState()).minHeight(6).maxHeight(10).create());
	public static final Feature<TreeConfiguration> DEAD_TWIGLET_TREE_TALL = register("dead_twiglet_tree_tall", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.defaultBlockState()).leafChance(0.15F, 0.6F).leaves(BOPBlocks.dead_leaves.defaultBlockState()).log(BOPBlocks.dead_log.defaultBlockState()).minHeight(12).maxHeight(18).create());
	public static final Feature<TreeConfiguration> TWIGLET_TREE_VOLCANO = register("twiglet_tree_volcano", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.black_sand).log(Blocks.DARK_OAK_LOG.defaultBlockState()).leaves(Blocks.DARK_OAK_LEAVES.defaultBlockState()).minHeight(1).maxHeight(2).create());
	public static final Feature<TreeConfiguration> BIG_HELLBARK_TREE = register("big_hellbark_tree", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == Blocks.NETHERRACK || world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING)).log(BOPBlocks.hellbark_log.defaultBlockState()).leaves(BOPBlocks.hellbark_leaves.defaultBlockState()).minHeight(3).maxHeight(7).create());

	//Special Trees
	public static final Feature<TreeConfiguration> REDWOOD_TREE = register("redwood_tree", new RedwoodTreeFeature.Builder().create());
	public static final Feature<TreeConfiguration> REDWOOD_TREE_MEDIUM = register("redwood_tree_medium", new RedwoodTreeFeature.Builder().minHeight(25).maxHeight(40).trunkWidth(2).create());
	public static final Feature<TreeConfiguration> REDWOOD_TREE_LARGE = register("redwood_tree_large", new RedwoodTreeFeature.Builder().minHeight(45).maxHeight(60).trunkWidth(3).create());
	public static final Feature<TreeConfiguration> MAHOGANY_TREE = register("mahogany_tree", new MahoganyTreeFeature.Builder().create());
	public static final Feature<TreeConfiguration> PALM_TREE = register("palm_tree", new PalmTreeFeature.Builder().create());
	public static final Feature<TreeConfiguration> DEAD_TREE = register("dead_tree", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.defaultBlockState()).leafChance(0.0F, 0.0F).leaves(Blocks.AIR.defaultBlockState()).log(BOPBlocks.dead_log.defaultBlockState()).minHeight(6).maxHeight(10).create());
	public static final Feature<TreeConfiguration> TALL_DEAD_TREE = register("tall_dead_tree", new TwigletTreeFeature.Builder().trunkFruit(BOPBlocks.dead_branch.defaultBlockState()).leafChance(0.0F, 0.0F).leaves(Blocks.AIR.defaultBlockState()).log(BOPBlocks.dead_log.defaultBlockState()).minHeight(8).maxHeight(12).create());
	public static final Feature<TreeConfiguration> DEAD_TREE_WASTELAND = register("dead_tree_wasteland", new TwigletTreeFeature.Builder().placeOn((world, pos) -> world.getBlockState(pos).getBlock() == BOPBlocks.dried_salt).trunkFruit(BOPBlocks.dead_branch.defaultBlockState()).leafChance(0.0F, 0.0F).leaves(Blocks.AIR.defaultBlockState()).log(BOPBlocks.dead_log.defaultBlockState()).minHeight(6).maxHeight(10).create());
	public static final Feature<TreeConfiguration> BURNT_TREE = register("burnt_tree", new TwigletTreeFeature.Builder().leafChance(0.0F, 0.0F).leaves(Blocks.AIR.defaultBlockState()).log(BOPBlocks.stripped_hellbark_log.defaultBlockState()).minHeight(3).maxHeight(5).create());

	/////////////////////////////////////////////////////////////////////////////////

	//Features
	public static final Feature<NoneFeatureConfiguration> BIG_PUMPKIN = register("big_pumpkin", new BigPumpkinFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> BLACK_SAND_SPLATTER = register("black_sand_splatter", new BlackSandSplatterFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> BONE_SPINE = register("bone_spine", new BoneSpineFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> BRAMBLE = register("bramble", new BrambleFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> CRAG_SPLATTER = register("crag_splatter", new CragSplatterFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> DEEP_BAYOU_VINES = register("deep_bayou_vines", new DeepBayouVinesFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> FERN = register("fern", new FernFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> FERN_GRASS = register("fern_grass", new FernGrassFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> FLESH_TENDON = register("flesh_tendon", new FleshTendonFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> GRASS_SPLATTER = register("grass_splatter", new GrassSplatterFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> HUGE_CLOVER = register("huge_clover", new HugeCloverFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> HUGE_GLOWSHROOM = register("huge_glowshroom", new HugeGlowshroomFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> HUGE_TOADSTOOL = register("huge_toadstool", new HugeToadstoolFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> LARGE_CRYSTAL = register("large_crystal", new LargeCrystalFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> MANGROVE = register("mangrove", new MangroveFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> MYCELIUM_SPLATTER = register("mycelium_splatter", new MyceliumSplatterFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> NETHER_VINES = register("nether_vines", new NetherVinesFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> OBSIDIAN_SPLATTER = register("obsidian_splatter", new ObsidianSplatterFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> RAINFOREST_CLIFFS_VINES = register("rainforest_cliffs_vines", new RainforestCliffsVinesFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> PODZOL_SPLATTER = register("podzol_splatter", new PodzolSplatterFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> PUMPKIN_PATCH = register("pumpkin_patch", new PumpkinPatchFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<RandomPatchConfiguration> RANDOM_PATCH_ABOVE_GROUND = register("random_patch_above_ground", new RandomPatchAboveGroundFeature(RandomPatchConfiguration.CODEC));
	public static final Feature<NoneFeatureConfiguration> SCATTERED_ROCKS = register("scattered_rocks", new ScatteredRocksFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SCRUB = register("scrub", new ScrubFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SHORT_BAMBOO = register("short_bamboo", new ShortBambooFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SMALL_BROWN_MUSHROOM = register("small_brown_mushroom", new SmallBrownMushroomFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SMALL_CRYSTAL = register("small_crystal", new SmallCrystalFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SMALL_GLOWSHROOM = register("small_glowshroom", new SmallGlowshroomFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SMALL_RED_MUSHROOM = register("small_red_mushroom", new SmallRedMushroomFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> SMALL_TOADSTOOL = register("small_toadstool", new SmallToadstoolFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> STANDARD_GRASS = register("standard_grass", new StandardGrassFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final Feature<NoneFeatureConfiguration> WASTELAND_GRASS = register("wasteland_grass", new WastelandGrassFeature(NoneFeatureConfiguration.CODEC.stable()));

	//Flowers
	public static final RandomPatchConfiguration CHERRY_BLOSSOM_GROVE_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.pink_daffodil.defaultBlockState(), 1).add(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration CONIFEROUS_FOREST_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(Blocks.CORNFLOWER.defaultBlockState(), 1).add(Blocks.OXEYE_DAISY.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration EXTENDED_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(Blocks.OXEYE_DAISY.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration FLOWER_MEADOW_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(Blocks.PINK_TULIP.defaultBlockState(), 1).add(Blocks.RED_TULIP.defaultBlockState(), 1).add(Blocks.WHITE_TULIP.defaultBlockState(), 1).add(Blocks.ORANGE_TULIP.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration MEADOW_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 1).add(Blocks.AZURE_BLUET.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration MOOR_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(Blocks.ALLIUM.defaultBlockState(), 1).add(BOPBlocks.violet.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration MYSTIC_GROVE_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.glowflower.defaultBlockState(), 1).add(BOPBlocks.pink_daffodil.defaultBlockState(), 1).add(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 1).add(Blocks.AZURE_BLUET.defaultBlockState(), 1).add(Blocks.ALLIUM.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration ORIGIN_VALLEY_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.rose.defaultBlockState(), 6).add(Blocks.DANDELION.defaultBlockState(), 4), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration RAINBOW_HILLS_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.orange_cosmos.defaultBlockState(), 1).add(BOPBlocks.pink_daffodil.defaultBlockState(), 1).add(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 1).add(Blocks.AZURE_BLUET.defaultBlockState(), 1).add(Blocks.ALLIUM.defaultBlockState(), 1).add(Blocks.CORNFLOWER.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1).add(Blocks.BLUE_ORCHID.defaultBlockState(), 1).add(Blocks.PINK_TULIP.defaultBlockState(), 1).add(Blocks.RED_TULIP.defaultBlockState(), 1).add(Blocks.WHITE_TULIP.defaultBlockState(), 1).add(Blocks.ORANGE_TULIP.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration RAINFOREST_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.orange_cosmos.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration SNOWY_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.violet.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration TROPICS_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(BOPBlocks.pink_hibiscus.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();
	public static final RandomPatchConfiguration WETLAND_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(Blocks.BLUE_ORCHID.defaultBlockState(), 1).add(Blocks.POPPY.defaultBlockState(), 1).add(Blocks.DANDELION.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(64).build();

	//Other
	public static final SpringConfiguration VOLCANO_SPRING_CONFIG = new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1, ImmutableSet.of(Blocks.BASALT, Blocks.MAGMA_BLOCK, BOPBlocks.black_sand, BOPBlocks.black_sandstone, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
	public static final SpringConfiguration WATER_SPRING_EXTRA_CONFIG = new SpringConfiguration(Fluids.WATER.defaultFluidState(), true, 4, 1, ImmutableSet.of(Blocks.DIRT, Blocks.TERRACOTTA, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, BOPBlocks.orange_sandstone));

	private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String key, F value)
	{
		value.setRegistryName(new ResourceLocation(BiomesOPlenty.MOD_ID, key));
		ForgeRegistries.FEATURES.register(value);
		return value;
	}
}
