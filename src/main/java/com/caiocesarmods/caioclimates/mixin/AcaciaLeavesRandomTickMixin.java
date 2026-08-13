package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.block.ModBlocks;
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
public abstract class AcaciaLeavesRandomTickMixin {

    @Inject(
            method = "ticksRandomly",
            at = @At("HEAD"),
            cancellable = true
    )
    private void makeAcaciaLeavesRandomTick(
            CallbackInfoReturnable<Boolean> cir) {

        LeavesBlock block = (LeavesBlock) (Object) this;

        if (block == Blocks.ACACIA_LEAVES) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )
    private void acaciaLeavesSeasonalTick(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random,
            CallbackInfo ci) {

        if (state.getBlock() != Blocks.ACACIA_LEAVES) {
            return;
        }

        String season = Season.getSeason(world.getDayTime());

        if (season.equals("SUMMER")) {

            if (random.nextInt(20) == 0) {
                world.setBlockState(
                        pos,
                        ModBlocks.ACACIA_BRANCHES.get().getDefaultState(),
                        3
                );
            }

        } else if (season.equals("FALL")) {

            if (random.nextInt(2) == 0) {
                world.setBlockState(
                        pos,
                        ModBlocks.ACACIA_BRANCHES.get().getDefaultState(),
                        3
                );
            }
        }
    }
}
