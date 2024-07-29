package me.mixces.legarity.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.living.player.ClientPlayerEntity;
import net.minecraft.client.entity.living.player.LocalClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LocalClientPlayerEntity.class)
public abstract class LocalClientPlayerEntityMixin extends ClientPlayerEntity {


	public LocalClientPlayerEntityMixin(World world, GameProfile gameProfile) {
		super(world, gameProfile);
	}

	/* MC-67665 Fix */
	@Override
	public Vec3d getRotationVec(float tickDelta) {
		return getRotationVector(pitch, yaw);
	}
}
