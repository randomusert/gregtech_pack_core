package io.github.randomusert.mods.gregtech_pack_core;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Gregtech_pack_core_config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<Integer> EU_TO_FE_RATIO =  BUILDER
            .comment("a ratio that is used to convert EU to FE")
            .define("eu_to_fe_ratio", 1);

    static final ModConfigSpec SPEC = BUILDER.build();
}
