package dev.sylus.customitemsystem.manager;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ItemManager {

    public static ItemStack addLore(ItemStack item, String name, ItemMeta iMetta, String ... lore){
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

}
