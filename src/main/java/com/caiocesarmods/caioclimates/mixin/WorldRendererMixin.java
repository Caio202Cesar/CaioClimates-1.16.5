package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtHandler;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPatternRegistry;
import com.caiocesarmods.caioclimates.Climate.Drought.PrecipitationHandler;
import com.caiocesarmods.caioclimates.Climate.Winter.SnowfallHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
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
import org.spongepowered.asm.mixin.Final;
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
    @Shadow @Final private Minecraft mc;
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

    @Inject(
            method = "addRainParticles",
            at = @At("HEAD"),
            cancellable = true
    )
    private void caioClimateAddPrecipitationParticles(
            ActiveRenderInfo activeRenderInfo,
            CallbackInfo ci
    ) {
        ClientWorld world = this.mc.world;

        if (world == null) {
            return;
        }

        /*
         * We completely replace vanilla addRainParticles().
         */
        ci.cancel();

        float rainStrength =
                world.getRainStrength(1.0F)
                        / (Minecraft.isFancyGraphicsEnabled() ? 1.0F : 2.0F);

        if (rainStrength <= 0.0F) {
            return;
        }

        Random random =
                new Random((long) this.ticks * 312987231L);

        IWorldReader worldReader = world;

        BlockPos cameraPos =
                new BlockPos(activeRenderInfo.getProjectedView());

        BlockPos soundPos = null;

        int particleCount =
                (int) (100.0F * rainStrength * rainStrength)
                        / (this.mc.gameSettings.particles
                        == ParticleStatus.DECREASED ? 2 : 1);

        for (int i = 0; i < particleCount; ++i) {

            int offsetX =
                    random.nextInt(21) - 10;

            int offsetZ =
                    random.nextInt(21) - 10;

            BlockPos surfacePos =
                    worldReader
                            .getHeight(
                                    Heightmap.Type.MOTION_BLOCKING,
                                    cameraPos.add(
                                            offsetX,
                                            0,
                                            offsetZ
                                    )
                            )
                            .down();

            if (surfacePos.getY() <= 0
                    || surfacePos.getY() > cameraPos.getY() + 10
                    || surfacePos.getY() < cameraPos.getY() - 10) {
                continue;
            }

            Biome biome =
                    worldReader.getBiome(surfacePos);

            /*
             * This is the important part.
             *
             * Do NOT use:
             *
             * biome.getPrecipitation()
             *
             * because dry biomes intentionally have RainType.NONE.
             *
             * PrecipitationHandler decides whether this location
             * currently has rain, snow, or no precipitation.
             */
            Biome.RainType precipitation =
                    PrecipitationHandler.getPrecipitation(
                            biome,
                            surfacePos,
                            world
                    );

            /*
             * addRainParticles() is specifically responsible for
             * precipitation hitting the ground.
             *
             * Therefore:
             *
             * RAIN -> splash particle
             * SNOW -> no rain splash
             * NONE -> nothing
             */
            if (precipitation != Biome.RainType.RAIN) {
                continue;
            }

            soundPos = surfacePos;

            if (this.mc.gameSettings.particles
                    == ParticleStatus.MINIMAL) {
                break;
            }

            double randomX =
                    random.nextDouble();

            double randomZ =
                    random.nextDouble();

            BlockState blockState =
                    worldReader.getBlockState(surfacePos);

            FluidState fluidState =
                    worldReader.getFluidState(surfacePos);

            VoxelShape voxelShape =
                    blockState.getCollisionShapeUncached(
                            worldReader,
                            surfacePos
                    );

            double collisionHeight =
                    voxelShape.max(
                            Direction.Axis.Y,
                            randomX,
                            randomZ
                    );

            double fluidHeight =
                    (double) fluidState.getActualHeight(
                            worldReader,
                            surfacePos
                    );

            double surfaceHeight =
                    Math.max(
                            collisionHeight,
                            fluidHeight
                    );

            /*
             * Vanilla uses RAIN unless the surface is lava,
             * magma, or a lit campfire.
             */
            IParticleData particleData =
                    !fluidState.isTagged(FluidTags.LAVA)
                            && !blockState.matchesBlock(Blocks.MAGMA_BLOCK)
                            && !CampfireBlock.isLit(blockState)
                            ? ParticleTypes.RAIN
                            : ParticleTypes.SMOKE;

            world.addParticle(
                    particleData,
                    (double) surfacePos.getX() + randomX,
                    (double) surfacePos.getY() + surfaceHeight,
                    (double) surfacePos.getZ() + randomZ,
                    0.0D,
                    0.0D,
                    0.0D
            );
        }

        /*
         * Vanilla rain sound.
         *
         * We only play it when our precipitation system
         * determined that the location is actually raining.
         */
        if (soundPos != null
                && random.nextInt(3) < this.rainSoundTime++) {

            this.rainSoundTime = 0;

            if (soundPos.getY() > cameraPos.getY() + 1
                    && worldReader
                    .getHeight(
                            Heightmap.Type.MOTION_BLOCKING,
                            cameraPos
                    )
                    .getY()
                    > MathHelper.floor(
                    (float) cameraPos.getY()
            )) {

                world.playSound(
                        soundPos,
                        SoundEvents.WEATHER_RAIN_ABOVE,
                        SoundCategory.WEATHER,
                        0.1F,
                        0.5F,
                        false
                );

            } else {

                world.playSound(
                        soundPos,
                        SoundEvents.WEATHER_RAIN,
                        SoundCategory.WEATHER,
                        0.2F,
                        1.0F,
                        false
                );
            }
        }
    }
}

