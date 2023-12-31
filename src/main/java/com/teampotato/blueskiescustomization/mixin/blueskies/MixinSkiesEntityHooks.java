package com.teampotato.blueskiescustomization.mixin.blueskies;

import com.legacy.blue_skies.entities.util.SkiesEntityHooks;
import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = SkiesEntityHooks.class, remap = false)
public abstract class MixinSkiesEntityHooks {

    @Inject(method = "nerfDamage", at = @At("HEAD"), cancellable = true)
    private static void configurableNerfDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
        if (PotatoCommonConfig.ENABLE_BLUE_SKIES_NERF.get()) return;
        cir.setReturnValue(amount);
        cir.cancel();
    }


    @Inject(method = "nerfIndirectDamage", at = @At("HEAD"), cancellable = true)
    private static void configurableNerfIndirectDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
        if (PotatoCommonConfig.ENABLE_BLUE_SKIES_NERF.get()) return;
//        cir.setReturnValue(Math.min(5.0F, amount));
        cir.setReturnValue(amount);
        cir.cancel();
    }
}
