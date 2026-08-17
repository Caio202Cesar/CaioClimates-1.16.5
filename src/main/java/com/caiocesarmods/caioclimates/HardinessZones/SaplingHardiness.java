package com.caiocesarmods.caioclimates.HardinessZones;

import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import net.minecraft.world.biome.Biome;

public class SaplingHardiness {
    private final int minZone;
    private final int maxZone;

    private final SummerHeat minSummerHeat;
    private final SummerHeat maxSummerHeat;

    private final Biome.RainType restrictedRainType;

    public SaplingHardiness(int minZone,
                            int maxZone,
                            SummerHeat minSummerHeat,
                            SummerHeat maxSummerHeat,
                            Biome.RainType restrictedRainType) {

        this.minZone = minZone;
        this.maxZone = maxZone;
        this.minSummerHeat = minSummerHeat;
        this.maxSummerHeat = maxSummerHeat;
        this.restrictedRainType = restrictedRainType;
    }

    public boolean isSuitable(int zone) {
        return zone >= minZone && zone <= maxZone;
    }

    public int getMinZone() {return minZone;}

    public int getMaxZone() {return maxZone;}

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