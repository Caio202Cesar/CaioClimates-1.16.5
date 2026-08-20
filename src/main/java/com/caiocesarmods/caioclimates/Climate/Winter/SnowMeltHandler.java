package com.caiocesarmods.caioclimates.Climate.Winter;

import com.caiocesarmods.caioclimates.Seasons.Season;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

public class SnowMeltHandler {

    public static boolean shouldMelt(ServerWorld world, BlockPos pos) {
        String currentSeason = Season.getSeason(world.getDayTime());

        Biome biome = world.getBiome(pos);
        float temperature = biome.getTemperature(pos);

        boolean iceCapClimate = temperature < 0.0F;
        boolean taigaClimate = temperature < 0.4F;
        boolean mesothermalClimate = temperature >= 0.7F;

        //If it is not raining
        if (!world.isRaining()) {
            if ("SUMMER".equals(currentSeason) && !iceCapClimate) {
                return true;
            }
            else if ("SPRING".equals(currentSeason) && !iceCapClimate && !taigaClimate) {
                return true;
            }
            else if ("FALL".equals(currentSeason) && !iceCapClimate && !taigaClimate) {
                return true;
            }

            else if ("WINTER".equals(currentSeason) && mesothermalClimate) {
                return true;
            }

            return false;
        }

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
