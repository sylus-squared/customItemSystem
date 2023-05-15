package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.commands.menu;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Switch;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class menuClick implements Listener {

    public void menuHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (event.getView().getTitle().equals("Modify an Item")) {
            try {
                switch (event.getCurrentItem().getType()) {

                    case SLIME_BLOCK:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "LAUNCHER")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Launch up about 6 blocks");
                                lore.add("§c10 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "LAUNCHER", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "LAUNCHER", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Launch up about 6 blocks");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;
                    case BEACON:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "LIGHTNING")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Strikes every mob with lightning dealing 5 hearts");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "LIGHTNING", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "LIGHTNING", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Launch up about 6 blocks");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }

                        break;

                    case ARROW:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "ARROW")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Fire an arrow (That's it)");
                                lore.add("§c1 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "ARROW", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "ARROW", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Fire an arrow (That's it)");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;
                    case TNT:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "ARROW")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Throws a peice of TNT that explodes after 5s)");
                                lore.add("§c30 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "TNTTHROW", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "TNTTHROW", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Throws a peice of TNT that explodes after 5s)");
                                lore.add("§c30 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;
                    case EGG:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "EGGTHROW")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Chucks an egg (Thats it)");
                                lore.add("§c1 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "EGGTHROW", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "EGGTHROW", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Chucks an egg (Thats it)");
                                lore.add("§c1 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;
                    case FLINT_AND_STEEL:
                        player.sendMessage(ChatColor.RED + "Work in progress");
                        break;
                    case FEATHER:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "OTHERLAUNCHER")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Launches all entities in a 5 block radius");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "OTHERLAUNCHER", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "OTHERLAUNCHER", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Launches all entities in a 5 block radius");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;
                    case ANVIL:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "ANVILRAIN")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Fires anvils in a line");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "ANVILRAIN", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "ANVILRAIN", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Fires anvils in a line");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "This item may not work correctly");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;
                    case SPECTRAL_ARROW:
                        player.closeInventory();
                        if (!Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "GLOWOING")) {
                            if (heldItem.getItemMeta().hasLore() != true) {
                                ItemMeta meta = heldItem.getItemMeta();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Gives all entities in a 30 block radius a glowing effect for 30s");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                heldItem = NBTEditor.set(heldItem, "GLOWOING", "test", "value");
                                player.setItemInHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            } else {

                                ItemStack item = player.getItemInHand();
                                if (item != null) {
                                    item = NBTEditor.set(item, "GLOWOING", "test", "value");
                                    player.setItemInHand(item);
                                }
                                ItemMeta meta = heldItem.getItemMeta();
                                List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                                lore.add("§eRIGHT CLICK ABILITY: " + "§7Gives all entities in a 30 block radius a glowing effect for 30s");
                                lore.add("§c60 second cooldown");
                                meta.setLore(lore);
                                heldItem.setItemMeta(meta);
                                player.getInventory().setItemInMainHand(heldItem);
                                player.sendMessage(ChatColor.GOLD + "Test");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Item already has this attribute");
                        }
                        break;


                }

            } catch (NullPointerException e){

            }

        }
        }

    }

