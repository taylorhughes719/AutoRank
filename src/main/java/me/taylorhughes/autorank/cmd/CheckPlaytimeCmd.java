package me.taylorhughes.autorank.cmd;

import me.taylorhughes.autorank.AutoRank;
import me.taylorhughes.autorank.util.Players;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author Taylor Hughes
 */
public class CheckPlaytimeCmd extends RCommand {

    public CheckPlaytimeCmd(AutoRank plugin) {
        super(plugin, "playtime");
    }

    @Override
    public boolean onPlayerCommand(Player sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender.hasPermission("autorank.check")) {
                String[] s = AutoRank.getTimePlayedStr(sender).split(":");
                String s1 = s[0] + " hours " + s[1] + " minutes";
                sender.sendMessage(getPlugin().getMessage("Commands.Check-Playtime").replaceAll("%time%", s1));
            }
        } else if (args.length == 1) {
            if (sender.hasPermission("autorank.check.others")) {
                Player p = Players.getPlayer(args[0]);
                String[] s = AutoRank.getTimePlayedStr(p).split(":");
                String s1 = s[0] + " hours " + s[1] + " minutes";
                sender.sendMessage(getPlugin().getMessage("Commands.Check-Playtime-Other").replaceAll("%player%", p.getDisplayName()).replaceAll("%time%", s1));
            }
        }
        return false;
    }

    @Override
    public boolean onConsoleCommand(ConsoleCommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
