package net.vercte.skylogged.mixin;

import com.copycatsplus.copycats.content.copycat.slab.CopycatSlabBlock;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CopycatSlabBlock.class)
public class CopycatSlabMixin {
    @WrapOperation(method = "onSneakWrenched", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;placeItemBackInInventory(Lnet/minecraft/world/item/ItemStack;)V"))
    public void doNotDupeSlabs(Inventory instance, ItemStack stack, Operation<Void> original) {
        // nooo-ooop
    }
}
