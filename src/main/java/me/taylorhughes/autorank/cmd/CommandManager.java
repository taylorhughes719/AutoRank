package me.taylorhughes.autorank.cmd;

import me.taylorhughes.autorank.AutoRank;

/**
 * @author Taylor Hughes
 */
public class CommandManager {

    private AutoRank plugin;
    private AutoRankCmd autoRankCmd;
    private CheckPlaytimeCmd checkPlaytimeCmd;

    public CommandManager(AutoRank plugin) {
        this.plugin = plugin;
    }

    public void load() {
        this.autoRankCmd = new AutoRankCmd(plugin);
        this.checkPlaytimeCmd = new CheckPlaytimeCmd(plugin);
    }

    public AutoRank getPlugin() {
        return plugin;
    }
}
