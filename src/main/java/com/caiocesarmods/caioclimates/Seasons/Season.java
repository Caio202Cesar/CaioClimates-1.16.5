package com.caiocesarmods.caioclimates.Seasons;

public enum Season {
    SPRING,
    SUMMER,
    FALL,
    WINTER;

    public static String getSeason(long dayTime) {
            long days = dayTime / 24000; // Convert ticks to days
            long cycle = days % 96; // Assume a full year is 96 days (24 per season)

            if (cycle < 24) {
                return "SPRING";
            } else if (cycle < 48) {
                return "SUMMER";
            } else if (cycle < 72) {
                return "FALL";
            } else {
                return "WINTER";
            }
    }
}

