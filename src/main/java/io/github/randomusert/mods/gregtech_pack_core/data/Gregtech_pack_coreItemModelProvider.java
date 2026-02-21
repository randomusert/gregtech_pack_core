package io.github.randomusert.mods.gregtech_pack_core.data;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.item.Gregtech_pack_coreItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class Gregtech_pack_coreItemModelProvider extends ItemModelProvider {
    public Gregtech_pack_coreItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Gregtech_pack_core.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Gregtech_pack_coreItems.MINECRAFTIUM.get());



    }

    private String getPath(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
}
