package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.ClimateType;
import com.caiocesarmods.caioclimates.Climate.ClimateTypeHandler;
import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.Seasons.SeasonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public abstract class BiomeTemperatureMixin {

    @Inject(method = "getBaseTemperature", at = @At("HEAD"), cancellable = true)
    private void onGetBaseTemperature(CallbackInfoReturnable<Float> cir) {
        Biome biome = (Biome) (Object) this;

        // Get the current server
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server == null) return; // Server not available

        // Get the world (Overworld)
        ServerWorld world = server.getLevel(World.OVERWORLD);
        if (world == null) return; // World not available

        // Get the world time
        long dayTime = world.getDayTime();

        // Determine the current season
        String currentSeasonName = SeasonHandler.getSeason(dayTime);
        Season currentSeason = Season.valueOf(currentSeasonName); // Convert String to Season enum

        // Get the ClimateType of the biome
        ClimateType climate = ClimateTypeHandler.getClimateForBiome(biome); // Ensure this method exists

        // If climate is defined, apply seasonal temperature
        if (climate != null) {
            float seasonalTemperature = climate.getTemperature(currentSeason);
            cir.setReturnValue(seasonalTemperature);
        }
    }
}

