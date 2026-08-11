package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.Drought.PrecipitationHandler;
import com.caiocesarmods.caioclimates.Climate.Winter.FrostHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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
    private boolean caioClimateSnowGeneration(
            Biome biome,
            IWorldReader world,
            BlockPos pos
    ) {

        /*
         * Our precipitation system is the final authority
         * over whether this location is actually receiving snow.
         */
        if (world instanceof World && Blocks.SNOW.getDefaultState().isValidPosition(world, pos)) {

            World actualWorld =
                    (World) world;

            Biome actualBiome =
                    actualWorld.getBiome(pos);

            return PrecipitationHandler.getPrecipitation(
                    actualBiome,
                    pos,
                    actualWorld
            ) == Biome.RainType.SNOW;
        }
        /*
         * Fallback to vanilla behavior.
         */
        return biome.doesSnowGenerate(
                world,
                pos
        );
    }

    @Redirect(
            method = "tickEnvironment",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/Biome;doesWaterFreeze(Lnet/minecraft/world/IWorldReader;Lnet/minecraft/util/math/BlockPos;)Z"
            )
    )
    private boolean modifyWaterFreezing(
            Biome biome,
            IWorldReader worldReader,
            BlockPos pos
    ) {

        ServerWorld world =
                (ServerWorld) (Object) this;

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

        FluidState fluidState =
                worldReader.getFluidState(pos);

        if (fluidState.getFluid() != Fluids.WATER) {
            return false;
        }

        if (!(blockState.getBlock()
                instanceof FlowingFluidBlock)) {
            return false;
        }

        /*
         * --------------------------------
         * EDGE REQUIREMENT
         * --------------------------------
         */

        boolean surroundedByWater =
                worldReader.hasWater(pos.west())
                        && worldReader.hasWater(pos.east())
                        && worldReader.hasWater(pos.north())
                        && worldReader.hasWater(pos.south());

        if (surroundedByWater) {
            return false;
        }

        /*
         * --------------------------------
         * CLIMATE FROST DECISION
         * --------------------------------
         */

        return FrostHandler.shouldFreeze(
                biome,
                pos,
                world
        );
    }
}