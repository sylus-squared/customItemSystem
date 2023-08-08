package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Objects;

public class anvilRain implements Listener {
    public void anvilRainHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void rightClick(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().getItemMeta() != null){
                int cooldownSeconds = 60;
                ItemStack heldItem = player.getInventory().getItemInMainHand();
                if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "ANVILRAIN")){
                    String source = "Anvil rain";
                    if (!cooldowns.hasCooldown(player, source)) {
                        cooldowns.setCooldown(player, cooldownSeconds, source);
                        Location location = player.getLocation();
                        World world = player.getWorld();
                        Vector direction = location.getDirection();

                        for (int i = 1; i < 7; i++) {
                            Location anvilLocations = new Location(world, player.getLocation().getX(), player.getLocation().getY() + 10, player.getLocation().getZ());
                            if (world.getBlockAt(anvilLocations).equals(Material.AIR) || world.getBlockAt(anvilLocations).equals(Material.CAVE_AIR)) {

                                FallingBlock anvil = world.spawnFallingBlock(anvilLocations, Material.ANVIL, (byte) 0);
                                anvil.setVelocity(direction.multiply(0.1 * i));
                                anvil.setDropItem(false);
                                anvil.setFallDistance(20);
                            }
                        }



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
