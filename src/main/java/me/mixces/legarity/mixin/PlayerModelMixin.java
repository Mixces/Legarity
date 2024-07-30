package me.mixces.legarity.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.render.model.entity.HumanoidModel;
import net.minecraft.client.render.model.entity.PlayerModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerModel.class)
public abstract class PlayerModelMixin extends HumanoidModel {

	@ModifyExpressionValue(
		method = "translateRightArm",
		at = @At(
			value = "CONSTANT",
			args = "floatValue = 1.0F"
		)
	)
	private float legarity$mc72397fix(float original) {
		return 0.5F;
	}
}
