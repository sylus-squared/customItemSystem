package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;



public class launcher implements Listener {

    public void launcherHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            Player player = event.getPlayer();
            if (event.getItem() != null){
                int cooldownSeconds = 10;
                if (player.getInventory().getItemInMainHand().getItemMeta() != null){
                    ItemStack item = event.getItem();
                    ItemStack heldItem = event.getItem();
                    if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "LAUNCHER")) {
                        String source = "Right click Launcher";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            player.setVelocity(player.getLocation().getDirection().multiply(0.3).setY(1));
                            player.playSound(player.getLocation(), Sound.ENTITY_SLIME_JUMP_SMALL, 1 ,1);
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
