package com.caiocesarmods.caioclimates.effect.ClimateEffects;

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

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if ((entity instanceof PlayerEntity)) {

            World world = entity.world;

            entity.addPotionEffect(new EffectInstance(
                    Effects.HUNGER,
                    40,
                    amplifier
            ));

            entity.addPotionEffect(new EffectInstance(
                    Effects.WEAKNESS,
                    40,
                    amplifier
            ));

            entity.addPotionEffect(new EffectInstance(
                    Effects.MINING_FATIGUE,
                    40,
                    amplifier
            ));
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
