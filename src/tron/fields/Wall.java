package tron.fields;

import tron.Matrix;
import tron.Configs;
import java.awt.Color;
import java.awt.Graphics;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class Wall extends Field {

    public Wall(int x, int y, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;
        m.setField(x, y, this);
        draw();
    }

    @Override
    public void collide(Bike b) {
        b.die();
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.white);
        int pX = x * Configs.getConfigValue("scaleX");
        int pY = y * Configs.getConfigValue("scaleY");
        int pWidth = Configs.getConfigValue("scaleX");
        int pHeight = Configs.getConfigValue("scaleY");
        g.fillRect(pX, pY, pWidth, pHeight);
    }

}
