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
        /*
         * --------------------------------
         * 1. SUNLIGHT
         * --------------------------------
         *
         * Ice can melt when exposed to
         * sufficiently strong sunlight.
         */
        if (world.getLightFor(
                LightType.SKY,
                pos
        ) <= 11) {
            return false;
        }

        Biome biome = world.getBiome(pos);

        float temperature =
                biome.getTemperature(pos);

        /*
         * --------------------------------
         * 2. BASE MELTING CHANCE
         * --------------------------------
         *
         * Warm biomes melt ice readily.
         * Colder biomes preserve it longer.
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
         * 3. COLD WINTER MODIFIER
         * --------------------------------
         *
         * If the biome is cold enough to
         * sustain snowfall throughout
         * winter, ice is more persistent.
         */
        String phase =
                SeasonalPhase.getPhase(
                        world.getDayTime()
                );

        if (phase.equals("EARLY_WINTER")
                || phase.equals("MID_WINTER")
                || phase.equals("LATE_WINTER")) {

            float winterSnowChance =
                    SnowfallHandler.getSnowChance(
                            biome,
                            pos,
                            world
                    );

            /*
             * High winter snow probability
             * means a colder climate.
             *
             * Reduce sunlight melting.
             */
            meltChance *=
                    (1.0F - winterSnowChance * 0.75F);
        }

        return random.nextFloat() < meltChance;
    }
}
