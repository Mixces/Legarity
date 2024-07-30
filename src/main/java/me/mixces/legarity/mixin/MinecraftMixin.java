package me.mixces.legarity.mixin;

//import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
//import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.options.KeyBinding;
import org.lwjgl.input.Keyboard;
//import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

//	@Shadow
//	private int attackCooldown;

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

//	@WrapOperation(
//		method = "tick",
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/client/options/KeyBinding;isPressed()Z",
//			ordinal = 2
//		)
//	)
//	private boolean legarity$updateMousePressState(KeyBinding instance, Operation<Boolean> original) {
//		return Mouse.isButtonDown(0);
//	}
//
//	@Inject(
//		method = "tickBlockMining",
//		at = @At(
//			value = "HEAD"
//		)
//	)
//	private void legarity$updateAttackCooldown(boolean holdingAttack, CallbackInfo ci) {
//		if (Mouse.isButtonDown(0)) {
//			attackCooldown = 0;
//		}
//	}
}
