
import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Leon
 */
public class LaserField extends Wall implements Timed {
    private int counter=0;

    public LaserField(int x,int y,Matrix m) {
        super(x,y,m);
        Clock.getInstance().login(this);
    }

    public void draw() {
         Graphics g=m.getGraphic().bufferGraphics;
      g.setColor(Color.yellow);
      g.fillRect(x*10, y*10, 10,10 );
    }

    @Override
    public void tick() {
       
        if(++counter==200){
       m.deleteField(x, y);
            System.out.println("aha");
        }
    }
}
