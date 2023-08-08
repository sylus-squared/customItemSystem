package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class Arrow implements Listener {
    public Arrow(){
    }
    public void arrowLogic(Player player){
        Location location = player.getLocation();
        Vector direction = location.getDirection();

        org.bukkit.entity.Arrow arrow = player.launchProjectile(org.bukkit.entity.Arrow.class, direction);
        arrow.setPickupStatus(org.bukkit.entity.Arrow.PickupStatus.DISALLOWED);
        arrow.setVelocity(direction.multiply(2));
    }
}
