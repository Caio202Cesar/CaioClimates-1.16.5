package com.caiocesarmods.caioclimates.block.SeasonalLeaves;

import com.caiocesarmods.caiocesarbiomes.Seasons.FruitSeason;
import net.minecraft.block.*;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

//Stage 0 = normal leaves
//Stage 1 = fruit start growing/appears small and green on tree
//Stage 2 = green fruit
//Stage 3 = ripe fruit

public class CropLeavesBlock extends LeavesBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    private final FruitSeason fruitSeason;
    private final Supplier<Block> nextStage;

    public CropLeavesBlock(LeavesBlock.Properties builder, FruitSeason fruitSeason, Supplier<Block> nextStage) {
        super(builder);
        this.setDefaultState(this.getDefaultState().with(AGE, 0));
        this.fruitSeason = fruitSeason;
        this.nextStage = nextStage;
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    protected int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    public BlockState withAge(BlockState state, int age) {
        return state.with(AGE, age);
    }

    public boolean isMaxAge(BlockState state) {
        return state.get(this.getAgeProperty()) >= this.getMaxAge();
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return !this.isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random); // keeps leaf decay working

        int age = state.get(AGE);

        if (fruitSeason.canGrow(worldIn) && age < getMaxAge()) {
            float chance = fruitSeason.getGrowthChance(worldIn);

            if (chance > 0.0F && random.nextInt((int)(20.0F / chance) + 1) == 0) {
                worldIn.setBlockState(pos, withAge(state, age + 1), 2);
            }
        }

        else if (fruitSeason.isFruitRipeSeason(worldIn)) {
            if(!isMaxAge(state)) {
                worldIn.setBlockState(pos, withAge(state, getMaxAge()), 2);
            }
            return;
        }

        else if (fruitSeason.isFruitRipeSeason(worldIn) && nextStage != null) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            BlockState newState = nextStage.get().getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent);

            worldIn.setBlockState(pos, newState, 2);
        }
    }

    public void grow(World worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(state, i), 2);
    }

    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.rand, 2, 5);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(AGE);
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return !this.isMaxAge(state);
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.grow(worldIn, pos, state);
    }
}
