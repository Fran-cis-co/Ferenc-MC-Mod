package net.fcontr.ferencmod.item;

import net.fcontr.ferencmod.FerencMod;
//import net.fcontr.ferencmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    // register the ability to create a tab in creative mode for our modded items
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FerencMod.MOD_ID);

    // Whenever a new modded feature is created, it is added here to see in creative mode
    public static final RegistryObject<CreativeModeTab> FERENC_TAB = CREATIVE_MODE_TABS.register("ferenc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILVER.get()))
                    .title(Component.translatable("creativetab.ferenc_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SILVER.get());
                        pOutput.accept(ModItems.RAW_SILVER.get());
                    }).build());

    public static void register(IEventBus eventBus){ CREATIVE_MODE_TABS.register(eventBus);}
}
