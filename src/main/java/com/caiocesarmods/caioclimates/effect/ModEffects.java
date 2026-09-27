package com.caiocesarmods.caioclimates.effect;

import com.caiocesarmods.caioclimates.CaioClimates;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CaioClimates.MOD_ID);

    public static final RegistryObject<Effect> HOT = EFFECTS.register("hot_effect",
            () -> new HotEffect(EffectType.NEUTRAL, 0xF3CB21));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

}
