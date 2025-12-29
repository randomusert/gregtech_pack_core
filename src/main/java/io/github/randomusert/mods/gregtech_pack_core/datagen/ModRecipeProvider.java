package io.github.randomusert.mods.gregtech_pack_core.datagen;

import io.github.randomusert.mods.gregtech_pack_core.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import io.github.randomusert.mods.gregtech_pack_core.common.util.Helper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    ItemLike WROUGHT_IRON_INGOT = io.github.randomusert.mods.gregtech_pack_core.common.util.Helper.item("gtceu", "wrought_iron_ingot");

    ItemLike ADVANCED_ENERGY_CUBE = Helper.item("mekanism", "advanced_energy_cube");





    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WROUGHT_IRON_INGOT)
                .requires(Items.IRON_INGOT)
                .requires(Items.COAL)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_coal", has(Items.COAL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COMPRESSED_IRON_BLOCK)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', Items.IRON_BLOCK)
                .unlockedBy("has_iron_block", has(Items.IRON_BLOCK))
                .save(recipeOutput);


    }
}
