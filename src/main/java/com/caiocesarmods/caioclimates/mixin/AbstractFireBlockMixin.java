package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {

    @Inject(
            method = "animateTick",
            at = @At("HEAD")
    )
    private void changeSmokeParticle(BlockState stateIn, World worldIn, BlockPos pos, Random rand, CallbackInfo ci) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        if (!this.canBurn(blockstate) && !blockstate.isSolidSide(worldIn, blockpos, Direction.UP)) {
            if (this.canBurn(worldIn.getBlockState(pos.west()))) {
                for(int j = 0; j < 2; ++j) {
                    double d3 = (double)pos.getX() + rand.nextDouble() * (double)0.1F;
                    double d8 = (double)pos.getY() + rand.nextDouble();
                    double d13 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d3, d8, d13, 0.0D, 0.10D, 0.0D);
                }
            }

            if (this.canBurn(worldIn.getBlockState(pos.east()))) {
                for(int k = 0; k < 2; ++k) {
                    double d4 = (double)(pos.getX() + 1) - rand.nextDouble() * (double)0.1F;
                    double d9 = (double)pos.getY() + rand.nextDouble();
                    double d14 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d4, d9, d14, 0.0D, 0.10D, 0.0D);
                }
            }

            if (this.canBurn(worldIn.getBlockState(pos.north()))) {
                for(int l = 0; l < 2; ++l) {
                    double d5 = (double)pos.getX() + rand.nextDouble();
                    double d10 = (double)pos.getY() + rand.nextDouble();
                    double d15 = (double)pos.getZ() + rand.nextDouble() * (double)0.1F;
                    worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d5, d10, d15, 0.0D, 0.10D, 0.0D);
                }
            }

            if (this.canBurn(worldIn.getBlockState(pos.south()))) {
                for(int i1 = 0; i1 < 2; ++i1) {
                    double d6 = (double)pos.getX() + rand.nextDouble();
                    double d11 = (double)pos.getY() + rand.nextDouble();
                    double d16 = (double)(pos.getZ() + 1) - rand.nextDouble() * (double)0.1F;
                    worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d6, d11, d16, 0.0D, 0.10D, 0.0D);
                }
            }

            if (this.canBurn(worldIn.getBlockState(pos.up()))) {
                for(int j1 = 0; j1 < 2; ++j1) {
                    double d7 = (double)pos.getX() + rand.nextDouble();
                    double d12 = (double)(pos.getY() + 1) - rand.nextDouble() * (double)0.1F;
                    double d17 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d7, d12, d17, 0.0D, 0.10D, 0.0D);
                }
            }
        } else {
            for(int i = 0; i < 3; ++i) {
                double d0 = (double)pos.getX() + rand.nextDouble();
                double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
                double d2 = (double)pos.getZ() + rand.nextDouble();
                worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d0, d1, d2, 0.0D, 0.10D, 0.0D);
            }
        }
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }

}
