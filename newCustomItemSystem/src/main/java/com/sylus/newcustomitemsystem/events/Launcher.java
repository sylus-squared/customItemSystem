package com.sylus.newcustomitemsystem.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Launcher {

    public Launcher(Player player){
        launcherLogic(player);
    }

    public void launcherLogic(Player player){
            player.setVelocity(player.getLocation().getDirection().multiply(0.3).setY(1));
            player.playSound(player.getLocation(), Sound.ENTITY_SLIME_JUMP_SMALL, 1 ,1);
    }
}
