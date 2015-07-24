package tron.items;

import tron.Matrix;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;
import tron.graphic.ImageManager;

/**
 *
 * @author Leon
 */
public class Coin extends Item {

    public Coin(int x, int y, Matrix m, Size size) {
        super((BufferedImage) ImageManager.get("Coin" + size), x, y, size, m);
    }

    @Override
    protected void doEffect(Bike b) {
        b.score(value);
    }

    @Override
    protected int getValue(Size s) {
        switch (s) {
            case SMALL:
                return 3;
            case MEDIUM:
                return 2;
            case LARGE:
                return 1;
            default:
                return 0;
        }
    }
}
