package com.caiocesarmods.caioclimates.Climate.Drought;

import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;

public enum DroughtPattern {

    /*
    //Am Koopen
    TROPICAL_FOREST_DROUGHT(
            // SPRING
            0.95F,  // EARLY_SPRING
            0.87F,  // MID_SPRING
            0.75F,  // LATE_SPRING

            // SUMMER
            0.02F,  // EARLY_SUMMER
            0.01F,  // MID_SUMMER
            0.02F,  // LATE_SUMMER

            // FALL
            0.65F,  // EARLY_FALL
            0.85F,  // MID_FALL
            1.00F,  // LATE_FALL

            // WINTER
            1.00F,  // EARLY_WINTER
            1.00F,  // MID_WINTER
            1.00F   // LATE_WINTER
    ),
    /*
     * Mediterranean / tropical wet-dry climate.
     *
     * Dry summer, progressively wetter fall,
     * wet winter, then progressively drying spring.
     */
    DRY_SUMMER(
            // SPRING
            0.65F,  // EARLY_SPRING
            0.27F,  // MID_SPRING
            0.05F,  // LATE_SPRING

            // SUMMER
            0.02F,  // EARLY_SUMMER
            0.01F,  // MID_SUMMER
            0.02F,  // LATE_SUMMER

            // FALL
            0.20F,  // EARLY_FALL
            0.75F,  // MID_FALL
            0.90F,  // LATE_FALL

            // WINTER
            0.92F,  // EARLY_WINTER
            1.00F,  // MID_WINTER
            0.81F   // LATE_WINTER
    ),

    /*
     * Semi-arid climate.
     *
     * Rain is possible, but considerably less frequent.
     */
    SEMI_ARID(
            // SPRING
            0.10F,
            0.08F,
            0.03F,

            // SUMMER
            0.01F,
            0.00F,
            0.02F,

            // FALL
            0.15F,
            0.30F,
            0.35F,

            // WINTER
            0.40F,
            0.45F,
            0.25F
    ),

    /*
     * Arid climate.
     *
     * Rain is extremely rare throughout the year.
     */
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