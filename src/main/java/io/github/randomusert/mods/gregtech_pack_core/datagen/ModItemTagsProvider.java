package io.github.randomusert.mods.gregtech_pack_core.datagen;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.item.ModItems;
import io.github.randomusert.mods.gregtech_pack_core.storage.LargeItemStorageVariant;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Gregtech_pack_core.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var itemPartsBuilder = this.tag(ModItemTags.Items.ITEM_PARTS);
        var itemDisksBuilder = this.tag(ModItemTags.Items.ITEM_DISKS);

        for (var type : LargeItemStorageVariant.values()) {
            var tag = ModItemTags.Items.PARTS_ITEM.get(type);
            this.tag(tag).add(ModItems.ITEM_STORAGE_PART.get(type).get());
            itemPartsBuilder.addTag(tag);

            tag = ModItemTags.Items.DISKS_ITEM.get(type);
            this.tag(tag).add(ModItems.ITEM_DISK.get(type).get());
            itemDisksBuilder.addTag(tag);
        }
        this.tag(ModItemTags.Items.DISKS).addTags(ModItemTags.Items.ITEM_DISKS);
        this.tag(ModItemTags.Items.PARTS).addTags(ModItemTags.Items.ITEM_PARTS);
    }
}
