package tron.fields;

import tron.Matrix;
import tron.Configs;
import tron.items.Item;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class ItemElement extends Field {

    private final Item i;
    private final BufferedImage image;

    public ItemElement(Item i, int x, int y, BufferedImage image, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.i = i;
        this.image = image;
        i.getMatrix().setField(x, y, this);
    }

    @Override
    public void collide(Bike b) {
        i.collect(b);
    }

    @Override
    public void draw() {
        Graphics g = i.getMatrix().getGraphic().getBufferGraphics();
        int pX = x * Configs.getConfigValue("scaleX");
        int pY = y * Configs.getConfigValue("scaleY");
        int pWidth = Configs.getConfigValue("scaleX");
        int pHeight = Configs.getConfigValue("scaleY");
        g.drawImage(image, pX, pY, pWidth, pHeight, null);
    }

    public void delete() {
        undraw();
        i.getMatrix().deleteField(x, y);
    }
}
