package net.fcontr.ferencmod.item;

import net.fcontr.ferencmod.FerencMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Register the ability to create items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FerencMod.MOD_ID);

    // --- Register the ore
    // Silver ingot
    public static final RegistryObject<Item> SILVER = ITEMS.register("silver",
            () -> new Item(new Item.Properties()));
    // Raw silver
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));


    // Enable event bus to register these modded items
    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
