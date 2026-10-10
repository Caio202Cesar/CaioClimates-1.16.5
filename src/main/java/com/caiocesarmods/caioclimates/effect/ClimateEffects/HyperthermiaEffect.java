package com.caiocesarmods.caioclimates.effect.ClimateEffects;

import com.caiocesarmods.caioclimates.effect.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class HyperthermiaEffect extends Effect {
    public HyperthermiaEffect(EffectType typeIn, int liquidColorIn) {
        super(EffectType.HARMFUL, 0xE0380A);
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

            entity.attackEntityFrom(ModDamageSources.HYPERTHERMIA, 1.0F);
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
