package io.github.randomusert.mods.gregtech_pack_core.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import io.github.randomusert.mods.gregtech_pack_core.common.util.Helper;

public class GtpcMaterials {
    public static Material Xenoverd;

    public static void register() {
        Xenoverd = new Material.Builder(Helper.rl("xenoverd"))
                .ingot()
                .element(GtpcElements.Xenoverd)
                .color(0x448b50)
                .secondaryColor(0x10631e)
                .flags(MaterialFlags.DISABLE_ALLOY_BLAST, MaterialFlags.GENERATE_SPRING_SMALL, MaterialFlags.GENERATE_SPRING
                , MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_DENSE, MaterialFlags.GENERATE_FINE_WIRE,
                        MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR)
                .iconSet(GtpcMaterialIconSets.Xenoverd)
                .buildAndRegister();
    }
}
