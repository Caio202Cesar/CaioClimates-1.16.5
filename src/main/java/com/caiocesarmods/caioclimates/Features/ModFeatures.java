package com.caiocesarmods.caioclimates.Features;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

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

    static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
