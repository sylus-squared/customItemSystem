package com.sylus.customitemsystem.events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class OtherLauncher implements Listener {
    public OtherLauncher() {

    }

    public void otherLauncherLogic(Player player) {

        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) entity;
                livingentity.setVelocity(player.getLocation().getDirection().multiply(0.5).setY(1));
                if (livingentity instanceof Player) {
                    Player entityPlayer = ((Player) livingentity).getPlayer();
                    livingentity.sendMessage(ChatColor.GOLD + "You have been launched");
                    player.playSound(player.getLocation(), Sound.ENTITY_SLIME_JUMP_SMALL, 1, 1);
                }
            }
        }
    }
}
