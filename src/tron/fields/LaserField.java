package tron.fields;

import tron.Matrix;
import tron.Configs;
import tron.clock.Clock;
import java.awt.Color;
import java.awt.Graphics;
import tron.bikes.Bike;
import tron.clock.Timed;

/**
 *
 * @author Leon
 */
public class LaserField extends Wall implements Timed {

    private int counter = 0;
    
    private final Color c;
    private final Bike b;

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
        int pX = x * Configs.getConfigValue("scaleX");
        int pY = y * Configs.getConfigValue("scaleY");
        int pWidth = Configs.getConfigValue("scaleX");
        int pHeight = Configs.getConfigValue("scaleY");
        g.fillRect(pX, pY, pWidth, pHeight);
    }

    @Override
    public void tick() {
        if (++counter == b.getLaserLength()) {
            m.deleteField(x, y);
            Clock.getInstance().logout(this);
        }
    }
}
