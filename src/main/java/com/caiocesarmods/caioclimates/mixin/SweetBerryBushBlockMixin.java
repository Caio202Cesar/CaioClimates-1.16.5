package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SweetBerryBushBlock.class)
public class SweetBerryBushBlockMixin {
    //Random tick into dead bush if climatic conditions aren't favorable.
    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )

    private void turnIntoDeadBushInUnsuitableClimate(BlockState state, ServerWorld world,
                                                      BlockPos pos, Random random, CallbackInfo ci) {

        Biome biome = world.getBiome(pos);
        Biome.RainType rainType = biome.getPrecipitation();

        float temp = biome.getTemperature(pos);
        float maxTemp = 0.64f;
        float minTemp = 0.0f;

        boolean isColdEnough = temp >= minTemp && temp <= maxTemp;

        if (!isColdEnough) {
            world.setBlockState(pos, Blocks.DEAD_BUSH.getDefaultState());
        }
    }
}
