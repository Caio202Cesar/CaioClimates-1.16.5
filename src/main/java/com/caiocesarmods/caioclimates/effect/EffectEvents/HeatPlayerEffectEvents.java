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

//Add also ways to amenize these effects
@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID)
public class HeatPlayerEffectEvents {
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

        /// BORDERLINE TROPICAL BIOMES (temp > 0.9F and < 0.95F)

        /// TEMPERATE BIOMES
        if (temp <= 0.89F) {

            //case for WARM summer
            if (heat == SummerHeat.WARM) {
                if (season.equals("SUMMER") && hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            220,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }
            }

            //case for HOT summer
            if (heat == SummerHeat.HOT) {
                if (season.equals("SUMMER")) {
                    if (hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            220,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                } else {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            180,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                    }
                }
            }

            //case for VERY HOT summer
            if (heat == SummerHeat.VERY_HOT) {
                if (phase.equals("LATE_SPRING") && hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            220,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }

                else if (season.equals("SUMMER")) {
                    if (hottestPartOfDay) {
                        player.addPotionEffect(new EffectInstance(
                                ModEffects.HOT.get(),
                                500,   // duration in ticks
                                2      // amplifier (Hot III)
                        ));
                    } else {
                        player.addPotionEffect(new EffectInstance(
                                ModEffects.HOT.get(),
                                240,   // duration in ticks
                                1      // amplifier (Hot II)
                        ));
                    }
                }

                else if (phase.equals("EARLY_FALL") && hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            220,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                }
            }
        }
    }
}

