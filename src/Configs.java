
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
       configs.put("gamespeed",8);
       configs.put("sizeX", 300);
       configs.put("sizeY",300);
       configs.put("height",1);
       configs.put("scaleX",2);
       configs.put("scaleY",2);
   }
   public static int getConfigValue(String key){
       return configs.get(key);
   }
    
}
