package com.caiocesarmods.caioclimates.Climate;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SnowfallHandler {

    public static float getSnowChance(Biome biome, BlockPos pos, World world) {

        System.out.println(
                "[CaioClimate] SnowfallHandler.getSnowChance() called!"
        );

        // Base biome temperature
        float temperature = biome.getTemperature(pos);

        System.out.println(
                "[CaioClimate] Temperature = "
                        + temperature
        );

        /*
         * Base snow probability.
         *
         * 0.90F and above = essentially no snow
         * 0.64F and below = essentially guaranteed
         */
        float snowChance;

        if (temperature >= 0.90F) {

            snowChance = 0.0F;

        } else {

            float normalized =
                    (0.90F - temperature) / 0.26F;

            normalized =
                    MathHelper.clamp(
                            normalized,
                            0.0F,
                            1.0F
                    );

            snowChance =
                    (float) Math.pow(normalized, 4.0);
        }

        /*
         * --------------------------------
         * 2. ALTITUDE MODIFIER
         * --------------------------------
         *
         * Higher elevations receive a
         * small increase in snow chance.
         */
        int altitude = pos.getY();

        if (altitude > 100) {

            float altitudeBonus =
                    (altitude - 100) / 15000.0F;

            // Maximum +20%
            altitudeBonus =
                    Math.min(0.10F, altitudeBonus);

            snowChance += altitudeBonus;
        }

        /*
         * --------------------------------
         * 3. SEASONAL PHASE
         * --------------------------------
         *
         * Snow is only possible during
         * winter.
         */
        String phase =
                SeasonalPhase.getPhase(world.getDayTime());

        switch (phase) {

            case "EARLY_WINTER":
                snowChance *= 0.50F;
                break;

            case "MID_WINTER":
                snowChance *= 1.00F;
                break;

            case "LATE_WINTER":
                snowChance *= 0.70F;
                break;

            default:
                snowChance = 0.0F;
                break;
        }


        /*
         * --------------------------------
         * 4. CLAMP RESULT
         * --------------------------------
         */
        // Never allow the probability outside 0–100%.
        float finalChance = MathHelper.clamp(
                snowChance,
                0.0F,
                1.0F
        );

        System.out.println(
                "[CaioClimate] Final snow chance = "
                        + finalChance
        );

        return finalChance;

    }

    private static int debugCounter = 0;

    public static boolean shouldSnow(
            Biome biome,
            BlockPos pos,
            World world
    ) {
        float snowChance = getSnowChance(biome, pos, world);

        if (snowChance <= 0.0F) {
            return false;
        }

        if (snowChance >= 1.0F) {
            return true;
        }

        long weatherPeriod = world.getGameTime() / 1200L;

        long seed =
                weatherPeriod
                        + (long) pos.getX() * 341873128712L
                        + (long) pos.getZ() * 132897987541L;

        Random random = new Random(seed);

        boolean snow = random.nextFloat() < snowChance;

        // DEBUG — print only occasionally
        if (debugCounter++ % 500 == 0) {
            System.out.println(
                    "[CaioCesarBiomes] SnowfallHandler active!"
                            + " | biome=" + biome.getRegistryName()
                            + " | pos=" + pos
                            + " | temperature=" + biome.getTemperature(pos)
                            + " | snowChance=" + snowChance
                            + " | result=" + snow
            );
        }

        return snow;
    }
}
