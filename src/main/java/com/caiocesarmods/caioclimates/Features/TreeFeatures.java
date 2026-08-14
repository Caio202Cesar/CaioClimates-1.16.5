package com.caiocesarmods.caioclimates.Features;

import com.caiocesarmods.caioclimates.CaioClimates;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
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

    public static final class States {
        protected static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.getDefaultState();
        protected static final BlockState ACACIA_LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();
    }

    static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
