package tron.graphic;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import tron.bikes.Bike;

/**
 *
 * @author michael
 */
public class ImageManager {

    private static HashMap<String, Image> right;
    private static HashMap<String, Image> left;
    private static HashMap<String, Image> up;
    private static HashMap<String, Image> down;
    private static HashMap<String, Image> images;

    static {
        right = new HashMap<>();
        left = new HashMap<>();
        up = new HashMap<>();
        down = new HashMap<>();
        images = new HashMap<>();
        loadBikeImages("orange");
        loadBikeImages("lilac");
        loadBikeImages("green");
        loadBikeImages("blue");
        loadBikeImages("red");
        try {
            load();
        } catch (IOException ex) {
            throw new RuntimeException("Nicht genügend Bilder du Depp!!");
        }
    }

    public static void loadBikeImages(String color) {
        try {
            right.put(color, ImageIO.read(new File("images/bikes/" + color + "/right.png")));
            left.put(color, ImageIO.read(new File("images/bikes/" + color + "/left.png")));
            up.put(color, ImageIO.read(new File("images/bikes/" + color + "/up.png")));
            down.put(color, ImageIO.read(new File("images/bikes/" + color + "/down.png")));
        } catch (IOException ex) {
            throw new RuntimeException("Fehlende Bilder du Idiot!");
        }

    }

    public static void load() throws IOException {
        images.put("Background", ImageIO.read(new File("images/BikeBackground.jpg")));
        images.put("Raster", ImageIO.read(new File("images/Raster.jpg")));
    }

    public static Image get(String imgname) {
        return images.get(imgname);
    }

    public static Image get(Bike.Orientation or, String color) {
        switch (or) {
            case RIGHT:
                return right.get(color);
            case LEFT:
                return left.get(color);
            case UP:
                return up.get(color);
            case DOWN:
                return down.get(color);
            default:
                throw new RuntimeException("??? WTF");
        }
    }
}
