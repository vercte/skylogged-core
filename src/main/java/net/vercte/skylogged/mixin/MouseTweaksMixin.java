package net.vercte.skylogged.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.tazer.clutternomore.common.shape_map.ShapeMap;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(yalter.mousetweaks.Main.class)
public class MouseTweaksMixin {
    @WrapOperation(method = "areStacksCompatible", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isSameItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z"))
    private static boolean skylogged$checkSameSet(ItemStack a, ItemStack b, Operation<Boolean> original) {
        return original.call(a, b) || ShapeMap.inSameShapeSet(a.getItem(), b.getItem());
    }

    @WrapOperation(method = "areStacksCompatible", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isSameItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z"))
    private static boolean skylogged$checkSameSetAndComponents(ItemStack a, ItemStack b, Operation<Boolean> original) {
        return original.call(a, b) || ShapeMap.inSameShapeSet(a.getItem(), b.getItem()) && a.getComponentsPatch().equals(b.getComponentsPatch());
    }
}
