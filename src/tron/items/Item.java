package tron.items;

import tron.Matrix;
import tron.fields.Field;
import tron.fields.ItemElement;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public abstract class Item {

    private final Field[][] elemente;
    private final List<ItemElement> item;
    private final BufferedImage image;
    private final int subimgwidth, subimgheight;
    private final int x, y;
    private final Matrix m;

    protected final int value;

    public Item(BufferedImage image, int x, int y, Size size, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.value = getValue(size);
        elemente = new Field[size.getSize()][size.getSize()];
        item = new LinkedList<>();
        this.image = image;
        subimgwidth = this.image.getWidth() / elemente.length;
        subimgheight = this.image.getHeight() / elemente[0].length;
        init();
    }

    private void init() {
        for (int i = 0; i < elemente.length; i++) {
            for (int j = 0; j < elemente[0].length; j++) {
                int imgX = i * subimgwidth;
                int imgY = j * subimgheight;
                BufferedImage sub = image.getSubimage(imgX, imgY, subimgwidth, subimgheight);
                item.add(new ItemElement(this, i + x, j + y, sub, m));
            }
        }
        item.stream().forEach((ie) -> {
            ie.draw();
        });
    }

    public Matrix getMatrix() {
        return m;
    }

    public void collect(Bike b) {
        item.stream().forEach((ie) -> {
            ie.delete();
        });
        doEffect(b);
    }

    public enum Size {

        SMALL(16), MEDIUM(22), LARGE(36);

        private Size(int size) {
            this.size = size;
        }
        private final int size;

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return size + "";
        }

    }

    protected abstract void doEffect(Bike b);

    protected abstract int getValue(Size s);
}
