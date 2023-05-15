package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

import static org.bukkit.potion.PotionEffectType.GLOWING;

public class glowEffect implements Listener {
    public void glowHandeler(NewCustomItemSystem plugin){
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
                    if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "GLOWOING")) {
                        String source = "Right click glow";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            player.playSound(player.getLocation(), Sound.ENTITY_GLOW_SQUID_AMBIENT, 1 ,1);
                            for (Entity entity : player.getNearbyEntities(20,20,20)){
                                if (entity instanceof LivingEntity){
                                    LivingEntity livingentity = (LivingEntity) entity;
                                    livingentity.addPotionEffect(new PotionEffect(GLOWING, 6600, 1));
                                    if (livingentity instanceof Player){
                                        Player playerEntity = ((Player) livingentity).getPlayer();
                                        playerEntity.sendMessage(ChatColor.GOLD + "You are now glowing for 30s");
                                        playerEntity.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1 ,1);
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
