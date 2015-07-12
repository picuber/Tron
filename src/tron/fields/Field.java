package tron.fields;

import tron.Matrix;
import tron.Configs;
import java.awt.Graphics;
import tron.bikes.Bike;
import tron.graphic.Drawable;

/**
 *
 * @author Leon
 */
public abstract class Field implements Drawable {

    protected Matrix m;
    protected int x;
    protected int y;

    /**
     * is called when the Field collides with a Bike
     *
     * @param b Bike which collides with the Field
     */
    public abstract void collide(Bike b);

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Matrix getMatrix() {
        return m;
    }

    @Override
    public void undraw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        int pX = x * Configs.getConfigValue("scaleX");
        int pY = y * Configs.getConfigValue("scaleY");
        int pWidth = Configs.getConfigValue("scaleX");
        int pHeight = Configs.getConfigValue("scaleY");
        g.clearRect(pX, pY, pWidth, pHeight);
    }

}
