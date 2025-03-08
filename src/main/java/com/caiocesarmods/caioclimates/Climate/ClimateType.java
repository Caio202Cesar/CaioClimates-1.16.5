package com.caiocesarmods.caioclimates.Climate;

import com.caiocesarmods.caioclimates.Seasons.Season;

public enum ClimateType {
    MEDITERRANEAN_HOT(new float[]{0.7F, 1.2F, 0.6F, 0.4F}, new boolean[] {false, false, true, true}),
    MARITIME_MEDITERRANEAN(new float[]{0.6F, 0.7F, 0.6F, 0.4F}, new boolean[] {false, false, true, true}),
    TROPICAL_SAVANNA(new float[]{0.95F, 1.0F, 0.95F, 0.85F}, new boolean[] {true, true, false, false}),
    HUMID_SUBTROPICAL(new float[]{0.7F, 1.0F, 0.6F, 0.4F}, new boolean[] {true, true, true, true}),
    MARITIME_HUMID_TEMPERATE(new float[]{0.5F, 0.7F, 0.4F, 0.25F}, new boolean[] {true, true, true, true}),
    MARITIME_HUMID_SUBTROPICAL(new float[]{0.6F, 0.7F, 0.6F, 0.4F}, new boolean[] {true, true, true, true}),
    HEMIBOREAL_HUMID_TEMPERATE(new float[]{0.25F, 0.6F, 0.4F, -0.5F}, new boolean[] {true, true, true, true}),
    HEMIBOREAL_MEDITERRANEAN_TEMPERATE(new float[]{0.25F, 0.6F, 0.4F, -0.5F}, new boolean[] {false, false, true, true}),
    MARITIME_TROPICAL(new float[]{0.95F, 1.0F, 0.9F, 0.8F}, new boolean[] {false, false, true, true}),
    TROPICAL_RAINFOREST(new float[]{0.9F, 1.0F, 0.9F, 0.8F}, new boolean[] {true, true, true, true}),
    TROPICAL_RAINFOREST_EDGE(new float[]{0.9F, 1.0F, 0.9F, 0.85F}, new boolean[] {true, true, true, false}),
    RAINFOREST_HUMID_SUBTROPICAL(new float[]{0.7F, 1.0F, 0.6F, 0.4F}, new boolean[] {true, true, true, true}),
    TROPICAL_XERIC_STEEPE(new float[]{1.2F, 1.2F, 1.2F, 1.0F}, new boolean[] {false, true, false, false}),
    TUNDRA(new float[]{0.12F, 0.2F, 0.12F, 0.0F}, new boolean[] {true, true, true, true}),
    HUMID_TEMPERATE(new float[]{0.6F, 0.8F, 0.5F, 0.12F}, new boolean[] {true, true, true, true}),
    MEDITERRANEAN_MARITIME_TEMPERATE(new float[]{0.5F, 0.7F, 0.4F, 0.25F}, new boolean[] {false, false, true, true}),
    XERIC_TEMPERATE_CONTINENTAL(new float[]{0.7F, 1.0F, 0.4F, -0.12F}, new boolean[] {false, false, false, true}),
    TAIGA(new float[]{0.12F, 0.3F, 0.2F, -0.12F}, new boolean[] {true, true, true, true}),
    SNOWY_TAIGA(new float[]{-0.3F, 0.25F, -0.2F, -0.4F}, new boolean[] {true, true, true, true}),
    ICE_CAP(new float[]{0.0F, 0.0F, 0.0F, 0.0F}, new boolean[] {true, true, true, true}),
    TROPICAL_DESERT(new float[]{1.2F, 1.2F, 1.2F, 1.2F}, new boolean[] {false, false, false, false}),
    SUBTROPICAL_DESERT(new float[]{0.8F, 1.2F, 0.9F, 0.4F}, new boolean[] {false, false, false, false}),
    MARITIME_SUBTROPICAL_DESERT(new float[]{0.6F, 0.7F, 0.6F, 0.4F}, new boolean[] {false, false, false, false});

    private final float[] seasonalTemperatures;
    private final boolean[] seasonalRain;

    ClimateType(float[] temperature, boolean[] rain) {
        this.seasonalTemperatures = temperature;
        this.seasonalRain = rain;
    }

    public float getTemperature(Season season) {
        return this.seasonalTemperatures[season.ordinal()];
    }

    public boolean hasRain(Season season) {
        return this.seasonalRain[season.ordinal()];
    }
}
