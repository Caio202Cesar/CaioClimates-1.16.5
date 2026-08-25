package com.caiocesarmods.caioclimates.block.BurntBlocks;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

public class CharredLog extends RotatedPillarBlock {
    public CharredLog() {
        super(AbstractBlock.Properties.from(Blocks.OAK_LOG).sound(SoundType.WOOD).hardnessAndResistance(1.2f)
                .harvestTool(ToolType.AXE));
    }

    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 0;
    }

    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 10;
    }

    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
        return true;
    }
}
