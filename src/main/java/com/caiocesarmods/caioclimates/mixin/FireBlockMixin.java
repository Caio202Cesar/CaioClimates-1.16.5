package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.block.ModBlocks;
import com.caiocesarmods.caioclimates.tags.ModBlockTags;
import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(FireBlock.class)
public class FireBlockMixin {

    @Inject(
            method = "tryCatchFire",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;removeBlock(Lnet/minecraft/util/math/BlockPos;Z)Z"
            ),
            cancellable = true
    )

    private void changeFlammableBlockTick(World worldIn, BlockPos pos, int chance, Random random, int age, Direction face, CallbackInfo ci) {
        BlockState blockstate = worldIn.getBlockState(pos);

        if (blockstate.isIn(BlockTags.LOGS)) {
            BlockState charredLog = ModBlocks.CHARRED_LOG.get().getDefaultState();

            if (blockstate.hasProperty(RotatedPillarBlock.AXIS)) {
                charredLog = charredLog.with(
                        RotatedPillarBlock.AXIS,
                        blockstate.get(RotatedPillarBlock.AXIS)
                );
            }
            worldIn.setBlockState(pos, charredLog, 3);
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.CAN_BURN_TO_BRANCHES)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.CHARRED_BRANCHES.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.BRANCHES)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.CHARRED_BRANCHES.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.BROAD_LEAVES_LARGE)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.SCORCHED_LARGE_BROAD_LEAVES.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.BROAD_LEAVES_SHORT)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.SCORCHED_SMALL_BROAD_LEAVES.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.CONIFER_LEAVES)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.SCORCHED_CONIFER_LEAVES.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.PALM_LONG_FRONDS)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.SCORCHED_LARGE_PALM_FROND.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        if (blockstate.isIn(ModBlockTags.PALM_SHORT_FRONDS)) {
            worldIn.setBlockState(
                    pos,
                    ModBlocks.SCORCHED_SHORT_PALM_FROND.get().getDefaultState(),
                    3
            );
            ci.cancel();
        }

        /*
        if (blockstate.isIn(BlockTags.LEAVES)) {
            if (random.nextFloat() < 0.8F) {
                // Don't destroy this tick.
                ci.cancel();
            }
        }*/
    }
}
