package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPatternRegistry;
import com.caiocesarmods.caioclimates.Climate.Moisture.MoistureCalculator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class BiomeGrassColorMixin {

    @Inject(
            method = "getGrassColor",
            at = @At("RETURN"),
            cancellable = true
    )
    private void caioClimateGrassColor(
            double posX,
            double posZ,
            CallbackInfoReturnable<Integer> cir) {

        ClientWorld world = Minecraft.getInstance().world;

        if (world == null) {
            return;
        }

        Biome biome = (Biome)(Object)this;

        DroughtPattern pattern = DroughtPatternRegistry.get(biome);

        if (pattern == null) {
            return;
        }

        float moisture =
                MoistureCalculator.getMoisture(pattern, world);

        cir.setReturnValue(
                tintGrass(cir.getReturnValue(), moisture)
        );
    }

    private static int tintGrass(int color, float moisture) {

        float amount = moisture * 0.35F;

        int r = (color >> 16) & 255;
        int g = (color >> 8) & 255;
        int b = color & 255;

        r = (int)(r * (1.0F - amount));

        g = Math.min(255,
                (int)(g + (255 - g) * amount));

        b = (int)(b * (1.0F - amount * 0.4F));

        return (r << 16) | (g << 8) | b;
    }
}
