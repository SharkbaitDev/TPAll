package me.arab.tpall;

import me.arab.tpall.command.TPCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getCommand("tpall").setExecutor(new TPCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Core getInstance() {
        return instance;
    }
}
