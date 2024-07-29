package me.mixces.legarity.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.options.KeyBinding;
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
}
