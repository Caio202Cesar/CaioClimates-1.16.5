package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Features.ModFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

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
