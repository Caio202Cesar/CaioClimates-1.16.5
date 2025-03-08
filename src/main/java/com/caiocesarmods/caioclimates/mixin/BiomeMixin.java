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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(value = Biome.class, priority = 900)
public class BiomeMixin {

    @Inject(method = "getPrecipitation", at = @At("HEAD"), cancellable = true)

    private void modifyPrecipitation(CallbackInfoReturnable<Biome.RainType> cir) {
        World world = Minecraft.getInstance().world;
        if (world == null) return;

        Season currentSeason = Season.valueOf(SeasonHandler.getSeason(world.getDayTime()));

        ClimateType climate = ClimateTypeHandler.getClimateForBiome((Biome)(Object)this);

        if (climate.hasRain(currentSeason)) {
            cir.setReturnValue(Biome.RainType.RAIN);
        } else {
            cir.setReturnValue(Biome.RainType.NONE);
        }
    }
}
