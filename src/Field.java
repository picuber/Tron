
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Leon
 */
public abstract class Field implements Drawable {

    /**
     * Matrix to which this Field belongs
     */
    protected Matrix m;

    /**
     * x-position of Field
     */
    protected int x;

    /**
     * y-position of Field
     */
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

    @Override
    public void undraw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.clearRect(x * 10, y * 10, 10, 10);
    }

}
