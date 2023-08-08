package com.sylus.newcustomitemsystem.events;

import org.bukkit.*;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class AnvilRain implements Listener {
    public AnvilRain() {
    }

    public void anvilThrowLogic(Player player) {
        player.sendMessage(ChatColor.RED + "Executing anvil throw");
        Location location = player.getLocation();
        World world = player.getWorld();
        Vector direction = location.getDirection();

        for (int i = 1; i < 7; i++) {
            player.sendMessage(ChatColor.RED + "Executing anvil throw loop");
            Location anvilLocations = new Location(world, player.getLocation().getX(), player.getLocation().getY() + 10 + i, player.getLocation().getZ());
            FallingBlock anvil = world.spawnFallingBlock(anvilLocations, Material.ANVIL, (byte) 0);
            anvil.setVelocity(direction.multiply(0.5 * i));
            anvil.setDropItem(false);
            anvil.setFallDistance(20);
            if (world.getBlockAt(anvilLocations).equals(Material.AIR) || world.getBlockAt(anvilLocations).equals(Material.CAVE_AIR)) {

                player.sendMessage(ChatColor.RED + "Executing anvil throw looped if");
            }
        }
        player.sendMessage(ChatColor.RED + "Executed anvil throw");
    }
}
