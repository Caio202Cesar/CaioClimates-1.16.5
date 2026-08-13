package com.caiocesarmods.caioclimates.Util;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VanillaTreeRemover {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {

        if (event.getName() == null) {
            return;
        }

        List<Supplier<ConfiguredFeature<?, ?>>> vegetation =
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

        System.out.println("Biome: " + event.getName());

        for (Supplier<ConfiguredFeature<?, ?>> supplier : vegetation) {
            ConfiguredFeature<?, ?> feature = supplier.get();

            if (feature == Features.TREES_JUNGLE) {
                System.out.println("Found TREES_JUNGLE");
            }

            if (feature == Features.TREES_JUNGLE_EDGE) {
                System.out.println("Found TREES_JUNGLE_EDGE");
            }

            if (feature == Features.BAMBOO_VEGETATION) {
                System.out.println("Found BAMBOO_VEGETATION");
            }

            if (feature == Features.TREES_SAVANNA) {
                System.out.println("Found TREES_SAVANNA");
            }

            if (feature == Features.TREES_SHATTERED_SAVANNA) {
                System.out.println("Found TREES_SHATTERED_SAVANNA");
            }
        }
    }
}
