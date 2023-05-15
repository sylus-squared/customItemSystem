package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Objects;

public class cactusThrow implements Listener {
    public void cactusThrowHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void rightClick(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().getItemMeta() != null){
                int cooldownSeconds = 60;
                ItemStack heldItem = player.getInventory().getItemInMainHand();
                if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "CACTUSTHROW")){
                    String source = "Anvil rain";
                    if (!cooldowns.hasCooldown(player, source)) {
                        cooldowns.setCooldown(player, cooldownSeconds, source);
                        Location location = player.getLocation();
                        World world = player.getWorld();
                        Vector direction = location.getDirection();

                            Location anvilLocations = new Location(world, player.getLocation().getX(), player.getLocation().getY() + 10, player.getLocation().getZ());
                            FallingBlock cactus = world.spawnFallingBlock(anvilLocations, Material.CACTUS, (byte) 0);
                            cactus.setVelocity(direction.multiply(2));
                            cactus.setDropItem(false);
                            cactus.canHurtEntities();
                            NBTEditor.set(cactus, "THROWNCACTUS", "test", "value");


                    } else {
                        event.setCancelled(true);
                        long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                        player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                    }

                }
            }
        }
    }


    @EventHandler
    public void entityDamageEvent(EntityDamageByEntityEvent event){
        if (!(event.getEntity() instanceof Player)){
            if (event.getDamager() instanceof FallingBlock) {
                Entity damager = event.getDamager();
                if (Objects.equals(NBTEditor.getString(damager, "test", "value"), "CACTUSTHROW")) {
                    if (event.getEntity() instanceof LivingEntity) {

                    try {

                        LivingEntity livingEntity = (LivingEntity) event.getEntity();
                        EntityEquipment mobInventory = livingEntity.getEquipment();


                    } catch (NullPointerException e) {

                    }

                }
            }
            }
        }
    }
}
