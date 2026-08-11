package com.caiocesarmods.caioclimates.Climate.Moisture;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import net.minecraft.util.math.MathHelper;

import java.util.EnumMap;

public class MoistureData implements IMoistureData {

    private final EnumMap<DroughtPattern, Float> moisture =
            new EnumMap<>(DroughtPattern.class);

    public MoistureData() {

        for (DroughtPattern pattern : DroughtPattern.values()) {
            moisture.put(pattern, 0.0F);
        }
    }

    @Override
    public float getMoisture(DroughtPattern pattern) {

        return moisture.get(pattern);
    }

    @Override
    public void setMoisture(DroughtPattern pattern, float value) {

        moisture.put(pattern, MathHelper.clamp(value, 0.0F, 1.0F));
    }
}
