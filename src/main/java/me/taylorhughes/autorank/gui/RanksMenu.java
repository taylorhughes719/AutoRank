package me.taylorhughes.autorank.gui;

import me.taylorhughes.autorank.AutoRank;
import me.taylorhughes.autorank.util.Reward;
import me.taylorhughes.autorank.util.Rewards;
import me.taylorhughes.autorank.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Taylor Hughes
 */
public class RanksMenu implements GUIHolder {

    private Inventory inv;
    private String title;
    private Map<Integer, Item> items;

    public RanksMenu() {
        this.title = AutoRank.getInstance().getMainConfig().getString("Menus.Ranks-Menu.Title");
        this.inv = Bukkit.createInventory(this, determineSize(), this.title);
        this.items = new HashMap<>();
        for (String rankName : AutoRank.getInstance().getMainConfig().getConfig().getConfigurationSection("Rewards").getKeys(false)) {

        }
    }

    /**
     * Get the object's inventory.
     *
     * @return The inventory.
     */
    @Override
    public @NotNull Inventory getInventory() {
        return this.inv;
    }

    public int determineSize() {
        if (Rewards.getTotalRewards() <= 9) {
            return 9;
        } else if (Rewards.getTotalRewards() <= 18) {
            return 18;
        } else if (Rewards.getTotalRewards() <= 27) {
            return 27;
        } else if (Rewards.getTotalRewards() <= 36) {
            return 36;
        } else if (Rewards.getTotalRewards() <= 45) {
            return 45;
        } else {
            return 54;
        }
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public Inventory getInv() {
        return this.inv;
    }

    public void setTitle(String title) {
        this.title = Text.colorize(title);
    }
}
