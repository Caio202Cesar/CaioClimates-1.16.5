package com.caiocesarmods.caioclimates.Climate;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class DroughtHandler {

    public static boolean shouldRain(
            Biome biome,
            BlockPos pos,
            ClientWorld world
    ) {
        DroughtPattern pattern =
                DroughtPatternRegistry.get(biome);

        /*
         * This biome has no custom drought pattern.
         *
         * Therefore, preserve vanilla behavior.
         */
        if (pattern == null) {
            return biome.getPrecipitation() != Biome.RainType.NONE;
        }

        /*
         * The global Minecraft weather event must
         * actually be rain.
         */
        if (!world.isRaining()) {
            return false;
        }

        String phase =
                SeasonalPhase.getPhase(world.getDayTime());

        switch (pattern) {

            case DRY_SUMMER:
                return shouldRainDrySummer(phase);

            case SEMI_ARID:
                return shouldRainSemiArid(phase);

            case ARID:
                return shouldRainArid(phase);

            default:
                return false;
        }
    }

    private static boolean shouldRainDrySummer(String phase) {

        switch (phase) {
            case "EARLY_SPRING":
            case "MID_SPRING":
                return false;

            case "LATE_SPRING":
                return false;

            case "EARLY_SUMMER":
                return false;

            case "MID_SUMMER":
                return false;

            case "LATE_SUMMER":
                return false;

            case "EARLY_FALL":
                return false;

            case "MID_FALL":
                return true;

            case "LATE_FALL":
                return true;

            case "EARLY_WINTER":
            case "MID_WINTER":
            case "LATE_WINTER":
                return true;

            default:
                return false;
        }
    }

    private static boolean shouldRainSemiArid(String phase) {
        // We'll tune this separately.
        return true;
    }

    private static boolean shouldRainArid(String phase) {
        // We'll tune this separately.
        return false;
    }
}
