package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.JungleTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(BigTree.class)
public class JungleTreeMixin {
    @Inject(
            method = "growBigTree",
            at = @At("HEAD")
    )

    private void cancelGrowthFromSapling(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos,
                                         BlockState state, Random rand, int branchX, int branchY,
                                         CallbackInfoReturnable<Boolean> cir) {

        Biome biome = world.getBiome(pos);

        if (biome.getPrecipitation() == Biome.RainType.NONE) {
            if ((Object)this instanceof JungleTree) {
                return;
            }
        }
    }
}
