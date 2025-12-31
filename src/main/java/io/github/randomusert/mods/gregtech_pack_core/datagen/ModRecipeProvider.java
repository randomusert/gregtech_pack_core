package io.github.randomusert.mods.gregtech_pack_core.datagen;

import com.refinedmods.refinedstorage.common.misc.ProcessorItem;
import com.refinedmods.refinedstorage.common.storage.ItemStorageVariant;
import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.block.ModBlocks;
import io.github.randomusert.mods.gregtech_pack_core.item.ModItems;
import io.github.randomusert.mods.gregtech_pack_core.storage.LargeItemStorageVariant;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import io.github.randomusert.mods.gregtech_pack_core.common.util.Helper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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

        for (var type : LargeItemStorageVariant.values()) {
            if (type.equals(LargeItemStorageVariant.TIER_5)) {
                partRecipe(ModItems.ITEM_STORAGE_PART.get(type),
                        com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getItemStoragePart(ItemStorageVariant.SIXTY_FOUR_K),
                        recipeOutput);
            } else {

                partRecipe(ModItems.ITEM_STORAGE_PART.get(type),
                        ModItemTags.Items.PARTS_ITEM.get(
                                LargeItemStorageVariant.values()[type.ordinal() -1]),
                        recipeOutput);
            }

            diskRecipe(ModItems.ITEM_DISK.get(type), ModItemTags.Items.PARTS_ITEM.get(type), recipeOutput);
        }

    }

    private void partRecipe(DeferredItem<Item> result, TagKey<Item> previousPart, RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("DID")
                .pattern("GRG")
                .pattern("DGD")
                .define('G', previousPart)
                .define('D', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getProcessor(ProcessorItem.Type.ADVANCED))
                .define('I', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getQuartzEnrichedCopper())
                .define('R', Items.REDSTONE_BLOCK)
                .unlockedBy("has_previous_part", has(previousPart))
                .save(consumer, Gregtech_pack_core.rl("part/" + result.getId().getPath()));
    }

    private void partRecipe(DeferredItem<Item> result, Item previousPart,
                            RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("DID")
                .pattern("GRG")
                .pattern("DGD")
                .define('G', previousPart)
                .define('D', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getProcessor(ProcessorItem.Type.ADVANCED))
                .define('I', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getQuartzEnrichedIron())
                .define('R', Items.REDSTONE)
                .unlockedBy("has_previous_part", has(previousPart))
                .save(consumer, Gregtech_pack_core.rl("part/" + result.getId().getPath()));
    }


    private void diskRecipe(DeferredItem<Item> result, TagKey<Item> part,
                            RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("GRG")
                .pattern("RSR")
                .pattern("III")
                .define('G', Tags.Items.GLASS_BLOCKS)
                .define('S', part)
                .define('I', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getQuartzEnrichedIron())
                .define('R', Items.REDSTONE)
                .unlockedBy("has_part", has(part))
                .save(consumer, Gregtech_pack_core.rl("disk/shaped/" + result.getId().getPath()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get())
                .requires(com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getStorageHousing())
                .requires(part)
                .unlockedBy("has_part", has(part))
                .save(consumer, Gregtech_pack_core.rl("disk/shapeless/" + result.getId().getPath()));
    }
}
