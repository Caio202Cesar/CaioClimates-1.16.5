package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Features.ModFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DefaultBiomeFeatures.class)
public abstract class DefaultBiomeFeaturesMixin {

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from jungles.
     */
    @Overwrite
    public static void withJungleTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_JUNGLE_NO_OAK
        );
    }

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from edge jungles.
     */
    @Overwrite
    public static void withJungleEdgeTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_JUNGLE_EDGE_NO_OAK
        );
    }

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from edge jungles.
     */
    @Overwrite
    public static void withShatteredSavannaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_SHATTERED_SAVANNA_NO_OAK
        );
    }

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from edge jungles.
     */
    @Overwrite
    public static void withSavannaTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_SAVANNA_NO_OAK
        );
    }

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from edge jungles.
     */
    @Overwrite
    public static void withMountainEdgeTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_MOUNTAIN_EDGE_NO_OAK
        );
    }

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from edge jungles.
     */
    @Overwrite
    public static void withMountainTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_MOUNTAIN_NO_OAK
        );
    }

    /**
     * @author CaioCesar
     * @reason Remove vanilla oak trees from edge jungles.
     */
    @Overwrite
    public static void withBambooVegetation(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.BAMBOO_VEGETATION_NO_OAK
        );
    }
}
