package com.caiocesarmods.caioclimates.Features;

import com.caiocesarmods.caioclimates.CaioClimates;
import com.caiocesarmods.caioclimates.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TreeFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CaioClimates.MOD_ID);

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ACACIA_SHRUB = register("acacia_shrub",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.ACACIA_LOG),
                    new SimpleBlockStateProvider(TreeFeatures.States.ACACIA_LEAVES),
                    new BushFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(1, 0, 0),
                    new TwoLayerFeature(0, 0, 0))).setIgnoreVines()
                    .setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JUNGLE_TREE_NO_CACAO = register("jungle_tree_no_cacao",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JUNGLE_LOG),
                    new SimpleBlockStateProvider(States.JUNGLE_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 8, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).setIgnoreVines().build()));

    //Bamboo
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BAMBOO_TREE = register("bamboo_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BAMBOO_LOG),
                    new SimpleBlockStateProvider(States.BAMBOO_LEAVES),
                    new SpruceFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), FeatureSpread.create(6)),
                    new StraightTrunkPlacer(10, 3, 0),
                    new TwoLayerFeature(1, 0, 1))).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TALL_BAMBOO_TREE = register("tall_bamboo_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.BAMBOO_LOG),
                    new SimpleBlockStateProvider(States.BAMBOO_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(1), 2),
                    new StraightTrunkPlacer(16, 5, 2),
                    new TwoLayerFeature(1, 0, 1))).build()));

    public static final class States {
        protected static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.getDefaultState();
        protected static final BlockState ACACIA_LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();

        protected static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
        protected static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();

        protected static final BlockState BAMBOO_LOG = Blocks.BAMBOO.getDefaultState();
        protected static final BlockState BAMBOO_LEAVES = ModBlocks.BAMBOO_LEAVES.get().getDefaultState();
    }


    static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
