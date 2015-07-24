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


    public LongerLaser(int x, int y, Matrix m, Size size) {
        super((BufferedImage) ImageManager.get("LongLaser" + size), x, y, size, m);
    }

    @Override
    protected void doEffect(Bike b) {
        b.addLaserLength(value);
    }
    
    @Override
    protected int getValue(Size s) {
        switch (s) {
            case SMALL:
                return 100;
            case MEDIUM:
                return 50;
            case LARGE:
                return 25;
            default:
                return 0;
        }
    }
}
