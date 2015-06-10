
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Leon
 */
public class Tron {

    private static final Tron instance = new Tron();
    private static final List<Matrix> world = new ArrayList<>();
    private static final List<Bike> bikes = new ArrayList<>();

    private Tron() {
    }

    public static Tron getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        initWorld();
        TestWindow f = new TestWindow(world.get(0).getGraphic());
        initBikes(f);
        f.setVisible(true);
        world.get(0).getGraphic().init();
        world.get(0).setBorderWalls();
        Clock.getInstance().start();

    }

    private static void initWorld() {
        for (int i = 0; i < 1; i++) {
            Matrix m = new Matrix();
            MatrixGraphic mg = new MatrixGraphic();
            m.setGraphic(mg);
            world.add(m);
        }
    }

    private static void initBikes(JFrame f) {
        f.addKeyListener(new Wheel(new Bike(30, 200, Color.orange, "1", world.get(0)), KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
        f.addKeyListener(new Wheel(new Bike(600, 500, Color.cyan, "2", world.get(0)), KeyEvent.VK_D, KeyEvent.VK_A));

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
