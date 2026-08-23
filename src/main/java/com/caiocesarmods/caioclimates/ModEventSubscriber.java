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
                    0.59f,                    // new temperature - hardiness zone 5
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

        if (event.getCategory() == Biome.Category.SAVANNA) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            if (path.contains("plateau")) {
                System.out.println("[DEBUG] Overriding temperature for Savanna: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.NONE,
                        1.2f,
                        Biome.TemperatureModifier.NONE,
                        0.35f));
            }
        }

        if (event.getCategory() == Biome.Category.ICY) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            if (path.contains("ice")) {
                System.out.println("[DEBUG] Overriding temperature for Icy Biome: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.NONE,
                        -0.5f,
                        Biome.TemperatureModifier.NONE,
                        0.0f));
            }

            else if (path.contains("snowy")) {
                System.out.println("[DEBUG] Overriding temperature for Snowy Biome: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.12f,
                        Biome.TemperatureModifier.NONE,
                        0.3f));
            }
        }

        if (event.getCategory() == Biome.Category.RIVER) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            if (path.contains("frozen")) {
                System.out.println("[DEBUG] Overriding temperature for Frozen River: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        -0.5f,
                        Biome.TemperatureModifier.NONE,
                        0.0f));
            }
        }

        if (event.getCategory() == Biome.Category.TAIGA) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            if (path.contains("snowy")) {
                System.out.println("[DEBUG] Overriding temperature for Snowy Taiga: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.17f,
                        Biome.TemperatureModifier.NONE,
                        0.4f));
            }
        }

        if (event.getCategory() == Biome.Category.BEACH) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            if (path.contains("snowy")) {
                System.out.println("[DEBUG] Overriding temperature for Snowy Taiga: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.17f,
                        Biome.TemperatureModifier.NONE,
                        0.4f));
            }

            else {// Beach for forest biomes
                System.out.println("[DEBUG] Overriding temperature for Beach: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.74f,                          // hardiness zone 7
                        Biome.TemperatureModifier.NONE,
                        0.8f
                ));
            }
        }

        if (event.getCategory() == Biome.Category.OCEAN) {

            ResourceLocation id = event.getName();
            if (id == null) return;

            String path = id.getPath();
            String namespace = id.getNamespace();

            // skip mod biomes
            if (namespace.equals("caiocesarbiomes")) return;
            if (namespace.equals("brbiomesmod")) return;

            //For warm ocean
            if (path.contains("warm")) {
                System.out.println("[DEBUG] Overriding temperature for Warm Oceans: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.95f,
                        Biome.TemperatureModifier.NONE,
                        0.5f));
            }

            else if (path.contains("lukewarm")) {
                System.out.println("[DEBUG] Overriding temperature for Lukewarm Oceans: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.87f,
                        Biome.TemperatureModifier.NONE,
                        0.5f));
            }

            else if (path.contains("cold")) {
                System.out.println("[DEBUG] Overriding temperature for Cold Oceans: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.65f,
                        Biome.TemperatureModifier.NONE,
                        0.5f));
            }

            else if (path.contains("frozen")) {
                System.out.println("[DEBUG] Overriding temperature for Frozen Oceans: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.12f,
                        Biome.TemperatureModifier.NONE,
                        0.5f));
            }

            else {// Beach for forest biomes
                System.out.println("[DEBUG] Overriding temperature for Ocean: " + id);
                event.setClimate(new Biome.Climate(
                        Biome.RainType.RAIN,
                        0.78f,
                        Biome.TemperatureModifier.NONE,
                        0.8f
                ));
            }
        }
    }
}
