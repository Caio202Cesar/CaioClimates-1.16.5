package com.caiocesarmods.caioclimates.HardinessZones;

import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import net.minecraft.world.biome.Biome;

public class SaplingHardiness {
    private final int minZone;
    private final int maxZone;
    private final int minSaplingWinterHardiness;

    private final SummerHeat minSummerHeat;
    private final SummerHeat maxSummerHeat;
    private final SummerHeat maxSaplingSummerHardiness;

    private final Biome.RainType restrictedRainType;

    public SaplingHardiness(int minZone,
                            int maxZone,
                            int minSaplingWinterHardiness,
                            SummerHeat minSummerHeat,
                            SummerHeat maxSummerHeat,
                            SummerHeat maxSaplingSummerHardiness,
                            Biome.RainType restrictedRainType) {

        this.minZone = minZone;
        this.maxZone = maxZone;
        this.minSaplingWinterHardiness = minSaplingWinterHardiness;
        this.minSummerHeat = minSummerHeat;
        this.maxSummerHeat = maxSummerHeat;
        this.maxSaplingSummerHardiness = maxSaplingSummerHardiness;
        this.restrictedRainType = restrictedRainType;
    }

    public boolean isSuitable(int zone) {
        return zone >= minZone && zone <= maxZone;
    }

    public int getMinZone() {return minZone;}

    public int getMaxZone() {return maxZone;}

    //Gives the sheltering need for sapling during winter
    public int getMinSaplingWinterHardiness() {
        return minSaplingWinterHardiness;
    }

    //Gives the sheltering need for sapling during summer
    public SummerHeat getMaxSaplingSummerHardiness() {
        return maxSaplingSummerHardiness;
    }

    //Add also sapling death for inadequate moisture/dryness of biome. There is no sheltering or protection for that.
    //Sapling can only survive based on proximity with water (another parameter, similar to the Weeping Willow one)

    public SummerHeat getMinSummerHeat() {return minSummerHeat;}

    public SummerHeat getMaxSummerHeat() {
        return maxSummerHeat;
    }

    public Biome.RainType getRestrictedRainType() {
        return restrictedRainType;
    }

    public boolean isSuitableSummerHeat(SummerHeat heat) {
        if (minSummerHeat != null && heat.ordinal() < minSummerHeat.ordinal()) {
            return false;
        }

        if (maxSummerHeat != null && heat.ordinal() > maxSummerHeat.ordinal()) {
            return false;
        }

        return true;
    }
}