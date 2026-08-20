package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtHandler;
import com.caiocesarmods.caioclimates.Climate.Winter.SnowfallHandler;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockRainParticleMixin {

    @Redirect(
            method = "animateTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;isRainingAt(Lnet/minecraft/util/math/BlockPos;)Z"
            )
    )
    private boolean caio$useLocalPrecipitation(
            World world,
            BlockPos pos
    ) {
        if (!world.isRemote) {
            return world.isRainingAt(pos);
        }

        Biome biome = world.getBiome(pos);

        if (SnowfallHandler.shouldSnow(biome, pos, world)) {
            return false;
        }

        if (DroughtHandler.shouldRain(biome, world)) {
            return true;
        }

        return world.isRainingAt(pos);
    }
}
