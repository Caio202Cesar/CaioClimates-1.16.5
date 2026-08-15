package com.caiocesarmods.caioclimates.Climate.Winter;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

//Water freezing
public class FrostHandler {

    public static float getFrostChance(
            Biome biome,
            BlockPos pos,
            World world
    ) {

        float temperature = biome.getTemperature(pos);

        /*
         * --------------------------------
         * ICE CAP
         * --------------------------------
         *
         * Permanently frozen climate.
         */
        if (temperature < 0.0F) {
            return 1.0F;
        }

        float frostChance;

        /*
         * --------------------------------
         * BASE FROST PROBABILITY
         * --------------------------------
         */

        if (temperature >= 0.90F) {
            frostChance = 0.0F;

        } else if (temperature <= 0.75F) {
            frostChance = 1.0F;

        } else {
            float normalized =
                    (0.90F - temperature) / 0.15F;

            frostChance =
                    normalized * normalized;
        }

        /*
         * --------------------------------
         * ALTITUDE
         * --------------------------------
         */

        int altitude = getAltitude(world, pos);

        if (altitude > 100) {

            float altitudeBonus =
                    (altitude - 100) / 15000.0F;

            altitudeBonus =
                    Math.min(0.30F, altitudeBonus);

            frostChance += altitudeBonus;
        }

        /*
         * --------------------------------
         * SEASONAL PHASE
         * --------------------------------
         */

        String phase =
                SeasonalPhase.getPhase(
                        world.getDayTime()
                );

        /*
         * --------------------------------
         * WINTER
         * --------------------------------
         */

        switch (phase) {

            case "EARLY_WINTER":
                frostChance *= 0.50F;
                break;

            case "MID_WINTER":
                frostChance *= 1.00F;
                break;

            case "LATE_WINTER":
                frostChance *= 0.70F;
                break;

            /*
             * --------------------------------
             * SPRING
             * --------------------------------
             *
             * Only cold/subarctic biomes.
             */

            case "EARLY_SPRING":

                if (temperature < 0.40F) {
                    frostChance *= 0.80F;
                } else {
                    frostChance = 0.0F;
                }

                break;

            case "MID_SPRING":

                if (temperature < 0.40F) {
                    frostChance *= 0.50F;
                } else {
                    frostChance = 0.0F;
                }

                break;

            case "LATE_SPRING":

                if (temperature < 0.40F) {
                    frostChance *= 0.20F;
                } else {
                    frostChance = 0.0F;
                }

                break;

            /*
             * --------------------------------
             * FALL
             * --------------------------------
             */

            case "EARLY_FALL":

                if (temperature < 0.40F) {
                    frostChance *= 0.20F;
                } else {
                    frostChance = 0.0F;
                }

                break;

            case "MID_FALL":

                if (temperature < 0.40F) {
                    frostChance *= 0.56F;
                } else {
                    frostChance = 0.0F;
                }

                break;

            case "LATE_FALL":

                if (temperature < 0.40F) {
                    frostChance *= 0.90F;
                } else {
                    frostChance = 0.0F;
                }

                break;

            default:
                frostChance = 0.0F;
                break;
        }

        return MathHelper.clamp(
                frostChance,
                0.0F,
                1.0F
        );
    }

    private static int getAltitude(
            World world,
            BlockPos pos
    ) {

        BlockPos terrainPos =
                world.getHeight(
                        Heightmap.Type.MOTION_BLOCKING,
                        pos
                );

        return terrainPos.getY() - 63;
    }

    public static boolean shouldFreeze(
            Biome biome,
            BlockPos pos,
            ServerWorld world
    ) {

        float chance =
                getFrostChance(
                        biome,
                        pos,
                        world
                );

        return world.rand.nextFloat() < chance;
    }
}