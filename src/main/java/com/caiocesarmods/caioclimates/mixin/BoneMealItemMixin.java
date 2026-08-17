package com.caiocesarmods.caioclimates.mixin;

import com.caiocesarmods.caioclimates.HardinessZones.PlantClimateConditionsRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {

    @Inject(
            method = "applyBonemeal(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/player/PlayerEntity;)Z",
            at = @At("HEAD"),
            cancellable = true,
            remap = false

            )
    private static void checkSaplingHardiness(
            ItemStack stack,
            World world,
            BlockPos pos,
            PlayerEntity player,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (world.isRemote) {
            return;
        }

        BlockState state = world.getBlockState(pos);
        Block sapling = state.getBlock();

        if (!PlantClimateConditionsRegistry.isRegistered(sapling)) {
            return;
        }

        String message = PlantClimateConditionsRegistry.getUnsuitableMessage(sapling, world, pos);

        if (message != null) {
            player.sendMessage(
                    new StringTextComponent(message),
                    player.getUniqueID()
            );

            cir.setReturnValue(false);
        }
    }
}
