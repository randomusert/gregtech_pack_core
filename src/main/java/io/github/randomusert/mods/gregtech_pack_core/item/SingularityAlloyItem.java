package io.github.randomusert.mods.gregtech_pack_core.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SingularityAlloyItem extends Item {
    public SingularityAlloyItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.gregtech_pack_core.singularity_alloy.creative")
                .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD));
    }
}
