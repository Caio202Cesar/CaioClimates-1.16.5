package com.caiocesarmods.caioclimates.item;

import com.caiocesarmods.caioclimates.CaioClimates;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CaioClimates.MOD_ID);

    public static final RegistryObject<Item> HARDINESS_ZONE_SCANNER = ITEMS.register("hardiness_zone_scanner",
            () -> new HardinessZoneScannerItem(new Item.Properties().group(ItemGroup.TOOLS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
