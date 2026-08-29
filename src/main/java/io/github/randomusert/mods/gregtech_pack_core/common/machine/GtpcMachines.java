package io.github.randomusert.mods.gregtech_pack_core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import io.github.randomusert.mods.gregtech_pack_core.Gregtech_pack_core;
import net.minecraft.resources.ResourceLocation;

import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.createOverlayCasingMachineModel;

public class GtpcMachines {

    private static ResourceLocation baseTextureTestMachine = ResourceLocation.fromNamespaceAndPath("gtceu", "block/casings/steam/bricked");
    public static final MachineDefinition MUI_TEST_MACHINE = Gregtech_pack_core.GTPC_REGISTRATE
            .machine("mui_test", TestMachine::new)
            .simpleModel(GTMachineModels.HP_STEAM_HULL_MODEL)
            .register();

    public static void init() {}
}
