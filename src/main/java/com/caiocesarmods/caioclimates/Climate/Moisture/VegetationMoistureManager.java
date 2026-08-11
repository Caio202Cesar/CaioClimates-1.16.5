package com.caiocesarmods.caioclimates.Climate.Moisture;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import com.caiocesarmods.caioclimates.Seasons.SeasonalPhase;
import net.minecraft.world.server.ServerWorld;

public final class VegetationMoistureManager {

    /**
     * Fraction of the remaining difference that is applied each Minecraft day.
     */
    private static final float CHANGE_RATE = 0.05F;

    private VegetationMoistureManager() {
    }

    public static void tick(ServerWorld world) {

        SeasonalPhase phase =
                SeasonalPhase.valueOf(
                        SeasonalPhase.getPhase(world.getDayTime()));

        world.getCapability(MoistureProvider.MOISTURE_CAPABILITY).ifPresent(data -> {

            for (DroughtPattern pattern : DroughtPattern.values()) {

                float current =
                        data.getMoisture(pattern);

                float target =
                        pattern.getRainChance(phase);

                float updated =
                        approach(current, target);

                data.setMoisture(pattern, updated);
            }

        });
    }

    public static float getMoisture(ServerWorld world,
                                    DroughtPattern pattern) {

        return world.getCapability(MoistureProvider.MOISTURE_CAPABILITY)
                .map(data -> data.getMoisture(pattern))
                .orElse(0.0F);
    }

    private static float approach(float current,
                                  float target) {

        return current + (target - current) * CHANGE_RATE;
    }
}