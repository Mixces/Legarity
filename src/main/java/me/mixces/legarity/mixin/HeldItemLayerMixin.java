package me.mixces.legarity.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.entity.layer.HeldItemLayer;
import net.minecraft.entity.living.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemLayer.class)
public abstract class HeldItemLayerMixin {

    @Inject(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/render/model/entity/HumanoidModel;translateRightArm(F)V"
		)
    )
    private void legarity$mc125204fix(LivingEntity entity, float handSwingAmount, float handSwing, float tickDelta, float age, float headYaw, float headPitch, float scale, CallbackInfo ci) {
        if (entity.isSneaking()) GlStateManager.translatef(0.0F, 0.2F, 0.0F);
    }

    @ModifyExpressionValue(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/living/LivingEntity;isSneaking()Z"
		)
    )
    private boolean legarity$mc125204fix_2(boolean original) {
        return false;
    }
}
