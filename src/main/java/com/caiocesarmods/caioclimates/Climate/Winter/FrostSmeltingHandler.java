package com.caiocesarmods.caioclimates.Climate.Winter;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FrostSmeltingHandler {

    public static boolean shouldMelt(
            ServerWorld world,
            BlockPos pos,
            BlockState state,
            Random random
    ) {
        Biome biome = world.getBiome(pos);

        float baseTemperature =
                biome.getTemperature();

        /*
         * --------------------------------
         * 1. ICE CAP
         * --------------------------------
         *
         * Permanent ice.
         *
         * No melting even under sunlight.
         */
        if (baseTemperature < 0.0F) {
            return false;
        }

        /*
         * --------------------------------
         * 2. SUNLIGHT
         * --------------------------------
         */

        if (world.getLightFor(
                LightType.SKY,
                pos
        ) <= 11) {
            return false;
        }

        float temperature =
                biome.getTemperature(pos);

        /*
         * --------------------------------
         * 3. BASE MELTING CHANCE
         * --------------------------------
         *
         * This is the normal climatic
         * melting behavior.
         */

        float meltChance;

        if (temperature >= 0.90F) {

            meltChance = 1.0F;

        } else if (temperature <= 0.64F) {

            meltChance = 0.10F;

        } else {

            float normalized =
                    (temperature - 0.64F) / 0.26F;

            meltChance =
                    0.10F + normalized * 0.90F;
        }

        /*
         * --------------------------------
         * 4. WINTER MELTING
         * --------------------------------
         *
         * Only warm climates get the
         * special winter melting behavior.
         */
        String phase =
                SeasonalPhase.getPhase(
                        world.getDayTime()
                );

        boolean winter =
                phase.equals("EARLY_WINTER")
                        || phase.equals("MID_WINTER")
                        || phase.equals("LATE_WINTER");

        if (winter && baseTemperature > 0.70F) {

            float winterSnowChance =
                    SnowfallHandler.getSnowChance(
                            biome,
                            pos,
                            world
                    );

            /*
             * More winter snow =
             * less ice melting.
             */
            meltChance *= (1.0F
                    - winterSnowChance * 0.75F);
        }

        return random.nextFloat() < meltChance;
    }
}
