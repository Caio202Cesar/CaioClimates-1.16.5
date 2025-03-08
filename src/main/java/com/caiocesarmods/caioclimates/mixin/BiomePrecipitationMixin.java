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
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = World.class, priority = 900)
public class BiomePrecipitationMixin {

    @Redirect(method = "isRainingAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;getPrecipitation()Lnet/minecraft/world/biome/Biome$RainType;"))

    public Biome.RainType getRainType(Biome biome, BlockPos pos) {
        World world = Minecraft.getInstance().world;

        Season currentSeason = Season.valueOf(SeasonHandler.getSeason(world.getDayTime()));

        ClimateType climate = ClimateTypeHandler.getClimateForBiome((Biome)(Object)this);

        if (climate.hasRain(currentSeason)) {
            return Biome.RainType.RAIN;
        } else {
            return Biome.RainType.NONE;
        }
    }
}

