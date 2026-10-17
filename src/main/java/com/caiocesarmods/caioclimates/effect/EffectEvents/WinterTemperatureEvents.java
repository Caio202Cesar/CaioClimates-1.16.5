package com.caiocesarmods.caioclimates.effect.EffectEvents;

import com.caiocesarmods.caioclimates.CaioClimates;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeat;
import com.caiocesarmods.caioclimates.Climate.SummerHeat.SummerHeatHelper;
import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import com.caiocesarmods.caioclimates.effect.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID)
public class WinterTemperatureEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;

        if (player.world.isRemote) {
            return;
        }

        World world = player.world;
        BlockPos pos = player.getPosition();

        Biome biome = world.getBiome(pos);
        float temp = biome.getTemperature(pos);

        String season = Season.getSeason(world.getDayTime());
        String phase = SeasonalPhase.getPhase(world.getDayTime());

        SummerHeat heat = SummerHeat.fromTemperature(SummerHeatHelper.get(world, pos));
        long time = world.getDayTime() % 24000L;
        boolean hottestPartOfDay = time >= 5000 && time <= 11000;

        if (season.equals("WINTER")) {
            /// EQUATORIAL BIOMES (temp > 0.95F)
            if (temp >= 0.95F) {
                if (heat == SummerHeat.VERY_HOT && hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            80,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }
            }

            /// MARGINAL TROPICAL BIOMES (temp <= 0.94F)
            if (temp <= 0.94F && !hottestPartOfDay) {
                player.addPotionEffect(new EffectInstance(
                        ModEffects.COLD.get(),
                        75,   // duration in ticks
                        0      // amplifier (Cold I)
                ));
            }

            /// SUBTROPICAL BIOMES ZONE 10 (temp 0.85-0.89F)
            if (temp <= 0.89F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            92,   // duration in ticks
                            0      // amplifier (Cold I)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            125,   // duration in ticks
                            1      // amplifier (Cold II)
                    ));
                }
            }

            /// SUBTROPICAL BIOMES ZONE 9 (temp 0.8-0.84F)
            if (temp <= 0.84F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            100,   // duration in ticks
                            0      // amplifier (Cold I)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            175,   // duration in ticks
                            1      // amplifier (Cold II)
                    ));
                }
            }

            /// TEMPERATE BIOMES ZONE 8 (temp <= 0.79F)
            if (temp <= 0.79F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            132,   // duration in ticks
                            1      // amplifier (Cold II)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            255,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                }
            }

            /// TEMPERATE BIOMES ZONE 7 (temp <= 0.74F)
            if (temp <= 0.74F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            242,   // duration in ticks
                            1      // amplifier (Cold II)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            396,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                }
            }


            /// COLD TEMPERATE BIOMES ZONE 6 (temp <= 0.69F)
            if (temp <= 0.69F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            322,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            465,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                }
            }

            if (temp <= 0.64F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            472,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            465,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                }
            }

            /// COLD TEMPERATE BIOMES ZONE 5 (temp <= 0.59F)
            if (temp <= 0.69F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            472,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            597,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                }
            }

            /// COLD TEMPERATE BIOMES ZONE 4 (temp <= 0.59F)
            if (temp <= 0.69F) {
                if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            672,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            897,   // duration in ticks
                            2      // amplifier (Cold III)
                    ));
                }
            }
        }
    }
}
