
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class Tron {

    private static final Tron instance = new Tron();
    private List<Matrix> world;
    private List<Bike> bikes;
    private List<LinkField> links;
    private TestWindow window;

    Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
        links = new ArrayList<>();
    }

    public static Tron getInstance() {
        return instance;
    }

    public void startGame() {
        initWorld();
        initPlayers();
        if (Tron.getInstance().bikes.size() <= 1) {
            JOptionPane.showMessageDialog(null, "Not enougth Players or Bots", "WARNING", JOptionPane.PLAIN_MESSAGE, null);        
            Tron.getInstance().stopGame();
            return;
        }
        Tron.getInstance().getWorld().get(0).init();
        initLinks();
        initItems();
        Clock.getInstance().resetGamespeed();
        Clock.getInstance().start();
    }

    public void stopGame() {
        Clock.getInstance().stop();
        Clock.getInstance().emptyClients();
        Tron.getInstance().world = new ArrayList<>();
        Tron.getInstance().bikes = new ArrayList<>();
        Tron.getInstance().links = new ArrayList<>();
        window.dispose();
        window = null;
        Startpage.getInstance().setVisible(true);
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
            if (!config.getName().equals("")||config.getMode() == PlayerStartConfig.MODE.BOT) {
                Bike b = new Bike(config.getX(), config.getY(), config.getColor(), config.getName(), Tron.getInstance().world.get(config.getMatrix()), config.getOr());
                Tron.getInstance().bikes.add(b);
                if (config.getMode() == PlayerStartConfig.MODE.TWOKEY) {
                    window.addKeyListener(new Wheel(b, config.getRightcode(), config.getLeftcode()));
                } else if (config.getMode() == PlayerStartConfig.MODE.FOURKEY) {
                    window.addKeyListener(new Wheel(b, config.getRightcode(), config.getLeftcode(), config.getUpcode(), config.getDowncode()));
                } else if (config.getMode() == PlayerStartConfig.MODE.BOT) {
                    new WallSurfer(b);
                }
            }
        }
    }

    private void initLinks() {
        Random r = new Random();
        for (int i = 0; i < Configs.getConfigValue("numberLinks"); i++) {
            int xPos, yPos, mPos;
            xPos = Math.abs(r.nextInt() % (Configs.getConfigValue("sizeX") - 2)) + 1;
            yPos = Math.abs(r.nextInt() % (Configs.getConfigValue("sizeY") - 2)) + 1;
            mPos = Math.abs(r.nextInt() % Configs.getConfigValue("height"));
            links.add(new LinkField(Tron.getInstance().getWorld().get(mPos), xPos, yPos));
        }
    }

    private void initItems() {
        try {
            new Coin(ImageIO.read(new File("images/item_score.png")), 1, 1, 20, 20, world.get(0), 3);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public List<LinkField> getLinks() {
        return links;
    }

}
