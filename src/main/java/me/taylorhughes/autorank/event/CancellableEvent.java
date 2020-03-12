package me.taylorhughes.autorank.event;

import me.taylorhughes.autorank.AutoRank;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * @author Taylor Hughes
 */
public abstract class CancellableEvent extends Event implements Cancellable {

    private AutoRank plugin;
    private boolean cancel;

    public CancellableEvent(AutoRank plugin) {
        this.plugin = plugin;
        this.cancel = false;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public AutoRank getPlugin() {
        return plugin;
    }
}
