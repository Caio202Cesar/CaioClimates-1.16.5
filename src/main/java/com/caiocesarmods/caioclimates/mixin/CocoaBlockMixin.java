package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CocoaBlock.class)
public class CocoaBlockMixin {
    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )

    private void destroyFruitBlockInUnsuitableClimate(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random,
            CallbackInfo ci) {

        Biome biome = world.getBiome(pos);

        Biome.RainType rainType = biome.getPrecipitation();

        float temp = biome.getTemperature(pos);
        float minTemp = 0.9f;

        boolean isTropical = temp >= minTemp;
        boolean isWet = rainType.equals(Biome.RainType.RAIN);

        if (!isTropical && !isWet) {
            world.destroyBlock(pos, false);
        }
    }
}


