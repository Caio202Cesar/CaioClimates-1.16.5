package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.ClimateType;
import com.caiocesarmods.caioclimates.Climate.ClimateTypeHandler;
import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.Seasons.SeasonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class BiomeTemperatureMixin {

    @Inject(method = "getTemperature()F", at = @At("HEAD"), cancellable = true)

    public void modifyTemperature(CallbackInfoReturnable<Float> cir) {
        Biome biome = (Biome)(Object)this;
        ClimateType climateType = ClimateTypeHandler.getClimateForBiome(biome);
        if (climateType != null) {
            long dayTime = Minecraft.getInstance().world.getDayTime();
            Season season = Season.valueOf(SeasonHandler.getSeason(dayTime));

            cir.setReturnValue(climateType.getTemperature(season));
        }
    }
}
