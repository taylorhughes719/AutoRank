package me.taylorhughes.autorank.util;

import me.taylorhughes.autorank.AutoRank;

import javax.security.auth.login.Configuration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Taylor Hughes
 */
public class Rewards {

    private static Map<String, Reward> rewards;

    public Rewards() {
        rewards = new HashMap<>();
        for (String s : AutoRank.getInstance().getMainConfig().getConfig().getConfigurationSection("Rewards").getKeys(false)) {
            Reward reward = new Reward(s);
            reward.setEnabled(AutoRank.getInstance().getMainConfig().getBoolean("Rewards." + s + ".Enabled"));
            reward.setDisplayName(AutoRank.getInstance().getMainConfig().getString("Rewards." + s + ".Display-Name"));
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
    }
}
