
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Leon
 */
public abstract class Item {

    private Field[][] elemente;
    private List<ItemElement> item;
    private BufferedImage image;
    private int subimgwidth, subimgheight;
    private int x, y;
    private Matrix m;

    public Item(BufferedImage image, int x, int y, int height, int width, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;
        elemente = new Field[width][height];
        item = new LinkedList<>();
        this.image = image;
        subimgwidth = this.image.getWidth() / elemente.length;
        subimgheight = this.image.getHeight() / elemente[0].length;
        init();
    }

    private void init() {
        for (int i = x; i < elemente.length; i++) {
            for (int j = y; j < elemente[0].length; j++) {
                int imgX = i * subimgwidth;
                int imgY = i * subimgheight;
                BufferedImage sub = image.getSubimage(imgX, imgY, subimgwidth, subimgheight);
                item.add(new ItemElement(this, i, j, sub, m));
            }
        }
        for (ItemElement ie : item) {
            ie.draw();
        }
    }

    public Matrix getMatrix() {
        return m;
    }

    public void collect(Bike b) {
        for (ItemElement ie : item) {
            ie.delete();
        }
        doEffect(b);
    }
    
    void doEffect(Bike b){
        //specified in sublasses
        System.out.println("Collected - No Effect");
    }
}
