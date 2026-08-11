package com.caiocesarmods.caioclimates.Climate.Moisture;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.world.World;

public final class MoistureCalculator {

    private MoistureCalculator() {}

    public static float getMoisture(DroughtPattern pattern, World world) {

        long day = (world.getDayTime() / 24000L) % 96L;

        int phaseIndex = (int)(day / 8L);
        float progress = (day % 8L) / 8.0F;

        SeasonalPhase[] phases = SeasonalPhase.values();

        SeasonalPhase current = phases[phaseIndex];
        SeasonalPhase next = phases[(phaseIndex + 1) % phases.length];

        float start = pattern.getRainChance(current);
        float end = pattern.getRainChance(next);

        // Smoothstep interpolation
        progress = progress * progress * (3.0F - 2.0F * progress);

        return lerp(start, end, progress);
    }

    private static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }
}
