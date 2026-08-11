package com.caiocesarmods.caioclimates.Climate.Moisture;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.caiocesarmods.caioclimates.CaioClimates;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class MoistureProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IMoistureData.class)
    public static Capability<IMoistureData> MOISTURE_CAPABILITY = null;

    public static final ResourceLocation ID =
            new ResourceLocation(CaioClimates.MOD_ID, "moisture");

    private final IMoistureData instance =
            MOISTURE_CAPABILITY.getDefaultInstance();

    private final LazyOptional<IMoistureData> optional =
            LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
                                             @Nullable Direction side) {

        return cap == MOISTURE_CAPABILITY
                ? optional.cast()
                : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {

        return MOISTURE_CAPABILITY
                .getStorage()
                .writeNBT(MOISTURE_CAPABILITY, instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {

        MOISTURE_CAPABILITY
                .getStorage()
                .readNBT(MOISTURE_CAPABILITY, instance, null, nbt);
    }

    public void invalidate() {
        optional.invalidate();
    }
}
