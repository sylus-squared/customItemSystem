package com.sylus.customitemsystem.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class TntThrow implements Listener {

    public void TntThrow() {
    }
    public void tntThrowLogic(Player player){
        Location location = player.getLocation();
        World world = player.getWorld();
        Vector direction = location.getDirection();

        TNTPrimed tnt = (TNTPrimed) world.spawnEntity(location, EntityType.PRIMED_TNT);
        tnt.setFuseTicks(80);
        tnt.setVelocity(direction.multiply(2));
    }
}
