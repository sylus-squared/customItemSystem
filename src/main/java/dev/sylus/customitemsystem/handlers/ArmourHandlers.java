package dev.sylus.customitemsystem.handlers;

import dev.sylus.customitemsystem.CustomItemSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ArmourHandlers implements Listener {
    public void itemHandlerHandler(CustomItemSystem plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private int cooldownSeconds;
    private String source;

    @EventHandler
    public void damageCheck(EntityDamageEvent event) {// This is still being worked on
        if (event.getEntity() instanceof Player){
            Player player = ((Player) event.getEntity()).getPlayer();

            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
                ItemStack[] playerArmour = player.getInventory().getArmorContents();
                System.out.println(Arrays.toString(playerArmour));
            }
        }
    }
}
