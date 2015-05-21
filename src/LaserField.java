
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Leon
 */
public class LaserField extends Wall implements Timed {

    private int counter = 0;

    public LaserField(int x, int y, Matrix m) {
        super(x, y, m);
        Clock.getInstance().login(this);
    }

    public void draw() {
        Graphics g = m.getGraphic().bufferGraphics;
        g.setColor(Color.yellow);
        g.fillRect(x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"));
    }

    @Override
    public void tick() {
        if (++counter == 200) {
            m.deleteField(x, y);
            System.out.println("aha");
        }
    }
}
