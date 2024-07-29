package me.mixces.legarity.mixin;

import com.google.common.collect.Lists;
import net.minecraft.client.options.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(KeyBinding.class)
public interface KeyBindingAccessor {

	@Accessor
	static List<KeyBinding> getALL() {
		return Lists.newArrayList();
	}
}
