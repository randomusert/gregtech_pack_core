package io.github.randomusert.mods.gregtech_pack_core.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.common.data.GtpcMaterials;
import io.github.randomusert.mods.gregtech_pack_core.common.util.Helper;
import io.github.randomusert.mods.gregtech_pack_core.storage.LargeItemStorageVariant;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core.GTPC_REGISTRATE;
import static io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core.MODID;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> GTPC_TAB = CREATIVE_MODE_TAB.register("gtpc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MINECRAFTIUM.get()))
                    .title(Component.translatable("creativetab.gregtech_pack_core.gtpc_tab"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModItems.MINECRAFTIUM);
                        output.accept(ModItems.GREGIUM);
                        output.accept(ModItems.SINGULARITY_ALLOY);
                        output.accept(ModBlocks.COMPRESSED_IRON_BLOCK);
                        //output.accept(ModItems.XENOVERD_INGOT);
                        output.accept(ModItems.XENOVERD_SCRAP);
                        output.accept(ModBlocks.XENOVERD_ORE);
                        for (var type : LargeItemStorageVariant.values()) {
                            output.accept(ModItems.ITEM_STORAGE_PART.get(type).get());
                        }
                        for (var type : LargeItemStorageVariant.values()) {
                            output.accept(ModItems.ITEM_DISK.get(type).get());
                        }
                    }).build());

    public static final Supplier<CreativeModeTab> GTPC_MATERIALS = CREATIVE_MODE_TAB.register("gtpc_material_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.gregtech_pack_core.gtpc_materials_tab"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModItems.SINGULARITY_ALLOY);
                        output.accept(ModBlocks.XENOVERD_ORE);
                        //output.accept(ModItems.XENOVERD_INGOT);
                        output.accept(ModItems.XENOVERD_SCRAP);
                        output.accept(ModItems.MINECRAFTIUM);
                        output.accept(ModItems.GREGIUM);
                    }).build());


    public static RegistryEntry<CreativeModeTab, CreativeModeTab> GTPC_GT_TAB = GTPC_REGISTRATE
            .defaultCreativeTab(MODID,
                    builder -> builder
                            .title(GTPC_REGISTRATE.addLang("itemGroup", Helper.rl("creative_tab_gt_stuff"), "Gregtech pack core GT items and machines"))
                            .icon(ModItems.GREGIUM::toStack)
                            .build())
            .register();
    /*
public static final RegistryEntry<CreativeModeTab, CreativeModeTab> GTPC_GT_TAB =
        GTPC_REGISTRATE
                .defaultCreativeTab(MODID, builder -> builder
                        .title(Component.literal("GTPC GT Stuff"))
                        .icon(ModItems.GREGIUM::toStack)
                        .displayItems((params, output) -> {
                            output.accept(ModItems.GREGIUM);
                        })
                        .build())
                .register();*/

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
