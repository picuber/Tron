
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   f.addKeyListener(new Wheel(new Bike(30,200,m),39,37));
       
        Tron.getInstance().getWorld().add(m);
        f.setVisible(true);
        mg.init();
        m.setBorderWalls();
        
        new Bike(60,200,m);
        new Bike(90,200,m);
        new Bike(120,200,m);
        Clock.getInstance().start();

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
