package io.github.randomusert.mods.gregtech_pack_core.common.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import static io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core.MODID;

public class Helper {
    public static ItemLike item(String modId, String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(modId, path);
        Item item = BuiltInRegistries.ITEM.get(id);

        if (item == Items.AIR) {
            throw new IllegalStateException("Missing item: " + id);
        }
        return item;
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
