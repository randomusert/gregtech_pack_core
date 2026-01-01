package io.github.randomusert.mods.gregtech_pack_core.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class XenoverdScrap extends Item {

    public XenoverdScrap(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("A scrap of a material that's properties are unknow").withStyle(ChatFormatting.DARK_GREEN, ChatFormatting.UNDERLINE));
    }
}
