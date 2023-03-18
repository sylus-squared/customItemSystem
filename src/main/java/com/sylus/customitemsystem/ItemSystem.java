package com.sylus.customitemsystem;
import com.sylus.customitemsystem.commands.fly;
import com.sylus.customitemsystem.commands.menu;
import com.sylus.customitemsystem.handlers.playerHandler;
import com.sylus.customitemsystem.handlers.torchHandler;
import com.sylus.customitemsystem.manager.cooldowns;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info(ChatColor.GREEN + "Plugin started");
        getCommand("fly").setExecutor(new fly());
        getCommand("menu").setExecutor(new menu(this));

        new torchHandler(this);
        new playerHandler(this);
        new cooldowns(this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(ChatColor.RED + "Plugin stopped");
    }

}


