package io.github.randomusert.mods.gregtech_pack_core.compat.emi;

import dev.emi.emi.api.stack.EmiStack;
import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.common.util.CustomItemStacksFromStrings;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

public class ItemInfoData {

    static EmiStack xenoverdIngotStack = EmiStack.of(CustomItemStacksFromStrings.xenoverd_ingot);

    static List<Component> xenoverdIngotInfoText = List.of(
            Component.translatable("tooltip.gtpc.items.xenoverd_ingot.info")
    );

    static EmiStack SingularityAlloy = EmiStack.of(CustomItemStacksFromStrings.xenoverd_ingot);

    static List<Component> SingularityAlloyText = List.of(
            Component.translatable("tooltip.gtpc.items.singularity_alloy.info")
    );

    static EmiStack xenoverdScrapStack = EmiStack.of(CustomItemStacksFromStrings.xenoverd_ingot);

    static List<Component> xenoverdScrapInfoText = List.of(
            Component.translatable("tooltip.gtpc.items.xenoverd_scrap.info")
    );


    @ApiStatus.Internal
    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(Gregtech_pack_core.MODID, path);
    }
}
