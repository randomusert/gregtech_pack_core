package io.github.randomusert.mods.gregtech_pack_core;

import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.randomusert.mods.gregtech_pack_core.common.data.GtpcElements;
import io.github.randomusert.mods.gregtech_pack_core.common.data.GtpcMaterials;
import io.github.randomusert.mods.gregtech_pack_core.common.machine.GtpcMachines;
import io.github.randomusert.mods.gregtech_pack_core.common.util.CustomItemStacksFromStrings;
import io.github.randomusert.mods.gregtech_pack_core.common.util.Helper;
import io.github.randomusert.mods.gregtech_pack_core.init.ModBlocks;
import io.github.randomusert.mods.gregtech_pack_core.init.ModCreativeTabs;
import io.github.randomusert.mods.gregtech_pack_core.init.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Gregtech_pack_core.MODID)
public class Gregtech_pack_core {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gregtech_pack_core";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final GTRegistrate GTPC_REGISTRATE = GTRegistrate.create(MODID);



    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public Gregtech_pack_core(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);



        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        GtpcElements.init();
        GtpcMaterials.register();
        GtpcMachines.init();

    }



    @SubscribeEvent
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
            LOGGER.info("Look, I found a {}!", Items.DIAMOND);
        });
    }

    // Add the example block item to the building blocks tab


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
    @SubscribeEvent
    private void modifyMaterials(PostMaterialEvent event) {
        // CustomMaterials.modify();
    }
}
