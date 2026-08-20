package com.caiocesarmods.caioclimates.HardinessZones;

import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeatHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

//I'm not able to pitch up general java knowledge and turn it on complex things.
public class PlantClimateConditionsRegistry {
    private static final Map<ResourceLocation, SaplingHardiness> RANGES = new HashMap<>();

    public static void register(ResourceLocation sapling,
                                int minZone,
                                int maxZone,
                                SummerHeat minSummerHeat,
                                SummerHeat maxSummerHeat,
                                Biome.RainType restrictedRainType) {
        RANGES.put(sapling, new SaplingHardiness(minZone, maxZone, minSummerHeat, maxSummerHeat, restrictedRainType));
    }

    static {

        // Vanilla saplings
        register(new ResourceLocation("minecraft", "oak_sapling"),
                4, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, null);
        register(new ResourceLocation("minecraft", "spruce_sapling"),
                1, 7, SummerHeat.COOLER, SummerHeat.WARM, null);
        register(new ResourceLocation("minecraft", "birch_sapling"),
                2, 8, SummerHeat.COOLER, SummerHeat.WARM, null);
        register(new ResourceLocation("minecraft", "jungle_sapling"),
                11, 12, SummerHeat.WARM, SummerHeat.VERY_HOT, Biome.RainType.NONE); //Max zone 11 because of cacao
        register(new ResourceLocation("minecraft", "acacia_sapling"),
                9, 12, SummerHeat.MILD, SummerHeat.SCORCHING, Biome.RainType.RAIN);
        register(new ResourceLocation("minecraft", "dark_oak_sapling"),
                4, 9, SummerHeat.MILD, SummerHeat.VERY_HOT, Biome.RainType.NONE);
        register(new ResourceLocation("minecraft", "bamboo_sapling"),
                4, 12, SummerHeat.MILD, SummerHeat.VERY_HOT, null);

        // Caio Cesar's Biomes saplings
        /*
        register(new ResourceLocation("caiocesarbiomes", "acerola_sapling"),
                4, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, null);
        register(new ResourceLocation("caiocesarbiomes", "agathis_sapling"),
                8, 12, SummerHeat.MILD, SummerHeat.VERY_HOT, Biome.RainType.NONE);
        register(new ResourceLocation("caiocesarbiomes", "almond_sapling"),
                5, 10, SummerHeat.WARM, SummerHeat.SCORCHING, Biome.RainType.RAIN);*/

    }

    public static int getMinWinterHardinessForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMinZone();
    }

    public static int getMaxWinterHardinessForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMaxZone();
    }

    public static SummerHeat getMinSummerHeatForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMinSummerHeat();
    }

    public static SummerHeat getMaxSummerHeatForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getMaxSummerHeat();
    }

    public static Biome.RainType getWrongRainTypeForPlant(ResourceLocation sapling) {
        SaplingHardiness range = RANGES.get(sapling);
        return range.getRestrictedRainType();
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

        if (range.getRestrictedRainType() == rainType) {

            if (rainType == Biome.RainType.NONE) {
                return "This biome is too dry for this sapling.";
            }

            if (rainType == Biome.RainType.RAIN) {
                return "This biome is too wet for this sapling.";
            }
        }

        return null;
    }
}

