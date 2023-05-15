package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class otherLauncher implements Listener {
    public void otherLauncherHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player player = event.getPlayer();
            if (event.getItem() != null) {
                int cooldownSeconds = 60;
                if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                    ItemStack item = event.getItem();
                    ItemStack heldItem = event.getItem();
                    if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "OTHERLAUNCHER")) {
                        String source = "Right click otherLauncher";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            for (Entity entity : player.getNearbyEntities(5,5,5)){
                                if (entity instanceof LivingEntity){
                                    LivingEntity livingentity = (LivingEntity) entity;
                                    livingentity.setVelocity(player.getLocation().getDirection().multiply(0.5).setY(1));
                                    if (livingentity instanceof Player){
                                        Player entityPlayer = ((Player) livingentity).getPlayer();
                                        livingentity.sendMessage(ChatColor.GOLD + "You have been launched");
                                        player.playSound(player.getLocation(), Sound.ENTITY_SLIME_JUMP_SMALL, 1 ,1);
                                    }
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
}
