package com.sylus.newcustomitemsystem;

import com.sylus.newcustomitemsystem.commands.LoreAddTest;
import com.sylus.newcustomitemsystem.commands.GetUUID;
import com.sylus.newcustomitemsystem.events.*;
import com.sylus.newcustomitemsystem.handlers.ItemHandlers;
import com.sylus.newcustomitemsystem.handlers.playerHandler;
import com.sylus.newcustomitemsystem.manager.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class NewCustomItemSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getLogger().log(Level.INFO, "[CustomItemSystem]: Plugin started");
        Bukkit.getLogger().log(Level.INFO, "[CustomItemSystem]: Started the plugin: build number 53");

        getCommand("fly").setExecutor(new com.sylus.newcustomitemsystem.commands.fly());
        getCommand("menu").setExecutor(new com.sylus.newcustomitemsystem.commands.menu(this));
        getCommand("loreAddTest").setExecutor(new LoreAddTest());
        getCommand("getUUID").setExecutor(new GetUUID());

        System.out.println("[CustomItemSystem]: (debug) Loaded the commands");

        new playerHandler(this);
        new itemManager();
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
