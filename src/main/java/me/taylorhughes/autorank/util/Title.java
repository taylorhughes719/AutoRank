package me.taylorhughes.autorank.util;

import org.bukkit.entity.Player;

/**
 * @author Taylor Hughes
 */
public class Title {

    private String title, subtitle;
    private int fadeIn, stay, fadeOut;

    public Title(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        this.title = Text.colorize(title);
        this.subtitle = Text.colorize(subtitle);
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public int getStay() {
        return stay;
    }

    public void setStay(int stay) {
        this.stay = stay;
    }

    public int getFadeOut() {
        return fadeOut;
    }

    public void setFadeOut(int fadeOut) {
        this.fadeOut = fadeOut;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = Text.colorize(subtitle);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Text.colorize(title);
    }

    public int getFadeIn() {
        return fadeIn;
    }

    public void setFadeIn(int fadeIn) {
        this.fadeIn = fadeIn;
    }

    public void send(Player player) {
        Titles.sendTitle(player, this.fadeIn, this.stay, this.fadeOut, this.title, this.subtitle);
    }

}
