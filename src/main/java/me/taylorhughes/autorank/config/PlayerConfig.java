package me.taylorhughes.autorank.config;

import me.taylorhughes.autorank.AutoRank;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * @author Taylor Hughes
 */
public class PlayerConfig {

    private AutoRank plugin;
    private Player player;
    private FileConfig config;

    public PlayerConfig(AutoRank plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        this.config = new FileConfig(plugin, "/players/" + player.getUniqueId() + ".yml");
    }

    public Player getPlayer() {
        return player;
    }

    public AutoRank getPlugin() {
        return plugin;
    }

    public FileConfig getConfig() {
        return config;
    }
}
