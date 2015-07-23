package tron.items;

import tron.Matrix;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;
import tron.graphic.ImageManager;

/**
 *
 * @author Leon
 */
public class LongerLaser extends Item {

    private final int value;

    public LongerLaser(int x, int y, Matrix m, Size size, int value) {
        super((BufferedImage) ImageManager.get("LongLaser" + size), x, y, size, m);
        this.value = value;
    }

    @Override
    protected void doEffect(Bike b) {
        b.addLaserLength(value);
    }
}
