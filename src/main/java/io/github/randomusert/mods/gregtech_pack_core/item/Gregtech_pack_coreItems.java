package io.github.randomusert.mods.gregtech_pack_core.item;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Gregtech_pack_coreItems {
    public static final DeferredRegister.Items NON_GT_RELATED_ITEMS = DeferredRegister.createItems(Gregtech_pack_core.MODID);

    public static final DeferredItem<Item> MINECRAFTIUM = NON_GT_RELATED_ITEMS.registerSimpleItem("minecraftium", new Item.Properties().stacksTo(90).rarity(Rarity.RARE));
}
