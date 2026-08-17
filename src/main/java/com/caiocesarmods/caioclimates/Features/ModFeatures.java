package com.caiocesarmods.caioclimates.Features;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import static com.caiocesarmods.caioclimates.Features.TreeFeatures.ACACIA_SHRUB;
import static net.minecraft.world.gen.feature.Features.*;

public class ModFeatures {

    public static final ConfiguredFeature<?, ?> TREES_JUNGLE_NO_OAK = register("trees_jungle_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(MEGA_JUNGLE_TREE.withChance(0.33333334F),
                    JUNGLE_TREE_NO_VINE.withChance(0.5F)), JUNGLE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.
                            configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> TREES_JUNGLE_EDGE_NO_OAK = register("trees_jungle_edge_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(JUNGLE_TREE_NO_VINE.withChance(0.1F)),
                            JUNGLE_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> TREES_SHATTERED_SAVANNA_NO_OAK = register("trees_shattered_savanna_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(ACACIA.withChance(0.8F)), ACACIA_SHRUB))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> TREES_SAVANNA_NO_OAK = register("trees_savanna_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(ACACIA.withChance(0.8F)), ACACIA_SHRUB))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> TREES_MOUNTAIN_EDGE_NO_OAK = register("trees_mountain_edge_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(SPRUCE.withChance(0.666F)), MEGA_SPRUCE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> TREES_MOUNTAIN_NO_OAK = register("trees_mountain_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(SPRUCE.withChance(0.666F)), MEGA_SPRUCE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> BAMBOO_VEGETATION_NO_OAK = register("bamboo_vegetation_no_oak",
            Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BAMBOO.withChance(0.6F),
                            JUNGLE_TREE.withChance(0.36F), JUNGLE_TREE_NO_VINE.withChance(0.22F)), MEGA_JUNGLE_TREE))
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA
                            .configure(new AtSurfaceWithExtraConfig(30, 0.1F, 1))));


    static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
