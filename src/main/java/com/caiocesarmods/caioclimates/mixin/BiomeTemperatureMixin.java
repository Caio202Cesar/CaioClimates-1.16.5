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

@Mixin(value = Biome.class, priority = 900)
public class BiomeTemperatureMixin {

    @Inject(method = "getTemperature", at = @At("HEAD"), cancellable = true)

    private void modifyTemperature(BlockPos pos, CallbackInfoReturnable<Float> cir) {
        World world = Minecraft.getInstance().world;

        if (world == null) return;

        Season currentSeason = Season.valueOf(SeasonHandler.getSeason(world.getDayTime()));

        ClimateType climate = ClimateTypeHandler.getClimateForBiome((Biome)(Object)this);

        float newTemperature = climate.getTemperature(currentSeason);

        cir.setReturnValue(newTemperature);
    }
}
