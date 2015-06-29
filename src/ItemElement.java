
import java.awt.image.BufferedImage;

/**
 *
 * @author Leon
 */
public class ItemElement extends Field {

    private Item i;
    private BufferedImage image;
    private int x, y;

    public ItemElement(Item i, int x, int y, BufferedImage image) {
        this.i = i;
        this.image = image;
    }

    @Override
    public void collide(Bike b) {
        i.collect();
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
