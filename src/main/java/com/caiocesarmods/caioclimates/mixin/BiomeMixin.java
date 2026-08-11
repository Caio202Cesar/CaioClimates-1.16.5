package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Biome.class)
public abstract class BiomeMixin {

    @Redirect(
            method = "doesSnowGenerate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/IWorldReader;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome;"
            )
    )
    private Biome caioClimateUseActualPrecipitation(
            IWorldReader world,
            BlockPos pos
    ) {

        return world.getBiome(pos);
    }
}