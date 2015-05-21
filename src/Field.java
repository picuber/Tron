
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Leon
 */
public abstract class Field implements Drawable {

    protected Matrix m;
    protected int x, y;

    public abstract void collide(Bike b);

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void undraw() {
        Graphics g = m.getGraphic().bufferGraphics;
        g.clearRect(x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"));
    }

}
