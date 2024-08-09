package me.mixces.legarity.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

	@Inject(
		method = "closeScreen",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/input/MouseInput;lock()V"

		)
	)
	private void legarity$updatePressedStates(CallbackInfo ci) {
		try {
			for (KeyBinding keyBinding : KeyBindingAccessor.getALL()) {
				final int keyCode = keyBinding.getKeyCode();

				if (keyCode == Keyboard.KEY_NONE) {
					continue;
				}

				KeyBinding.set(keyCode, Keyboard.isKeyDown(keyCode));
			}
		} catch (IndexOutOfBoundsException exception) {
			/* no-op */
		}
	}

	@WrapWithCondition(
		method = "tick",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/render/GameRenderer;updateShader(Lnet/minecraft/entity/Entity;)V"
		)
	)
	private boolean legarity$disableShaderCheck(GameRenderer instance, Entity camera) {
		return false;
	}
}
