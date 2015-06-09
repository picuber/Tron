
import java.awt.Color;
import java.awt.event.KeyEvent;
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

    public static void main(String[] args) {
        Matrix m = new Matrix();
        MatrixGraphic mg = new MatrixGraphic();
        m.setGraphic(mg);
        TestWindow f = new TestWindow(mg);
        f.addKeyListener(new Wheel(new Bike(30, 200, Color.orange, m), KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
        f.addKeyListener(new Wheel(new Bike(600, 500, Color.cyan, m), KeyEvent.VK_D, KeyEvent.VK_A));

        Tron.getInstance().getWorld().add(m);
        f.setVisible(true);
        mg.init();
        m.setBorderWalls();

//        new Bike(60,200,m);
//        new Bike(90,200,m);
//        new Bike(120,200,m);
        Clock.getInstance().start();

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
