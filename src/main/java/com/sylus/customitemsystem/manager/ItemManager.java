package com.sylus.customitemsystem.manager;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ItemManager {

    public static ItemStack addLore(ItemStack item, String name, ItemMeta iMetta, String ... lore){
    //ItemStack returnItem = getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " ");
     ItemMeta meta = item.getItemMeta();
     List<String> lores = new ArrayList<>();
     for(String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
     }
     lores.add(Arrays.toString(lore));
    meta.setLore(lores);
    item.setItemMeta(meta);
    return item;
 }
 /*
 Test code, will delete at some point
    private static ItemStack getItem(ItemStack item, String name, String... lore){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for(String s : lore){
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
  }
  */
}
