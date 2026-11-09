package com.caiocesarmods.caioclimates.block.SeasonalLeaves;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPatternRegistry;
import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import com.caiocesarmods.caioclimates.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.Random;

public class AcaciaBranches extends LeavesBlock implements IForgeShearable {
    private final Block nextStage;

    public AcaciaBranches(Properties properties, Block nextStage) {
        super(properties);
        this.nextStage = nextStage;
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {

        Biome biome = worldIn.getBiome(pos);

        DroughtPattern pattern = DroughtPatternRegistry.get(biome);

        if (pattern == null) {
            return;
        }

        String phase = SeasonalPhase.getPhase(worldIn.getDayTime());
        float rainChance = pattern.getRainChance(SeasonalPhase.valueOf(phase));

        if (rainChance > 0.50F && random.nextFloat() < rainChance) {

            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            worldIn.setBlockState(
                    pos,
                    Blocks.ACACIA_LEAVES.getDefaultState()
                            .with(LeavesBlock.DISTANCE, distance)
                            .with(LeavesBlock.PERSISTENT, persistent),
                    3
            );
        }
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 90;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 100;
    }
}