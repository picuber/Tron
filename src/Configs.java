
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
       configs.put("sizeX", 700);
       configs.put("sizeY",700);
       configs.put("height",1);
       configs.put("scaleX",1);
       configs.put("scaleY",1);
       configs.put("bikelength", 30);
       configs.put("bikebroadth", 15);
   }
   public static int getConfigValue(String key){
       return configs.get(key);
   }
    
}
