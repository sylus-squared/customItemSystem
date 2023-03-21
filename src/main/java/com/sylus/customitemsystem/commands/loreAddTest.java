package com.sylus.customitemsystem.commands;

import com.sylus.customitemsystem.ItemSystem;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;

import java.util.ArrayList;
import java.util.List;

import static com.sylus.customitemsystem.manager.itemManager.addLore;
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
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getItemMeta().hasLore() != true){
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            ItemMeta meta = heldItem.getItemMeta();
            List<String> newLore = new ArrayList();
            newLore.add("New lore test");
            meta.setLore(newLore);
            heldItem.setItemMeta(meta);
            player.getInventory().setItemInMainHand(heldItem);
            player.sendMessage(ChatColor.GOLD + "Test");
            return true;
        }

        Bukkit.getLogger().info(ChatColor.GREEN + "Test");
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        heldItem = NBTEditor.set( item, "BananaPuncher714", "any custom string key", "item", "owner" );
        ItemMeta meta = heldItem.getItemMeta();
        List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        lore.add("New lore test");
        meta.setLore(lore);
        heldItem.setItemMeta(meta);
        player.getInventory().setItemInMainHand(heldItem);
        player.sendMessage(ChatColor.GOLD + "Test");
        return true;

    }
}
