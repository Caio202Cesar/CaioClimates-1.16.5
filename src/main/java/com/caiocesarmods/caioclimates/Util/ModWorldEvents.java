package com.caiocesarmods.caioclimates.Util;

import com.caiocesarmods.caioclimates.CaioClimates;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        //ModPlantGeneration.generatePlants(event);
        ModTreeGeneration.generateTrees(event);
    }
}
