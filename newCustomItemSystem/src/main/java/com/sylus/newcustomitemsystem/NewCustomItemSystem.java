package com.sylus.newcustomitemsystem;

import com.sylus.newcustomitemsystem.commands.LoreAddTest;
import com.sylus.newcustomitemsystem.events.*;
import com.sylus.newcustomitemsystem.handlers.ItemHandlers;
import com.sylus.newcustomitemsystem.handlers.playerHandler;
import com.sylus.newcustomitemsystem.manager.itemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NewCustomItemSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Plugin started");
        System.out.println("[CustomItemSystem]: Started the plugin: build number 52");
        getCommand("fly").setExecutor(new com.sylus.newcustomitemsystem.commands.fly());
        getCommand("menu").setExecutor(new com.sylus.newcustomitemsystem.commands.menu(this));
        getCommand("loreAddTest").setExecutor(new LoreAddTest());

        new playerHandler(this);
        new itemManager();
        new ItemHandlers().itemHandlerHandler(this);
        new MenuClick().menuHandeler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin shutdown");
    }
}
