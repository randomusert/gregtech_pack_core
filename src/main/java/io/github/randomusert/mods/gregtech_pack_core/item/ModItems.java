package io.github.randomusert.mods.gregtech_pack_core.item;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gregtech_pack_core.MODID);

    public static final DeferredItem<Item> MINECRAFTIUM = ITEMS.registerSimpleItem("minecraftium", new Item.Properties().stacksTo(90).rarity(Rarity.EPIC));

    public static final DeferredItem<Item> GREGIUM = ITEMS.registerSimpleItem("gregium", new Item.Properties().stacksTo(90).rarity(Rarity.EPIC));
}
