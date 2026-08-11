package com.caiocesarmods.caioclimates.Climate.SummerHeat;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SummerHeatHelper {

    public static float get(World world, BlockPos pos) {

        float altitudeModifier = (pos.getY() - 64) * -0.005F;

        return SummerTemperatureRegistry.get(world, pos) + altitudeModifier;
    }
}
