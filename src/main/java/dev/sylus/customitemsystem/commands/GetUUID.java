package dev.sylus.customitemsystem.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GetUUID implements CommandExecutor {

    private UUID uuid;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        try{ // Data validation :(

            String playerName = args[0];

            this.uuid = Bukkit.getOfflinePlayer(playerName).getUniqueId();

        } catch (ArrayIndexOutOfBoundsException e){
            player.sendMessage(ChatColor.RED + "Please include a players name, the format is /getUUID <player name>");
            return true;
        }

        TextComponent mainComponent = new TextComponent("Click ");
        mainComponent.setColor(ChatColor.GOLD.asBungee());
        TextComponent subComponent = new TextComponent("here");
        subComponent.setColor(ChatColor.AQUA.asBungee());
        subComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(this.uuid.toString()).create()));
        subComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, this.uuid.toString()));
        mainComponent.addExtra(subComponent);
        mainComponent.addExtra(" and copy the UUID from the command bar");
        player.spigot().sendMessage(mainComponent);

        return true;
    }
}
