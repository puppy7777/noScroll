package com.puppy7777.noscroll;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class toggleCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "noscroll";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            configHandler.enabled = !configHandler.enabled;
            configHandler.saveConfig();
            try{
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(
                        "noScroll " + ((configHandler.enabled) ? "enabled" : "disabled")));
            } catch (Exception ignored) {}
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}