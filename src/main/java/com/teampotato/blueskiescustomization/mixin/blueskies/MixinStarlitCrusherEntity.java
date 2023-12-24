package com.teampotato.blueskiescustomization.mixin.blueskies;

import com.legacy.blue_skies.entities.hostile.boss.StarlitCrusherEntity;
import com.legacy.blue_skies.entities.projectile.SpearEntity;
import com.legacy.blue_skies.entities.util.base.SkiesBossEntity;
import com.legacy.blue_skies.registries.SkiesParticles;
import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = StarlitCrusherEntity.class)
public abstract class MixinStarlitCrusherEntity extends SkiesBossEntity {
    MixinStarlitCrusherEntity(EntityType<? extends SkiesBossEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void hurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (PotatoCommonConfig.ENABLE_BLUE_SKIES_NERF.get()) return;

        if (source == DamageSource.OUT_OF_WORLD) {
        } else if (this.getInvulTime() <= 0 && !((StarlitCrusherEntity) (Object) this).isSpinning() && (source.isCreativePlayer() || ((StarlitCrusherEntity) (Object) this).getWallsInDungeonArea(5.0).size() < 4)) {
            if (!this.level.isClientSide && ((StarlitCrusherEntity) (Object) this).getWallsInDungeonArea(5.0).size() < 4 && this.tickCount > 140 && source.isProjectile() && source.getDirectEntity() instanceof SpearEntity) {
            } else {
                ItemStack stack;
                if (!source.isCreativePlayer() && source.getDirectEntity() instanceof PlayerEntity && source.getEntity() instanceof PlayerEntity) {
                    if (source.getDirectEntity() instanceof LivingEntity) {
                        stack = ((LivingEntity) source.getDirectEntity()).getMainHandItem();
                        if (stack.getItem() instanceof AxeItem) {
                            if (this.hurtTime <= 0 && this.level instanceof ServerWorld) {
                                ((ServerWorld) this.level).sendParticles(SkiesParticles.FALLING_LEAF, this.getX(), this.getY() + (double) this.getBbHeight() + 0.10000000149011612, this.getZ(), 60, this.getBoundingBox().getXsize() / 2.0, 0.10000000149011612, this.getBoundingBox().getZsize() / 2.0, 0.05);
                            }

                            if (((StarlitCrusherEntity) (Object) this).isStunned()) {
                                final boolean h = super.hurt(source, amount);
                                cir.setReturnValue(h);
                                cir.cancel();
                            } else {
                                final boolean h = super.hurt(source, amount * 0.3F);
                                cir.setReturnValue(h);
                                cir.cancel();
                            }
                        }
                    }
                }
            }
        }
    }
}
