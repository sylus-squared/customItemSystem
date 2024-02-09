package dev.sylus.customitemsystem.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LightningStrike implements Listener {
    public LightningStrike(Player player){
        lightningLogic(player);
    }


    public void lightningLogic(Player player) {
        for (Entity entity : player.getNearbyEntities(5,5,5)){
            if (entity instanceof LivingEntity){
                LivingEntity livingentity = (LivingEntity) entity;
                livingentity.getWorld().strikeLightningEffect(livingentity.getLocation());
                livingentity.damage(10);
            }
        }

    }
}
