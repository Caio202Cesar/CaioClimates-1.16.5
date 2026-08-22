package com.caiocesarmods.caioclimates;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = {Dist.CLIENT}
)

public class CaioClimatesBlocks$BlocksClientSideHandler {
    public CaioClimatesBlocks$BlocksClientSideHandler() {}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //Seasonal tulip
    }
}
