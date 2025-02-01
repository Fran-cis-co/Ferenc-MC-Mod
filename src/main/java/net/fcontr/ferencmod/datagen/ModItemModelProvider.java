package net.fcontr.ferencmod.datagen;

import net.fcontr.ferencmod.FerencMod;
import net.fcontr.ferencmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


// Datagen class which allows us to create json files for basic modded items
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FerencMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // ----- Register Items ----- //
        basicItem(ModItems.SILVER.get());
    }
}
