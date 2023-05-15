package com.sylus.newcustomitemsystem;

import com.sylus.newcustomitemsystem.commands.loreAddTest;
import com.sylus.newcustomitemsystem.events.*;
import com.sylus.newcustomitemsystem.handlers.playerHandler;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import com.sylus.newcustomitemsystem.manager.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class NewCustomItemSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Plugin started");
        getCommand("fly").setExecutor(new com.sylus.newcustomitemsystem.commands.fly());
        getCommand("menu").setExecutor(new com.sylus.newcustomitemsystem.commands.menu(this));
        getCommand("loreAddTest").setExecutor(new loreAddTest());

        new playerHandler(this);
        new itemManager();
        new launcher().launcherHandeler(this);
        new arrow().arrowHandeler(this);
        new menuClick().menuHandeler(this);
        new lightningStrike().lightningHandeler(this);
        new tntThrow().tntHandeler(this);
        new otherLauncher().otherLauncherHandeler(this);
        new glowEffect().glowHandeler(this);
        new cactusThrow().cactusThrowHandeler(this);
        new anvilRain().anvilRainHandeler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin shutdown");
    }
}
