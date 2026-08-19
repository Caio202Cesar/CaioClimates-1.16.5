package com.caiocesarmods.caioclimates.Climate.SummerHeat;

public enum SummerHeat {

    ABSENT(Float.NEGATIVE_INFINITY, -0.10F),
    ICY( -0.10F, 0.15F),
    TUNDRA_COLD(0.15F, 0.3F),
    COOLER(0.3F, 0.5F),
    MILD(0.5F, 0.7F),
    WARM(0.7F, 0.8F),
    HOT(0.8F, 0.9F),
    VERY_HOT(0.9F, 1.0F),
    SCORCHING(1.0F, 2.0F),
    UNBEARABLE(2.0F, Float.POSITIVE_INFINITY);

    private final float min;
    private final float max;

    SummerHeat(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(float value) {
        return value >= min && value < max;
    }

    public static SummerHeat fromTemperature(float value) {
        for (SummerHeat heat : values()) {
            if (heat.contains(value)) {
                return heat;
            }
        }
        return WARM;
    }
}


