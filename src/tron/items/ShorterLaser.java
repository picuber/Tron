package tron.items;

import tron.Matrix;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;
import tron.graphic.ImageManager;

/**
 *
 * @author Leon
 */
public class ShorterLaser extends Item {

    private final int value;

    public ShorterLaser(int x, int y, Matrix m, Size size, int value) {
        super((BufferedImage) ImageManager.get("ShortLaser" + size), x, y, size, m);
        this.value = value;
    }

    @Override
    protected void doEffect(Bike b) {
        b.subLaserLength(value);
    }
}
