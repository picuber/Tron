
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leon
 */
public class Configs {
   private static final Map<String,Integer> configs;
   static{
       configs=new HashMap<>();
       configs.put("gamespeed",10);
       configs.put("sizeX", 5);
       configs.put("sizeY",5);
       configs.put("height",1);
   }
   public static int getConfigValue(String key){
       return configs.get(key);
   }
    
}
