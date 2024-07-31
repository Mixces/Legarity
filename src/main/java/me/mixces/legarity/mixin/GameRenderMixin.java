package me.mixces.legarity.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GameRenderer.class)
public class GameRenderMixin {

	@Shadow
	private Minecraft minecraft;

	@ModifyArg(
		method = "tick",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/world/ClientWorld;getBrightness(Lnet/minecraft/util/math/BlockPos;)F"
		)
	)
	private BlockPos legarity$mc51150fix(BlockPos par1) {
		final Vec3d eyeVec = minecraft.getCamera().getEyePosition(1.0F);
		return par1.add(eyeVec.x - par1.getX(), eyeVec.y - par1.getY(), eyeVec.z - par1.getZ());
	}
}
