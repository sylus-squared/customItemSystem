package com.sylus.customitemsystem.events;


import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class launcher implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (event.getItem() != null){
                ItemMeta lore = (ItemMeta) event.getItem().getItemMeta().getLore();
                //Check if it has the specific NBT tag
                Player player = event.getPlayer();
                ItemStack heldItem = event.getItem();
                if ( NBTEditor.contains( heldItem, "any custom string key", "item", "owner" ) ) {
                    String owner = NBTEditor.getString( heldItem, "any custom string key", "item", "owner" );
                    player.sendMessage(ChatColor.RED + "Works");
                }
            }

        }
    }
}
