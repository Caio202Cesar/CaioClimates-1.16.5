package com.caiocesarmods.caioclimates.Climate.Drought;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class DroughtHandler {

    private static final Map<ResourceLocation, Boolean> RAIN_STATE =
            new HashMap<>();

    private static long lastDay = -1;

    public static float getRainChance(Biome biome, World world) {

        DroughtPattern pattern =
                DroughtPatternRegistry.get(biome);

        //Normal RAIN biomes.
        if (pattern == null) {
            return biome.getPrecipitation()
                    == Biome.RainType.RAIN
                    ? 1.0F
                    : 0.0F;
        }

        SeasonalPhase phase = SeasonalPhase.valueOf(
                SeasonalPhase.getPhase(world.getDayTime()));

        return pattern.getRainChance(phase);
    }


    public static boolean shouldRain(Biome biome, World world) {

        DroughtPattern pattern = DroughtPatternRegistry.get(biome);

        if (pattern == null) {
            return biome.getPrecipitation()
                    == Biome.RainType.RAIN;
        }

        ResourceLocation biomeId =
                biome.getRegistryName();

        if (biomeId == null) {
            return false;
        }

        //Minecraft day
        long currentDay =
                world.getDayTime() / 24000L;

        /*
         * New Minecraft day:
         * clear the previous drought decisions.
         */
        if (currentDay != lastDay) {

            RAIN_STATE.clear();

            lastDay = currentDay;
        }

        /*
         * Already decided for this biome today.
         */
        Boolean cached =
                RAIN_STATE.get(biomeId);

        if (cached != null) {
            return cached;
        }

        /*
         * Make ONE random decision for this biome.
         */
        float chance =
                getRainChance(
                        biome,
                        world
                );

        System.out.println(
                "[CaioClimate] Drought weather decision | "
                        + biome.getRegistryName()
                        + " | phase="
                        + SeasonalPhase.getPhase(world.getDayTime())
                        + " | chance="
                        + chance
        );

        boolean rain =
                world.rand.nextFloat() < chance;

        RAIN_STATE.put(
                biomeId,
                rain
        );

        return rain;
    }
}