package com.caiocesarmods.caioclimates.Climate.Winter;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

public class SnowMeltHandler {

    public static boolean shouldMelt(
            ServerWorld world,
            BlockPos pos
    ) {
        if (!world.isRaining()) {
            return false;
        }

        Biome biome = world.getBiome(pos);

        // If precipitation at this location is snow,
        // existing snow should remain.
        if (SnowfallHandler.shouldSnow(
                biome,
                pos,
                world
        )) {
            return false;
        }

        // Local precipitation is rain.
        return true;
    }
}
