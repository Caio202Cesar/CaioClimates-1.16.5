package com.caiocesarmods.caioclimates.item;

import com.caiocesarmods.caioclimates.HardinessZones.HardinessZones;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class HardinessZoneScannerItem extends Item {
    public HardinessZoneScannerItem(Properties props) {
        super(props);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.caioclimates.hardiness_scanner").mergeStyle(TextFormatting.GOLD));

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote) {

            // Raytrace (what player is looking at)
            RayTraceResult result = player.pick(5.0D, 0.0F, false);

            if (result.getType() == RayTraceResult.Type.BLOCK) {

                BlockRayTraceResult blockHit = (BlockRayTraceResult) result;
                BlockPos pos = blockHit.getPos();
                BlockState state = world.getBlockState(pos);

                // Check if it's a plant type
                if (state.getBlock() instanceof SaplingBlock ||
                        state.getBlock() instanceof VineBlock) {

                    ResourceLocation id = state.getBlock().getRegistryName();

                    if (id != null) {
                        String zone = HardinessZones.getZoneForSapling(id);

                        player.sendMessage(
                                new StringTextComponent("§aScanned Plant Zone: §e" + zone),
                                player.getUniqueID()
                        );

                        world.playSound(null, player.getPosition(),
                                SoundEvents.BLOCK_NOTE_BLOCK_PLING,
                                SoundCategory.PLAYERS, 1.0F, 1.5F);
                    }


                }
            }
        }
        return ActionResult.resultSuccess(stack);
    }
}

