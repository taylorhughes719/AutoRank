package me.taylorhughes.autorank;

import me.taylorhughes.autorank.cmd.AutoRankCmd;
import me.taylorhughes.autorank.cmd.CheckPlaytimeCmd;
import me.taylorhughes.autorank.config.FileConfig;
import me.taylorhughes.autorank.data.DataManager;

import me.taylorhughes.autorank.event.InventoryListener;
import me.taylorhughes.autorank.event.PlayerListener;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Objects;


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
    private AutoRankCmd autoRankCmd;
    private CheckPlaytimeCmd checkPlaytimeCmd;
    private InventoryListener invListener;
    private PlayerListener pListener;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!this.getDataFolder().exists() && !this.getDataFolder().mkdir()) {
            this.getLogger().severe("Failed to create plugin directory! The plugin will now be disabled!");
            this.setEnabled(false);
        }

        // Set static instance of the plugin
        instance = this;

        // Create configurations
        this.config = new FileConfig(this, "config.yml");
        this.messagesConfig = new FileConfig(this, "messages.yml");

        // Load configurations
        this.config.load();
        this.messagesConfig.load();

        this.dataManager = new DataManager(this);

        // Register commands
        this.checkPlaytimeCmd = new CheckPlaytimeCmd(this);
        Objects.requireNonNull(getCommand("playtime")).setExecutor(checkPlaytimeCmd);

        this.autoRankCmd = new AutoRankCmd(this);
        Objects.requireNonNull(getCommand("autorank")).setExecutor(autoRankCmd);

        this.invListener = new InventoryListener(this);
        this.pListener = new PlayerListener(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        dataManager.shutdown();

        this.invListener = null;
        this.pListener = null;

        HandlerList.unregisterAll(instance);

        // Just to be safe, set the instance to null
        instance = null;

        HandlerList.unregisterAll(this);

        // Shutdown everything
        this.checkPlaytimeCmd = null;
        this.autoRankCmd = null;
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
