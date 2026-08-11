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
        register("caiocesarbiomes:cork_oak_savanna", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:cork_oak_beach", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:hot_mediterranean_beach", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_conifer_savanna", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_conifer_savanna_beach", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_oak_woodland", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_oak_sparse_woodland", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_scrubland_river", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_savanna_river", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:mediterranean_scrubland", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:oleander_gardens", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:olive_grove", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:olive_grove_beach", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:subtropical_pine_dry_forest", DroughtPattern.DRY_SUMMER);

        register("caiocesarbiomes:tropical_eucalyptus_dry_forest", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:eucalyptus_savanna", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:dry_tropical_beach", DroughtPattern.DRY_SUMMER);

        register("caiocesarbiomes:hemiboreal_steppe", DroughtPattern.SEMI_ARID);

    }
}
