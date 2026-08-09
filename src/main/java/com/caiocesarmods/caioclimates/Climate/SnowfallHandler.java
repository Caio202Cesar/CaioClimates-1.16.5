package com.caiocesarmods.caioclimates.Climate;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class SnowfallHandler {

    public static float getSnowChance(Biome biome, BlockPos pos, World world) {

        // Base biome temperature
        float temperature = biome.getTemperature(pos);

        /*
         * Base snow probability.
         *
         * 0.90F and above = essentially no snow
         * 0.69F and below = essentially guaranteed
         */
        float snowChance;

        if (temperature >= 0.90F) {
            snowChance = 0.0F;
        } else if (temperature <= 0.69F) {
            snowChance = 1.0F;
        } else {
            float normalized =
                    (0.90F - temperature) / 0.40F;

            // Non-linear curve: colder climates
            // become snowy much more rapidly.
            snowChance = normalized * normalized;
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
        return MathHelper.clamp(
                snowChance,
                0.0F,
                1.0F
        );

    }
}
