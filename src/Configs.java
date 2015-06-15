
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Leon
 */
public class Configs {

    private static final Map<String, Integer> configs;
    private static String[] playerNames;

    static {
        playerNames = new String[4];
        configs = new HashMap<>();
        configs.put("gamespeed", 10);
        configs.put("sizeX", 700);
        configs.put("sizeY", 700);
        configs.put("height", 1);
        configs.put("scaleX", 1);
        configs.put("scaleY", 1);
        configs.put("bikelength", 30);
        configs.put("bikebroadth", 15);
        configs.put("laserlength", 200);
    }

    public static void setPlayerNames(String[] playerNames) {
        Configs.playerNames = playerNames;
    }
    
   public static void addPlayer(String name, int playerNumber){
       Configs.playerNames[playerNumber-1] = name;
   }

    public static int getConfigValue(String key) {
        return configs.get(key);
    }

    public static String[] getPlayerNames() {
        return playerNames;
    }

}
