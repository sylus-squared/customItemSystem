package com.sylus.customitemsystem.commands;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoreAddTest implements CommandExecutor { // this will be cleaned up at some point


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command");
            return true;
        } else if (args[0] == null) {
            sender.sendMessage(ChatColor.RED + "Please include a value. The format is /loreAddTest [NBT]");
        }

        Player player = (Player) sender;
        if (player.getInventory().getItemInMainHand() == null){
            player.sendMessage(ChatColor.RED + "Please have an item in your hand");
            return true;
        }
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (!heldItem.getItemMeta().hasLore()){
                ItemMeta meta = heldItem.getItemMeta();
                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                lore.add("Added the lore: " + Arrays.toString(args) + " test key");
                meta.setLore(lore);
                heldItem.setItemMeta(meta);
                player.getInventory().setItemInMainHand(heldItem);
                heldItem = NBTEditor.set( heldItem, args[0], "test", "value" );
                player.setItemInHand( heldItem );
                player.sendMessage(ChatColor.GOLD + "Added the following lore: " + Arrays.toString(args));
                return true;
        }else {

            ItemStack item = player.getItemInHand();
            if ( item != null ) {
                item = NBTEditor.set( item, args[0], "test", "value" );
                player.setItemInHand( item );
                player.sendMessage( "" + NBTEditor.getString( item, "test", "value" ) );
            }
        Bukkit.getLogger().info(ChatColor.GREEN + "Test");
        ItemMeta meta = heldItem.getItemMeta();
        List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        lore.add("Added the lore: " + Arrays.toString(args) + " test key");
        meta.setLore(lore);
        heldItem.setItemMeta(meta);
        player.getInventory().setItemInMainHand(heldItem);
        player.sendMessage(ChatColor.GOLD + "Added the following lore: " + Arrays.toString(args));
        return true;
        }

    }

}
