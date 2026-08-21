package com.caiocesarmods.caioclimates.Climate;

public class ClimateSetup {
    public static void register() {

        /// Minecraft Vanilla
        ClimateDomainRegistry.register("minecraft:warm_ocean", ClimateDomain.WARM_OCEAN);
        ClimateDomainRegistry.register("minecraft:deep_warm_ocean", ClimateDomain.WARM_OCEAN);

        ClimateDomainRegistry.register("minecraft:lukewarm_ocean", ClimateDomain.LUKEWARM_OCEAN);
        ClimateDomainRegistry.register("minecraft:deep_lukewarm_ocean", ClimateDomain.WARM_OCEAN);

        ClimateDomainRegistry.register("minecraft:ocean", ClimateDomain.OCEAN);
        ClimateDomainRegistry.register("minecraft:deep_ocean", ClimateDomain.OCEAN);

        ClimateDomainRegistry.register("minecraft:cold_ocean", ClimateDomain.COLD_OCEAN);
        ClimateDomainRegistry.register("minecraft:deep_cold_ocean", ClimateDomain.COLD_OCEAN);

        ClimateDomainRegistry.register("minecraft:frozen_ocean", ClimateDomain.ICY_OCEAN);
        ClimateDomainRegistry.register("minecraft:deep_frozen_ocean", ClimateDomain.ICY_OCEAN);

        ClimateDomainRegistry.register("minecraft:frozen_river", ClimateDomain.ICE_CAP);

        //Considering absence of birch trees, summer here is hot;
        ClimateDomainRegistry.register("minecraft:plains", ClimateDomain.TEMPERATE);
        ClimateDomainRegistry.register("minecraft:sunflower_plains", ClimateDomain.TEMPERATE);

        ClimateDomainRegistry.register("minecraft:desert", ClimateDomain.SUBTROPICAL_DESERT);
        ClimateDomainRegistry.register("minecraft:desert_hills", ClimateDomain.SUBTROPICAL_DESERT);
        ClimateDomainRegistry.register("minecraft:desert_lakes", ClimateDomain.SUBTROPICAL_DESERT);

        ClimateDomainRegistry.register("minecraft:mountains", ClimateDomain.ALPINE);
        ClimateDomainRegistry.register("minecraft:mountain_edge", ClimateDomain.ALPINE);
        ClimateDomainRegistry.register("minecraft:wooded_mountains", ClimateDomain.ALPINE);
        ClimateDomainRegistry.register("minecraft:gravelly_mountains", ClimateDomain.ALPINE_TUNDRA);
        ClimateDomainRegistry.register("minecraft:modified_gravelly_mountains", ClimateDomain.ALPINE_TUNDRA);

        //It has a temperate oceanic climate due to birch trees (Eastern Europe)
        ClimateDomainRegistry.register("minecraft:forest", ClimateDomain.TEMPERATE_OCEANIC);
        ClimateDomainRegistry.register("minecraft:wooded_hills", ClimateDomain.TEMPERATE_OCEANIC);
        ClimateDomainRegistry.register("minecraft:flower_forest", ClimateDomain.TEMPERATE_OCEANIC);

        ClimateDomainRegistry.register("minecraft:taiga", ClimateDomain.SUBARTIC);
        ClimateDomainRegistry.register("minecraft:taiga_hills", ClimateDomain.SUBARTIC);
        ClimateDomainRegistry.register("minecraft:snowy_taiga", ClimateDomain.SNOWY);
        ClimateDomainRegistry.register("minecraft:snowy_taiga_hills", ClimateDomain.SNOWY);
        ClimateDomainRegistry.register("minecraft:giant_tree_taiga", ClimateDomain.SUBARTIC);
        ClimateDomainRegistry.register("minecraft:giant_tree_taiga_hills", ClimateDomain.SUBARTIC);
        ClimateDomainRegistry.register("minecraft:taiga_mountains", ClimateDomain.SUBARTIC);
        ClimateDomainRegistry.register("minecraft:snowy_taiga_mountains", ClimateDomain.SNOWY);
        ClimateDomainRegistry.register("minecraft:giant_spruce_taiga", ClimateDomain.SUBARTIC);
        ClimateDomainRegistry.register("minecraft:giant_spruce_taiga_hills", ClimateDomain.SUBARTIC);

        ClimateDomainRegistry.register("minecraft:swamp", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("minecraft:swamp_hills", ClimateDomain.HUMID_SUBTROPICAL);

        ClimateDomainRegistry.register("minecraft:snowy_tundra", ClimateDomain.TUNDRA);
        ClimateDomainRegistry.register("minecraft:snowy_mountains", ClimateDomain.SNOWY);
        ClimateDomainRegistry.register("minecraft:snowy_beach", ClimateDomain.SNOWY);
        ClimateDomainRegistry.register("minecraft:ice_spikes", ClimateDomain.ICE_CAP);

        ClimateDomainRegistry.register("minecraft:mushroom_fields", ClimateDomain.TROPICAL_MARITIME);
        ClimateDomainRegistry.register("minecraft:mushroom_fields_shore", ClimateDomain.TROPICAL_MARITIME);

        ClimateDomainRegistry.register("minecraft:beach", ClimateDomain.TEMPERATE_OCEANIC);
        ClimateDomainRegistry.register("minecraft:stone_beach", ClimateDomain.SUBARTIC);

        ClimateDomainRegistry.register("minecraft:jungle", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("minecraft:jungle_hills", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("minecraft:jungle_edge", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("minecraft:modified_jungle", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("minecraft:modified_jungle_edge", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("minecraft:bamboo_jungle", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("minecraft:bamboo_jungle_hills", ClimateDomain.TROPICAL_FOREST);

        ClimateDomainRegistry.register("minecraft:birch_forest", ClimateDomain.HEMIBOREAL_CONTINENTAL);
        ClimateDomainRegistry.register("minecraft:birch_forest_hills", ClimateDomain.HEMIBOREAL_CONTINENTAL);
        ClimateDomainRegistry.register("minecraft:tall_birch_forest", ClimateDomain.HEMIBOREAL_CONTINENTAL);
        ClimateDomainRegistry.register("minecraft:tall_birch_hills", ClimateDomain.HEMIBOREAL_CONTINENTAL);

        ClimateDomainRegistry.register("minecraft:dark_forest", ClimateDomain.TEMPERATE_OCEANIC);
        ClimateDomainRegistry.register("minecraft:dark_forest_hills", ClimateDomain.TEMPERATE_OCEANIC);

        ClimateDomainRegistry.register("minecraft:savanna", ClimateDomain.TROPICAL_SAVANNA);
        ClimateDomainRegistry.register("minecraft:savanna_plateau", ClimateDomain.TROPICAL_SAVANNA);
        ClimateDomainRegistry.register("minecraft:shattered_savanna", ClimateDomain.TROPICAL_SAVANNA);
        ClimateDomainRegistry.register("minecraft:shattered_savanna_plateau", ClimateDomain.TROPICAL_SAVANNA);

        ClimateDomainRegistry.register("minecraft:soul_sand_valley", ClimateDomain.HELL);
        ClimateDomainRegistry.register("minecraft:crimson_forest", ClimateDomain.HELL);
        ClimateDomainRegistry.register("minecraft:warped_forest", ClimateDomain.HELL);
        ClimateDomainRegistry.register("minecraft:basalt_deltas", ClimateDomain.HELL);
        ClimateDomainRegistry.register("minecraft:nether_wastes", ClimateDomain.HELL);

        ClimateDomainRegistry.register("minecraft:badlands", ClimateDomain.TEMPERATE_CONTINENTAL_SEMIARID);
        ClimateDomainRegistry.register("minecraft:wooded_badlands_plateau", ClimateDomain.TEMPERATE_CONTINENTAL_MEDITERRANEAN);
        ClimateDomainRegistry.register("minecraft:badlands_plateau", ClimateDomain.TEMPERATE_CONTINENTAL_SEMIARID);
        ClimateDomainRegistry.register("minecraft:eroded_badlands", ClimateDomain.TEMPERATE_CONTINENTAL_SEMIARID);
        ClimateDomainRegistry.register("minecraft:modified_badlands_plateau", ClimateDomain.TEMPERATE_CONTINENTAL_SEMIARID);
        ClimateDomainRegistry.register("minecraft:modified_wooded_badlands_plateau", ClimateDomain.TEMPERATE_CONTINENTAL_MEDITERRANEAN);

        ClimateDomainRegistry.register("minecraft:the_void", ClimateDomain.NONE);
        ClimateDomainRegistry.register("minecraft:the_end", ClimateDomain.NONE);
        ClimateDomainRegistry.register("minecraft:small_end_islands", ClimateDomain.NONE);
        ClimateDomainRegistry.register("minecraft:end_midlands", ClimateDomain.NONE);
        ClimateDomainRegistry.register("minecraft:the_end", ClimateDomain.NONE);
        ClimateDomainRegistry.register("minecraft:small_end_islands", ClimateDomain.NONE);

        /// Caio Cesar Biomes / Caio Cesar's Naturalistic Voyage
        ClimateDomainRegistry.register("caiocesarbiomes:bamboo_subtropical_laurel_jungle", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:montane_laurel_grove", ClimateDomain.HUMID_SUBTROPICAL_HIGHLAND);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_laurel_forest", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_laurel_jungle", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:laurel_forest_river", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:humid_subtropical_beach", ClimateDomain.HUMID_SUBTROPICAL);

        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_extreme_hills", ClimateDomain.HUMID_SUBTROPICAL_HIGHLAND);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_seasonal_forest", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_lucidophyll_oak_forest_beach", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_lucidophyll_oak_forest_river", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:humid_subtropical_pine_forest", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:humid_subtropical_pine_beach", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:humid_subtropical_pine_river", ClimateDomain.HUMID_SUBTROPICAL);

        ClimateDomainRegistry.register("caiocesarbiomes:coastal_subtropical_desert", ClimateDomain.FOGGY_MILD_TROPICAL_DESERT);
        ClimateDomainRegistry.register("caiocesarbiomes:coastal_subtropical_desert_lomas", ClimateDomain.FOGGY_MILD_TROPICAL_DESERT);

        ClimateDomainRegistry.register("caiocesarbiomes:tropical_pine_island", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("caiocesarbiomes:tropical_island", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("caiocesarbiomes:monsoon_ficus_tropical_forest", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("caiocesarbiomes:tropical_bamboo_marsh", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("caiocesarbiomes:tropical_bamboo_marsh_river", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("caiocesarbiomes:tropical_bamboo_beach", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("caiocesarbiomes:tropical_beach", ClimateDomain.TROPICAL_FOREST);

        ClimateDomainRegistry.register("caiocesarbiomes:dry_tropical_beach", ClimateDomain.TROPICAL_SAVANNA);

        ClimateDomainRegistry.register("caiocesarbiomes:cork_oak_savanna", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:cork_oak_beach", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:hot_mediterranean_beach", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_conifer_savanna", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_conifer_savanna_beach", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_oak_woodland", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_oak_sparse_woodland", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_scrubland_river", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_savanna_river", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:mediterranean_scrubland", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:oleander_gardens", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:olive_grove", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:olive_grove_beach", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_pine_dry_forest", ClimateDomain.SUBTROPICAL_HOT_MEDITERRANEAN);

        ClimateDomainRegistry.register("caiocesarbiomes:stony_mediterranean_shore", ClimateDomain.SUBTROPICAL_COOL_MEDITERRANEAN);

        ClimateDomainRegistry.register("caiocesarbiomes:eucalyptus_plains", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:eucalyptus_sahel", ClimateDomain.TROPICAL_SEMIARID);
        ClimateDomainRegistry.register("caiocesarbiomes:eucalyptus_savanna", ClimateDomain.TROPICAL_SAVANNA);
        ClimateDomainRegistry.register("caiocesarbiomes:subtropical_eucalyptus_dry_forest", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("caiocesarbiomes:tropical_eucalyptus_dry_forest", ClimateDomain.TROPICAL_SAVANNA);

        ClimateDomainRegistry.register("caiocesarbiomes:gravel_tundra", ClimateDomain.TUNDRA);
        ClimateDomainRegistry.register("caiocesarbiomes:lush_southern_tundra", ClimateDomain.TUNDRA);
        ClimateDomainRegistry.register("caiocesarbiomes:tussock_tundra", ClimateDomain.TUNDRA);
        ClimateDomainRegistry.register("caiocesarbiomes:tussock_tundra_beach", ClimateDomain.TUNDRA);

        ClimateDomainRegistry.register("caiocesarbiomes:ginkgo_forest", ClimateDomain.TEMPERATE_CONTINENTAL);

        ClimateDomainRegistry.register("caiocesarbiomes:hemiboreal_forest", ClimateDomain.HEMIBOREAL_CONTINENTAL);
        ClimateDomainRegistry.register("caiocesarbiomes:hemiboreal_steppe", ClimateDomain.HEMIBOREAL_CONTINENTAL_SEMIARID);

        ClimateDomainRegistry.register("caiocesarbiomes:inactive_volcanic_site", ClimateDomain.NONE);

        ClimateDomainRegistry.register("caiocesarbiomes:japanese_maple_grove", ClimateDomain.HEMIBOREAL_CONTINENTAL);

        //The Valdivian Decidous Forest biome has a rainforest drought climate.
        ClimateDomainRegistry.register("caiocesarbiomes:pewen_coniferous_grove", ClimateDomain.HUMID_SUBTROPICAL_OCEANIC_MONTANE);
        ClimateDomainRegistry.register("caiocesarbiomes:valdivian_temperate_rainforest", ClimateDomain.HUMID_SUBTROPICAL_OCEANIC);
        ClimateDomainRegistry.register("caiocesarbiomes:valdivian_colun_beach", ClimateDomain.HUMID_SUBTROPICAL_OCEANIC);

        ClimateDomainRegistry.register("caiocesarbiomes:southern_beech_forest", ClimateDomain.SUBPOLAR_OCEANIC);

        ClimateDomainRegistry.register("caiocesarbiomes:sahel", ClimateDomain.TROPICAL_SEMIARID);
        ClimateDomainRegistry.register("caiocesarbiomes:salt_desert", ClimateDomain.NONE);
        ClimateDomainRegistry.register("caiocesarbiomes:socotra_dryland", ClimateDomain.TROPICAL_DESERT);

        ClimateDomainRegistry.register("caiocesarbiomes:temperate_desert", ClimateDomain.TEMPERATE_DESERT);
        ClimateDomainRegistry.register("caiocesarbiomes:temperate_desert_oasis", ClimateDomain.TEMPERATE_DESERT);
        ClimateDomainRegistry.register("caiocesarbiomes:temperate_desert_river", ClimateDomain.TEMPERATE_DESERT);

        ClimateDomainRegistry.register("caiocesarbiomes:tropical_desert", ClimateDomain.TROPICAL_DESERT);

        ClimateDomainRegistry.register("caiocesarbiomes:temperate_rainforest", ClimateDomain.TEMPERATE_COOL_MEDITERRANEAN);

        ClimateDomainRegistry.register("caiocesarbiomes:volcanic_site", ClimateDomain.NONE);

        /// Brazillian Biomes
        ClimateDomainRegistry.register("brbiomesmod:amazon_rainforest", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("brbiomesmod:amazon_varzea_forest", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("brbiomesmod:black_amazon_river", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("brbiomesmod:amazon_rainforest_edge", ClimateDomain.TROPICAL_SAVANNA);

        ClimateDomainRegistry.register("brbiomesmod:araucaria_plateau", ClimateDomain.HUMID_SUBTROPICAL_HIGHLAND);

        ClimateDomainRegistry.register("brbiomesmod:atlantic_forest", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("brbiomesmod:atlantic_forest_hills", ClimateDomain.TROPICAL_MONTANE);
        ClimateDomainRegistry.register("brbiomesmod:atlantic_forest_beach", ClimateDomain.TROPICAL_FOREST);
        ClimateDomainRegistry.register("brbiomesmod:atlantic_forest_river", ClimateDomain.TROPICAL_FOREST);

        ClimateDomainRegistry.register("brbiomesmod:caatinga_shrubland", ClimateDomain.TROPICAL_SEMIARID);

        ClimateDomainRegistry.register("brbiomesmod:cerrado", ClimateDomain.TROPICAL_SAVANNA);

        ClimateDomainRegistry.register("brbiomesmod:dunas_restinga", ClimateDomain.TROPICAL_SAVANNA);
        ClimateDomainRegistry.register("brbiomesmod:restinga_beach", ClimateDomain.TROPICAL_SAVANNA);

        ClimateDomainRegistry.register("brbiomesmod:butia_pampas", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("brbiomesmod:pampas_hills", ClimateDomain.HUMID_SUBTROPICAL_HIGHLAND);
        ClimateDomainRegistry.register("brbiomesmod:pampas", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("brbiomesmod:pampas_coastal_fields", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("brbiomesmod:pampas_river", ClimateDomain.HUMID_SUBTROPICAL);
        ClimateDomainRegistry.register("brbiomesmod:pampas_beach", ClimateDomain.HUMID_SUBTROPICAL);

        ClimateDomainRegistry.register("brbiomesmod:pantanal", ClimateDomain.TROPICAL_SAVANNA);
        ClimateDomainRegistry.register("brbiomesmod:cocal_forest", ClimateDomain.TROPICAL_SAVANNA);

    }
}
