package com.caiocesarmods.caioclimates.Util;

import com.caiocesarmods.caioclimates.Features.ModFeatures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.function.Supplier;

public class ModTreeGeneration {
    public static void generateTrees(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());

        /// Jungle
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.JUNGLE.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.MODIFIED_JUNGLE.getLocation())))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.JUNGLE_HILLS.getLocation()))))
        {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.TREES_JUNGLE_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(16, 0.0F, 0))));
        }

        /// Bamboo Jungle
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.BAMBOO_JUNGLE.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.BAMBOO_JUNGLE_HILLS.getLocation()))))
        {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.BAMBOO_VEGETATION_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(50, 0.1F, 1))));
        }

        /// Jungle Edge
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.JUNGLE_EDGE.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.MODIFIED_JUNGLE_EDGE.getLocation())))) {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.TREES_JUNGLE_EDGE_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(2, 0.1f, 1))));
        }

        /// Savanna
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.SAVANNA.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.SAVANNA_PLATEAU.getLocation())))) {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.TREES_SAVANNA_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
        }

        /// Shattered Savanna
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.SHATTERED_SAVANNA.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.SHATTERED_SAVANNA_PLATEAU.getLocation())))) {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.TREES_SHATTERED_SAVANNA_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
        }

        /// Mountain Edge
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.MOUNTAIN_EDGE.getLocation()))) {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.TREES_MOUNTAIN_EDGE_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
        }

        /// Mountain
        if (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.MOUNTAINS.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.MODIFIED_GRAVELLY_MOUNTAINS.getLocation()))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.WOODED_MOUNTAINS.getLocation())))
                || (key.equals(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Biomes.GRAVELLY_MOUNTAINS.getLocation())))
        )) {

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModFeatures.TREES_MOUNTAIN_NO_OAK
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
        }
    }
}
