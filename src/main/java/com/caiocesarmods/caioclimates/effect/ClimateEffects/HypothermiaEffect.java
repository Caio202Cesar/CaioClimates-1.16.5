package com.caiocesarmods.caioclimates.effect.ClimateEffects;

import com.caiocesarmods.caioclimates.effect.ModDamageSources;
import com.caiocesarmods.caioclimates.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class HypothermiaEffect extends Effect {
    public HypothermiaEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.HARMFUL, 0x475766);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if ((entity instanceof PlayerEntity)) {

            World world = entity.world;

            entity.addPotionEffect(new EffectInstance(
                    Effects.HUNGER,
                    80,
                    amplifier
            ));

            entity.addPotionEffect(new EffectInstance(
                    Effects.WEAKNESS,
                    80,
                    amplifier
            ));

            entity.addPotionEffect(new EffectInstance(
                    Effects.MINING_FATIGUE,
                    80,
                    amplifier
            ));

            entity.attackEntityFrom(ModDamageSources.HYPOTHERMIA, 1.0F);
        }

        if (entity.isPotionActive(ModEffects.COLD.get())) {

            EffectInstance cold = entity.getActivePotionEffect(ModEffects.COLD.get());

            assert cold != null;
            int duration = cold.getDuration();

            if (amplifier == 0 && duration <= 115) {
                entity.addPotionEffect(new EffectInstance(
                        ModEffects.HYPOTHERMIA.get(),
                        200,
                        0
                ));
            }


            if (amplifier == 1 && duration <= 80) {
                entity.addPotionEffect(new EffectInstance(
                        ModEffects.HYPOTHERMIA.get(),
                        200,
                        1
                ));
            }


            if (amplifier >= 2 && duration <= 50) {
                entity.addPotionEffect(new EffectInstance(
                        ModEffects.HYPOTHERMIA.get(),
                        200,
                        3
                ));
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int interval = 100 >> amplifier;

        // Hypothermia I: every 5 seconds
        // Hypothermia II: every 2.5 seconds
        // Hypothermia III: every 1.25 seconds
        return duration % interval == 0;
    }
}
