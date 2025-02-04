package net.fcontr.ferencmod.util;

import net.fcontr.ferencmod.FerencMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


// util file which allows us to create tags for our modded items
public class ModTags {
    public static class Blocks {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.tryBuild(FerencMod.MOD_ID, name));

        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name){
            return ItemTags.create(ResourceLocation.tryBuild(FerencMod.MOD_ID, name));
        }
    }
}
