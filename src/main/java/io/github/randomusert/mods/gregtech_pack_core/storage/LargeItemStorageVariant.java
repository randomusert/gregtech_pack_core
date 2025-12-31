package io.github.randomusert.mods.gregtech_pack_core.storage;

import com.refinedmods.refinedstorage.common.storage.StorageVariant;
import io.github.randomusert.mods.gregtech_pack_core.item.ModItems;
import lombok.Getter;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;


@Getter
public enum LargeItemStorageVariant implements StorageVariant {
    TIER_5(256);

    private final Long capacity;
    private final String name;
    private final Long energyUsage;

    LargeItemStorageVariant(int capacity) {
        this.name = capacity + "k";
        this.capacity = capacity * 1000L;
        this.energyUsage = (long) ((this.ordinal() + 5) * 2);
    }




    @Override
    public @Nullable Item getStoragePart() {
        return ModItems.ITEM_STORAGE_PART.get(this).get();
    }
}
