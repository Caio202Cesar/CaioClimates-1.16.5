package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPatternRegistry;
import com.caiocesarmods.caioclimates.Climate.Moisture.MoistureCalculator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class BiomeGrassColorMixin {

    @Inject(
            method = "getGrassColorByClimate",
            at = @At("HEAD"),
            cancellable = true
    )
    private void caioClimateGrassColor(CallbackInfoReturnable<Integer> cir) {

        Biome biome = (Biome)(Object)this;

        ClientWorld world = Minecraft.getInstance().world;

        if (world == null) {
            return;
        }

        DroughtPattern pattern = DroughtPatternRegistry.get(biome);

        if (pattern == null) {
            return;
        }

        float temperature = MathHelper.clamp(
                biome.getTemperature(new BlockPos(0, 64, 0)),
                0.0F,
                1.0F
        );

        float baseHumidity = MathHelper.clamp(
                biome.getDownfall(),
                0.0F,
                1.0F
        );

        float moisture =
                MoistureCalculator.getMoisture(pattern, world);

        float humidity =
                baseHumidity + (moisture - baseHumidity) * 0.75F;

        humidity = MathHelper.clamp(humidity, 0.0F, 1.0F);

        cir.setReturnValue(
                GrassColors.get(
                        temperature,
                        humidity
                )
        );
    }
}
