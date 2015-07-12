package tron.items;

import tron.Matrix;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class LongerLaser extends Item {

    private final int value;

    public LongerLaser(BufferedImage image, int x, int y, int height, int width, Matrix m, int value) {
        super(image, x, y, height, width, m);
        this.value = value;
    }

    @Override
    protected void doEffect(Bike b) {
        b.addLaserLength(value);
    }
}
