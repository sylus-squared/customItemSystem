package com.sylus.newcustomitemsystem.manager;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class cooldowns implements Listener {
    private static Map<String, List<Cooldown>> cooldowns = new HashMap<>();

    public static void setCooldown(Player player, int seconds, String source) {
        long expireTime = System.currentTimeMillis() + (seconds * 1000L);
        List<Cooldown> playerCooldowns = cooldowns.get(player.getName());
        if (playerCooldowns == null) {
            playerCooldowns = new ArrayList<>();
            cooldowns.put(player.getName(), playerCooldowns);
        }
        playerCooldowns.add(new Cooldown(expireTime, source));
    }

    public static boolean hasCooldown(Player player, String source) {
        List<Cooldown> playerCooldowns = cooldowns.get(player.getName());
        if (playerCooldowns == null) {
            return false;
        }
        playerCooldowns.removeIf(cooldown -> cooldown.getExpiration() <= System.currentTimeMillis());
        for (Cooldown cooldown : playerCooldowns) {
            if (cooldown.getSource().equals(source)) {
                return true;
            }
        }
        return false;
    }

    public static long getCooldown(Player player, String source) {
        List<Cooldown> playerCooldowns = cooldowns.get(player.getName());
        if (playerCooldowns == null) {
            return 0;
        }
        playerCooldowns.removeIf(cooldown -> cooldown.getExpiration() <= System.currentTimeMillis());
        for (Cooldown cooldown : playerCooldowns) {
            if (cooldown.getSource().equals(source)) {
                return (cooldown.getExpiration() - System.currentTimeMillis())/1000;
            }
        }
        return 0;
    }

    public static class Cooldown {

        private long expiration;
        private String source;

        public Cooldown(long expiration, String source) {
            this.expiration = expiration;
            this.source = source;
        }

        public long getExpiration() {
            return expiration;
        }

        public String getSource() {
            return source;
        }
    }

}
