package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.settings.ParticleStatus;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.event.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow private int ticks;
    @Shadow private int rainSoundTime;
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

    @Redirect(
            method = "addRainParticles",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/world/ClientWorld;playSound(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FFZ)V"
            )
    )
    private void modifyRainSound(
            ClientWorld instance, BlockPos p_184156_1_, net.minecraft.util.SoundEvent p_184156_2_, SoundCategory p_184156_3_, float p_184156_4_, float p_184156_5_, boolean p_184156_6_
    ) {
        Biome biome = instance.getBiome(p_184156_1_);

        if (SnowfallHandler.shouldSnow(
                biome,
                p_184156_1_,
                instance
        )) {

            System.out.println(
                    "[CaioClimate] Suppressed rain sound at "
                            + p_184156_1_
                            + " | biome="
                            + biome.getRegistryName()
            );

            return;
        }

        // Normal vanilla rain sound
        instance.playSound(
                p_184156_1_,
                p_184156_2_,
                p_184156_3_,
                p_184156_4_,
                p_184156_5_,
                p_184156_6_
        );
    }

    @Redirect(
            method = "renderRainSnow",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/Biome;getPrecipitation()Lnet/minecraft/world/biome/Biome$RainType;"
            )
    )
    private Biome.RainType caioClimateModifyPrecipitation(
            Biome biome
    ) {

        DroughtPattern pattern =
                DroughtPatternRegistry.get(biome);

        /*
         * Not a drought-pattern biome.
         * Vanilla behavior.
         */
        if (pattern == null) {
            return biome.getPrecipitation();
        }

        ClientWorld world =
                Minecraft.getInstance().world;

        if (world == null) {
            return Biome.RainType.NONE;
        }

        /*
         * Minecraft's global weather must actually
         * be a rain event.
         */
        if (!world.isRaining()) {
            return Biome.RainType.NONE;
        }

        /*
         * Our drought system decides whether this
         * biome participates in the rain event.
         */
        return DroughtHandler.shouldRain(
                biome,
                world
        )
                ? Biome.RainType.RAIN
                : Biome.RainType.NONE;
    }
}

