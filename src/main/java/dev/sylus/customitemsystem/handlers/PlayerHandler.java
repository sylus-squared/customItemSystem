package dev.sylus.customitemsystem.handlers;

import dev.sylus.customitemsystem.CustomItemSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerHandler implements Listener {
    public PlayerHandler(CustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        // Remember to actually update the build number
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome. Currently testing: Cactus throw and anvil rain ", ChatColor.YELLOW + "build 53");
    }
}


