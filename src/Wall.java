
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
        Graphics g = m.getGraphic().bufferGraphics;
        g.setColor(Color.darkGray);
        g.fillRect(x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"));
    }

}
