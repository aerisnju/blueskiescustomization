package com.teampotato.blueskiescustomization.mixin.blueskies;

import com.legacy.blue_skies.asm_hooks.PlayerHooks;
import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(value = PlayerHooks.class, remap = false)
public abstract class MixinPlayerHooks {
    @Inject(method = "isNerfableTool", at = @At("HEAD"), cancellable = true)
    private static void configurableNerfableToolHook(@Nullable ItemStack stack, @Nullable BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (PotatoCommonConfig.ENABLE_BLUE_SKIES_NERF.get()) return;
        cir.setReturnValue(false);
        cir.cancel();
    }
}
