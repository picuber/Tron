
/**
 *
 * @author Leon
 */
public abstract class Field implements Drawable {

    protected int x, y;

    public abstract void collide(Bike b);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
