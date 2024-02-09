package com.sylus.customitemsystem;

import com.sylus.customitemsystem.commands.Fly;
import com.sylus.customitemsystem.commands.LoreAddTest;
import com.sylus.customitemsystem.commands.GetUUID;
import com.sylus.customitemsystem.commands.Menu;
import com.sylus.customitemsystem.events.*;
import com.sylus.customitemsystem.handlers.ItemHandlers;
import com.sylus.customitemsystem.handlers.PlayerHandler;
import com.sylus.customitemsystem.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class CustomItemSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getLogger().log(Level.INFO, "[CustomItemSystem]: Plugin started");
        Bukkit.getLogger().log(Level.INFO, "[CustomItemSystem]: Started the plugin: build number 53");

        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu(this));
        getCommand("loreAddTest").setExecutor(new LoreAddTest());
        getCommand("getUUID").setExecutor(new GetUUID());

        System.out.println("[CustomItemSystem]: (debug) Loaded the commands");

        new PlayerHandler(this);
        new ItemManager();
        new ItemHandlers().itemHandlerHandler(this);
        new MenuClick().menuHandeler(this);

        Bukkit.getLogger().log(Level.INFO, "[CustomItemSystem]: Loaded the handlers");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().log(Level.INFO, "[CustomItemSystem]: Plugin shutdown");

    }
}
