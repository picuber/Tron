package tron;

import java.awt.image.BufferedImage;
import tron.clock.Clock;
import tron.bikes.*;
import tron.bikes.bots.*;
import tron.graphic.MatrixGraphic;
import tron.items.*;
import tron.fields.links.FixedLinkField;
import tron.fields.links.LinkField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import tron.graphic.ImageManager;
import tron.highscore.GameScore;

/**
 *
 * @author Leon
 */
public class Tron {

    private static final Tron instance = new Tron();
    private List<Matrix> world;
    private List<Bike> bikes;
    private List<LinkField> links;
    private GameScore scoreList;

    Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
        links = new ArrayList<>();
        scoreList = new GameScore();
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
        world.stream().forEach((w) -> {
            w.init();
        });
        initLinks();
        initItems();
    }

    public void finallyStart() {
        bikes.stream().forEach((b) -> {
            b.startGame();
        });
        Clock.getInstance().resetGamespeed();
        Clock.getInstance().start();
    }

    public void stopGame() {
        Clock.getInstance().stop();
        Clock.getInstance().emptyClients();
        System.out.println(scoreList);
        scoreList.uploadToDB();
        Tron.getInstance().world = new ArrayList<>();
        Tron.getInstance().bikes = new ArrayList<>();
        Tron.getInstance().links = new ArrayList<>();
        Tron.getInstance().scoreList = new GameScore();
        Startpage.getInstance().setVisible(true);
    }

    private void initWorld() {
        for (int i = 0; i < Configs.getConfigValue("height"); i++) {
            Matrix m = new Matrix(i);
            MatrixGraphic mg = new MatrixGraphic();
            m.setGraphic(mg);
            Tron.getInstance().world.add(m);
        }
    }

    private void initPlayers() {
        for (int i = 0; i < 4; i++) {
            PlayerStartConfig config = Configs.getPlayers()[i];
            if (!config.getName().equals("") || config.getMode() == PlayerStartConfig.MODE.BOT) {
                Bike b = new Bike(config.getX(), config.getY(), config.getColor(), config.getName(), Tron.getInstance().world.get(config.getMatrix()), config.getOr(), i);
                Tron.getInstance().world.get(config.getMatrix()).init();
                Tron.getInstance().bikes.add(b);
            }
        }
        for (int i = 0; i < bikes.size(); i++) {
            PlayerStartConfig config = Configs.getPlayers()[bikes.get(i).getPlayerNr()];
            if (!config.getName().equals("") && config.getMode() == PlayerStartConfig.MODE.TWOKEY) {
                for (Bike b : bikes) {
                    b.getWindow().addKeyListener(new Wheel(bikes.get(i), config.getRightcode(), config.getLeftcode()));
                }
            } else if (!config.getName().equals("") && config.getMode() == PlayerStartConfig.MODE.FOURKEY) {
                for (Bike b : bikes) {
                    b.getWindow().addKeyListener(new Wheel(bikes.get(i), config.getRightcode(), config.getLeftcode(), config.getUpcode(), config.getDowncode()));
                }
            } else if (config.getMode() == PlayerStartConfig.MODE.BOT) {
                new WallSurfer(bikes.get(i));
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
        initInterLayerLinks();
    }

    private void initInterLayerLinks() {
        for (int i = 0; i < world.size() - 1; i++) {
            new FixedLinkField(Tron.getInstance().world.get(i), 1, 1, Tron.getInstance().world.get(i + 1), Configs.getConfigValue("sizeX") - 2, Configs.getConfigValue("sizeY") - 2);
        }
    }

    private void initItems() {
        new Coin(50, 50, world.get(0), Item.Size.LARGE, 1);
        new Coin(100, 50, world.get(0), Item.Size.MEDIUM, 2);
        new Coin(50, 100, world.get(0), Item.Size.SMALL, 3);
        new ShorterLaser(100, 100, world.get(0), Item.Size.LARGE, 100);
        new LongerLaser(50, 150, world.get(0), Item.Size.LARGE, 100);
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

    public GameScore getScoreList() {
        return scoreList;
    }

}
