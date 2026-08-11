package com.caiocesarmods.caioclimates;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Climate.Moisture.MoistureProvider;
import com.caiocesarmods.caioclimates.Climate.Moisture.VegetationMoistureManager;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID)
public class CapabilityEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<World> event) {

        if (!(event.getObject() instanceof ServerWorld)) {
            return;
        }

        ServerWorld world = (ServerWorld) event.getObject();

        if (world.getDimensionKey() != World.OVERWORLD) {
            return;
        }

        event.addCapability(
                MoistureProvider.ID,
                new MoistureProvider()
        );
    }

    @SubscribeEvent
    public static void onWorldLoad(net.minecraftforge.event.world.WorldEvent.Load event) {

        if (!(event.getWorld() instanceof ServerWorld))
            return;

        ServerWorld world = (ServerWorld) event.getWorld();

        world.getCapability(MoistureProvider.MOISTURE_CAPABILITY).ifPresent(data -> {

            System.out.println("===== Moisture Capability =====");

            for (DroughtPattern pattern : DroughtPattern.values()) {

                System.out.println(
                        pattern.name() + " = " +
                                data.getMoisture(pattern));
            }

            System.out.println("===============================");
        });

    }

    @SubscribeEvent
    public static void onWorldTick(TickEvent.WorldTickEvent event) {

        if (event.phase != TickEvent.Phase.END)
            return;

        if (!(event.world instanceof ServerWorld))
            return;

        ServerWorld world = (ServerWorld) event.world;

        // Overworld only
        if (world.getDimensionKey() != World.OVERWORLD)
            return;

        if (world.getDayTime() % 24000L == 0L) {
            VegetationMoistureManager.tick(world);
        }
    }
}
