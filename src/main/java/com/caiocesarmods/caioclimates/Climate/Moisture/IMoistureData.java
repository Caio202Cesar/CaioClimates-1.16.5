package com.caiocesarmods.caioclimates.Climate.Moisture;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;

public interface IMoistureData {
    float getMoisture(DroughtPattern pattern);

    void setMoisture(DroughtPattern pattern, float moisture);
}
