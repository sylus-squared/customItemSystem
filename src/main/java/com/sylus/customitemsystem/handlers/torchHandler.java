package com.sylus.customitemsystem.handlers;

import com.sylus.customitemsystem.ItemSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/*event priority
Lowest
Low
Normal (Defult if you don't specify a priority)
High
Highest
--------
Monitor (Different)
 */
//This will be removed soon
//It is only here for testing
public class torchHandler implements Listener {
    public torchHandler(ItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low(BlockPlaceEvent event){
       if (event.getBlock().getType() == Material.TORCH){
           if(!event.getPlayer().hasPermission(("test.torch.diamond"))) {
               return;
           }
           event.getBlock().setType(Material.DIAMOND_BLOCK);
       }
    }


}
