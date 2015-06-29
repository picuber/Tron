
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author michael
 */
class ImageManager {

    private static HashMap<String, Image> right;
    private static HashMap<String, Image> left;
    private static HashMap<String, Image> up;
    private static HashMap<String, Image> down;

    static {
        right = new HashMap<>();
        left = new HashMap<>();
        up = new HashMap<>();
        down = new HashMap<>();
        load("orange");
        load("lilac");
        load("green");
        load("blue");
        load("red");
    }

    static void load(String color) {
        try {
            right.put(color, ImageIO.read(new File("images/" + color + "/right.png")));
            left.put(color, ImageIO.read(new File("images/" + color + "/left.png")));
            up.put(color, ImageIO.read(new File("images/" + color + "/up.png")));
            down.put(color, ImageIO.read(new File("images/" + color + "/down.png")));
        } catch (IOException ex) {
            throw new RuntimeException("Fehlende Bilder du Idiot!");
        }

    }

    static Image get(Bike.Orientation or, String color) {
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
