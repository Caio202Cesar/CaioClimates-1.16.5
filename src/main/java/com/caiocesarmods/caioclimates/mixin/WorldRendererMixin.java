package com.caiocesarmods.caioclimates.mixin;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;
import javax.xml.ws.RequestWrapper;

import static com.sun.nio.zipfs.ZipFileAttributeView.AttrID.method;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Shadow
    private @Nullable ClientWorld world;

@RequestWrapper(method = {"renderWeather", "tickRainSplashing"}, at = @At(value = "INVOKE", target =
        "Lnet/minecraft/world/biome/Biome;getRainFall(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome$RainFall;"))
    private
}

