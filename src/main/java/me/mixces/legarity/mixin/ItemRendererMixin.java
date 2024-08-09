package me.mixces.legarity.mixin;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

	@Inject(
		method = "renderGuiItem",
		at = @At("HEAD")
	)
	private void legarity$enableDepth(ItemStack stack, int x, int y, CallbackInfo ci) {
		GlStateManager.enableDepthTest();
	}
}
