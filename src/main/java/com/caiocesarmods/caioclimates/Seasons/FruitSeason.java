package com.caiocesarmods.caioclimates.Seasons;

import net.minecraft.world.server.ServerWorld;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum FruitSeason {
    //Caio Cesar's Naturalistic Voyage
    APPLE(
            Season.SPRING, SeasonalPhase.LATE_SPRING,
            Season.FALL,
            SeasonalPhase.MID_SUMMER, SeasonalPhase.LATE_SUMMER);

    //Brazilian Biomes

    private final Season fruitGrowSeason; //This season is where the fruit appears on the tree.
    private final SeasonalPhase fruitGrowPhase;
    private final Season harvestSeason;

    private final Set<SeasonalPhase> fruitRipePhases;

    FruitSeason(Season fruitGrowSeason, SeasonalPhase fruitGrowPhase,
                Season harvestSeason,
                SeasonalPhase... fruitRipePhases) {

        this.fruitGrowSeason = fruitGrowSeason;
        this.fruitGrowPhase = fruitGrowPhase;
        this.harvestSeason = harvestSeason;

        this.fruitRipePhases = EnumSet.noneOf(SeasonalPhase.class);
        Collections.addAll(this.fruitRipePhases, fruitRipePhases);
    }

    public Set<SeasonalPhase> getFruitRipePhases() {
        return fruitRipePhases;
    }

    ///Fruit ripening season = here, all the fruit reaches maturity.
    public boolean isFruitRipeSeason(ServerWorld world) {

        SeasonalPhase currentPhase = SeasonalPhase.valueOf(SeasonalPhase.getPhase(world.getDayTime()));

        return fruitRipePhases.contains(currentPhase);
    }


    ///Season where the fruit drop from the tree (or the fruiting block random ticks to another, like to autumn or winter ones)
    public boolean isHarvestSeason(ServerWorld world) {

        Season currentSeason = Season.valueOf(Season.getSeason(world.getDayTime()));

        return currentSeason == harvestSeason;
    }

    public boolean canGrow(ServerWorld world) {

        Season currentSeason = Season.valueOf(Season.getSeason(world.getDayTime()));
        SeasonalPhase currentPhase = SeasonalPhase.valueOf(SeasonalPhase.getPhase(world.getDayTime()));

        return currentSeason == fruitGrowSeason
                || currentPhase.ordinal() >= fruitGrowPhase.ordinal()
                && !isHarvestSeason(world);

    }

    public float getGrowthChance(ServerWorld world) {
        if (!canGrow(world)) {
            return 0.0F;
        }

        return 1.0F;
    }
}
