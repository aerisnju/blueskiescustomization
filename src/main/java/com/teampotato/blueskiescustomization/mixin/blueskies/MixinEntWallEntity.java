package com.teampotato.blueskiescustomization.mixin.blueskies;

import com.legacy.blue_skies.entities.hostile.boss.summons.ent.EntWallEntity;
import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntWallEntity.class)
public abstract class MixinEntWallEntity extends LivingEntity {
    MixinEntWallEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void hurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (PotatoCommonConfig.ENABLE_BLUE_SKIES_NERF.get()) return;

        if (source != DamageSource.OUT_OF_WORLD && source.getDirectEntity() instanceof LivingEntity) {
            ItemStack stack = ((LivingEntity) source.getDirectEntity()).getMainHandItem();
            if (stack.getItem() instanceof AxeItem) {
                ((EntWallEntity) (Object) this).playDamageEffect();
                boolean h = super.hurt(source, amount);
                cir.setReturnValue(h);
                cir.cancel();
            }
        }
    }
}
