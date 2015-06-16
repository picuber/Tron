
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
    private TestWindow f;

    Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
    }

    public static Tron getInstance() {
        return instance;
    }

    public void startGame() {
        initWorld();
        initPlayers();
        Tron.getInstance().getWorld().get(0).init();
        initLinks();
        initItems();
        Clock.getInstance().start();
    }

    public void stopGame() {
        Clock.getInstance().stop();
        Tron.getInstance().world.removeAll(Tron.getInstance().world);
        Tron.getInstance().bikes.removeAll(Tron.getInstance().bikes);
        f.dispose();
        f=null;
    }

    private void initWorld() {
        for (int i = 0; i < Configs.getConfigValue("height"); i++) {
            Matrix m = new Matrix();
            MatrixGraphic mg = new MatrixGraphic();
            m.setGraphic(mg);
            Tron.getInstance().world.add(m);
        }
    }

    private void initPlayers() {
        f = new TestWindow(Tron.getInstance().getWorld().get(0));

        for (int i = 0; i < 4; i++) {
            PlayerStartConfig config = Configs.getPlayers()[i];
            if (!config.getName().equals("")) {
                Bike b = new Bike(config.getX(), config.getY(), config.getColor(), config.getName(), Tron.getInstance().world.get(config.getMatrix()), config.getOr());
                Tron.getInstance().bikes.add(b);
                if (config.isTwoKeyColtrol()) {
                    f.addKeyListener(new Wheel(b, config.getRightcode(), config.getLeftcode()));
                } else {
                    f.addKeyListener(new Wheel(b, config.getRightcode(), config.getLeftcode(), config.getUpcode(), config.getDowncode()));
                }
            }
        }
    }
    
    private void initLinks(){
        new LinkField(Tron.getInstance().getWorld().get(0), 50, 50, Tron.getInstance().getWorld().get(0), 100, 100);
    }
    
    private void initItems(){
        
    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
