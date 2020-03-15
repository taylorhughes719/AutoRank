package me.taylorhughes.autorank.event;

import me.taylorhughes.autorank.AutoRank;
import me.taylorhughes.autorank.util.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

/**
 * @author Taylor Hughes
 */
public class PlayerListener implements Listener {

    private AutoRank plugin;

    public PlayerListener(AutoRank plugin) {
        this.plugin = plugin;
    }

    public AutoRank getPlugin() {
        return plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                plugin.getDataManager().loadPlayerData(e.getPlayer().getUniqueId());
            }
        }.runTaskLaterAsynchronously(plugin, 20L);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {}

    @EventHandler
    public void onPlayerRankup(PlayerRankupEvent e) {
        if (plugin.getMainConfig().getBoolean("On-Rankup.Send-Title.Enabled")) {
            Title title = new Title(plugin.getMainConfig().getString("On-Rankup.Send-Title.Title"),
                    plugin.getMainConfig().getString("On-Rankup.Send-Title.Subtitle"),
                    plugin.getMainConfig().getInt("On-Rankup.Send-Title.Fade-In"),
                    plugin.getMainConfig().getInt("On-Rankup.Send-Title.Stay"),
                    plugin.getMainConfig().getInt("On-Rankup.Send-Title.Fade-Out"));
            title.send(e.getPlayer());
        }
        if (plugin.getMainConfig().getBoolean("On-Rankup.Broadcast.Enabled")) {
            Bukkit.broadcast(plugin.getMainConfig().getString("On-Rankup.Broadcast.Message"), "essentials.help");
        }
        for (String s : Objects.requireNonNull(plugin.getMainConfig().getConfig().getConfigurationSection("")).getKeys(false)) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s);
        }
    }
}
