package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredRandomFeatureList;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(DefaultBiomeFeatures.class)
public abstract class DefaultBiomeFeaturesMixin {

    /**
     * @author YourName
     * @reason Remove vanilla oak trees from jungles.
     */
    @Overwrite
    public static void withJungleTrees(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.TREES_JUNGLE_NO_OAK
        );
    }
}
