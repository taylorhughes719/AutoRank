package me.taylorhughes.autorank.util;

import org.bukkit.inventory.ItemStack;

/**
 * @author Taylor Hughes
 */
public class Reward {

    private String key;
    private String displayName;
    private String lore;
    private String rank;
    private boolean enabled;
    private String permission;
    private long timeRequired;
    private ItemStack display;

    public Reward(String key) {
        this.key = key;
    }

    public Reward(String key, String displayName, String lore, String rank, boolean enabled, String permission, long timeRequired) {
        this.key = key;
        this.displayName = displayName;
        this.lore = lore;
        this.rank = rank;
        this.enabled = enabled;
        this.permission = permission;
        this.timeRequired = timeRequired;
    }

    public long getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(long timeRequired) {
        this.timeRequired = timeRequired;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ItemStack getDisplay() {
        return display;
    }

    public void setDisplay(ItemStack display) {
        this.display = display;
    }
}
