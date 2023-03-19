package com.sylus.customitemsystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static com.sylus.customitemsystem.manager.itemManager.addLore;
//Not working right now. Probbly something to do with the YML
public class loreAddTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command");
            return true;
        }

        Player player = (Player) sender;
        if (player.getInventory().getItemInMainHand() == null){
            player.sendMessage(ChatColor.RED + "Please have an item in your hand");
            return true;
        }
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        ItemMeta meta = heldItem.getItemMeta();
        List<String> newLore = new ArrayList();
        newLore.add("This is new lore");
        meta.setLore(newLore);
        heldItem.setItemMeta(meta);
        player.getInventory().setItemInMainHand(heldItem);
        player.sendMessage(ChatColor.GOLD + "Test");
        /*
        ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta metaToAdd = addLore(item, meta, meta, );
        player.getInventory().getItemInMainHand().setItemMeta(metaToAdd);
*/


        return true;

    }
}
