
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
    private TestWindow window;

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
        if (Tron.getInstance().bikes.isEmpty()) {
            Tron.getInstance().stopGame();
            return;
        }
        Tron.getInstance().getWorld().get(0).init();
        initLinks();
        initItems();
        Clock.getInstance().start();
    }

    public void stopGame() {
        Clock.getInstance().stop();
        Clock.getInstance().emptyClients();
        Tron.getInstance().world.removeAll(Tron.getInstance().world);
        Tron.getInstance().bikes.removeAll(Tron.getInstance().bikes);
        if(window !=null){
        window.dispose();
        }
        window = null;
        new Startpage("Continue...");
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
        window = new TestWindow(Tron.getInstance().getWorld().get(0));
        for (int i = 0; i < 4; i++) {
            PlayerStartConfig config = Configs.getPlayers()[i];
            if (!config.getName().equals("")) {
                Bike b = new Bike(config.getX(), config.getY(), config.getColor(), config.getName(), Tron.getInstance().world.get(config.getMatrix()), config.getOr());
                Tron.getInstance().bikes.add(b);
                if (config.getMode() == PlayerStartConfig.MODE.TWOKEY) {
                    window.addKeyListener(new Wheel(b, config.getRightcode(), config.getLeftcode()));
                } else if (config.getMode() == PlayerStartConfig.MODE.FOURKEY) {
                    window.addKeyListener(new Wheel(b, config.getRightcode(), config.getLeftcode(), config.getUpcode(), config.getDowncode()));
                } else if (config.getMode() == PlayerStartConfig.MODE.BOT) {
                    new Bot(b);
                }
            }
        }
    }

    private void initLinks() {
        new LinkField(Tron.getInstance().getWorld().get(0), 501, 501, Tron.getInstance().getWorld().get(0), 900, 900);
        new LinkField(Tron.getInstance().getWorld().get(0), 500, 500, Tron.getInstance().getWorld().get(0), 100, 100);
        new LinkField(Tron.getInstance().getWorld().get(0), 501, 500, Tron.getInstance().getWorld().get(0), 900, 100);
        new LinkField(Tron.getInstance().getWorld().get(0), 500, 501, Tron.getInstance().getWorld().get(0), 100, 900);
    }

    private void initItems() {

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
