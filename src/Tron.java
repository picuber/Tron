
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Tron {

    private static final Tron instance = new Tron();
    private final List<Matrix> world;
    private final List<Bike> bikes;
  

    private Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
    }

    public static Tron getInstance() {
        return instance;
    }

    public static void main(String[] args)  {
        Matrix m=new Matrix();
        MatrixGraphic mg = new MatrixGraphic();
        m.setGraphic(mg);
        TestWindow f = new TestWindow(mg);

        f.setVisible(true);
        mg.init();
        m.setBorderWalls();
        Wall w = new Wall(1, 1, m);
        LaserField lf = new LaserField(1, 2, m);
        Clock.getInstance().start();

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
