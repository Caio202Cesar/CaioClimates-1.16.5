package com.caiocesarmods.caioclimates.HardinessZones;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class SaplingHardinessRegistry {
    private static final Map<Block, int[]> RANGES = new HashMap<>();

    static {
        // Vanilla saplings
        register(Blocks.OAK_SAPLING, 4, 10);
        register(Blocks.SPRUCE_SAPLING, 1, 7);
        register(Blocks.BIRCH_SAPLING, 2, 8);
        register(Blocks.JUNGLE_SAPLING, 11, 12); //Max zone 11 because of cacao
        register(Blocks.ACACIA_SAPLING, 9, 12);
        register(Blocks.DARK_OAK_SAPLING, 4, 9);

        // Your custom saplings can also be registered
        // register(TreeBlocks.FIG_SAPLING.get(), 7, 10);
    }

    public static void register(Block sapling, int minZone, int maxZone) {
        RANGES.put(sapling, new int[]{minZone, maxZone});
    }

    public static boolean isRegistered(Block sapling) {
        return RANGES.containsKey(sapling);
    }

    public static boolean isSuitable(Block sapling, World world, BlockPos pos) {
        int[] range = RANGES.get(sapling);

        if (range == null) {
            return true;
        }

        int zone = HardinessZones.getZone(world, pos);

        return zone >= range[0] && zone <= range[1];
    }
}

