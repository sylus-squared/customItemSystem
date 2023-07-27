package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.util.Vector;

import java.util.Objects;

public class CactusThrow implements Listener {
    public CactusThrow(){
    }
    public void cactusThrowLogic(Player player){
        Location location = player.getLocation();
        World world = player.getWorld();
        Vector direction = location.getDirection();

        Location anvilLocations = new Location(world, player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ());
        FallingBlock cactus = world.spawnFallingBlock(anvilLocations, Material.CACTUS, (byte) 0);
        cactus.setVelocity(direction.multiply(1.2));
        cactus.setDropItem(false);
        cactus.canHurtEntities();
        NBTEditor.set(cactus, "THROWNCACTUS", "test", "value");
    }



    @EventHandler
    public void entityDamageEvent(EntityDamageByEntityEvent event){
        System.out.println("Event fired");
        if (!(event.getEntity() instanceof Player)){
            if (event.getDamager() instanceof FallingBlock) {
                Entity damager = event.getDamager();
                if (Objects.equals(NBTEditor.getString(damager, "test", "value"), "CACTUSTHROW")) {
                    if (event.getEntity() instanceof LivingEntity) {
                    try {
                        LivingEntity livingEntity = (LivingEntity) event.getEntity();
                        livingEntity.damage(5);
                        World world = livingEntity.getWorld();
                        Location location = livingEntity.getLocation();

                        world.spawnParticle(Particle.EXPLOSION_NORMAL, location, 3);
                        world.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);

                        EntityEquipment mobInventory = livingEntity.getEquipment();
                    } catch (NullPointerException e) {

                    }

                }
            }
            }
        }
    }
}
