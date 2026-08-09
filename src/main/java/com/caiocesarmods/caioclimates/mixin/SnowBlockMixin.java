package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.SnowMeltHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SnowBlock.class)
public abstract class SnowBlockMixin {

    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )
    private void climateSnowMelt(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random,
            CallbackInfo ci
    ) {

        if (SnowMeltHandler.shouldMelt(world, pos)) {
            world.removeBlock(pos, false);
        }
    }
}
