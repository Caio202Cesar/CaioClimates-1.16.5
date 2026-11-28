package com.caiocesarmods.caioclimates.HardinessZones;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPatternRegistry;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeatHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlantClimateConditions {
    private static final Map<ResourceLocation, SaplingHardiness> RANGES = new HashMap<>();

    public static void register(ResourceLocation sapling,
                                int minZone,
                                int maxZone,
                                int minSaplingWinterHardiness,
                                float minDownfall,
                                float maxDownfall,
                                SummerHeat minSummerHeat,
                                SummerHeat maxSummerHeat,
                                SummerHeat maxSaplingSummerHardiness,
                                Biome.RainType restrictedRainType,
                                DroughtPattern... restrictedDroughtPatterns) {
        RANGES.put(sapling, new SaplingHardiness(minZone, maxZone, minSaplingWinterHardiness, minDownfall, maxDownfall, minSummerHeat, maxSummerHeat,
                maxSaplingSummerHardiness, restrictedRainType, restrictedDroughtPatterns));
    }

    public static int getMinWinterHardinessForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range != null ? range.getMinZone() : -1;
    }

    public static int getMaxWinterHardinessForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range != null ? range.getMaxZone() : -1;
    }

    public static int getMinWinterHardinessForSapling(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range != null ? range.getMinSaplingWinterHardiness() : -1;
    }

    public static float getMinDownfallForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range != null ? range.getMinDownfall() : -1;
    }

    public static float getMaxDownfallForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range != null ? range.getMaxDownfall() : -1;
    }

    public static SummerHeat getMinSummerHeatForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMinSummerHeat();
    }

    public static SummerHeat getMaxSummerHeatForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMaxSummerHeat();
    }

    public static SummerHeat getMaxSummerHeatForSapling(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMaxSaplingSummerHardiness();
    }

    public static Biome.RainType getWrongRainTypeForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getRestrictedRainType();
    }

    public static Set<DroughtPattern> getRestrictedDroughtPatternForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getRestrictedDroughtPatterns();
    }

    public static boolean isRegistered(ResourceLocation sapling) {
        return RANGES.containsKey(sapling);
    }

    public static boolean isSuitable(ResourceLocation sapling, World world, BlockPos pos) {
        SaplingHardiness range = RANGES.get(sapling);

        if (range == null) {
            return true;
        }

        ///Hardiness zone
        int zone = HardinessZones.getZone(world, pos);

        if (!range.isSuitable(zone)) {
            return false;
        }

        ///Summer heat
        Biome biome = world.getBiome(pos);

        SummerHeat summerHeat =
                SummerHeat.fromTemperature(SummerHeatHelper.get(world, pos));

        if (!range.isSuitableSummerHeat(summerHeat)) {return false;}

        ///RainType
        Biome.RainType rainType = biome.getPrecipitation();
        if (range.getRestrictedRainType() != null
                && rainType == range.getRestrictedRainType()) {
            return false;
        }

        DroughtPattern restrictedDroughtPatterns = DroughtPatternRegistry.get(biome);
        Set<DroughtPattern> restrictedPatterns = range.getRestrictedDroughtPatterns();

        if (restrictedDroughtPatterns != null
                && restrictedPatterns.contains(restrictedDroughtPatterns)) {
            return false;
        }

        /// Downfall
        float suitableDownfall = biome.getDownfall();

        if (!range.isDownfallSuitable(suitableDownfall)) {
            return false;
        }

        return true;
    }

    public static String getUnsuitableMessage(ResourceLocation sapling, World world, BlockPos pos) {
        SaplingHardiness range = RANGES.get(sapling);

        if (range == null) {
            return null;
        }

        Biome biome = world.getBiome(pos);

        /// Hardiness zone
        int zone = HardinessZones.getZone(world, pos);

        if (zone < range.getMinZone()) {
            return "The winters here are too cold for this sapling.";
        }

        if (zone > range.getMaxZone()) {
            return "The winters here are too hot for this sapling.";
        }

        /// Summer heat
        SummerHeat summerHeat = SummerHeat.fromTemperature(
                SummerHeatHelper.get(world, pos));

       if (range.getMinSummerHeat() != null
                && summerHeat.ordinal() < range.getMinSummerHeat().ordinal()) {
            return "The summers here are too cold for this sapling.";
        }

        if (range.getMaxSummerHeat() != null
                && summerHeat.ordinal() > range.getMaxSummerHeat().ordinal()) {
            return "The summers here are too hot for this sapling.";
        }

        /// RainType
        Biome.RainType rainType = biome.getPrecipitation();

        DroughtPattern restrictedDroughtPatterns = DroughtPatternRegistry.get(biome);
        Set<DroughtPattern> restrictedPatterns = range.getRestrictedDroughtPatterns();

        if (range.getRestrictedRainType() == rainType) {

            if (rainType == Biome.RainType.NONE) {
                return "This biome is too dry for this sapling.";
            }

            if (rainType == Biome.RainType.RAIN) {
                return "This biome is too wet for this sapling.";
            }

        }

        if (restrictedDroughtPatterns != null && restrictedPatterns != null
                && restrictedPatterns.contains(restrictedDroughtPatterns)) {
            return "This biome is too dry for this sapling.";
        }

        /// Downfall
        float biomeDownfall = biome.getDownfall();

        if (biomeDownfall > range.getMaxDownfall()) {
            return "This biome is too wet for this sapling.";
        }

        if (biomeDownfall < range.getMinDownfall()) {
            return "This biome is too dry for this sapling.";
        }

        return null;
    }
}

