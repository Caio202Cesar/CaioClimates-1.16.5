package com.caiocesarmods.caioclimates.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

//Heat-caused discomfort
public class HotEffect extends Effect {
    protected HotEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.NEUTRAL, 0xF3CB21);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (!(entity instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity player = (PlayerEntity) entity;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
