
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
       configs.put("gamespeed",1);
       configs.put("sizeX", 700);
       configs.put("sizeY",700);
       configs.put("height",1);
       configs.put("scaleX",1);
       configs.put("scaleY",1);
   }
   public static int getConfigValue(String key){
       return configs.get(key);
   }
    
}
