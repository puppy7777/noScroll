package com.puppy7777.noscroll;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = NoScroll.MODID, version = NoScroll.VERSION)
public class NoScroll {
    public static final String MODID = "noscroll";
    public static final String VERSION = "1.0";

    /**
     * If everything goes to plan, you should see this message in the console.
     *
     * This is the main class and method of your mod. It is the entry point for the mod and
     * is used to register all the things that your mod needs to function.
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("ClientCommandHandler: " + ClientCommandHandler.instance);
        //MinecraftForge.EVENT_BUS.register(new keybindHandler());
        ClientCommandHandler.instance.registerCommand(new toggleCommand());
    }
}
