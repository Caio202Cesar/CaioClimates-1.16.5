package com.caiocesarmods.caioclimates.HardinessZones;

import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

//I'm not able to pitch up general java knowledge and turn it on complex things.
public class PlantClimateConditionsRegistry {
    private static final Map<Block, SaplingHardiness> RANGES = new HashMap<>();
    private static final Map<ResourceLocation, SaplingHardiness> MOD_RANGES = new HashMap<>();

    public static void register(Block sapling,
                                int minZone,
                                int maxZone,
                                SummerHeat minSummerHeat,
                                SummerHeat maxSummerHeat,
                                Biome.RainType restrictedRainType) {
        RANGES.put(sapling, new SaplingHardiness(minZone, maxZone, minSummerHeat, maxSummerHeat, restrictedRainType));
    }

    public static void registerModPlants(ResourceLocation plant,
                                int minZone,
                                int maxZone,
                                SummerHeat minSummerHeat,
                                SummerHeat maxSummerHeat,
                                Biome.RainType restrictedRainType) {
        MOD_RANGES.put(plant, new SaplingHardiness(minZone, maxZone, minSummerHeat, maxSummerHeat, restrictedRainType));
    }

    static {
        // Vanilla saplings
        register(Blocks.OAK_SAPLING, 4, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, null);
        register(Blocks.SPRUCE_SAPLING, 1, 7, SummerHeat.COOLER, SummerHeat.WARM, null);
        register(Blocks.BIRCH_SAPLING, 2, 8, SummerHeat.COOLER, SummerHeat.WARM, null);
        register(Blocks.JUNGLE_SAPLING, 11, 12, SummerHeat.WARM, SummerHeat.VERY_HOT, Biome.RainType.NONE); //Max zone 11 because of cacao
        register(Blocks.ACACIA_SAPLING, 9, 12, SummerHeat.MILD, SummerHeat.SCORCHING, Biome.RainType.RAIN);
        register(Blocks.DARK_OAK_SAPLING, 4, 9, SummerHeat.MILD, SummerHeat.VERY_HOT, Biome.RainType.NONE);

        // Your custom saplings can also be registered
        // register(TreeBlocks.FIG_SAPLING.get(), 7, 10);
    }

    static {
        // Caio Cesar's Biomes
        registerModPlants(new ResourceLocation("caiocesarbiomes", "acerola_sapling"),
                4, 10, SummerHeat.MILD, SummerHeat.VERY_HOT, null);


        // Your custom saplings can also be registered
        // register(TreeBlocks.FIG_SAPLING.get(), 7, 10);
    }

    public static String getConditionsForPlant(ResourceLocation id) {
        return MOD_RANGES.getOrDefault(id, new SaplingHardiness(minZone, maxZone, minSummerHeat, maxSummerHeat, restrictedRainType));
    }

    public static boolean isRegistered(Block sapling) {
        return RANGES.containsKey(sapling);
    }

    public static boolean isSuitable(Block sapling, World world, BlockPos pos) {
        SaplingHardiness range = RANGES.get(sapling);

        if (range == null) {
            return true;
        }

        // Hardiness zone
        int zone = HardinessZones.getZone(world, pos);

        if (!range.isSuitable(zone)) {
            return false;
        }

        // Summer heat
        Biome biome = world.getBiome(pos);

        SummerHeat summerHeat = SummerHeat.fromTemperature(
                biome.getTemperature(pos)
        );

        if (!range.isSuitableSummerHeat(summerHeat)) {
            return false;
        }

        // RainType
        Biome.RainType rainType = biome.getPrecipitation();

        if (range.getRestrictedRainType() != null
                && rainType == range.getRestrictedRainType()) {
            return false;
        }

        return true;
    }

    public static String getUnsuitableMessage(Block sapling, World world, BlockPos pos) {
        SaplingHardiness range = RANGES.get(sapling);

        if (range == null) {
            return null;
        }

        Biome biome = world.getBiome(pos);

        // Hardiness zone
        int zone = HardinessZones.getZone(world, pos);

        if (zone < range.getMinZone()) {
            return "The winters here are too cold for this sapling.";
        }

        if (zone > range.getMaxZone()) {
            return "The winters here are too hot for this sapling.";
        }

        // Summer heat
        SummerHeat summerHeat = SummerHeat.fromTemperature(
                biome.getTemperature(pos)
        );

        if (range.getMinSummerHeat() != null
                && summerHeat.ordinal() < range.getMinSummerHeat().ordinal()) {
            return "The summers here are too cold for this sapling.";
        }

        if (range.getMaxSummerHeat() != null
                && summerHeat.ordinal() > range.getMaxSummerHeat().ordinal()) {
            return "The summers here are too hot for this sapling.";
        }

        // RainType
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

