package com.caiocesarmods.caioclimates.Climate;

public class BiomeDroughtSetup {
    public static void register() {
        System.out.println("SummerTemperatureSetup.register()");

        DroughtPatternRegistry.register("caiocesarbiomes:mediterranean_scrubland", DroughtPattern.DRY_SUMMER);
        DroughtPatternRegistry.register("minecraft:savanna", DroughtPattern.DRY_SUMMER);

    }
}
