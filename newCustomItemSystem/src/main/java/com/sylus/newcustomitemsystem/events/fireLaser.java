package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Objects;

public class fireLaser implements Listener {
    public void fireLaserHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void rightClick(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().getItemMeta() != null){
                ItemStack heldItem = player.getInventory().getItemInMainHand();
                if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "FIRELASER")){
                    String source = "Fire laser";
                    if (!cooldowns.hasCooldown(player, source)) {
                        Location location = player.getLocation();
                        World world = player.getWorld();
                        Vector direction = location.getDirection();

                        Firework firework = (Firework) player.launchProjectile(Firework.class, direction);
                        firework.setTicksLived(20);


                    } else {
                        event.setCancelled(true);
                        long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                        player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                    }

                }
            }
        }
    }
}
