package me.taylorhughes.autorank.data;

import me.taylorhughes.autorank.AutoRank;
import me.taylorhughes.autorank.util.Manager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * @author Taylor Hughes
 */
public class DataManager extends Manager {

    private Map<Player, PlayerData> data;

    public DataManager(AutoRank plugin) {
        super(plugin);
        this.data = new HashMap<>();
    }

    public void shutdown() {
        if (this.data != null) {
            this.data.clear();
            this.data = null;
        }
    }

    public PlayerData getPlayerData(Player player) {
        return this.data.getOrDefault(player, null);
    }

    public boolean isLoaded(Player player) {
        return this.data.containsKey(player);
    }

    public PlayerData getPlayerData(String playerName) {
        PlayerData data = null;
        for (Player p : this.data.keySet()) {
            if (p.getName().equalsIgnoreCase(playerName)) {
                data = this.data.get(p);
            }
        }
        return data;
    }

    public PlayerData getPlayerData(UUID playerID) {
        PlayerData data = null;
        for (Player p : this.data.keySet()) {
            if (p.getUniqueId().equals(playerID)) {
                data = this.data.get(p);
            }
        }
        return data;
    }

    public void loadPlayerData(UUID playerID) {}

    public Map<Player, PlayerData> getData() {
        return data;
    }


}
