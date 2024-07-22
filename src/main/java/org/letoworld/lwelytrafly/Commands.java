package org.letoworld.lwelytrafly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private final LWElytraFly plugin; // Обновите тип плагина

    public Commands(LWElytraFly plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("lwelytrafly")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("lwelytrafly.reload")) {
                    this.plugin.reloadPluginConfig();
                    sender.sendMessage("§aThe configuration has been reloaded!.");
                    return true;
                } else {
                    sender.sendMessage("§cThe configuration has been reloaded!.");
                    return true;
                }
            } else {
                sender.sendMessage("§cUsage: /lwelytrafly reload");
                return true;
            }
        }
        return false;
    }
}
