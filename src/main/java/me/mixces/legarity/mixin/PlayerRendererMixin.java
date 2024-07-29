package me.mixces.legarity.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.client.render.model.entity.PlayerModel;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin {

    @WrapOperation(
		method = "renderPlayerRightHandModel",
		at = @At(
			value = "FIELD",
			opcode = Opcodes.PUTFIELD,
			target = "Lnet/minecraft/client/render/model/entity/PlayerModel;sneaking:Z"
		)
	)
    private void legarity$mc1349fix(PlayerModel instance, boolean value, Operation<Void> original) {
        instance.hasVehicle = instance.sneaking = false;
    }
}
