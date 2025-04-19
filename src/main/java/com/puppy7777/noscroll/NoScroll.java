package com.puppy7777.noscroll;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NoScroll.MODID, version = NoScroll.VERSION)
public class NoScroll {
    public static final String MODID = "noscroll";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("[noScroll] Pre-initialization started");
        configHandler.loadConfig(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("ClientCommandHandler: " + ClientCommandHandler.instance);
        //MinecraftForge.EVENT_BUS.register(new keybindHandler());
        ClientCommandHandler.instance.registerCommand(new toggleCommand());
    }
}
