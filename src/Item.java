
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Item {

    Field[][] elemente;
    BufferedImage image;
    int subimgwidth, subimgheight;

    public Item(BufferedImage image, int height, int width) {
        elemente = new Field[width][height];
        this.image = image;
        subimgwidth = this.image.getWidth() / elemente.length;
        subimgheight = this.image.getHeight() / elemente[0].length;
        init();
    }

    private void init() {
        for (int i = 0; i < elemente.length; i++) {
            for (int j = 0; j < elemente[0].length; j++) {
                int imgX = i*subimgwidth;
                int imgY = i*subimgheight;
                BufferedImage sub = image.getSubimage(imgX, imgY, subimgwidth, subimgheight);
            }
        }
    }

    public void collect() {
        
    }
}
