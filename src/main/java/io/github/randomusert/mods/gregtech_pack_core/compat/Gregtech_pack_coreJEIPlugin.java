package io.github.randomusert.mods.gregtech_pack_core.compat;


import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import io.github.randomusert.mods.gregtech_pack_core.init.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class Gregtech_pack_coreJEIPlugin implements IModPlugin {

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Gregtech_pack_core.MODID, "gtpc_jei_plugin");
    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(
                new ItemStack(ModItems.SINGULARITY_ALLOY.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.gtpc.items.singularity_alloy.info")
        );

        registration.addIngredientInfo(
                new ItemStack(ModItems.XENOVERD_INGOT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.gtpc.items.xenoverd_ingot.info").withStyle(ChatFormatting.DARK_GREEN)
        );

        registration.addIngredientInfo(
                new ItemStack(ModItems.XENOVERD_SCRAP.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.gtpc.items.xenoverd_scrap.info").withStyle(ChatFormatting.DARK_GREEN)
        );
    }
}
