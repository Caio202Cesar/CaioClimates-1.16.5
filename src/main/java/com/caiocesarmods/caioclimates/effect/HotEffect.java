package com.caiocesarmods.caioclimates.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

//Heat-caused discomfort = this is applied in following situations: summers with temperature hot to above, moderate heat sources
public class HotEffect extends Effect {
    protected HotEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.NEUTRAL, 0xF3CB21);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (!(entity instanceof PlayerEntity)) {
            return;
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
