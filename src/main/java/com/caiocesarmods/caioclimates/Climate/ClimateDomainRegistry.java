package com.caiocesarmods.caioclimates.Climate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class ClimateDomainRegistry {
    private static final Map<ResourceLocation, ClimateDomain> MAP = new HashMap<>();

    private ClimateDomainRegistry() {}

    // ---- REGISTER USING STRING ----
    public static void register(String biomeId, ClimateDomain climate) {
        MAP.put(new ResourceLocation(biomeId), climate);
    }

    // ---- REGISTER USING RESOURCELOCATION (OPTIONAL) ----
    public static void register(ResourceLocation biomeId, ClimateDomain climate) {
        MAP.put(biomeId, climate);
    }

    // ---- QUERY FROM WORLD ----
    public static ClimateDomain get(World world, BlockPos pos) {
        Biome biome = world.getBiome(pos);

        ResourceLocation id = world.func_241828_r()
                .getRegistry(Registry.BIOME_KEY)
                .getKey(biome);

        if (id == null) return ClimateDomain.NONE; // safe fallback

        return MAP.getOrDefault(id, ClimateDomain.NONE);
    }
}