package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public abstract class DefaultBiomeFeaturesMixin {

    @Inject(
            method = "withJungleTrees",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaJungleTrees(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Inject(
            method = "withJungleEdgeTrees",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaJungleEdgeTrees(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Inject(
            method = "withShatteredSavannaTrees",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaShatteredSavannaTrees(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Inject(
            method = "withSavannaTrees",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaSavannaTrees(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Inject(
            method = "withMountainTrees",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaMountainTrees(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Inject(
            method = "withMountainEdgeTrees",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaMountainEdgeTrees(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }

    @Inject(
            method = "withBambooVegetation",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeVanillaBambooVegetation(
            BiomeGenerationSettings.Builder builder,
            CallbackInfo ci
    ) {
        ci.cancel();
    }
}
