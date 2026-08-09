package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.SnowfallHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    private static int debugCounter = 0;

    @Redirect(
            method = "renderRainSnow",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/Biome;getTemperature(Lnet/minecraft/util/math/BlockPos;)F"
            )
    )
    private float climate$modifyPrecipitationTemperature(
            Biome biome,
            BlockPos pos
    ) {
        Minecraft minecraft = Minecraft.getInstance();
        World world = minecraft.world;

        if (world == null) {
            return biome.getTemperature(pos);
        }

        boolean snow =
                SnowfallHandler.shouldSnow(
                        biome,
                        pos,
                        world
                );

        if (debugCounter++ % 500 == 0) {
            System.out.println(
                    "[CaioCesarBiomes] WorldRendererMixin active!"
                            + " | biome=" + biome.getRegistryName()
                            + " | snow=" + snow
            );
        }

        return snow ? 0.14F : 0.15F;
    }
}
