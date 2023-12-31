package com.teampotato.blueskiescustomization.mixin.blueskies;

import com.legacy.blue_skies.BlueSkiesConfig;
import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlueSkiesConfig.CommonConfig.class, remap = false)
public abstract class MixinBlueSkiesCommonConfig {
    @Inject(method = "isModAllowedForFeatureGen", at = @At("HEAD"), cancellable = true)
    private void everyModFeatureGen(String mod, CallbackInfoReturnable<Boolean> cir) {
        if (PotatoCommonConfig.ALLOW_EVERY_MOD_GEN_FEATURE_IN_DIM.get()) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}