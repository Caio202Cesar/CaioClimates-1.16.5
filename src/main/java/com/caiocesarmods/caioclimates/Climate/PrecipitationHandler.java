package com.caiocesarmods.caioclimates.Climate;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class PrecipitationHandler {

    public static Biome.RainType getPrecipitation(
            Biome biome,
            BlockPos pos,
            World world
    ) {

        /*
         * ====================================================
         * GLOBAL WEATHER
         * ====================================================
         */

        if (!world.isRaining()) {
            return Biome.RainType.NONE;
        }


        /*
         * ====================================================
         * DROUGHT PATTERN
         * ====================================================
         */

        DroughtPattern droughtPattern =
                DroughtPatternRegistry.get(biome);

        if (droughtPattern != null) {

            /*
             * The drought pattern determines whether this
             * location currently has a rainfall event.
             */

            if (!DroughtHandler.shouldRain(
                    biome,
                    world
            )) {
                return Biome.RainType.NONE;
            }

            /*
             * It is currently a wet period.
             *
             * Now determine whether that precipitation
             * falls as rain or snow.
             */

            if (SnowfallHandler.shouldSnow(
                    biome,
                    pos,
                    world
            )) {
                return Biome.RainType.SNOW;
            }

            return Biome.RainType.RAIN;
        }


        /*
         * ====================================================
         * NORMAL RAIN BIOMES
         * ====================================================
         */

        if (biome.getPrecipitation()
                == Biome.RainType.RAIN) {

            /*
             * Normal rainy biome, but our climate system
             * can transform the precipitation into snow.
             */

            if (SnowfallHandler.shouldSnow(
                    biome,
                    pos,
                    world
            )) {
                return Biome.RainType.SNOW;
            }

            return Biome.RainType.RAIN;
        }


        /*
         * ====================================================
         * OTHER BIOMES
         * ====================================================
         */

        return Biome.RainType.NONE;
    }
}
