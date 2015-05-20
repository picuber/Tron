
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
    private MatrixGraphic graphic;

    private Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
    }

    public static Tron getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        MatrixGraphic mg = new MatrixGraphic();
        Tron.getInstance().setGraphic(mg);
        TestWindow f= new TestWindow(mg);
       f.setVisible(true);

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    private void setGraphic(MatrixGraphic mg) {
        graphic = mg;
    }

}
