package com.caiocesarmods.caioclimates.effect.ClimateEffects;

import com.caiocesarmods.caioclimates.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ColdEffect extends Effect {
    public ColdEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.NEUTRAL, 0x8ecc8e);
    }

    private static final String COLD_EXPOSURE = "coldExposure";

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if ((entity instanceof PlayerEntity)) {

            World world = entity.world;

            entity.addPotionEffect(new EffectInstance(
                    Effects.HASTE,
                    40,
                    amplifier
            ));

            entity.addPotionEffect(new EffectInstance(
                    Effects.SATURATION,
                    40,
                    amplifier
            ));
        }

        if (entity.isPotionActive(ModEffects.COLD.get())) {

            int exposure = entity.getPersistentData().getInt(COLD_EXPOSURE);

            EffectInstance cold = entity.getActivePotionEffect(ModEffects.COLD.get());

            if (amplifier == 0) {
                exposure++;
            }

            if (amplifier == 1) {
                exposure += 2;
            }

            if (amplifier >= 2) {
                exposure += 3;
            }

            entity.getPersistentData().putInt(COLD_EXPOSURE, exposure);

            if (exposure >= 110) {

                entity.addPotionEffect(new EffectInstance(
                        ModEffects.HYPOTHERMIA.get(),
                        200,
                        0
                ));

            }


            if (exposure >= 80 && amplifier >= 1) {

                entity.addPotionEffect(new EffectInstance(
                        ModEffects.HYPOTHERMIA.get(),
                        200,
                        1
                ));

            }


            if (exposure >= 50 && amplifier >= 2) {

                entity.addPotionEffect(new EffectInstance(
                        ModEffects.HYPOTHERMIA.get(),
                        200,
                        2
                ));

            }

        }
        else {

            int exposure = entity.getPersistentData()
                    .getInt(COLD_EXPOSURE);

            if (exposure > 0) {
                entity.getPersistentData()
                        .putInt(COLD_EXPOSURE, exposure - 1);
            }

        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
