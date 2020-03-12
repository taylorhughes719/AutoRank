package me.taylorhughes.autorank.cmd;

import me.taylorhughes.autorank.AutoRank;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author Taylor Hughes
 */
public class AutoRankCmd extends RCommand {

    public AutoRankCmd(AutoRank plugin) {
        super(plugin, "autorank");
    }

    @Override
    public boolean onPlayerCommand(Player sender, Command command, String label, String[] args) {
        if (args.length == 0) {

        }
        return false;
    }

    @Override
    public boolean onConsoleCommand(ConsoleCommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
