package com.caiocesarmods.caioclimates.Util;

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
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CaioClimates.MOD_ID)
public class PlayerEffectEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;

        if (player.world.isRemote) {
            return;
        }

        World world = player.world;
        BlockPos pos = player.getPosition();

        String season = Season.getSeason(world.getDayTime());
        String phase = SeasonalPhase.getPhase(world.getDayTime());

        SummerHeat heat = SummerHeat.fromTemperature(SummerHeatHelper.get(world, pos));

        //case for hot summer biomes
        if (heat == SummerHeat.HOT) {
            if (season.equals("SUMMER")) {
                player.addPotionEffect(new EffectInstance(
                        ModEffects.HOT.get(),
                        220,   // duration in ticks
                        0      // amplifier (Hot I)
                ));
            }
        }

        /*
        if (season.equals("SUMMER")) {


            if (heat == SummerHeat.HOT) {
                // Give Hot I
            } else if (heat == SummerHeat.VERY_HOT) {
                // Give Hot II
            } else if (heat == SummerHeat.SCORCHING) {
                // Give Hot III
            } else {
                // Remove Hot
            }

        } else {
            // Remove Hot
        }*/
    }
}
