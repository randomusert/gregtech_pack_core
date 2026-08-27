package io.github.randomusert.mods.gregtech_pack_core.datagen;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Gregtech_pack_core.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // block tags of mineable/pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPRESSED_IRON_BLOCK.get())
                .add(ModBlocks.XENOVERD_ORE.get());
        // block tags of needs_iron_tool
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.COMPRESSED_IRON_BLOCK.get());
        // block tags of needs_diamond_tool
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.XENOVERD_ORE.get());
    }
}
