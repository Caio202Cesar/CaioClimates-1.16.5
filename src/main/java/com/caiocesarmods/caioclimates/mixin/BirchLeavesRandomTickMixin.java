package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.block.ModBlocks;
import com.caiocesarmods.caioclimates.Seasons.Season;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(LeavesBlock.class)
public abstract class BirchLeavesRandomTickMixin {

    @Inject(
            method = "ticksRandomly",
            at = @At("HEAD"),
            cancellable = true
    )
    private void makeBirchLeavesRandomTick(
            CallbackInfoReturnable<Boolean> cir) {

        LeavesBlock block = (LeavesBlock) (Object) this;

        if (block == Blocks.BIRCH_LEAVES) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )
    private void birchLeavesSeasonalTick(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random,
            CallbackInfo ci) {

        if (state.getBlock() != Blocks.BIRCH_LEAVES) {
            return;
        }

        String season = Season.getSeason(world.getDayTime());

        if (season.equals("FALL")) {

            if (random.nextInt(30) == 0) {
                world.setBlockState(
                        pos,
                        ModBlocks.BIRCH_FALL_LEAVES.get().getDefaultState(),
                        3
                );
            }

        } else if (season.equals("WINTER")) {

            if (random.nextInt(15) == 0) {
                world.setBlockState(
                        pos,
                        ModBlocks.BIRCH_FALL_LEAVES.get().getDefaultState(),
                        3
                );
            }
        }
    }
}
