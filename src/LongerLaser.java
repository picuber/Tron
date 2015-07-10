
import java.awt.image.BufferedImage;

/**
 *
 * @author Leon
 */
public class LongerLaser extends Item {

    private int value;
    
    public LongerLaser(BufferedImage image, int x, int y, int height, int width, Matrix m, int value) {
        super(image, x, y, height, width, m);
        this.value = value;
    }

    @Override
    void doEffect(Bike b) {
        b.addLaserLength(value);
    }
}

