package com.caiocesarmods.caioclimates.block;

import com.caiocesarmods.caioclimates.CaioClimates;
import com.caiocesarmods.caioclimates.block.BurntBlocks.CharredBranches;
import com.caiocesarmods.caioclimates.block.BurntBlocks.CharredLog;
import com.caiocesarmods.caioclimates.block.SeasonalLeaves.*;
import com.caiocesarmods.caioclimates.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), ModBlocks.BIRCH_BRANCHES));
    public static final RegistryObject<Block> BIRCH_BRANCHES = registerBlock("birch_branches",
                    () -> new BirchWinterBranches(AbstractBlock.Properties.create(Material.LEAVES)
                            .hardnessAndResistance(0.2F).tickRandomly().notSolid().sound(SoundType.PLANT)
                            .harvestTool(ToolType.HOE), Blocks.BIRCH_LEAVES));

    public static final RegistryObject<Block> OAK_FALL_LEAVES = registerBlock("oak_fall_leaves",
            () -> new OakFallLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), ModBlocks.OAK_BRANCHES));
    public static final RegistryObject<Block> OAK_BRANCHES = registerBlock("oak_branches",
            () -> new OakWinterBranches(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F).tickRandomly().notSolid().sound(SoundType.PLANT)
                    .harvestTool(ToolType.HOE), Blocks.OAK_LEAVES));

    //Dark Oak (Quercus velutina)
    public static final RegistryObject<Block> DARK_OAK_FALL_LEAVES = registerBlock("dark_oak_fall_leaves",
            () -> new DarkOakFallLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), ModBlocks.DARK_OAK_BRANCHES));
    public static final RegistryObject<Block> DARK_OAK_BRANCHES = registerBlock("dark_oak_branches",
            () -> new DarkOakWinterBranches(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F).tickRandomly().notSolid().sound(SoundType.PLANT)
                    .harvestTool(ToolType.HOE), Blocks.DARK_OAK_LEAVES));

    //Dry season
    public static final RegistryObject<Block> ACACIA_BRANCHES = registerBlock("acacia_branches",
            () -> new AcaciaBranches(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F).tickRandomly().notSolid().sound(SoundType.PLANT)
                    .harvestTool(ToolType.HOE), Blocks.ACACIA_LEAVES));

    //Dead bamboo
    public static final RegistryObject<Block> DEAD_BAMBOO_SHOOT = registerBlock("dead_bamboo_shoot",
            () -> new DeadBushBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS, MaterialColor.WOOD)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));

    //Burnt Blocks
    public static final RegistryObject<Block> CHARRED_LOG = registerBlock("charred_log",
            CharredLog::new);
    public static final RegistryObject<Block> CHARRED_BRANCHES = registerBlock("charred_branches",
            CharredBranches::new);

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
