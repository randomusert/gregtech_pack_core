package io.github.randomusert.mods.gregtech_pack_core.datagen;

import com.refinedmods.refinedstorage.common.util.IdentifierUtil;
import io.github.randomusert.mods.gregtech_pack_core.storage.LargeItemStorageVariant;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ModItemTags {

    public static class Items {
        public static final TagKey<Item> PARTS = tag("parts");
        public static final TagKey<Item> DISKS = tag("disks");
        public static final TagKey<Item> ITEM_PARTS = tag("parts/items");

        public static final TagKey<Item> ITEM_DISKS = tag("disks/items");
        public static final Map<LargeItemStorageVariant, TagKey<Item>> PARTS_ITEM = new HashMap<>();

        public static final Map<LargeItemStorageVariant, TagKey<Item>> DISKS_ITEM = new HashMap<>();

        static {
            for (var type : LargeItemStorageVariant.values()) {
                PARTS_ITEM.put(type, tag("parts/items/" + type.getName()));
                DISKS_ITEM.put(type, tag("disks/items/" + type.getName()));
            }
        }


        private static TagKey<Item> tag(String name) {
            return net.minecraft.tags.ItemTags.create(IdentifierUtil.createIdentifier(name));
        }
    }
}
