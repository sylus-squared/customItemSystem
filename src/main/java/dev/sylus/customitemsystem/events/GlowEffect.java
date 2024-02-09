package dev.sylus.customitemsystem.events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.potion.PotionEffectType.GLOWING;

public class GlowEffect implements Listener {
    public GlowEffect(Player player){
        glowLogic(player);
    }

    public void glowLogic(Player player) {
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

    }
}
