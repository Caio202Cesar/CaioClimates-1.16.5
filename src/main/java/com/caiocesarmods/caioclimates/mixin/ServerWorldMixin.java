package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.SnowfallHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

    @Redirect(
            method = "tickEnvironment",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/Biome;doesSnowGenerate(Lnet/minecraft/world/IWorldReader;Lnet/minecraft/util/math/BlockPos;)Z"
            )
    )
    private boolean modifySnowGeneration(
            Biome biome,
            IWorldReader worldReader,
            BlockPos pos
    ) {
        ServerWorld world = (ServerWorld) (Object) this;

        float snowChance =
                SnowfallHandler.getSnowChance(
                        biome,
                        pos,
                        world
                );

        return world.rand.nextFloat() < snowChance;
    }
}