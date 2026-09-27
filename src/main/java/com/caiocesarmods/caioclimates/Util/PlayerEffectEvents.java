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
        long time = world.getDayTime() % 24000L;
        boolean hottestPartOfDay = time >= 7000 && time <= 11000;

        ///case for HOT summer biomes
        if (heat == SummerHeat.HOT) {
            if (season.equals("SUMMER") && hottestPartOfDay) {
                player.addPotionEffect(new EffectInstance(
                        ModEffects.HOT.get(),
                        220,   // duration in ticks
                        0      // amplifier (Hot I)
                ));
            }
        }
    }
}
