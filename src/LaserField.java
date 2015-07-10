
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Leon
 */
public class LaserField extends Wall implements Timed {

    private int counter = 0;
    private Color c;
    private Bike b;

    public LaserField(int x, int y, Color c, Matrix m, Bike b) {
        super(x, y, m);
        this.c = c;
        this.b = b;
        m.setField(x, y, this);
        draw();
        Clock.getInstance().login(this);
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(c);
        g.fillRect(x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"));
    }

    @Override
    public void tick() {
        if (++counter == b.getLaserLength()) {
            m.deleteField(x, y);
            Clock.getInstance().logout(this);
        }
    }
}
