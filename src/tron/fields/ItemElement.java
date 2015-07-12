package tron.fields;


import tron.Matrix;
import tron.Configs;
import tron.items.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class ItemElement extends Field {

    private Item i;
    private BufferedImage image;

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
        g.drawImage(image, x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"), null);
    }

    public void delete() {
        undraw();
        i.getMatrix().deleteField(x, y);
    }
}
