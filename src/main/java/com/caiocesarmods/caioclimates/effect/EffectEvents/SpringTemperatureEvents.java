package com.caiocesarmods.caioclimates.effect.EffectEvents;

import com.caiocesarmods.caioclimates.CaioClimates;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID)
public class SpringTemperatureEvents {



    /*
        /// EQUATORIAL BIOMES (temp > 0.95F)
        if (temp >= 0.95F) {
            if (heat == SummerHeat.VERY_HOT) {
                if (season.equals("SPRING")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            320,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                }
                if (season.equals("SUMMER")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            420,   // duration in ticks
                            2      // amplifier (Hot III)
                    ));
                }
                if (season.equals("FALL")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            320,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                }
                if (season.equals("WINTER") && hottestPartOfDay) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            180,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }
            }

            if (heat == SummerHeat.HOT) {
                if (season.equals("SPRING")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            120,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }
                if (season.equals("SUMMER")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            320,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                }
                if (season.equals("FALL")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            120,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }
            }
        }

        /// BORDERLINE TROPICAL BIOMES (temp > 0.9F and < 0.95F)
        if (temp >= 0.95F) {
            if (heat == SummerHeat.VERY_HOT) {
                if (season.equals("SPRING")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            320,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                }
                if (season.equals("SUMMER")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            220,   // duration in ticks
                            2      // amplifier (Hot III)
                    ));
                }
                if (season.equals("FALL")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            120,   // duration in ticks
                            0      // amplifier (Hot I)
                    ));
                }
                if (season.equals("WINTER")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            80,   // duration in ticks
                            0      // amplifier (Cold I)
                    ));
                }
            }

            if (heat == SummerHeat.HOT) {
                if (season.equals("SUMMER")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.HOT.get(),
                            320,   // duration in ticks
                            1      // amplifier (Hot II)
                    ));
                }
                if (season.equals("WINTER")) {
                    player.addPotionEffect(new EffectInstance(
                            ModEffects.COLD.get(),
                            85,   // duration in ticks
                            0      // amplifier (Cold I)
                    ));
                }
            }
        }

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
    }*/


}
