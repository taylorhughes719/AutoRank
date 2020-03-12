package me.taylorhughes.autorank.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Represents an item that can be clicked.
 *
 * @author Taylor Hughes
 */
public interface Clickable {

    /**
     * Called when the item is clicked
     *
     * @param e The click event
     */
    void onClick(InventoryClickEvent e);
}
