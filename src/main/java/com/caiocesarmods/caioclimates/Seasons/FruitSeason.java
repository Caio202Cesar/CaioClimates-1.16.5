package com.caiocesarmods.caioclimates.Seasons;

import com.caiocesarmods.caioclimates.Seasons.Season;
import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.world.server.ServerWorld;

public enum FruitSeason {

    APPLE(
            Season.SPRING, SeasonalPhase.LATE_SPRING,
            Season.SUMMER, SeasonalPhase.MID_SUMMER,
            Season.FALL, SeasonalPhase.EARLY_FALL
    );

    private final Season fruitGrowSeason;
    private final SeasonalPhase fruitGrowPhase;
    private final Season fruitRipeSeason;
    private final SeasonalPhase fruitRipePhase;
    private final Season harvestSeason;
    private final SeasonalPhase harvestPhase;

    FruitSeason(Season fruitGrowSeason, SeasonalPhase fruitGrowPhase,
                Season fruitRipeSeason, SeasonalPhase fruitRipePhase,
                Season harvestSeason, SeasonalPhase harvestPhase) {
        this.fruitGrowSeason = fruitGrowSeason;
        this.fruitGrowPhase = fruitGrowPhase;
        this.fruitRipeSeason = fruitRipeSeason;
        this.fruitRipePhase = fruitRipePhase;
        this.harvestSeason = harvestSeason;
        this.harvestPhase = harvestPhase;
    }

    public Season getFruitGrowSeason() {
        return fruitGrowSeason;
    }

    public SeasonalPhase getFruitGrowPhase() {
        return fruitGrowPhase;
    }

    public Season getFruitRipeSeason() {
        return fruitRipeSeason;
    }

    public SeasonalPhase getFruitRipePhase() {
        return fruitRipePhase;
    }

    public Season getHarvestSeason() {
        return harvestSeason;
    }

    public SeasonalPhase getHarvestPhase() {
        return harvestPhase;
    }

    //Fruit ripening season = here, all the fruit reaches maturity.
    public boolean isFruitRipeSeason(ServerWorld world) {

        Season currentSeason = Season.valueOf(Season.getSeason(world.getDayTime()));
        SeasonalPhase currentPhase = SeasonalPhase.valueOf(SeasonalPhase.getPhase(world.getDayTime()));

        return currentSeason == fruitRipeSeason && currentPhase == fruitRipePhase;
    }

    //Season where the fruit drop from the tree (or the fruiting block random ticks to another, like to autumn or winter ones)
    public boolean isHarvestSeason(ServerWorld world) {

        Season currentSeason = Season.valueOf(Season.getSeason(world.getDayTime()));
        SeasonalPhase currentPhase = SeasonalPhase.valueOf(SeasonalPhase.getPhase(world.getDayTime()));

        return currentSeason == harvestSeason && currentPhase == harvestPhase;
    }

    public boolean canGrow(ServerWorld world) {

        SeasonalPhase currentPhase = SeasonalPhase.valueOf(SeasonalPhase.getPhase(world.getDayTime()));

        return currentPhase.ordinal() >= fruitGrowPhase.ordinal()
                && currentPhase.ordinal() < fruitRipePhase.ordinal();

    }

    public float getGrowthChance(ServerWorld world) {
        if (!canGrow(world)) {
            return 0.0F;
        }

        return 1.0F;
    }
}
