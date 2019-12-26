package biomesoplenty.common.biome.nether;

import biomesoplenty.api.enums.BOPClimates;
import biomesoplenty.common.biome.NetherBiomeBOP;
import biomesoplenty.common.world.biome.BiomeFeatureHelper;
import biomesoplenty.common.world.gen.feature.BOPBiomeFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class VisceralHeapBiome extends NetherBiomeBOP
{
    public VisceralHeapBiome()
    {
        super((new Builder()).surfaceBuilder(SurfaceBuilder.NETHER, SurfaceBuilder.NETHERRACK_CONFIG).precipitation(RainType.NONE).category(Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).waterColor(4159204).waterFogColor(329011).parent((String)null));

        //Terrain
        this.addStructureStart(Feature.NETHER_BRIDGE.configured(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.configured(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).decorated(Placement.COUNT_VERY_BIASED_RANGE.configured(new CountRangeConfig(20, 8, 16, 256))));

        DefaultBiomeFeatures.addDefaultMushrooms(this);

        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.NETHER_BRIDGE.configured(IFeatureConfig.NO_FEATURE_CONFIG).decorated(Placement.NOPE.configured(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configured(DefaultBiomeFeatures.OPEN_NETHER_SPRING_CONFIG).decorated(Placement.COUNT_RANGE.configured(new CountRangeConfig(4, 4, 8, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configured(DefaultBiomeFeatures.HELL_FIRE_CONFIG).decorated(Placement.HELL_FIRE.configured(new FrequencyConfig(7))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configured(IFeatureConfig.NO_FEATURE_CONFIG).decorated(Placement.LIGHT_GEM_CHANCE.configured(new FrequencyConfig(7))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configured(IFeatureConfig.NO_FEATURE_CONFIG).decorated(Placement.COUNT_RANGE.configured(new CountRangeConfig(7, 0, 0, 128))));

        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BOPBiomeFeatures.FLESH_SPLATTER.configured(IFeatureConfig.NO_FEATURE_CONFIG).decorated(Placement.COUNT_HEIGHTMAP_DOUBLE.configured(new FrequencyConfig(500))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BOPBiomeFeatures.BONE_SPINE.configured(IFeatureConfig.NO_FEATURE_CONFIG).decorated(Placement.COUNT_HEIGHTMAP_DOUBLE.configured(new FrequencyConfig(15))));

        //Base Decorations
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configured(BiomeFeatureHelper.createClusterConfiguration(Blocks.BROWN_MUSHROOM.getDefaultState())).decorated(Placement.CHANCE_RANGE.configured(new ChanceRangeConfig(0.1F, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configured(BiomeFeatureHelper.createClusterConfiguration(Blocks.RED_MUSHROOM.getDefaultState())).decorated(Placement.CHANCE_RANGE.configured(new ChanceRangeConfig(0.1F, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).decorated(Placement.COUNT_RANGE.configured(new CountRangeConfig(16, 10, 20, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).decorated(Placement.MAGMA.configured(new FrequencyConfig(2))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configured(DefaultBiomeFeatures.CLOSED_NETHER_SPRING_CONFIG).decorated(Placement.COUNT_RANGE.configured(new CountRangeConfig(8, 10, 20, 128))));

        //Entities
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.GHAST, 50, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_PIGMAN, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.MAGMA_CUBE, 2, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 1, 4, 4));

        this.addWeight(BOPClimates.NETHER, 7);
    }
}
