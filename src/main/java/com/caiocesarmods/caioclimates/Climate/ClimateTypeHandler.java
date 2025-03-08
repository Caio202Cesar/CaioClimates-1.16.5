package com.caiocesarmods.caioclimates.Climate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class ClimateTypeHandler {
    private static final Map<ResourceLocation, ClimateType> BIOME_CLIMATE_MAP = new HashMap<>();

    static {
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:plains"), ClimateType.HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:desert"), ClimateType.SUBTROPICAL_DESERT);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:mountains"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:forest"), ClimateType.HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:taiga"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:swamp"), ClimateType.HUMID_SUBTROPICAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:frozen_ocean"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:frozen_river"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:snowy_tundra"), ClimateType.TUNDRA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:snowy_mountains"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:mushroom_fields"), ClimateType.TROPICAL_RAINFOREST);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:mushroom_field_shore"), ClimateType.TROPICAL_RAINFOREST);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:desert_hills"), ClimateType.SUBTROPICAL_DESERT);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:wooded_hills"), ClimateType.HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:taiga_hills"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:mountain_edge"), ClimateType.HEMIBOREAL_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:jungle"), ClimateType.TROPICAL_RAINFOREST);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:jungle_hills"), ClimateType.TROPICAL_RAINFOREST);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:jungle_edge"), ClimateType.TROPICAL_RAINFOREST_EDGE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:snowy_beach"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:birch_forest"), ClimateType.HEMIBOREAL_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:birch_forest_hills"), ClimateType.HEMIBOREAL_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:dark_forest"), ClimateType.MARITIME_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:snowy_taiga"), ClimateType.SNOWY_TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:snowy_taiga_hills"), ClimateType.SNOWY_TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:giant_tree_taiga"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:giant_tree_taiga_hills"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:wooded_mountains"), ClimateType.TUNDRA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:savanna"), ClimateType.TROPICAL_SAVANNA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:savanna_plateau"), ClimateType.TROPICAL_SAVANNA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:badlands"), ClimateType.XERIC_TEMPERATE_CONTINENTAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:wooded_badlands_plateau"), ClimateType.HEMIBOREAL_MEDITERRANEAN_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:badlands_plateau"), ClimateType.XERIC_TEMPERATE_CONTINENTAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:warm_ocean"), ClimateType.MARITIME_TROPICAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:lukewarm_ocean"), ClimateType.MARITIME_HUMID_SUBTROPICAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:ocean"), ClimateType.MARITIME_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:cold_ocean"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:frozen_ocean"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:deep_lukewarm_ocean"), ClimateType.MARITIME_HUMID_SUBTROPICAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:deep_ocean"), ClimateType.MARITIME_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:deep_cold_ocean"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:deep_frozen_ocean"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:sunflower_plains"), ClimateType.HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:desert_lakes"), ClimateType.SUBTROPICAL_DESERT);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:gravelly_mountains"), ClimateType.TUNDRA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:flower_forest"), ClimateType.HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:taiga_mountains"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:swamp_hills"), ClimateType.HUMID_SUBTROPICAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:ice_spikes"), ClimateType.ICE_CAP);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:modified_jungle"), ClimateType.TROPICAL_RAINFOREST);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:modified_jungle"), ClimateType.TROPICAL_RAINFOREST_EDGE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:tall_birch_forest"), ClimateType.HEMIBOREAL_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:dark_forest_hills"), ClimateType.MARITIME_HUMID_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:snowy_taiga_mountains"), ClimateType.SNOWY_TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:giant_spruce_taiga"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:giant_spruce_taiga_hills"), ClimateType.TAIGA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:modified_gravelly_mountains"), ClimateType.TUNDRA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:shattered_savanna"), ClimateType.TROPICAL_SAVANNA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:shattered_savanna_plateau"), ClimateType.TROPICAL_SAVANNA);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:eroded_badlands"), ClimateType.XERIC_TEMPERATE_CONTINENTAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:modified_wooded_badlands_plateau"), ClimateType.HEMIBOREAL_MEDITERRANEAN_TEMPERATE);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:modified_badlands_plateau"), ClimateType.XERIC_TEMPERATE_CONTINENTAL);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:bamboo_jungle"), ClimateType.TROPICAL_RAINFOREST);
        BIOME_CLIMATE_MAP.put(new ResourceLocation("minecraft:bamboo_jungle_hills"), ClimateType.TROPICAL_RAINFOREST);

    }

    public static ClimateType getClimateForBiome(Biome biome) {
        ResourceLocation biomeID = biome.getRegistryName();
        if (BIOME_CLIMATE_MAP.containsKey(biomeID)) {
            return BIOME_CLIMATE_MAP.get(biomeID);
        }
        float temp = biome.getTemperature();
        Biome.RainType rainType = biome.getPrecipitation();

        if (temp < 0.15F) {
            return ClimateType.ICE_CAP;
        } else if (temp < 0.4F) {
            return ClimateType.TAIGA;
        } else if (temp < 0.8F) {
            return ClimateType.MARITIME_HUMID_TEMPERATE;
        } else {
            return rainType == Biome.RainType.NONE ? ClimateType.TROPICAL_DESERT : ClimateType.TROPICAL_RAINFOREST;
        }
    }
}
