package me.arab.tpall;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class TeleportAPI {

    public static void teleportAll(Location location, List<Player> players){

        new BukkitRunnable(){
            @Override
            public void run(){
                if(players.size() <= Core.getInstance().getConfig().getInt("player-amount")){
                    for(Player player1 : players){
                        player1.teleport(location);
                    }
                    this.cancel();
                    players.clear();
                }
                else if(players.size() > Core.getInstance().getConfig().getInt("player-amount")){
                    for(int i = 0; i < Core.getInstance().getConfig().getInt("player-amount"); i++){
                        players.get(i).teleport(location);
                        players.remove(players.get(i));
                    }
                }
            }
        }.runTaskTimer(Core.getInstance(), 0L, Core.getInstance().getConfig().getInt("increment-ticks"));

    }

}
