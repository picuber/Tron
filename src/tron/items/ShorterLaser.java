package tron.items;


import tron.Matrix;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class ShorterLaser extends Item {

    private int value;
    
    public ShorterLaser(BufferedImage image, int x, int y, int height, int width, Matrix m, int value) {
        super(image, x, y, height, width, m);
        this.value = value;
    }

    @Override
    void doEffect(Bike b) {
        b.subLaserLength(value);
    }
}

