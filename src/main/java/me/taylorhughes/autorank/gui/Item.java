package me.taylorhughes.autorank.gui;

import org.bukkit.inventory.ItemStack;

/**
 * @author Taylor Hughes
 */
public abstract class Item implements Clickable {

    private ItemStack item;

    public Item(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}
