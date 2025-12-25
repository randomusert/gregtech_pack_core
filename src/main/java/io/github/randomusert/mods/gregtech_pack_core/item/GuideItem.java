package io.github.randomusert.mods.gregtech_pack_core.item;

import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vazkii.patchouli.api.PatchouliAPI;

public class GuideItem extends Item {

    public GuideItem(Properties properties) {
        super(properties);
    }

    private static final ResourceLocation BOOKLOCATION = ResourceLocation.fromNamespaceAndPath(Gregtech_pack_core.MODID, "gtpc_guide");

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, ServerPlayer player, InteractionHand hand) {
        if (!level.isClientSide) {
            PatchouliAPI.get().openBookGUI(player, BOOKLOCATION);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
