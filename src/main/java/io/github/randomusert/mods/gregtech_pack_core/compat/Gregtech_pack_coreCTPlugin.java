package io.github.randomusert.mods.gregtech_pack_core.compat;

import com.blamejared.crafttweaker.api.plugin.CraftTweakerPlugin;
import com.blamejared.crafttweaker.api.plugin.ICraftTweakerPlugin;
import com.blamejared.crafttweaker.api.plugin.IRecipeHandlerRegistrationHandler;
import com.blamejared.crafttweaker.gametest.util.CraftTweakerGameTester;

@CraftTweakerPlugin("gregtech_pack_core:main")
public class Gregtech_pack_coreCTPlugin implements ICraftTweakerPlugin {

    @Override
    public void registerRecipeHandlers(IRecipeHandlerRegistrationHandler handler) {
        ICraftTweakerPlugin.super.registerRecipeHandlers(handler);
    }
}
