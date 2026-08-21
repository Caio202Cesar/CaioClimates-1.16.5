package com.caiocesarmods.caioclimates.Climate.Drought;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;

public enum DroughtPattern {

    //Similar to Koopen's Am climate
    TROPICAL_RAINFOREST_DROUGHT(
            // SPRING
            1.00F,  // EARLY_SPRING
            0.97F,  // MID_SPRING
            0.75F,  // LATE_SPRING

            // SUMMER
            0.10F,  // EARLY_SUMMER
            0.05F,  // MID_SUMMER
            0.15F,  // LATE_SUMMER

            // FALL
            0.85F,  // EARLY_FALL
            0.99F,  // MID_FALL
            1.00F,  // LATE_FALL

            // WINTER
            1.00F,  // EARLY_WINTER
            1.00F,  // MID_WINTER
            1.00F   // LATE_WINTER
    ),

    //Mediterranean/tropical wet-dry climate
    DRY_SUMMER(
            // SPRING
            0.75F,  // EARLY_SPRING
            0.20F,  // MID_SPRING
            0.05F,  // LATE_SPRING

            // SUMMER
            0.02F,  // EARLY_SUMMER
            0.01F,  // MID_SUMMER
            0.02F,  // LATE_SUMMER

            // FALL
            0.27F,  // EARLY_FALL
            0.85F,  // MID_FALL
            0.90F,  // LATE_FALL

            // WINTER
            1.00F,  // EARLY_WINTER
            1.00F,  // MID_WINTER
            1.00F   // LATE_WINTER
    ),

    //Semi-arid climate
    SEMI_ARID(
            // SPRING
            0.3F,
            0.02F,
            0.03F,

            // SUMMER
            0.01F,
            0.00F,
            0.02F,

            // FALL
            0.5F,
            0.10F,
            0.35F,

            // WINTER
            0.40F,
            0.45F,
            0.25F
    ),

    //Arid climate.
    ARID(
            // SPRING
            0.01F,
            0.01F,
            0.01F,

            // SUMMER
            0.00F,
            0.00F,
            0.00F,

            // FALL
            0.01F,
            0.01F,
            0.01F,

            // WINTER
            0.01F,
            0.01F,
            0.01F
    );

    private final float earlySpring;
    private final float midSpring;
    private final float lateSpring;

    private final float earlySummer;
    private final float midSummer;
    private final float lateSummer;

    private final float earlyFall;
    private final float midFall;
    private final float lateFall;

    private final float earlyWinter;
    private final float midWinter;
    private final float lateWinter;


    DroughtPattern(
            float earlySpring,
            float midSpring,
            float lateSpring,
            float earlySummer,
            float midSummer,
            float lateSummer,
            float earlyFall,
            float midFall,
            float lateFall,
            float earlyWinter,
            float midWinter,
            float lateWinter
    ) {
        this.earlySpring = earlySpring;
        this.midSpring = midSpring;
        this.lateSpring = lateSpring;

        this.earlySummer = earlySummer;
        this.midSummer = midSummer;
        this.lateSummer = lateSummer;

        this.earlyFall = earlyFall;
        this.midFall = midFall;
        this.lateFall = lateFall;

        this.earlyWinter = earlyWinter;
        this.midWinter = midWinter;
        this.lateWinter = lateWinter;
    }


    public float getRainChance(SeasonalPhase phase) {

        switch (phase) {

            case EARLY_SPRING:
                return earlySpring;

            case MID_SPRING:
                return midSpring;

            case LATE_SPRING:
                return lateSpring;

            case EARLY_SUMMER:
                return earlySummer;

            case MID_SUMMER:
                return midSummer;

            case LATE_SUMMER:
                return lateSummer;

            case EARLY_FALL:
                return earlyFall;

            case MID_FALL:
                return midFall;

            case LATE_FALL:
                return lateFall;

            case EARLY_WINTER:
                return earlyWinter;

            case MID_WINTER:
                return midWinter;

            case LATE_WINTER:
                return lateWinter;

            default:
                return 0.0F;
        }
    }
}