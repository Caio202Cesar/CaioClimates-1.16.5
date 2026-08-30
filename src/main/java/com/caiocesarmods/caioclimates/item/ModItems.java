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

    public static final RegistryObject<Item> GARDENER_HELPER = ITEMS.register("gardener_helper",
            () -> new HardinessZoneScannerItem(new Item.Properties().group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> OAK_ACORN = ITEMS.register("oak_acorn",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> DARK_OAK_ACORN = ITEMS.register("dark_oak_acorn",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> OAK_GALLS = ITEMS.register("oak_galls",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> ARABIC_GUM = ITEMS.register("arabic_gum",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> SPRUCE_CONE = ITEMS.register("spruce_cone",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
