package me.taylorhughes.autorank.event;

import me.taylorhughes.autorank.util.Reward;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author Taylor Hughes
 */
public class PlayerRankupEvent extends PlayerEvent implements Cancellable {

    public static final HandlerList handlers = new HandlerList();
    private String rank;
    private boolean cancel;

    public PlayerRankupEvent(@NotNull Player who) {
        super(who);
        this.cancel = false;
    }

    public String getRank() {
        return this.rank;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public HandlerList getHandlerList() {
        return handlers;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
}
