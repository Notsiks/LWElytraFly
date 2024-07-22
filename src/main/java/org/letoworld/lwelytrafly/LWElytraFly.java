package org.letoworld.lwelytrafly;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class LWElytraFly extends JavaPlugin {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        loadConfig();
        getServer().getPluginManager().registerEvents(new EventElytra(this), this);
        getCommand("lwelytrafly").setExecutor(new Commands(this));
    }

    private void loadConfig() {
        saveDefaultConfig();
        config = getConfig();
    }


    @Override
    public void onDisable() {
        //Add logic disable plugin
    }

    public void reloadPluginConfig() {
        this.reloadConfig();
        this.config = this.getConfig();
    }
}
