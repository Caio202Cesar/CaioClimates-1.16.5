package com.caiocesarmods.caioclimates.Climate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class DroughtPatternRegistry {

    private static final Map<ResourceLocation, DroughtPattern> PATTERNS =
            new HashMap<>();

    public static void register(
            String biomeId,
            DroughtPattern pattern
    ) {
        PATTERNS.put(
                new ResourceLocation(biomeId),
                pattern
        );
    }

    public static DroughtPattern get(Biome biome) {

        ResourceLocation id = biome.getRegistryName();

        if (id == null) {
            return null;
        }

        return PATTERNS.get(id);
    }

    public static void registerDefaults() {

        register(
                "caiocesarbiomes:mediterranean_scrubland",
                DroughtPattern.DRY_SUMMER
        );

        // Add other dry biomes here.
    }
}
