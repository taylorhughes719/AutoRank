package me.taylorhughes.autorank.event;

import me.taylorhughes.autorank.AutoRank;
import me.taylorhughes.autorank.gui.GUIHolder;
import me.taylorhughes.autorank.util.Text;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

/**
 * @author Taylor Hughes
 */
public class InventoryListener implements Listener {

    private AutoRank plugin;

    public InventoryListener(AutoRank plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (Objects.requireNonNull(e.getClickedInventory()).getHolder() instanceof GUIHolder) {
            if (e.getView().getTitle().equalsIgnoreCase(Text.decolorize(Text.colorize(AutoRank.getInstance().getMainConfig().getString("Menus.Ranks-Menu.Title"))))) {
                e.setCancelled(true);
            }
        }
    }

    public AutoRank getPlugin() {
        return plugin;
    }
}
