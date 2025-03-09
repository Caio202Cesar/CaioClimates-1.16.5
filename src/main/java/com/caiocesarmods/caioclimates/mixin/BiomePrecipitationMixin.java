package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.ClimateType;
import com.caiocesarmods.caioclimates.Climate.ClimateTypeHandler;
import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.Seasons.SeasonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.IDayTimeReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class BiomePrecipitationMixin {

    @Inject(method = "getPrecipitation", at = @At("HEAD"), cancellable = true)
    private void modifyPrecipitation(CallbackInfoReturnable<Biome.RainType> cir) {
        Biome biome = (Biome) (Object) this;

        // Get the world time
        long dayTime = Minecraft.getInstance().level.getDayTime();

        // Determine the current season
        String currentSeasonName = SeasonHandler.getSeason(dayTime);
        Season currentSeason = Season.valueOf(currentSeasonName); // Convert String to Season enum

        // Get the ClimateType of the biome
        ClimateType climate = ClimateTypeHandler.getClimateForBiome(biome); // Adjust based on your system

        // Check if the climate allows rain in the current season
        if (climate != null && climate.hasRain(currentSeason)) {
            // If the biome normally does not allow rain, force it to RAIN
            if (biome.getPrecipitation() == Biome.RainType.NONE) {
                cir.setReturnValue(Biome.RainType.RAIN);
            }
        }
    }
}

