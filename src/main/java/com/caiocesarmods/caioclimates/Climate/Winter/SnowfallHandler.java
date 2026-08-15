package com.caiocesarmods.caioclimates.Climate.Winter;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class SnowfallHandler {

    public static float getSnowChance(Biome biome, BlockPos pos, World world) {
        /*
         * ============================================================
         * 1. BIOME TEMPERATURE
         * ============================================================
         *
         * 0.90F and above = essentially no snow.
         * 0.64F and below = essentially guaranteed snow.
         *
         */
        float temperature = biome.getTemperature(pos);

        /*
         * ============================================================
         * 2. ICE-CAP CLIMATE
         * ============================================================
         *
         * Base temperature below 0.0F represents an ice-cap climate.
         *
         * These climates have:
         *
         *     WINTER = 100% snow
         *     SUMMER = 100% snow
         *
         * Fall and spring are handled later as shoulder seasons.
         */

        boolean iceCapClimate = temperature < 0.0F;

        /*
         * ============================================================
         * 3. NORMAL WINTER SNOW PROBABILITY
         * ============================================================
         *
         * 0.90F and above = 0%
         * 0.64F and below = 100%
         *
         * This curve is used by non-ice-cap climates.
         */

        float winterSnowChance;

        if (temperature >= 0.90F) {

            winterSnowChance = 0.0F;

        } else {

            float normalized =
                    (0.90F - temperature) / 0.26F;

            normalized =
                    MathHelper.clamp(
                            normalized,
                            0.0F,
                            1.0F
                    );

            winterSnowChance =
                    (float) Math.pow(normalized, 4.0);
        }


        // ============================================================
        // 2. ALTITUDE MODIFIER
        // ============================================================

        int altitude = getAltitude(world, pos);

        if (altitude > 100) {

            float altitudeBonus =
                    (altitude - 100) / 15000.0F;

            // Maximum +10%
            altitudeBonus =
                    Math.min(0.10F, altitudeBonus);

            winterSnowChance += altitudeBonus;
        }


        // ============================================================
        // 3. SEASONAL PHASE
        // ============================================================

        String phase =
                SeasonalPhase.getPhase(
                        world.getDayTime()
                );


        /*
         * ========================================================
         * 7. ICE-CAP biomes have year around snow chance
         * ========================================================
         *
         * Even during the warmest part of the year, the biome
         * remains a permanent snow climate.
         */
        if (iceCapClimate) {
            if (phase.equals("EARLY_SPRING")
                    || phase.equals("MID_SPRING")
                    || phase.equals("LATE_SPRING")
                    || phase.equals("EARLY_SUMMER")
                    || phase.equals("MID_SUMMER")
                    || phase.equals("LATE_SUMMER")
                    || phase.equals("EARLY_FALL")
                    || phase.equals("MID_FALL")
                    || phase.equals("LATE_FALL")) {

                return 1.0F;
            }
        }

        /*
         * ============================================================
         * 7. Normal WINTER
         * ============================================================
         *
         * Use the normal winter snow curve.
         */

        if (phase.equals("EARLY_WINTER")) {

                winterSnowChance *= 0.50F;

                return MathHelper.clamp(
                        winterSnowChance,
                        0.0F,
                        1.0F
                );
        }

        if (phase.equals("MID_WINTER")) {

                winterSnowChance *= 1.00F;

                return MathHelper.clamp(
                        winterSnowChance,
                        0.0F,
                        1.0F
                );
        }

        if (phase.equals("LATE_WINTER")) {

                winterSnowChance *= 0.70F;

                return MathHelper.clamp(
                        winterSnowChance,
                        0.0F,
                        1.0F
                );
        }

        // ============================================================
        // 8. SHOULDER-SEASON SNOW
        // ============================================================

        /*
         * Shoulder-season snow begins at 0.64F.
         *
         * Above 0.64F:
         *      0%
         *
         * At 0.64F:
         *      approximately 2%
         *
         * At 0.40F:
         *      approximately 90%
         *
         * Below 0.40F:
         *      remains at 90%
         *
         * This is intentionally a smooth curve rather than
         * a hard transition.
         */

        float shoulderSnowChance = 0.0F;

        if (temperature <= 0.64F && !iceCapClimate) {

            float normalized =
                    (0.64F - temperature)
                            / 0.24F;

            normalized =
                    MathHelper.clamp(
                            normalized,
                            0.0F,
                            1.0F
                    );

            /*
             * Start at 2% at 0.64F and increase smoothly
             * toward 90% at 0.40F.
             */
            shoulderSnowChance =
                    0.02F
                            + 0.88F
                            * (float) Math.pow(
                            normalized,
                            2.0
                    );

            shoulderSnowChance =
                    MathHelper.clamp(
                            shoulderSnowChance,
                            0.0F,
                            0.90F
                    );
        }


        // ============================================================
        // 9. FALL
        // ============================================================

        if (phase.equals("EARLY_FALL")) {

            shoulderSnowChance *= 0.15F;

            return MathHelper.clamp(
                    shoulderSnowChance,
                    0.0F,
                    1.0F
            );
        }

        if (phase.equals("MID_FALL")) {

            shoulderSnowChance *= 0.50F;

            return MathHelper.clamp(
                    shoulderSnowChance,
                    0.0F,
                    1.0F
            );
        }

        if (phase.equals("LATE_FALL")) {

            shoulderSnowChance *= 0.80F;

            return MathHelper.clamp(
                    shoulderSnowChance,
                    0.0F,
                    1.0F
            );
        }

        // ============================================================
        // 10. SPRING
        // ============================================================

        if (phase.equals("EARLY_SPRING")) {

            shoulderSnowChance *= 0.80F;

            return MathHelper.clamp(
                    shoulderSnowChance,
                    0.0F,
                    1.0F
            );
        }

        if (phase.equals("MID_SPRING")) {

            shoulderSnowChance *= 0.50F;

            return MathHelper.clamp(
                    shoulderSnowChance,
                    0.0F,
                    1.0F
            );
        }

        if (phase.equals("LATE_SPRING")) {

            shoulderSnowChance *= 0.15F;

            return MathHelper.clamp(
                    shoulderSnowChance,
                    0.0F,
                    1.0F
            );
        }

        /*
         * ============================================================
         * 12. SUMMER
         * ============================================================
         *
         * Non-ice-cap climates have no snow during summer.
         *
         * Ice-cap climates were already handled above and return
         * 100% throughout summer.
         */

        return 0.0F;

    }

    // ================================================================
    // ALTITUDE
    // ================================================================

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


    // ================================================================
    // DETERMINISTIC SNOW DECISION
    // ================================================================

    public static boolean shouldSnow(Biome biome, BlockPos pos, World world) {

        float snowChance = getSnowChance(biome, pos, world);

        if (snowChance <= 0.0F) {
            return false;
        }

        if (snowChance >= 1.0F) {
            return true;
        }

        long weatherPeriod =
                world.getGameTime() / 1200L;

        int biomeId =
                biome.getRegistryName() != null
                        ? biome.getRegistryName().hashCode()
                        : 0;

        long seed =
                weatherPeriod
                        * 341873128712L
                        + biomeId;

        Random random =
                new Random(seed);

        return random.nextFloat()
                < snowChance;
    }
}
