package tron;

import tron.bikes.Bike;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leon
 */
public class Configs {

    private static final Map<String, Integer> configs;
    private static final PlayerStartConfig[] players;

    static {
        configs = new HashMap<>();
        configs.put("gamespeed", 0);
        configs.put("sizeX", 500);
        configs.put("sizeY", 500);
        configs.put("height", 2);
        configs.put("scaleX", 1);
        configs.put("scaleY", 1);
        configs.put("bikelength", 30);
        configs.put("bikebroadth", 15);
        configs.put("laserlength", 300);
        configs.put("botRandomness", 1000);
        configs.put("numberLinks", 5);
        configs.put("windowNotVisible", 0);
        configs.put("itemSpawningFrequency", 500);
        players = new PlayerStartConfig[4];
        resetDefaultConfigPlayers();
    }

    public static void resetDefaultConfigPlayers() {
        players[0] = new PlayerStartConfig(null, 30, Configs.getConfigValue("sizeY") / 2, 0, KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S, "orange", PlayerStartConfig.MODE.TWOKEY, Bike.Orientation.DOWN);
        players[1] = new PlayerStartConfig(null, Configs.getConfigValue("sizeX") / 2, Configs.getConfigValue("sizeY") - 30, 0, KeyEvent.VK_H, KeyEvent.VK_F, KeyEvent.VK_T, KeyEvent.VK_G, "green", PlayerStartConfig.MODE.TWOKEY, Bike.Orientation.RIGHT);
        players[2] = new PlayerStartConfig(null, Configs.getConfigValue("sizeX") / 2, 30, 0, KeyEvent.VK_L, KeyEvent.VK_J, KeyEvent.VK_I, KeyEvent.VK_K, "lilac", PlayerStartConfig.MODE.TWOKEY, Bike.Orientation.LEFT);
        players[3] = new PlayerStartConfig(null, Configs.getConfigValue("sizeX") - 30, Configs.getConfigValue("sizeY") / 2, 0, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, "blue", PlayerStartConfig.MODE.TWOKEY, Bike.Orientation.UP);
    }

    public static void setPlayerName(String name, int playerNumber) {
        Configs.players[playerNumber - 1].setName(name);
    }

    public static void setControlMode(PlayerStartConfig.MODE mode, int playerNumber) {
        Configs.players[playerNumber - 1].setMode(mode);
    }

    public static void setConfigValue(String key, int value) {
        configs.put(key, value);
    }

    public static int getConfigValue(String key) {
        return configs.get(key);
    }

    public static Map<String, Integer> getConfigs() {
        return configs;
    }

    public static PlayerStartConfig[] getPlayers() {
        return players;
    }

}
