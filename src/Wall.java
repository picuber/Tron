
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Leon
 */
public class Wall extends Field {

    public Wall(int x, int y, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;

    }

    @Override
    public void collide(Bike b) {
        b.die();
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(x * 10, y * 10, 10, 10);
    }

}
