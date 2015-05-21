
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Tron {

    private static Tron instance = new Tron();
    private List<Matrix> world;
    private List<Bike> bikes;

    private Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
    }

    public static Tron getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        MatrixGraphic mg = new MatrixGraphic(m);
        m.setGraphic(mg);
        TestWindow f = new TestWindow(mg);

        f.setVisible(true);
        mg.init();
        Wall w = new Wall(1, 1, m);
        m.setField(1, 1, w);
        w.draw();
        LaserField lf = new LaserField(1, 2, m);
        m.setField(1, 2, lf);
        lf.draw();
        Clock.getInstance().start();

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

}
