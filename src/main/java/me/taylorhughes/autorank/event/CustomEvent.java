package me.taylorhughes.autorank.event;

import me.taylorhughes.autorank.AutoRank;
import org.bukkit.event.Event;

/**
 * @author Taylor Hughes
 */
public abstract class CustomEvent extends Event {

    private AutoRank plugin;

    public CustomEvent(AutoRank plugin) {
        this.plugin = plugin;
    }

    public AutoRank getPlugin() {
        return plugin;
    }
}
