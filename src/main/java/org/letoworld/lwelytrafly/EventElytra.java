package org.letoworld.lwelytrafly;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public class EventElytra implements Listener {
    private final LWElytraFly plugin;

    public EventElytra(LWElytraFly plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();

        if (command.equals("/fly")) {
            // Проверяем, есть ли элитра на игроке
            ItemStack chestplate = player.getInventory().getChestplate(); // Получаем доспех (верхний слот)

            if ((chestplate == null || chestplate.getType() != Material.ELYTRA)) {
                String messageFly = plugin.getConfig().getString("messageFly");
                player.sendMessage(messageFly);
                event.setCancelled(true);
            }
        }
    }
}
