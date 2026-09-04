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

public class PlantClimateConditionsRegistry {
    private static final Map<ResourceLocation, SaplingHardiness> RANGES = new HashMap<>();

    public static void register(ResourceLocation sapling,
                                int minZone,
                                int maxZone,
                                int minSaplingWinterHardiness,
                                SummerHeat minSummerHeat,
                                SummerHeat maxSummerHeat,
                                SummerHeat maxSaplingSummerHardiness,
                                Biome.RainType restrictedRainType,
                                DroughtPattern... restrictedDroughtPatterns) {
        RANGES.put(sapling, new SaplingHardiness(minZone, maxZone, minSaplingWinterHardiness, minSummerHeat, maxSummerHeat,
                maxSaplingSummerHardiness, restrictedRainType, restrictedDroughtPatterns));
    }

    static {

        // Vanilla saplings
        register(new ResourceLocation("minecraft", "oak_sapling"),
                3, 10, 5, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT, null);
        register(new ResourceLocation("minecraft", "spruce_sapling"),
                1, 7, 1, SummerHeat.COOLER, SummerHeat.HOT, SummerHeat.HOT, null);
        register(new ResourceLocation("minecraft", "birch_sapling"),
                2, 7, 3, SummerHeat.COOLER, SummerHeat.WARM, SummerHeat.WARM,null);
        register(new ResourceLocation("minecraft", "jungle_sapling"),
                11, 12, 11, SummerHeat.WARM, SummerHeat.VERY_HOT, SummerHeat.HOT, null); //Max zone 11 because of cacao
        register(new ResourceLocation("minecraft", "acacia_sapling"),
                9, 12, 10, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.SCORCHING, Biome.RainType.RAIN);
        register(new ResourceLocation("minecraft", "dark_oak_sapling"),
                3, 9, 5, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT, Biome.RainType.NONE);
        register(new ResourceLocation("minecraft", "bamboo_sapling"),
                4, 12, 7, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT, null);

        // Caio Cesar's Biomes saplings
        register(new ResourceLocation("caiocesarbiomes", "acerola_sapling"),
                9, 12, 10, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.VERY_HOT, null);

        register(new ResourceLocation("caiocesarbiomes", "agathis_sapling"),
                8, 12, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT, Biome.RainType.NONE);

        register(new ResourceLocation("caiocesarbiomes", "aleppo_pine_sapling"),
                8, 10, 8, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.SCORCHING, Biome.RainType.RAIN);

        register(new ResourceLocation("caiocesarbiomes", "almond_sapling"),
                5, 10, 8, SummerHeat.WARM, SummerHeat.SCORCHING, SummerHeat.VERY_HOT, Biome.RainType.RAIN);

        register(new ResourceLocation("caiocesarbiomes", "apple_sapling"),
                2, 10, 7, SummerHeat.COOLER, SummerHeat.SCORCHING, SummerHeat.HOT, null);

        register(new ResourceLocation("caiocesarbiomes", "aspen_sapling"),
                2, 7, 3, SummerHeat.COOLER, SummerHeat.WARM, SummerHeat.WARM,null);

        register(new ResourceLocation("caiocesarbiomes", "avocado_sapling"),
                8, 12, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT, null);

        register(new ResourceLocation("caiocesarbiomes", "bald_cypress_sapling"),
                4, 11, 5, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT, null);

        register(new ResourceLocation("caiocesarbiomes", "banana_sapling"),
                9, 12, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT, Biome.RainType.NONE);

        register(new ResourceLocation("caiocesarbiomes", "baobab_sapling"),
                10, 12, 11, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.VERY_HOT, Biome.RainType.RAIN);

        register(new ResourceLocation("caiocesarbiomes", "bismarck_palm_sapling"),
                9, 12, 10, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.SCORCHING, null);

        register(new ResourceLocation("caiocesarbiomes", "black_poplar_sapling"),
                2, 10, 4, SummerHeat.COOLER, SummerHeat.SCORCHING, SummerHeat.VERY_HOT, null);

        //Needs allowed DroughtPattern
        register(new ResourceLocation("caiocesarbiomes", "blackwood_acacia_sapling"),
                8, 10, 9, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);



        register(new ResourceLocation("caiocesarbiomes", "cinnamon_sapling"),
                10, 12, 11, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.HOT, Biome.RainType.NONE);


        register(new ResourceLocation("caiocesarbiomes", "durian_sapling"),
                11, 12, 11, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.HOT, Biome.RainType.NONE);
    }

    public static int getMinWinterHardinessForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMinZone();
    }

    public static int getMaxWinterHardinessForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMaxZone();
    }

    public static int getMinWinterHardinessForSapling(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMinSaplingWinterHardiness();
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

        return null;
    }
}

