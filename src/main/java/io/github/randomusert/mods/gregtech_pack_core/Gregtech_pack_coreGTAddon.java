package io.github.randomusert.mods.gregtech_pack_core;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import io.github.randomusert.mods.gregtech_pack_core.common.registries.Gregtech_pack_coreRegistries;

@GTAddon(Gregtech_pack_core.MODID)
public class Gregtech_pack_coreGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return  Gregtech_pack_coreRegistries.GTPC_REGISTRATE;
    }

    // LEAVE EMPTY
    @Override
    public void gtInitComplete() {

    }


    @Override
    public boolean requiresHighTier() {
        return false;
    }
}
