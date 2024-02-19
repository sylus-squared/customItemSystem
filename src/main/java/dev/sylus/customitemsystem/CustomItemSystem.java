package dev.sylus.customitemsystem;

import dev.sylus.customitemsystem.commands.Fly;
import dev.sylus.customitemsystem.commands.LoreAddTest;
import dev.sylus.customitemsystem.commands.GetUUID;
import dev.sylus.customitemsystem.commands.Menu;
import dev.sylus.customitemsystem.handlers.ItemHandlers;
import dev.sylus.customitemsystem.handlers.PlayerHandler;
import dev.sylus.customitemsystem.manager.ItemManager;
import dev.sylus.customitemsystem.events.MenuClick;
import dev.sylus.customitemsystem.utils.Files;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class CustomItemSystem extends JavaPlugin {
    public Files files;

    @Override
    public void onEnable() {
        // Plugin startup logic
        files = new Files(this, "items.yml");


        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu(this));
        getCommand("loreAddTest").setExecutor(new LoreAddTest());
        getCommand("getUUID").setExecutor(new GetUUID());

        new PlayerHandler(this);
        new ItemManager();
        new ItemHandlers().itemHandlerHandler(this);
        new MenuClick(files).menuHandeler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
