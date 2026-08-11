package com.caiocesarmods.caioclimates.Climate.Moisture;

import com.caiocesarmods.caioclimates.Climate.Drought.DroughtPattern;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class MoistureStorage implements Capability.IStorage<IMoistureData> {

    @Nullable
    @Override
    public CompoundNBT writeNBT(Capability<IMoistureData> capability,
                                IMoistureData instance,
                                Direction side) {

        CompoundNBT nbt = new CompoundNBT();

        for (DroughtPattern pattern : DroughtPattern.values()) {
            nbt.putFloat(pattern.name(), instance.getMoisture(pattern));
        }

        return nbt;
    }

    @Override
    public void readNBT(Capability<IMoistureData> capability,
                        IMoistureData instance,
                        Direction side,
                        net.minecraft.nbt.INBT nbt) {

        CompoundNBT compound = (CompoundNBT) nbt;

        for (DroughtPattern pattern : DroughtPattern.values()) {
            instance.setMoisture(
                    pattern,
                    compound.getFloat(pattern.name()));
        }
    }
}