
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
        initWorld();
        TestWindow f = new TestWindow(Tron.getInstance().world.get(0).getGraphic());
        initBikes(f);
        f.setVisible(true);
        Tron.getInstance().world.get(0).getGraphic().init();
        Tron.getInstance().world.get(0).setBorderWalls();
        Clock.getInstance().start();
    }

    private static void initWorld() {
        for (int i = 0; i < 1; i++) {
            Matrix m = new Matrix();
            MatrixGraphic mg = new MatrixGraphic();
            m.setGraphic(mg);
            Tron.getInstance().world.add(m);
        }
    }

    private static void initBikes(JFrame f) {
        f.addKeyListener(new Wheel(new Bike(30, 200, Color.orange, "1", Tron.getInstance().world.get(0)), KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
        f.addKeyListener(new Wheel(new Bike(600, 500, Color.cyan, "2", Tron.getInstance().world.get(0)), KeyEvent.VK_D, KeyEvent.VK_A));

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
