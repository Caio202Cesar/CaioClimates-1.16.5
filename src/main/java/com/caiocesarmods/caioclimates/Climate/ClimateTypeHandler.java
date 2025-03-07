package com.caiocesarmods.caioclimates.Climate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClimateTypeHandler {
    public static ClimateType getBiomeClimate(Biome biome) {
        if (biome == null) {
            CaioCLimates.LOGGER.warn("getBiomeClimate: Biome is NULL!");
            return null;
        }
        ResourceLocation biomeID = biome.getRegistryName();
    }
}
