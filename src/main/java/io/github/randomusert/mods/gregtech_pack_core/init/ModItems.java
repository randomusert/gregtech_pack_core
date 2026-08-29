package io.github.randomusert.mods.gregtech_pack_core.init;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.item.SingularityAlloyItem;
import io.github.randomusert.mods.gregtech_pack_core.item.XenoverdIngot;
import io.github.randomusert.mods.gregtech_pack_core.item.XenoverdScrap;
import io.github.randomusert.mods.gregtech_pack_core.storage.LargeItemStorageVariant;
import io.github.randomusert.mods.gregtech_pack_core.storage.expandedstoragedisk.ExpandedStorageDiskItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gregtech_pack_core.MODID);

    public static final DeferredItem<Item> MINECRAFTIUM = ITEMS.registerSimpleItem("minecraftium", new Item.Properties().stacksTo(90).rarity(Rarity.RARE));

    public static final DeferredItem<Item> GREGIUM = ITEMS.registerSimpleItem("gregium", new Item.Properties().stacksTo(90).rarity(Rarity.RARE));

    public static final DeferredItem<SingularityAlloyItem> SINGULARITY_ALLOY =
            ITEMS.registerItem(
                    "singularity_alloy",
                    SingularityAlloyItem::new,
                    new Item.Properties().stacksTo(99).rarity(Rarity.EPIC)
            );

/*
    public static final DeferredItem<XenoverdIngot> XENOVERD_INGOT =
            ITEMS.registerItem(
                    "xenoverd_ingot",
                            XenoverdIngot::new,
                            new Item.Properties().stacksTo(99).rarity(Rarity.EPIC).fireResistant());*/
    public static final  DeferredItem<XenoverdScrap> XENOVERD_SCRAP =
            ITEMS.registerItem(
                        "xenoverd_scrap",
                            XenoverdScrap::new,
                            new Item.Properties().stacksTo(99).rarity(Rarity.EPIC).fireResistant()
            );

    public static final Map<LargeItemStorageVariant, DeferredItem<Item>> ITEM_STORAGE_PART = new HashMap<>();
    public static final Map<LargeItemStorageVariant, DeferredItem<Item>> ITEM_DISK = new HashMap<>();


    static {
        for (var variant : LargeItemStorageVariant.values()) {
            ITEM_STORAGE_PART.put(variant, ITEMS.registerItem("storagepart_" + variant.getName(), Item::new));
            ITEM_DISK.put(variant,
                    ITEMS.register("disk_" + variant.getName(), () -> new ExpandedStorageDiskItem(variant)));
        }
    }


}
