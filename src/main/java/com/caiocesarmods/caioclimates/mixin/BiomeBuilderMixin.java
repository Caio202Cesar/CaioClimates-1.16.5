package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.ClimateType;
import com.caiocesarmods.caioclimates.Seasons.SeasonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(value = Biome.Builder.class, priority = 900)
public class BiomeBuilderMixin {
    @Shadow @Nullable private Biome.RainType precipitation;

    @Inject(method = "precipitation", at = @At("HEAD"), cancellable = true)
    private void modifyPrecipitation(Biome.RainType rainType, CallbackInfoReturnable<Biome.Builder> cir) {
        long worldTime = Minecraft.getInstance().world.getDayTime();
        String season = SeasonHandler.getSeason(worldTime);
        Biome biome = ((Biome.Builder)(Object)this).build();
        ClimateType climate = ClimateType.
    }
}
