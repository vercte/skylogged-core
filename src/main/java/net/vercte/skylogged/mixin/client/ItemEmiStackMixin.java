package net.vercte.skylogged.mixin.client;

import dev.emi.emi.api.stack.ItemEmiStack;
import dev.tazer.clutternomore.common.shape_map.ShapeMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEmiStack.class)
public class ItemEmiStackMixin {
    @Mutable
    @Shadow
    @Final
    private Item item;

    @Inject(method = "<init>(Lnet/minecraft/world/item/Item;Lnet/minecraft/core/component/DataComponentPatch;J)V", at = @At("TAIL"), require = 0)
    public void replaceWithParent(Item item, DataComponentPatch components, long amount, CallbackInfo ci) {
        if(components != DataComponentPatch.EMPTY) return;

        this.item = ShapeMap.getParent(item);
    }
}
