package com.caiocesarmods.caioclimates.HardinessZones;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class HardinessZones {
    public static int getZone(World world, BlockPos pos) {
        Biome biome = world.getBiome(pos);
        float baseTemp = biome.getTemperature(pos);

        if (baseTemp <= 0.14f) return 0; //Always snow
        if (baseTemp <= 0.19f) return 1; //Tundra zone
        if (baseTemp <= 0.29f) return 2; //Border taiga
        if (baseTemp <= 0.39f) return 3; //Taiga
        if (baseTemp <= 0.49f) return 4; //Border continental temperate
        if (baseTemp <= 0.59f) return 5; //Continental temperate
        if (baseTemp <= 0.69f) return 6; //Warmer Continental temperate
        if (baseTemp <= 0.74f) return 7; //Colder Temperate
        if (baseTemp <= 0.79f) return 8; //Warmer Temperate
        if (baseTemp <= 0.84f) return 9; //Colder subtropical
        if (baseTemp <= 0.89f) return 10; //Warmer Subtropical
        if (baseTemp <= 0.94f) return 11;//Border tropical
        return 12;//Tropical
    }
}
