
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void undraw(){
          Graphics g=m.getGraphic().bufferGraphics;
      
      g.clearRect(x*10, y*10, 10,10 );
    }
    
}
