package me.taylorhughes.autorank;

import me.taylorhughes.autorank.config.FileConfig;
import me.taylorhughes.autorank.data.DataManager;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;


/**
 * The main class of the AutoRank plugin.
 *
 * @author Taylor Hughes
 */
public final class AutoRank extends JavaPlugin {

    private static AutoRank instance;
    private FileConfig config;
    private FileConfig messagesConfig;
    private DataManager dataManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!this.getDataFolder().exists() && !this.getDataFolder().mkdir()) {
            this.getLogger().severe("Failed to create plugin directory! The plugin will now be disabled!");
            this.setEnabled(false);
        }

        // Create configurations
        this.config = new FileConfig(this, "config.yml");
        this.messagesConfig = new FileConfig(this, "messages.yml");

        // Load configurations
        this.config.load();
        this.messagesConfig.load();

        this.dataManager = new DataManager(this);

        // Set static instance of the plugin
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(instance);

        // Just to be safe, set the instance to null
        instance = null;

        HandlerList.unregisterAll(this);
    }

    /**
     * Get the instance of the plugin.
     *
     * @return The plugin's static instance.
     */
    public static AutoRank getInstance() {
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    @NotNull
    public FileConfig getMainConfig() {
        return config;
    }

    public String getMessage(String key) {
        return this.messagesConfig.getString(key);
    }

    public String getMessage(String key, String def) {
        return this.messagesConfig.getString(key, def);
    }

    public static String getTimePlayedStr(Player player) {
        return Duration.ofMinutes((player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20) / 60).toString();
    }
}
