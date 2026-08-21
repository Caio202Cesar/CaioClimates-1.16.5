package com.caiocesarmods.caioclimates.Climate.Drought;

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
        register("minecraft:desert", DroughtPattern.ARID);
        register("minecraft:desert_hills", DroughtPattern.ARID);
        register("minecraft:desert_lakes", DroughtPattern.ARID);

        register("minecraft:savanna", DroughtPattern.DRY_SUMMER);
        register("minecraft:savanna_plateau", DroughtPattern.DRY_SUMMER);
        register("minecraft:shattered_savanna", DroughtPattern.DRY_SUMMER);
        register("minecraft:shattered_savanna_plateau", DroughtPattern.DRY_SUMMER);

        register("minecraft:jungle", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("minecraft:jungle_hills", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("minecraft:modified_jungle", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("minecraft:bamboo_jungle", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("minecraft:bamboo_jungle_hills", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("minecraft:jungle_edge", DroughtPattern.DRY_SUMMER);
        register("minecraft:modified_jungle_edge", DroughtPattern.DRY_SUMMER);

        register("minecraft:badlands", DroughtPattern.SEMI_ARID);
        register("minecraft:wooded_badlands_plateau", DroughtPattern.DRY_SUMMER);
        register("minecraft:badlands_plateau", DroughtPattern.SEMI_ARID);
        register("minecraft:eroded_badlands", DroughtPattern.SEMI_ARID);
        register("minecraft:modified_badlands_plateau", DroughtPattern.SEMI_ARID);
        register("minecraft:modified_wooded_badlands_plateau", DroughtPattern.DRY_SUMMER);

        register("minecraft:frozen_river", DroughtPattern.SEMI_ARID);
        register("minecraft:snowy_tundra", DroughtPattern.SEMI_ARID);
        register("minecraft:snowy_mountains", DroughtPattern.SEMI_ARID);
        register("minecraft:snowy_beach", DroughtPattern.SEMI_ARID);
        register("minecraft:ice_spikes", DroughtPattern.ARID);

        register("caiocesarbiomes:coastal_subtropical_desert", DroughtPattern.ARID);
        register("caiocesarbiomes:coastal_subtropical_desert_lomas", DroughtPattern.ARID);

        register("caiocesarbiomes:tropical_pine_island", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("caiocesarbiomes:tropical_island", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("caiocesarbiomes:monsoon_ficus_tropical_forest", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("caiocesarbiomes:tropical_bamboo_marsh", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("caiocesarbiomes:tropical_bamboo_marsh_river", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("caiocesarbiomes:tropical_bamboo_beach", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("caiocesarbiomes:tropical_beach", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);

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

        register("caiocesarbiomes:stony_mediterranean_shore", DroughtPattern.DRY_SUMMER);

        register("caiocesarbiomes:dry_tropical_beach", DroughtPattern.DRY_SUMMER);

        register("caiocesarbiomes:tropical_eucalyptus_dry_forest", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:eucalyptus_savanna", DroughtPattern.DRY_SUMMER);
        register("caiocesarbiomes:eucalyptus_sahel", DroughtPattern.SEMI_ARID);

        register("caiocesarbiomes:hemiboreal_steppe", DroughtPattern.SEMI_ARID);

        register("caiocesarbiomes:sahel", DroughtPattern.SEMI_ARID);
        register("caiocesarbiomes:salt_desert", DroughtPattern.ARID);
        register("caiocesarbiomes:socotra_dryland",DroughtPattern.ARID);

        register("caiocesarbiomes:temperate_desert", DroughtPattern.ARID);
        register("caiocesarbiomes:temperate_desert_oasis", DroughtPattern.ARID);
        register("caiocesarbiomes:temperate_desert_river", DroughtPattern.ARID);

        register("caiocesarbiomes:tropical_desert", DroughtPattern.ARID);

        register("caiocesarbiomes:temperate_rainforest", DroughtPattern.DRY_SUMMER);

        register("brbiomesmod:amazon_rainforest", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("brbiomesmod:amazon_varzea_forest", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("brbiomesmod:black_amazon_river", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("brbiomesmod:amazon_rainforest_edge", DroughtPattern.DRY_SUMMER);

        register("brbiomesmod:atlantic_forest", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("brbiomesmod:atlantic_forest_beach", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);
        register("brbiomesmod:atlantic_forest_river", DroughtPattern.TROPICAL_RAINFOREST_DROUGHT);

        register("brbiomesmod:caatinga_shrubland", DroughtPattern.SEMI_ARID);
        register("brbiomesmod:cerrado", DroughtPattern.DRY_SUMMER);
        register("brbiomesmod:dunas_restinga", DroughtPattern.DRY_SUMMER);
        register("brbiomesmod:restinga_beach", DroughtPattern.DRY_SUMMER);
        register("brbiomesmod:pantanal",  DroughtPattern.DRY_SUMMER);
        register("brbiomesmod:cocal_forest",  DroughtPattern.DRY_SUMMER);

    }
}
