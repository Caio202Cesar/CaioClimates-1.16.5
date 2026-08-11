package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.Winter.FrostSmeltingHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(IceBlock.class)
public abstract class IceBlockMixin {

    @Inject(
            method = "randomTick",
            at = @At("HEAD"),
            cancellable = true
    )
    private void climateIceMelt(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random,
            CallbackInfo ci
    ) {

        if (FrostSmeltingHandler.shouldMelt(
                world,
                pos,
                state,
                random
        )) {
            world.setBlockState(
                    pos,
                    Blocks.WATER.getDefaultState()
            );
        }

        ci.cancel();
    }
}
