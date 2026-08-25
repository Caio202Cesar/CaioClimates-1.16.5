package com.caiocesarmods.caioclimates.tags;

import net.minecraft.block.Block;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

public final class ModBlockTags {

    public static final ITag.INamedTag<Block> BRANCHES =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "branches")));

    public static final ITag.INamedTag<Block> BROAD_LEAVES_LARGE =
            BlockTags.makeWrapperTag(String.valueOf(new ResourceLocation("caioclimates", "broad_leaves_large")));
}
