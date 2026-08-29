package io.github.randomusert.mods.gregtech_pack_core.compat.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiInfoRecipe;
import dev.emi.emi.api.stack.EmiStack;
import io.github.randomusert.mods.gregtech_pack_core.common.util.CustomItemStacksFromStrings;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@EmiEntrypoint
public class Gregtech_pack_coreEMIPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {

        registry.addRecipe(new EmiInfoRecipe(List.of(ItemInfoData.xenoverdIngotStack), ItemInfoData.xenoverdIngotInfoText,
                ItemInfoData.rl("xenoverd_ingot")));
    }
}
