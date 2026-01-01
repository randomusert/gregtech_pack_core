package io.github.randomusert.mods.gregtech_pack_core.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class XenoverdIngot extends Item {
    public XenoverdIngot(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("A super rare material found in the overworld. We don't fully understand it's properties, but we know that it can duplicate raw materials").withStyle(ChatFormatting.DARK_GREEN, ChatFormatting.UNDERLINE));
    }
}
