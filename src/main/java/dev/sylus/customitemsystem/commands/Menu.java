package dev.sylus.customitemsystem.commands;


import dev.sylus.customitemsystem.CustomItemSystem;
import dev.sylus.customitemsystem.utils.Files;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Menu implements CommandExecutor, Listener {
    private String invName = "Modify an Item";
    Files files;

    public Menu(CustomItemSystem plugin, Files filesInstance){
        files = filesInstance;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (!event.getView().getTitle().equals(invName)){
            return;
        }
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        event.setCancelled(true);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can use this command");
            return true;
        }
        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(player, 9 * 4, invName);
        for (int i = 0; i < 10; i++){
            inv.setItem(i, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        }
        for (int i = 27; i < 36; i++){
            inv.setItem(i, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        }
        // Need to add the code to give items nbt data in the gui
        inv.setItem(10, getItem(new ItemStack(Material.SLIME_BLOCK), "&eLeaping", "&eClick to select &8Boosts the user up 10 blocks", "&c60 second cooldown"));
        inv.setItem(11, getItem(new ItemStack(Material.BEACON), "&bLightning", "&eClick to select &8Strikes all mobs within", "&8a 5 block range dealing 10 damage", "&c2min cooldown"));
        inv.setItem(12, getItem(new ItemStack(Material.ARROW), "&eFire an arrow", "&eClick to apply &8Fires an arrow (that's it)", "&c2 second cooldown"));
        inv.setItem(13, getItem(new ItemStack(Material.TNT), "&eThrow TNT", "&eClick to apply &8Throws a piece of TNT that", "&8explodes after 5 seconds", "&c60 second cooldown"));
        inv.setItem(14, getItem(new ItemStack(Material.EGG), "&eThrow an egg", "&eClick to apply &8Throws an egg (that's it)", "&c2 second cooldown"));
        inv.setItem(15, getItem(new ItemStack(Material.FLINT_AND_STEEL), "&eLet them burn", "&eClick to apply &8Fires a beam that sets the first", "&8person it hits on &cfire", "&c3 second cooldown"));
        inv.setItem(16, getItem(new ItemStack(Material.FEATHER), "&eLaunch", "&eClick to apply &8Lunches all entities within a 5 block", "radius up 5 blocks", "&c20 second cooldown"));
        inv.setItem(17, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        inv.setItem(18, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        inv.setItem(19, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        inv.setItem(20, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        inv.setItem(21, getItem(new ItemStack(Material.ANVIL), "&eAnvil rain", "&eClick to apply &4Rains anvils from 25 blocks up", "&c2min cooldown"));
        inv.setItem(22, getItem(new ItemStack(Material.SPECTRAL_ARROW), "&eGlow", "&eClick to apply &8Fires a spectral arrow (that's it)", "&c2 second cooldown"));
        inv.setItem(23, getItem(new ItemStack(Material.GOLDEN_APPLE), "&elucky chance", "&eClick to apply &8gives the user a 10% chance to be granted a", "&6golden apple &8 or take 10 damage", "&c5 min cooldown"));
        inv.setItem(24, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        inv.setItem(25, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        inv.setItem(26, getItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", " "));
        player.openInventory(inv);
        return true;
    }

    //USE NBT INSTEAD
    private ItemStack getItem(ItemStack item, String name, String ... lore){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for(String s : lore){
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lores);
        item.setItemMeta(meta);

        for (String key : files.getConfig("items.yml").getKeys(false)) {
            if (files.getConfig("items.yml").getString(key + ".item").equals(item.getType().toString())){
                NBTEditor.set(item, "ITEMSYSTEM", key );
            }
        }
        return item;
    }
}
