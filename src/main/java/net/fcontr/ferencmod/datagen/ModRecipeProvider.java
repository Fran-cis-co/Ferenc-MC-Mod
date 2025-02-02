package net.fcontr.ferencmod.datagen;

import net.fcontr.ferencmod.FerencMod;
import net.fcontr.ferencmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

// Class file which will allow us to generate the json files that allows us to either smelt or craft our modded items
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        // List of all the items that are silver related which can be smelted
        List<ItemLike> SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER.get());

        oreSmelting(pRecipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER.get(), 0.85f, 200, "silver");
        oreBlasting(pRecipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER.get(), 0.85f, 100, "silver");
    }


    /*
    *  These are the vanilla methods which will be used to design what comes in/out, the xp we get, and the time it takes to
    *  Smelt/blast modded items.
    */
    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, FerencMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
