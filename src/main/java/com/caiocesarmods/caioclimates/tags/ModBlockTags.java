package com.caiocesarmods.caioclimates.tags;

import net.minecraft.block.Block;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

public final class ModBlockTags {

    public static final ITag.INamedTag<Block> BRANCHES =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "branches")));

    public static final ITag.INamedTag<Block> BROAD_LEAVES_LARGE =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "broad_leaves_large")));

    public static final ITag.INamedTag<Block> BROAD_LEAVES_SHORT =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "broad_leaves_large")));

    public static final ITag.INamedTag<Block> CONIFER_LEAVES =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "conifer_leaves")));

    public static final ITag.INamedTag<Block> PALM_LONG_FRONDS =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "palm_long_fronds")));

    public static final ITag.INamedTag<Block> PALM_SHORT_FRONDS =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "palm_short_fronds")));

    public static final ITag.INamedTag<Block> CAN_BURN_TO_BRANCHES =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "can_burn_to_branches")));
}
