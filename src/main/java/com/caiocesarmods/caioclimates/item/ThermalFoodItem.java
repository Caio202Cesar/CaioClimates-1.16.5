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

        int currentLevel = current.getAmplifier();
        int newLevel = currentLevel + change;

        if (newLevel < 0) {
            entity.removeActivePotionEffect(effect);
            return;
        }

        newLevel = Math.min(2, newLevel);

        entity.addPotionEffect(new EffectInstance(
                effect,
                current.getDuration(),
                newLevel,
                false,
                current.doesShowParticles(),
                current.isShowIcon()
        ));
    }
}
