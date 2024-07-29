package me.mixces.legarity.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ClientPlayerInteractionManager.class)
public abstract class ClientPlayerInteractionManagerMixin {

	@Shadow
	public abstract boolean isMiningBlock();

	@ModifyExpressionValue(
		method = "updateBlockMining",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/ClientPlayerInteractionManager;isMiningBlock(Lnet/minecraft/util/math/BlockPos;)Z"
		)
    )
    private boolean legarity$mc255057fix(boolean original) {
        return original && isMiningBlock();
    }
}
