package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.SnowfallHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.LightType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

    static {
        System.out.println("[CaioClimate] ServerWorldMixin loaded!");
    }

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

        /*
         * --------------------------------
         * VANILLA PHYSICAL CONDITIONS
         * --------------------------------
         */

        if (pos.getY() < 0 || pos.getY() >= 256) {
            return false;
        }

        if (worldReader.getLightFor(
                LightType.BLOCK,
                pos
        ) >= 10) {
            return false;
        }

        BlockState blockState =
                worldReader.getBlockState(pos);

        if (!blockState.isAir(worldReader, pos)) {
            return false;
        }

        if (!Blocks.SNOW.getDefaultState()
                .isValidPosition(worldReader, pos)) {
            return false;
        }

        /*
         * --------------------------------
         * CLIMATE SNOW DECISION
         * --------------------------------
         */

        return SnowfallHandler.shouldSnow(
                biome,
                pos,
                world
        );
    }
}