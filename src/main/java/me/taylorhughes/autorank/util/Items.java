package me.taylorhughes.autorank.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Item utilities
 *
 * @author Taylor Hughes
 */
public class Items {

    public static boolean verify(ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }

    public static boolean loreContains(@NotNull ItemStack item, String text) {
        return item.getItemMeta() != null && item.getItemMeta().hasLore() && item.getItemMeta().getLore().stream().anyMatch(line -> Text.decolorize(line).equalsIgnoreCase(text) || Text.decolorize(line).toLowerCase().contains(text.toLowerCase()));
    }
}
