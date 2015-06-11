
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
        TestWindow f = new TestWindow(Tron.getInstance().getWorld().get(0));
        initBikes(f);
        Tron.getInstance().getWorld().get(0).init();
        new LinkField(Tron.getInstance().getWorld().get(0), 50, 50, Tron.getInstance().getWorld().get(0), 100, 100);
        Clock.getInstance().start();
    }

    private static void initWorld() {
        for (int i = 0; i < Configs.getConfigValue("height"); i++) {
            Matrix m = new Matrix();
            MatrixGraphic mg = new MatrixGraphic();
            m.setGraphic(mg);
            Tron.getInstance().world.add(m);
        }
    }

    private static void initBikes(JFrame f) {
        Tron.getInstance().bikes.add(new Bike(30, 200, Color.orange, "1", Tron.getInstance().world.get(0)));
        f.addKeyListener(new Wheel(Tron.getInstance().bikes.get(0), KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT));
        Tron.getInstance().bikes.add(new Bike(600, 500, Color.cyan, "2", Tron.getInstance().world.get(0)));
        f.addKeyListener(new Wheel(Tron.getInstance().bikes.get(1), KeyEvent.VK_D, KeyEvent.VK_A));

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
