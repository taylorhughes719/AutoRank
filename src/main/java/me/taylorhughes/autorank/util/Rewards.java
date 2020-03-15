package me.taylorhughes.autorank.util;

import me.taylorhughes.autorank.AutoRank;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Taylor Hughes
 */
public class Rewards {

    private AutoRank plugin;
    private static Map<String, Reward> rewards;

    public Rewards(AutoRank plugin) {
        this.plugin = plugin;
        rewards = new HashMap<>();
        for (String s : this.plugin.getMainConfig().getConfig().getConfigurationSection("Rewards").getKeys(false)) {
            Reward reward = new Reward(s);
            reward.setEnabled(this.plugin.getMainConfig().getBoolean("Rewards." + s + ".Enabled"));
            reward.setDisplayName(this.plugin.getMainConfig().getString("Rewards." + s + ".Display-Name"));

            ItemBuilder displayItem = new ItemBuilder(Material.matchMaterial(this.plugin.getMainConfig().getString("Rewards." + s + ".Display-Item.Material")));
            displayItem.setName(this.plugin.getMainConfig().getString("Rewards." + s + ".Display-Item.Name"));
            displayItem.setAmount(this.plugin.getMainConfig().getInt("Rewards." + s + ".Display-Item.Amount"));
            if (this.plugin.getMainConfig().getBoolean("Rewards." + s + ".Display-Item.Glowing")) {
                displayItem.setGlowing(true);
            }
            if (this.plugin.getMainConfig().getConfig().contains("Rewards." + s + ".Display-Item.Lore")) {
                displayItem.setLore(this.plugin.getMainConfig().getStringList("Rewards." + s + ".Display-Item.Lore"));
            }


            // Set reward time
            long time = 0L;
            String t1 = this.plugin.getMainConfig().getString("Rewards." + s + ".Playtime-Required");
            String[] t2 = t1.split(" ");
            String timeUnit = t2[1];
            int timeInt = Integer.parseInt(t2[0]);
            timeInt = timeInt * 60;
            if (timeUnit.equalsIgnoreCase("h")) {
                time = Duration.ofMinutes(timeInt).toMillis();
            } else if (timeUnit.equalsIgnoreCase("d")) {
                time = Duration.ofMinutes(timeInt).toDays();
            }
            reward.setTimeRequired(time);
        }

    }

    public static Reward getReward(String name) {
        return rewards.getOrDefault(name, null);
    }

    public static int getTotalRewards() {
        return rewards.size();
    }

    public void shutdown() {
        rewards.clear();
        rewards = null;
        this.plugin = null;
    }

    public AutoRank getPlugin() {
        return plugin;
    }
}
