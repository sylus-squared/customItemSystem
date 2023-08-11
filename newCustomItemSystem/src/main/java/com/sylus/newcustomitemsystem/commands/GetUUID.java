package com.sylus.newcustomitemsystem.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetUUID implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        TextComponent message = new TextComponent( "Click here" );
        message.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "TEST MESSAGE" ) );
        player.spigot().sendMessage(message);
/*
        try{ // THIS DOES NOT CURRENTLY WORK
            UUID uuid = Bukkit.getOfflinePlayer(Arrays.toString(args)).getUniqueId();

        } catch (NullPointerException e){
            player.sendMessage(ChatColor.RED + "Please include a players name, the format is /getUUID <player name>");
        }

 */

        return true;
    }
}
