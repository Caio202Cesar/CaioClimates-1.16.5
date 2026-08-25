package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static net.minecraft.block.AbstractFireBlock.getFireForPlacement;
import static net.minecraft.block.FireBlock.AGE;

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
        int i = worldIn.getBlockState(pos).getFlammability(worldIn, pos, face);
        if (random.nextInt(chance) < i) {
            BlockState blockstate = worldIn.getBlockState(pos);

            if (random.nextInt(age + 10) < 5 && !worldIn.isRainingAt(pos)) {
                int j = Math.min(age + random.nextInt(5) / 4, 15);
                worldIn.setBlockState(pos, this.caioClimates_1_16_5$getFireWithAge(worldIn, pos, j), 3);
            } else if (blockstate.isIn(BlockTags.LOGS)) {
                BlockState charred = ModBlocks.CHARRED_LOG.get().getDefaultState();

                if (blockstate.hasProperty(RotatedPillarBlock.AXIS)) {
                    charred = charred.with(
                            RotatedPillarBlock.AXIS,
                            blockstate.get(RotatedPillarBlock.AXIS)
                    );
                }

                worldIn.setBlockState(pos, charred, 3);
                ci.cancel();
            }

            blockstate.catchFire(worldIn, pos, face, null);
        }

        ci.cancel();
    }

    @Unique
    private BlockState caioClimates_1_16_5$getFireWithAge(IWorld world, BlockPos pos, int age) {
        BlockState blockstate = getFireForPlacement(world, pos);
        return blockstate.matchesBlock(Blocks.FIRE) ? blockstate.with(AGE, Integer.valueOf(age)) : blockstate;
    }
}
