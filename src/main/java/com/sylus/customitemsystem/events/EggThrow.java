package com.sylus.customitemsystem.events;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class EggThrow implements Listener {
    public EggThrow(){
    }

    public void eggThrowLogic(Player player) {
        Location location = player.getLocation();
        Vector direction = location.getDirection();

        Egg egg = player.launchProjectile(Egg.class, direction);
        egg.setVelocity(direction.multiply(2));
        player.playSound(player.getLocation(), Sound.ENTITY_EGG_THROW, 1 ,1);
    }

}
