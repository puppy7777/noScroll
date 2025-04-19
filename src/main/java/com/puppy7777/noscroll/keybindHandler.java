package com.puppy7777.noscroll;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class keybindHandler {
    public keybindHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.isKeyDown(Keyboard.KEY_EQUALS)) {
            configHandler.enabled = !configHandler.enabled;
            configHandler.saveConfig();
            try{
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(
                        "noScroll " + ((configHandler.enabled) ? "enabled" : "disabled")));
            } catch (Exception ignored) {}
        }
    }
}
