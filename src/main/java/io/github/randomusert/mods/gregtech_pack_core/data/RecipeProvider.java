package io.github.randomusert.mods.gregtech_pack_core.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.data.item.GTItems;
import com.gregtechceu.gtceu.data.item.GTMaterialItems;
import com.gregtechceu.gtceu.data.material.FirstDegreeMaterials;
import com.gregtechceu.gtceu.data.material.GTMaterials;
import io.github.randomusert.mods.gregtech_pack_core.block.ModBlocks;
import net.minecraft.ResourceLocationException;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {
    public RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    ItemLike WROUGHT_IRON_INGOT = io.github.randomusert.mods.gregtech_pack_core.common.util.Helper.item("gtceu", "wrought_iron_ingot");
    // GTCEu materials that are not craftable
    private void gtceuMaterials(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WROUGHT_IRON_INGOT)
                .requires(Items.IRON_INGOT)
                .requires(Items.COAL)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_coal", has(Items.COAL))
                .save(output);
    }
}
