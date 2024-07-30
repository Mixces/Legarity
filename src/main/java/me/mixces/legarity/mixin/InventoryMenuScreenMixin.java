package me.mixces.legarity.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.menu.InventoryMenuScreen;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryMenuScreen.class)
public abstract class InventoryMenuScreenMixin extends Screen {

	@Shadow
	protected abstract void keyPressed(char chr, int key);

	@Inject(
		method = "mouseClicked",
		at = @At(
			value = "HEAD"
		)
	)
    public void legarity$mc577fix(int mouseX, int mouseY, int mouseButton, CallbackInfo ci) {
		keyPressed(Keyboard.getEventCharacter(), mouseButton - 100);
    }
}
