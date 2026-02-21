package io.github.randomusert.mods.gregtech_pack_core.item;


import com.gregtechceu.gtceu.data.misc.GTCreativeModeTabs;

import com.tterrag.registrate.util.entry.RegistryEntry;
import static io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core.GTPC_REGISTRATE;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Gregtech_pack_coreCreativeModeTabs {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gregtech_pack_core.MODID);
    public static final Supplier<CreativeModeTab> GTPC_TAB = CREATIVE_MODE_TAB.register("gtpc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Gregtech_pack_coreItems.MINECRAFTIUM.get()))
                    .title(Component.translatable("creativetab.gregtech_pack_core.gtpc_tab"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(Gregtech_pack_coreItems.MINECRAFTIUM);
                    }).build());
}
