package tron.fields;


import tron.Tron;
import tron.Configs;
import tron.Matrix;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class LinkField extends Field {

    public LinkField(Matrix m, int x, int y) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.m.setField(x, y, this);
        draw();
    }

    public Matrix getM() {
        return m;
    }

    @Override
    public void collide(Bike b) {
        List<LinkField> linkList = Tron.getInstance().getLinks();
        Random r = new Random();
        LinkField link = linkList.get(Math.abs(r.nextInt() % Configs.getConfigValue("numberLinks")));
        b.goToLinkEnd(link);
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.red);
        int pX = x * Configs.getConfigValue("scaleX");
        int pY = y * Configs.getConfigValue("scaleY");
        int pWidth = Configs.getConfigValue("scaleX");
        int pHeight = Configs.getConfigValue("scaleY");
        g.fillRect(pX, pY, pWidth, pHeight);
    }

}
