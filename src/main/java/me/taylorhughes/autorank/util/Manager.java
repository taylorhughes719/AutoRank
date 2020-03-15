package me.taylorhughes.autorank.util;

import me.taylorhughes.autorank.AutoRank;

/**
 * A manager class.
 *
 * @author Taylor Hughes
 */
public class Manager {

    private AutoRank plugin;

    public Manager(AutoRank plugin) {
        this.plugin = plugin;
    }

    public AutoRank getPlugin() {
        return plugin;
    }
}
