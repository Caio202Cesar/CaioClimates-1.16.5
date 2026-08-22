package com.caiocesarmods.caioclimates.HardinessZones.PlantProtection;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class PlantShelteringHandler {

    //Protection for plants and saplings
    private boolean isPlantSheltered(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable checkPos = new BlockPos.Mutable(pos.getX(), pos.getY() + 1, pos.getZ());

        while (checkPos.getY() < world.getHeight()) {

            BlockState stateAbove = world.getBlockState(checkPos);

            if (stateAbove.isAir() || stateAbove.getBlock() instanceof VineBlock) {
                checkPos.move(Direction.UP);
                continue;
            }

            // Any block overhead shelters the plant.
            return true;
        }

        return false;
    }

    /// (radius 2 → 5x5 small green house)
    /// (radius 3 → 7x7 medium green house)
    /// (radius 4 → 9x9 large green house)

    //2x2 glass protection
    private boolean isUnderGlass5x5(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // Step 1: Find the first block above that blocks the sky (roof height)
        int roofY = -1;

        for (int y = pos.getY() + 1; y < world.getHeight(); y++) {
            mutable.setPos(pos.getX(), y, pos.getZ());

            if (!world.isAirBlock(mutable)) {
                roofY = y;
                break;
            }
        }

        if (roofY == -1) {
            return false; // No roof found
        }

        int radius = 2;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                mutable.setPos(pos.getX() + x, roofY, pos.getZ() + z);
                BlockState state = world.getBlockState(mutable);

                if (!(state.getBlock() instanceof GlassBlock)) {
                    return false; // If any block is not glass → fail
                }
            }
        }
        return true; // Entire roof area is glass
    }

    //7x7 glass protection
    private boolean isUnderGlass7x7(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // Step 1: Find the first block above that blocks the sky (roof height)
        int roofY = -1;

        for (int y = pos.getY() + 1; y < world.getHeight(); y++) {
            mutable.setPos(pos.getX(), y, pos.getZ());

            if (!world.isAirBlock(mutable)) {
                roofY = y;
                break;
            }
        }

        if (roofY == -1) {
            return false; // No roof found
        }

        int radius = 3;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                mutable.setPos(pos.getX() + x, roofY, pos.getZ() + z);
                BlockState state = world.getBlockState(mutable);

                if (!(state.getBlock() instanceof GlassBlock)) {
                    return false; // If any block is not glass → fail
                }
            }
        }
        return true; // Entire roof area is glass
    }

    //9x9 glass protection
    private boolean isUnderGlass9x9(ServerWorld world, BlockPos pos) {

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // Step 1: Find the first block above that blocks the sky (roof height)
        int roofY = -1;

        for (int y = pos.getY() + 1; y < world.getHeight(); y++) {
            mutable.setPos(pos.getX(), y, pos.getZ());

            if (!world.isAirBlock(mutable)) {
                roofY = y;
                break;
            }
        }

        if (roofY == -1) {
            return false; // No roof found
        }

        int radius = 4;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                mutable.setPos(pos.getX() + x, roofY, pos.getZ() + z);
                BlockState state = world.getBlockState(mutable);

                if (!(state.getBlock() instanceof GlassBlock)) {
                    return false; // If any block is not glass → fail
                }
            }
        }
        return true; // Entire roof area is glass
    }
}
