
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leon
 */
public class Configs {

    private static final Map<String, Integer> configs;
    private static PlayerStartConfig[] players;

    static {
        players = new PlayerStartConfig[4];
        players[0] = new PlayerStartConfig(null, 30, 350, 0, KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_S, Color.orange, true, Bike.Orientation.RIGHT);
        players[1] = new PlayerStartConfig(null, 670, 350, 0, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, Color.cyan, true, Bike.Orientation.LEFT);
        players[2] = new PlayerStartConfig(null, 350, 670, 0, KeyEvent.VK_H, KeyEvent.VK_F, KeyEvent.VK_T, KeyEvent.VK_G, Color.green, true, Bike.Orientation.UP);
        players[3] = new PlayerStartConfig(null, 350, 30, 0, KeyEvent.VK_L, KeyEvent.VK_J, KeyEvent.VK_I, KeyEvent.VK_K, Color.red, true, Bike.Orientation.DOWN);
        configs = new HashMap<>();
        configs.put("gamespeed", 5);
        configs.put("sizeX", 700);
        configs.put("sizeY", 700);
        configs.put("height", 1);
        configs.put("scaleX", 1);
        configs.put("scaleY", 1);
        configs.put("bikelength", 30);
        configs.put("bikebroadth", 15);
        configs.put("laserlength", 1000);
    }

    public static void setPlayerName(String name, int playerNumber) {
        Configs.players[playerNumber - 1].setName(name);
    }

    public static void setControlMode(boolean twoKeyControl, int playerNumber) {
        Configs.players[playerNumber - 1].setTwoKeyColtrol(twoKeyControl);
    }

    public static int getConfigValue(String key) {
        return configs.get(key);
    }

    public static PlayerStartConfig[] getPlayers() {
        return players;
    }

}
