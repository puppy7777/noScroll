package com.puppy7777.noscroll;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class configHandler {
    private static Configuration config;

    public static boolean enabled;

    public static void loadConfig(File file) {
        config = new Configuration(file);

        try {
            config.load();
        } catch (Exception e) {
            System.err.println("Failed to load configuration file: " + file.getName());
            e.printStackTrace();
        }

        enabled = config.get("noScroll", "Enabled", true, "noScroll?").getBoolean();
    }

    public static void saveConfig() {
        if (config == null) {
            System.err.println("Config not initialized. Call loadConfig() first.");
            return;
        }
        config.get("noScroll", "Enabled", enabled, "noScroll?").set(enabled);
        config.save();
        System.out.println("Configuration saved successfully.");
    }
}
