package com.caiocesarmods.caioclimates.block.SeasonalLeaves;

import com.caiocesarmods.caioclimates.Seasons.FruitSeason;
import net.minecraft.block.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

//Stage 0 = appear normal leaves
//Stage 1 = fruit start growing/appears small and green on tree
//Stage 2 = green fruit
//Stage 3 = ripe fruit
public class CropLeavesBlock extends LeavesBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    private final FruitSeason fruitSeason;
    private final Supplier<Block> nextStage;
    private final Supplier<Item> fruitItem;

    public CropLeavesBlock(LeavesBlock.Properties builder, FruitSeason fruitSeason, Supplier<Block> nextStage, Supplier<Item> fruitItem) {
        super(builder);
        this.setDefaultState(this.getDefaultState().with(AGE, 0));
        this.fruitSeason = fruitSeason;
        this.nextStage = nextStage;
        this.fruitItem = fruitItem;
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

        if (age < getMaxAge()) {
            if (fruitSeason.canGrow(worldIn)) {
                float chance = fruitSeason.getGrowthChance(worldIn);

                if (chance > 0.0F && random.nextInt((int) (20.0F / chance) + 1) == 0) {
                    worldIn.setBlockState(pos, withAge(state, age + 1), 2);
                }
            }

            //If the fruit tree is not on its fruit season, but the fruitinh block is < getMaxAge() --> abort and turn into normal leaves.
            if (!fruitSeason.canGrow(worldIn)) {
                int distance = state.get(LeavesBlock.DISTANCE);
                boolean persistent = state.get(LeavesBlock.PERSISTENT);

                BlockState newState = nextStage.get().getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent);

                worldIn.setBlockState(pos, newState, 2);
            }
        }

        else if (fruitSeason.isFruitRipeSeason(worldIn)) {
            if(!isMaxAge(state)) {
                worldIn.setBlockState(pos, withAge(state, getMaxAge()), 2);
            }
            return;
        }

        else if (fruitSeason.isHarvestSeason(worldIn) && age == getMaxAge() && nextStage != null) {
            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            BlockState newState = nextStage.get().getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent);

            worldIn.setBlockState(pos, newState, 2);

            Item item = fruitItem.get();
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, item.getDefaultInstance());
            worldIn.addEntity(itemEntity);

        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && isMaxAge(state)) {

            int distance = state.get(LeavesBlock.DISTANCE);
            boolean persistent = state.get(LeavesBlock.PERSISTENT);

            Item item = fruitItem.get();
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, item.getDefaultInstance());

            worldIn.addEntity(itemEntity);

            BlockState newState = nextStage.get().getDefaultState().with(LeavesBlock.DISTANCE, distance).with(LeavesBlock.PERSISTENT, persistent);
            worldIn.setBlockState(pos, newState, 2);

            worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

        }
        return ActionResultType.SUCCESS;
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
