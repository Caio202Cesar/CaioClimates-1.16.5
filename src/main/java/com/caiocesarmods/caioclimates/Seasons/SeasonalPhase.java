package com.caiocesarmods.caioclimates.Seasons;

public enum SeasonalPhase {
    EARLY_SPRING,
    MID_SPRING,
    LATE_SPRING,

    EARLY_SUMMER,
    MID_SUMMER,
    LATE_SUMMER,

    EARLY_FALL,
    MID_FALL,
    LATE_FALL,

    EARLY_WINTER,
    MID_WINTER,
    LATE_WINTER;

    public static String getPhase(long dayTime) {
        long days = dayTime / 24000;
        long cycle = days % 96;

        if (cycle < 8) {
            return "EARLY_SPRING";
        }
        else if (cycle < 16) {
            return "MID_SPRING";
        }
        else if (cycle < 24) {
            return "LATE_SPRING";
        }
        else if (cycle < 32) {
            return "EARLY_SUMMER";
        }
        else if (cycle < 40) {
            return "MID_SUMMER";
        }
        else if (cycle < 48) {
            return "LATE_SUMMER";
        }
        else if (cycle < 56) {
            return "EARLY_FALL";
        }
        else if (cycle < 64) {
            return "MID_FALL";
        }
        else if (cycle < 72) {
            return "LATE_FALL";
        }
        else if (cycle < 80) {
            return "EARLY_WINTER";
        }
        else if (cycle < 88) {
            return "MID_WINTER";
        } else {
        return "LATE_WINTER";}
    }

    public Season getSeason() {
        switch (this) {
            case EARLY_SPRING:
            case MID_SPRING:
            case LATE_SPRING:
                return Season.SPRING;

            case EARLY_SUMMER:
            case MID_SUMMER:
            case LATE_SUMMER:
                return Season.SUMMER;

            case EARLY_FALL:
            case MID_FALL:
            case LATE_FALL:
                return Season.FALL;

            default:
                return Season.WINTER;
        }
    }
}
