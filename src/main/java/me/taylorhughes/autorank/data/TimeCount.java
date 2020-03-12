package me.taylorhughes.autorank.data;

/**
 * @author Taylor Hughes
 */
public enum TimeCount {

    REALTIME(false), PLAYTIME(false), SESSIONTIME(false), AFKTIME(true), AFKTOTALTIME(true);

    private final boolean afk;

    TimeCount(boolean afk) {
        this.afk = afk;
    }

    public boolean isAfk() {
        return afk;
    }
}
