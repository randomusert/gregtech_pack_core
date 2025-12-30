package io.github.randomusert.mods.gregtech_pack_core.common.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class Helper {
    public static ItemLike item(String namespace, String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace, path);
        Item item = BuiltInRegistries.ITEM.get(id);

        if (item == Items.AIR) {
            throw new IllegalStateException("Missing item: " + id);
        }
        return item;
    }
}
