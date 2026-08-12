package com.caiocesarmods.caioclimates.block;

import com.caiocesarmods.caioclimates.CaioClimates;
import com.caiocesarmods.caioclimates.ModItems;
import com.caiocesarmods.caioclimates.block.SeasonalLeaves.BirchFallLeaves;
import com.caiocesarmods.caioclimates.block.SeasonalLeaves.BirchWinterBranches;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, CaioClimates.MOD_ID);

    public static final RegistryObject<Block> BIRCH_FALL_LEAVES = registerBlock("birch_fall_leaves",
            () -> new BirchFallLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), ModBlocks.BIRCH_WINTER_BRANCHES));
    public static final RegistryObject<Block> BIRCH_WINTER_BRANCHES = registerBlock("birch_winter_branches",
            () -> new BirchWinterBranches(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), (Supplier<Block>) Blocks.BIRCH_LEAVES));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroup.DECORATIONS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
