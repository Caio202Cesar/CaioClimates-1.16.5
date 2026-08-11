package com.caiocesarmods.caioclimates.Climate.SummerHeat;

import net.minecraft.util.ResourceLocation;

public class SummerTemperatureSetup {
    public static void register() {

        /// Minecraft Vanilla
        System.out.println("SummerTemperatureSetup.register()");
        System.out.println("Before: " + SummerTemperatureRegistry.size());

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "warm_ocean"), 0.88F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "deep_warm_ocean"), 0.88F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "lukewarm_ocean"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "deep_lukewarm_ocean"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "ocean"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "deep_ocean"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "cold_ocean"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "deep_cold_ocean"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "frozen_ocean"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "deep_frozen_ocean"), 0.14F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "frozen_river"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "snowy_tundra"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "snowy_mountains"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "snowy_beach"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "ice_spikes"), 0.1F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "plains"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "sunflower_plains"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "desert"), 1.5F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "desert_hills"), 1.5F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "desert_lakes"), 1.5F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "mountains"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "mountain_edge"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "wooded_mountains"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "gravelly_mountains"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "modified_gravelly_mountains"), 0.48F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "forest"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "wooded_hills"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "flower_forest"), 0.78F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "taiga"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "taiga_hills"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "snowy_taiga"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "snowy_taiga_hills"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "giant_tree_taiga"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "giant_tree_taiga_hills"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "taiga_mountains"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "snowy_taiga_mountains"), 0.14F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "giant_spruce_taiga"), 0.48F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "giant_spruce_taiga_hills"), 0.48F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "swamp"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "swamp_hills"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "mushroom_fields"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "mushroom_fields_shore"), 0.78F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "beach"), 0.78F); //Cfb temperate beach
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "stone_beach"), 0.48F); //taiga beach

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "jungle"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "jungle_hills"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "jungle_edge"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "modified_jungle"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "modified_jungle_edge"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "bamboo_jungle"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "bamboo_jungle_hills"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "birch_forest"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "birch_forest_hills"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "tall_birch_forest"), 0.68F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "tall_birch_hills"), 0.68F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "dark_forest"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "dark_forest_hills"), 0.78F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "savanna"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "savanna_plateau"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "shattered_savanna"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "shattered_savanna_plateau"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "soul_sand_valley"), 4.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "crimson_forest"), 3.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "warped_forest"), 2.5F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "basalt_deltas"), 3.5F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "nether_wastes"), 4.0F);

        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "badlands"), 1.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "wooded_badlands_plateau"), 1.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "badlands_plateau"), 1.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "eroded_badlands"), 1.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "modified_wooded_badlands_plateau"), 1.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("minecraft", "modified_badlands_plateau"), 1.0F);

        /// Caio César's Naturalistic Voyage
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "bamboo_subtropical_laurel_jungle"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "montane_laurel_grove"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_laurel_forest"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_laurel_jungle"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "laurel_forest_river"), 0.93F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "humid_subtropical_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_extreme_hills"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_seasonal_forest"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_lucidophyll_oak_forest_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_lucidophyll_oak_forest_river"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "humid_subtropical_pine_forest"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "humid_subtropical_pine_river"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "humid_subtropical_pine_beach"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "coastal_subtropical_desert"), 0.78F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "coastal_subtropical_desert_lomas"), 0.78F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_pine_island"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_island"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "monsoon_ficus_tropical_forest"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_bamboo_marsh"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_bamboo_marsh_river"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_bamboo_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_beach"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "dry_tropical_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_seasonal_forest"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "cork_oak_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "cork_oak_savanna"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "hot_mediterranean_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_conifer_savanna"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_conifer_savanna_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_oak_woodland"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_oak_sparse_woodland"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_scrubland_river"), 0.89F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_savanna_river"), 0.89F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "mediterranean_scrubland"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "olive_grove"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "olive_grove_beach"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "oleander_gardens"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_pine_dry_forest"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "eucalyptus_plains"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "eucalyptus_sahel"), 1.2F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "eucalyptus_savanna"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "subtropical_eucalyptus_dry_forest"), 0.89F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_eucalyptus_dry_forest"), 0.95F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "gravel_tundra"), 0.29F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "lush_southern_tundra"), 0.29F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tussock_tundra"), 0.29F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tussock_tundra_beach"), 0.29F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "ginkgo_forest"), 0.89F);
        //Hot continental forest has a summer temperature of 0.89
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "hemiboreal_forest"), 0.75F);
        //Medicine hat (Steepes based on central asia would have a 0.99F, but a hemiboreal one has milder temperatures)
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "hemiboreal_steppe"), 0.75F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "japanese_maple_grove"), 0.78F);

        //Valdivian Temperate Forests are cooler (0.69F) than northern hemisphere based temperate oceanic biomes.
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "pewen_coniferous_grove"), 0.69F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "valdivian_temperate_rainforest"), 0.69F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "valdivian_colun_beach"), 0.69F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "southern_beech_forest"), 0.32F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "sahel"), 1.2F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "salt_desert"), 1.5F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "socotra_dryland"), 1.5F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "temperate_desert"), 1.5F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "temperate_desert_oasis"), 0.98F);
        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "temperate_desert_river"), 0.98F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "tropical_desert"), 1.5F);

        SummerTemperatureRegistry.register(new ResourceLocation("caiocesarbiomes", "temperate_rainforest"), 0.78F);

        /// Brazillian Biomes
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "amazon_rainforest"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "amazon_varzea_forest"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "amazon_rainforest_edge"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "black_amazon_river"), 0.89F);

        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "araucaria_plateau"), 0.9F);

        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "atlantic_forest"), 0.93F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "atlantic_forest_hills"), 0.93F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "atlantic_forest_beach"), 0.93F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "atlantic_forest_river"), 0.89F);

        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "caatinga_shrubland"), 1.2F);

        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "cerrado"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "dunas_restinga"), 1.0F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "restinga_beach"), 1.0F);

        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "butia_pampas"), 0.85F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "pampas_hills"), 0.9F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "pampas"), 0.9F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "pampas_coastal_fields"), 0.85F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "pampas_river"), 0.83F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "pampas_beach"), 0.83F);

        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "pantanal"), 0.95F);
        SummerTemperatureRegistry.register(new ResourceLocation("brbiomesmod", "cocal_forest"), 0.95F);

        System.out.println("After: " + SummerTemperatureRegistry.size());

    }
}
