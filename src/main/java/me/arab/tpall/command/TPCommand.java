package me.arab.tpall.command;

import me.arab.tpall.Core;
import me.arab.tpall.TeleportAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class TPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if((sender instanceof Player)){
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase("tpall")){
                if(player.hasPermission("tpall.command")){

                    // Increment Path: tpall.increment-seconds
                    // Player Amount Path: tpall.player-amount

                    List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
                    onlinePlayers.remove(player);

                    TeleportAPI.teleportAll(player.getLocation(), onlinePlayers);

                    player.sendMessage(Core.getInstance().getConfig().getString("teleport-message").replace("&", "§"));

                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}
