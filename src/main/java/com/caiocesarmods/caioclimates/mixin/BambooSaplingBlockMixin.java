package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.HardinessZones.PlantClimateConditionsRegistry;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(BambooSaplingBlock.class)
public class BambooSaplingBlockMixin {

    @Inject(
            method = "randomTick",
            at = @At("HEAD"),
            cancellable = true
    )
    private void restrictNaturalGrowth(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random,
            CallbackInfo ci
    ) {
        ResourceLocation bambooSapling = state.getBlock().getRegistryName();

        if (!PlantClimateConditionsRegistry.isRegistered(bambooSapling)) {
            return;
        }

        if (!PlantClimateConditionsRegistry.isSuitable(bambooSapling, world, pos)) {
            ci.cancel();
        }
    }

    @Inject(
            method = "canGrow",
            at = @At("HEAD"),
            cancellable = true
    )
    private void restrictGrowth(
            IBlockReader worldIn,
            BlockPos pos,
            BlockState state,
            boolean isClient,
            CallbackInfoReturnable<Boolean> cir
    ) {
        ResourceLocation bambooSapling = state.getBlock().getRegistryName();

        if (!PlantClimateConditionsRegistry.isRegistered(bambooSapling)) {
            return;
        }

        if (!(worldIn instanceof World)) {
            cir.setReturnValue(false);
            return;
        }

        World world = (World) worldIn;

        if (!PlantClimateConditionsRegistry.isSuitable(bambooSapling, world, pos)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = "canUseBonemeal",
            at = @At("HEAD"),
            cancellable = true
    )
    private void restrictBonemeal(
            World world,
            Random random,
            BlockPos pos,
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {
        ResourceLocation bambooSapling = state.getBlock().getRegistryName();

        if (!PlantClimateConditionsRegistry.isRegistered(bambooSapling)) {
            return;
        }

        if (!PlantClimateConditionsRegistry.isSuitable(bambooSapling, world, pos)) {
            cir.setReturnValue(false);
        }
    }
}
