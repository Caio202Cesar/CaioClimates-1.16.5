package com.caiocesarmods.caioclimates.HardinessZones;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import com.caiocesarmods.caioclimates.HardinessZones.PlantClimateConditions;

import java.util.HashMap;
import java.util.Map;

public class PlantClimateConditionsRegistry {
    public static void register() {
        /// Vanilla Minecraft
        PlantClimateConditions.register(new ResourceLocation("minecraft", "oak_sapling"),
                3, 10, 5, 0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "spruce_sapling"),
                1, 7, 1, 0F, 0.84F, SummerHeat.COOLER, SummerHeat.HOT, SummerHeat.HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "birch_sapling"),
                2, 7, 3,0F, 1F, SummerHeat.COOLER, SummerHeat.WARM, SummerHeat.WARM,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "jungle_sapling"), //Max zone 11 because of cacao
                11, 12, 11,0F, 1F, SummerHeat.WARM, SummerHeat.VERY_HOT, SummerHeat.HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "acacia_sapling"),
                9, 12, 10,0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.SCORCHING,
                Biome.RainType.RAIN);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "dark_oak_sapling"),
                3, 9, 5,0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "bamboo_sapling"),
                4, 12, 7,0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("minecraft", "sweet_berry_bush"),
                0, 6, 0,0F, 1F, SummerHeat.ICY, SummerHeat.MILD, SummerHeat.MILD,
                null);

        /// Caio Cesar's Biomes saplings
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "acerola_sapling"),
                9, 12, 10,0F, 1F, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "agathis_sapling"),
                8, 12, 10,0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "aleppo_pine_sapling"),
                8, 10, 8,0F, 1F, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.SCORCHING,
                Biome.RainType.RAIN);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "almond_sapling"),
                5, 10, 8,0F, 1F, SummerHeat.WARM, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                Biome.RainType.RAIN);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "apple_sapling"),
                2, 10, 7,0F, 1F, SummerHeat.COOLER, SummerHeat.SCORCHING, SummerHeat.HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "aspen_sapling"),
                2, 7, 3,0F, 1F, SummerHeat.COOLER, SummerHeat.WARM, SummerHeat.WARM,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "avocado_sapling"),
                8, 12, 10,0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "bald_cypress_sapling"),
                4, 11, 5,0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "banana_sapling"),
                9, 12, 10,0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "baobab_sapling"),
                10, 12, 11,0F, 1F, SummerHeat.HOT, SummerHeat.SCORCHING,
                SummerHeat.VERY_HOT, Biome.RainType.RAIN);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "bismarck_palm_sapling"),
                9, 12, 10,0F, 1F, SummerHeat.HOT, SummerHeat.SCORCHING, SummerHeat.SCORCHING,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "black_poplar_sapling"),
                2, 10, 4,0F, 1F, SummerHeat.COOLER, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "blackwood_acacia_sapling"),
                8, 10, 9,0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "canary_date_sapling"),
                8, 12, 9,0.0F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "cinnamon_sapling"),
                10, 12, 11,0.8F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "pohutukawa_sapling"),
                9, 12, 10,0.0F, 1F, SummerHeat.MILD, SummerHeat.VERY_HOT, SummerHeat.HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "durian_sapling"),
                11, 12, 11,0.7F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "lychee_sapling"),
                9, 12, 10,0.35F, 1F, SummerHeat.WARM, SummerHeat.VERY_HOT, SummerHeat.HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "monkey_puzzle_sapling"),
                7, 10, 8,0.7F, 1F, SummerHeat.COOLER, SummerHeat.HOT, SummerHeat.WARM,
                null);
        PlantClimateConditions.register(new ResourceLocation("caiocesarbiomes", "fig_sapling"),
                5, 10, 8,0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);

        //Soursop, Mangosteen, Rambutan, Genipapo are ultratropical (zone 11 to above)

        ///Brazillian Biomes
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "acai_sapling"),
                11, 12, 11,0.5F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "acoita_cavalo_sapling"),
                9, 12, 10,0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "algarrobillo_sapling"),
                9, 12, 10,0F, 0.7F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "apricot_ipe_sapling"),
                9, 12, 10,0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "babassu_sapling"),
                11, 12, 11,0F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "bacuri_sapling"),
                11, 12, 11,0F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "balsa_sapling"),
                11, 12, 11,0F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "black_jurema_sapling"),
                9, 12, 10, 0.0F, 0.6F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "black_sucupira_sapling"),
                10, 12, 11, 0.0F, 1.0F, SummerHeat.WARM, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "bracatinga_sapling"),
                8, 10, 9, 0.7F, 1F, SummerHeat.MILD, SummerHeat.HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "brazillian_pepper_sapling"),
                9, 12, 10, 0.0F, 1F, SummerHeat.MILD, SummerHeat.SCORCHING, SummerHeat.VERY_HOT,
                null);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "cambuci_sapling"),
                9, 11, 10, 0.8F, 1F, SummerHeat.MILD, SummerHeat.HOT, SummerHeat.HOT,
                Biome.RainType.NONE);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "jenipapo_sapling"),
                11, 12, 11, 0F, 1F, SummerHeat.WARM, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                null, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "parana_pine_sapling"),
                8, 10, 9, 0F, 1F, SummerHeat.MILD, SummerHeat.HOT, SummerHeat.WARM,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "kapok_sapling"),
                10, 12, 11, 7F, 1F, SummerHeat.HOT, SummerHeat.VERY_HOT, SummerHeat.VERY_HOT,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
        PlantClimateConditions.register(new ResourceLocation("brbiomesmod", "sapucaia_sapling"),
                10, 12, 9, 0F, 1F, SummerHeat.WARM, SummerHeat.VERY_HOT, SummerHeat.WARM,
                null, DroughtPattern.SEMI_ARID, DroughtPattern.ARID);
    }
}
