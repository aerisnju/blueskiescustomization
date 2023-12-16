package com.teampotato.blueskiescustomization.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PotatoCommonConfig {
    public static final ForgeConfigSpec COMMON_CONFIG;

    public static final ForgeConfigSpec.BooleanValue
            ENABLE_BLUE_SKIES_NERF,
            ALLOW_EVERY_MOD_GEN_FEATURE_IN_DIM;

    static {
        ForgeConfigSpec.Builder CONFIG_BUILDER = new ForgeConfigSpec.Builder();

        CONFIG_BUILDER
                .push("BlueSkiesExtraSettings")
                .comment("Blue Skies Extra Settings")
        ;
        ENABLE_BLUE_SKIES_NERF = CONFIG_BUILDER
                .comment("Enable nerfing weapons and tools in blue skies dimensions")
                .define("enableDimensionalNerf", true)
        ;
        ALLOW_EVERY_MOD_GEN_FEATURE_IN_DIM = CONFIG_BUILDER
                .comment("Allow every mod generate features in blue skies dimensions")
                .define("allowEveryModFeatureGenInBlueSkiesDims", false);
        
        CONFIG_BUILDER.pop();

        COMMON_CONFIG = CONFIG_BUILDER.build();
    }
}
