package com.puppy7777.noscroll.mixins;

import com.puppy7777.noscroll.configHandler;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "startGame", at = @At("HEAD"))
    private void startGame(CallbackInfo ci) {
        System.out.println("Mixin worked!");
    }

    @Redirect(method = "func_71407_l", at = @At(value = "INVOKE", target =
            "Lorg/lwjgl/input/Mouse;getEventDWheel()I"), remap = false)
    private int getEventDWheel() {
        //System.out.println("OMG!!!!! GOT HERE!!!!!!");
        int i =  Mouse.getEventDWheel();
        if (configHandler.enabled) {
            return Math.min(i, 0);
        } else {
            return i;
        }

    }
}
