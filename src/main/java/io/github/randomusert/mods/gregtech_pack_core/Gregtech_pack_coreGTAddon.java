package io.github.randomusert.mods.gregtech_pack_core;


import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.RecipeOutput;

@GTAddon(Gregtech_pack_core.MODID)
public class Gregtech_pack_coreGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return Gregtech_pack_core.GTPC_REGISTRATE;
    }


    /// THIS MUST BE LEFT EMPTY!!!!!
    @Override
    public void gtInitComplete() {

    }


}
