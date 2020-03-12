package me.taylorhughes.autorank.data;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author Taylor Hughes
 */
public class PlayerData {

    private Player player;
    private UUID uuid;
    private String name;
    private long loginTime;
    private boolean afk;
    private boolean receiveRewards;

    public PlayerData(Player player) {
        this.player = player;
        this.uuid = player.getUniqueId();
        this.name = player.getName();
    }

    public String getName() {
        return this.name;
    }

    public Player getPlayer() {
        return this.player;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long time) {
        this.loginTime = time;
    }

    public boolean isAFK() {
        return afk;
    }

    public void setAfk(boolean afk) {
        this.afk = afk;
    }

    public UUID getUUID() {
        return uuid;
    }

    public boolean canReceiveRewards() {
        return receiveRewards;
    }

    public void setGiveRewards(boolean canReceiveRewards) {
        this.receiveRewards = canReceiveRewards;
    }

    public void saveData() {}

    public long getPlayTimeSeconds(Player p) {
        return p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
    }
}
