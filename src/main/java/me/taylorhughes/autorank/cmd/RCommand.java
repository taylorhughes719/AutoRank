package me.taylorhughes.autorank.cmd;

import me.taylorhughes.autorank.AutoRank;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

/**
 * @author Taylor Hughes
 */
public abstract class RCommand implements CommandExecutor {

    private AutoRank plugin;
    private String cmd;

    public RCommand(AutoRank plugin, String cmd) {
        this.plugin = plugin;
        this.cmd = cmd;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase(this.cmd)) {
            if (sender instanceof ConsoleCommandSender) {
                return this.onConsoleCommand((ConsoleCommandSender) sender, command, label, args);
            } else {
                return this.onPlayerCommand((Player) sender, command, label, args);
            }
        }
        return false;
    }

    public abstract boolean onPlayerCommand(Player sender, Command command, String label, String[] args);


    public abstract boolean onConsoleCommand(ConsoleCommandSender sender, Command command, String label, String[] args);

    public AutoRank getPlugin() {
        return this.plugin;
    }

    public boolean noPermission(Player player) {
        player.sendMessage(this.plugin.getMessage("No-Permission.Command"));
        return false;
    }
}

