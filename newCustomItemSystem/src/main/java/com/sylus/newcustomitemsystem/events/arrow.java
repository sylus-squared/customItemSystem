package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Objects;

public class arrow implements Listener {
    public void arrowHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (event.getItem() != null) {
                int cooldownSeconds = 1;
                if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                    ItemStack item = event.getItem();
                    ItemStack heldItem = event.getItem();
                    if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "ARROW")) {
                        String source = "Right click Arrow";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            // Get the player's location and direction
                            Location location = player.getLocation();
                            Vector direction = location.getDirection();

                            // Create a new arrow and set its initial position and velocity
                            Arrow arrow = player.launchProjectile(Arrow.class, direction);
                            // Edit pickup status
                            arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                            // Edit velocity
                            arrow.setVelocity(direction.multiply(2));
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

}
