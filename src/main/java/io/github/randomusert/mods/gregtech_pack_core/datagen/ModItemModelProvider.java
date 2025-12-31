package io.github.randomusert.mods.gregtech_pack_core.datagen;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.item.ModItems;
import io.github.randomusert.mods.gregtech_pack_core.storage.LargeItemStorageVariant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Gregtech_pack_core.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MINECRAFTIUM.get());
        basicItem(ModItems.GREGIUM.get());
        basicItem(ModItems.SINGULARITY_ALLOY.get());

        for (var type : LargeItemStorageVariant.values()) {
            singleTexture(getPath(ModItems.ITEM_STORAGE_PART.get(type).get()),
                    mcLoc("item/generated"), "layer0", modLoc("item/parts/" + type.getName()));

            singleTexture(getPath(ModItems.ITEM_DISK.get(type).get()), mcLoc("item/generated"),
                    "layer0", modLoc("item/disks/" + type.getName()));
        }
    }

    private String getPath(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
}
