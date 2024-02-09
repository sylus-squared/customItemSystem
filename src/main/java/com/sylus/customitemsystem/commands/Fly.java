package com.sylus.customitemsystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command");
            return true;
        }

        Player player = (Player) sender;

        if (player.getAllowFlight()){
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.GOLD + "Flying disabled");
        } else {
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.GOLD + "Flying enabled");
        }


        return true;

    }
}
