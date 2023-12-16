package com.teampotato.blueskiescustomization.mixin.blueskies;

import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntity.class)
public abstract class MixinMinecraftLivingEntity {
    @Shadow
    public abstract double getAttributeValue(Attribute attribute);

    @Inject(at = @At("HEAD"), method = "getArmorValue", cancellable = true)
    private void getArmorValue(CallbackInfoReturnable<Integer> cir) {
        if (PotatoCommonConfig.ENABLE_BLUE_SKIES_NERF.get()) return;
        cir.setReturnValue(Mth.floor(this.getAttributeValue(Attributes.ARMOR)));
        cir.cancel();
    }
}
