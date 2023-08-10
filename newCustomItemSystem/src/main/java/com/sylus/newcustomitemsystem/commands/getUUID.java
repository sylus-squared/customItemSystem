package com.sylus.newcustomitemsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Level;

public class getUUID implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        try{ // THIS DOES NOT CURRENTLY WORK
            UUID uuid = Bukkit.getOfflinePlayer(Arrays.toString(args)).getUniqueId();

        } catch (NullPointerException e){
            player.sendMessage(ChatColor.RED + "Please include a players name, the format is /getUUID <player name>");
        }

        return true;
    }
}
