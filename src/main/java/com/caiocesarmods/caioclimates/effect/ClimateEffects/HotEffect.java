package com.caiocesarmods.caioclimates.effect.ClimateEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

//Heat-caused discomfort = this is applied in following situations: summers with temperature hot to above, moderate heat sources
public class HotEffect extends Effect {
    public HotEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.NEUTRAL, 0xF3CB21);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if ((entity instanceof PlayerEntity)) {

            World world = entity.world;

            if (!world.isRemote) {
                ((ServerWorld) world).spawnParticle(
                        ParticleTypes.FALLING_WATER,
                        entity.getPosX(),
                        entity.getPosY() + 1.6,
                        entity.getPosZ(),
                        2,
                        0.25,
                        0.15,
                        0.25,
                        0.0
                );
            }

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
