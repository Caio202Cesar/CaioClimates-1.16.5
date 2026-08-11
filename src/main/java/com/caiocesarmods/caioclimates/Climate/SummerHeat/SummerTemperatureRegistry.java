package com.caiocesarmods.caioclimates.Climate.SummerHeat;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class SummerTemperatureRegistry {
    private static final Map<ResourceLocation, Float> SUMMER_TEMPERATURES = new HashMap<>();


    public static void register(ResourceLocation biome, float temperature) {
        System.out.println("REGISTER: " + biome + " -> " + temperature);
        SUMMER_TEMPERATURES.put(biome, temperature);
    }

    public static int size() {
        System.out.println("Registry size = " + SUMMER_TEMPERATURES.size());

        return SUMMER_TEMPERATURES.size();
    }

    public static float get(World world, BlockPos pos) {
        Biome biome = world.getBiome(pos);

        ResourceLocation id = world.func_241828_r()
                .getRegistry(Registry.BIOME_KEY)
                .getKey(biome);

        if (id == null)
            return -0.5F;

        return SUMMER_TEMPERATURES.getOrDefault(id, -0.5F);
    }
}

