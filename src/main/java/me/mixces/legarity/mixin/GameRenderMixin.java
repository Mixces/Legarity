package me.mixces.legarity.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameRenderer.class)
public class GameRenderMixin {

	@WrapOperation(
		method = "tick",
		at = @At(
			value = "NEW",
			target = "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/math/BlockPos;"
		)
	)
	private BlockPos legarity$mc51150fix(Entity entity, Operation<BlockPos> original) {
		final Vec3d eyeVec = entity.getEyePosition(1.0F);
		final BlockPos pos = original.call(entity);
		return pos.add(eyeVec.x - pos.getX(), eyeVec.y - pos.getY(), eyeVec.z - pos.getZ());
	}
}
