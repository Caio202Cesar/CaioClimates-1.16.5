package com.caiocesarmods.caioclimates.item;

import com.caiocesarmods.caioclimates.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class ThermalFoodItem extends Item {
    private final int heatChange;
    private final int coldChange;

    public ThermalFoodItem(
            Item.Properties properties,
            int heatChange,
            int coldChange
    ) {
        super(properties);

        this.heatChange = heatChange;
        this.coldChange = coldChange;
    }

    @Override
    public ItemStack  onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack result = super.onItemUseFinish(stack, worldIn, entityLiving);

        if (!worldIn.isRemote && entityLiving instanceof PlayerEntity) {

            System.out.println("[ThermalFood] Food consumed!");

            applyThermalChange(
                    entityLiving,
                    ModEffects.HOT.get(),
                    heatChange
            );

            applyThermalChange(
                    entityLiving,
                    ModEffects.COLD.get(),
                    coldChange
            );
        }

        return result;
    }

    private void applyThermalChange(LivingEntity entity, Effect effect, int change) {
        if (change == 0) {
            return;
        }

        EffectInstance current = entity.getActivePotionEffect(effect);

        if (current == null) {
            return;
        }

        int newLevel = current.getAmplifier() + change;

        // Remove the effect if its intensity reaches zero.
        if (newLevel < 0) {
            entity.removeActivePotionEffect(effect);
            return;
        }

        // Maximum intensity: III (amplifier 2).
        newLevel = Math.min(2, newLevel);

        // Preserve the existing effect properties.
        int duration = current.getDuration();
        boolean ambient = current.isAmbient();
        boolean showParticles = current.doesShowParticles();
        boolean showIcon = current.isShowIcon();

        // Remove the old instance before adding the modified one.
        entity.removeActivePotionEffect(effect);

        entity.addPotionEffect(new EffectInstance(
                effect,
                duration,
                newLevel,
                ambient,
                showParticles,
                showIcon
        ));
    }
}
