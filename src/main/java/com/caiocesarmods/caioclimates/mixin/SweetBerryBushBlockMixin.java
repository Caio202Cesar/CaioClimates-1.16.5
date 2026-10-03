package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeatHelper;
import com.caiocesarmods.caioclimates.HardinessZones.PlantClimateConditionsRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SweetBerryBushBlock.class)
public class SweetBerryBushBlockMixin {
    //Random tick into dead bush if climatic conditions aren't favorable.
    @Inject(
            method = "randomTick",
            at = @At("HEAD")
    )

    private void turnIntoDeadBushInUnsuitableClimate(BlockState state, ServerWorld world,
                                                      BlockPos pos, Random random, CallbackInfo ci) {
        /*
        Biome biome = world.getBiome(pos);
        Biome.RainType rainType = biome.getPrecipitation();

        float temp = biome.getTemperature(pos);
        float maxTemp = 0.64f;
        float minTemp = 0.0f;

        boolean isColdEnough = temp >= minTemp && temp <= maxTemp;
        boolean suitableSummerTemps = caioClimates_1_16_5$isSummerHot(world, pos);

        if (!isColdEnough || !suitableSummerTemps) {
            world.setBlockState(pos, Blocks.DEAD_BUSH.getDefaultState());
        }*/

        ResourceLocation berryBush = state.getBlock().getRegistryName();

        if (!PlantClimateConditionsRegistry.isRegistered(berryBush)) {
            return;
        }

        if (!PlantClimateConditionsRegistry.isSuitable(berryBush, world, pos)) {
            world.setBlockState(pos, Blocks.DEAD_BUSH.getDefaultState());
        }

    }

    @Unique
    private static boolean caioClimates_1_16_5$isSummerHot(World world, BlockPos pos) {
        SummerHeat heat = SummerHeat.fromTemperature(SummerHeatHelper.get(world, pos));
        return heat == SummerHeat.WARM || heat == SummerHeat.HOT ||
                heat == SummerHeat.VERY_HOT || heat == SummerHeat.SCORCHING || heat == SummerHeat.UNBEARABLE;
    }
}
