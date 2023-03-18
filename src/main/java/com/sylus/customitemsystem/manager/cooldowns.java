package com.sylus.customitemsystem.manager;

import com.sylus.customitemsystem.ItemSystem;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class cooldowns implements Listener {

    private Map<UUID, Integer> playerCooldownMap = new HashMap<>();
    public cooldowns(ItemSystem plugin){
        new BukkitRunnable(){
            @Override
            public void run(){
                for (UUID uuid : playerCooldownMap.keySet()){
                    if (playerCooldownMap.get(uuid) == 1){
                        playerCooldownMap.remove(uuid);
                        continue;
                    }
                    playerCooldownMap.put(uuid,playerCooldownMap.get(uuid) -1);
                }
            }
        }.runTaskTimer(plugin, 0, 25);
    }
    public void addPlayerToMap(Player player, Integer time){
        playerCooldownMap.put(player.getUniqueId(),time);
    }

    public boolean isPlayerInCooldown(Player player){
        return playerCooldownMap.containsKey(player.getUniqueId());

    }
}
