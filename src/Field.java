
/**
 *
 * @author Leon
 */
public abstract class Field implements Drawable {

    private int x, y;

    public abstract void collide(Bike b);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
