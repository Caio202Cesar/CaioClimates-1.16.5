package com.caiocesarmods.caioclimates;

import com.caiocesarmods.caioclimates.Seasons.SetSeasonCommand;
import com.caiocesarmods.caioclimates.Util.BiomeClimateHUD;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        BiomeClimateHUD.onRenderGameOverlay(event);
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        SetSeasonCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {

        if (event.getCategory() == Biome.Category.PLAINS) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String namespace = id.getNamespace();

            // ⛔ Skip all biomes from caiocesarbiomes
            if (namespace.equals("caiocesarbiomes")) {
                System.out.println("[DEBUG] Skipping biomes from caiocesarbiomes: " + id);
                return;
            }

            // 🛑 Skip all biomes from brbiomesmod
            if (namespace.equals("brbiomesmod")) {
                System.out.println("[DEBUG] Skipping biomes from brbiomesmod: " + id);
                return;
            }

            // ✔ Only vanilla (or other-mod) mesa biomes reach this point
            System.out.println("[DEBUG] Overriding temperature for: " + id);

            event.setClimate(new Biome.Climate(
                    Biome.RainType.RAIN,          // rain
                    0.74f,                         // new temperature - hardiness zone 7
                    Biome.TemperatureModifier.NONE,
                    0.4f                          // downfall
            ));
        }


        if (event.getCategory() == Biome.Category.MESA) {

            System.out.println("[DEBUG] Overriding Badlands temperature!");

            event.setClimate(new Biome.Climate(
                    Biome.RainType.NONE,     // rain type
                    0.69f,                    // new temperature - hardiness zone 6
                    Biome.TemperatureModifier.NONE,
                    0.0f                     // downfall
            ));
        }

        if (event.getCategory() == Biome.Category.JUNGLE) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String namespace = id.getNamespace();

            // ⛔ Skip all biomes from caiocesarbiomes
            if (namespace.equals("caiocesarbiomes")) {
                System.out.println("[DEBUG] Skipping biomes from caiocesarbiomes: " + id);
                return;
            }

            // 🛑 Skip all biomes from brbiomesmod
            if (namespace.equals("brbiomesmod")) {
                System.out.println("[DEBUG] Skipping biomes from brbiomesmod: " + id);
                return;
            }

            // ✔ Only vanilla (or other-mod) mesa biomes reach this point
            System.out.println("[DEBUG] Overriding temperature for: " + id);

            event.setClimate(new Biome.Climate(
                    Biome.RainType.RAIN,          // rain
                    1.2f,                         // new temperature
                    Biome.TemperatureModifier.NONE,
                    0.9f                          // downfall
            ));
        }

        if (event.getCategory() == Biome.Category.SWAMP) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String namespace = id.getNamespace();

            // ⛔ Skip all biomes from caiocesarbiomes
            if (namespace.equals("caiocesarbiomes")) {
                System.out.println("[DEBUG] Skipping biomes from caiocesarbiomes: " + id);
                return;
            }

            // 🛑 Skip all biomes from brbiomesmod
            if (namespace.equals("brbiomesmod")) {
                System.out.println("[DEBUG] Skipping biomes from brbiomesmod: " + id);
                return;
            }

            // ✔ Only vanilla (or other-mod) mesa biomes reach this point
            System.out.println("[DEBUG] Overriding temperature for: " + id);

            event.setClimate(new Biome.Climate(
                    Biome.RainType.RAIN,          // rain
                    0.84f,                         // new temperature - hardiness zone 9
                    Biome.TemperatureModifier.NONE,
                    0.9f                          // downfall
            ));
        }

        if (event.getCategory() == Biome.Category.FOREST) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            // skip ALL birch forest variants
            if (path.contains("birch")) {
                System.out.println("[DEBUG] Skipping Birch Forest: " + id);
                return;
            }

            if (path.contains("dark")) {
                System.out.println("[DEBUG] Overriding temperature for Dark Forest: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.79f,                          // hardiness zone 8
                        Biome.TemperatureModifier.NONE,
                        0.8f));
            }

            else {// If reached, apply override
                System.out.println("[DEBUG] Overriding temperature for: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.74f,                          // hardiness zone 7
                        Biome.TemperatureModifier.NONE,
                        0.8f
                ));
            }
        }

        if (event.getCategory() == Biome.Category.DESERT) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String namespace = id.getNamespace();

            // ⛔ Skip all biomes from caiocesarbiomes
            if (namespace.equals("caiocesarbiomes")) {
                System.out.println("[DEBUG] Skipping biomes from caiocesarbiomes: " + id);
                return;
            }

            // 🛑 Skip all biomes from brbiomesmod
            if (namespace.equals("brbiomesmod")) {
                System.out.println("[DEBUG] Skipping biomes from brbiomesmod: " + id);
                return;
            }

            // ✔ Only vanilla (or other-mod) mesa biomes reach this point
            System.out.println("[DEBUG] Overriding temperature for: " + id);

            event.setClimate(new Biome.Climate(
                    Biome.RainType.NONE,          // rain
                    0.89f,                         // new temperature - hardiness zone 10
                    Biome.TemperatureModifier.NONE,
                    0.0f                          // downfall
            ));
        }
    }
}
