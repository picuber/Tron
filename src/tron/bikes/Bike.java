package tron.bikes;

import tron.graphic.ImageManager;
import tron.Tron;
import tron.Configs;
import tron.PlayerWindow;
import tron.Matrix;
import tron.clock.Clock;
import tron.clock.Timed;
import tron.graphic.Drawable;
import tron.fields.Field;
import tron.fields.LaserField;
import tron.fields.links.LinkField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import tron.highscore.GameSingleScore;
import tron.views.ReadyView;
import tron.views.messageView.DeathView;
import tron.views.messageView.WinView;

/**
 *
 * @author Leon
 */
public class Bike implements Timed, Drawable {

    private int x, y;
    private int length;
    private int broadth;
    private int score;
    private int laserLength;
    private Color c;
    private Matrix m;
    private Orientation or, lastor;
    private boolean ready;
    private boolean dead;

    private final String name;
    private final String color;
    private final int playerNr;
    private final PlayerWindow window;

    public Bike(int x, int y, String color, String name, Matrix m, Orientation or, int playerNr) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.color = color;
        c = getColorFromString(color);
        if (name.equals("")) {
            name = "BOT";
        }
        this.name = name;
        this.or = or;
        this.lastor = or;
        this.score = 0;
        this.playerNr = playerNr;
        this.length = Configs.getConfigValue("bikelength");
        this.broadth = Configs.getConfigValue("bikebroadth");
        this.laserLength = Configs.getConfigValue("laserlength");
        ready = false;
        dead = false;
        this.window = new PlayerWindow(new ReadyView(this), playerNr);
        window.setTitle("Are you ready?");
    }

    public void startGame() {
        window.changeView(m.getGraphic().getView());
        window.setTitle(name + " - Level " + m.getLayer());
        Clock.getInstance().login(this);
    }

    public static Color getColorFromString(String color) {
        switch (color) {
            case "lilac":
                return new Color(110, 9, 103);
            case "green":
                return Color.GREEN;
            case "blue":
                return Color.BLUE;
            case "orange":
                return Color.ORANGE;
            case "red":
                return Color.red;
            default:
                throw new RuntimeException("Du dummer Idiot! Es gibt nur 5 Farben");
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Matrix getMatrix() {
        return m;
    }

    public int getLaserLength() {
        return laserLength;
    }

    public PlayerWindow getWindow() {
        return window;
    }

    public int getPlayerNr() {
        return playerNr;
    }

    public boolean isReady() {
        return ready;
    }

    public boolean isDead() {
        return dead;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setLaserLength(int laserLength) {
        this.laserLength = laserLength;
    }

    public void setDefaultLaserLength() {
        this.laserLength = Configs.getConfigValue("laserlength");
    }

    public void addLaserLength(int length) {
        laserLength += length;
    }

    public void subLaserLength(int length) {
        laserLength -= length;
    }

    public void goToLinkEnd(LinkField linkEndPoint) {
        undraw();
        updateBackground();
        m = linkEndPoint.getM();
        x = linkEndPoint.getX();
        y = linkEndPoint.getY();
        window.changeView(m.getGraphic().getView());
        m.init();
        switch ((int) (Math.random() * 4)) {
            case 0:
                or = Orientation.UP;
                break;
            case 1:
                or = Orientation.DOWN;
                break;
            case 2:
                or = Orientation.LEFT;
                break;
            case 3:
                or = Orientation.RIGHT;
                break;
            default:
                System.out.println("ERROR");
        }
        draw();
        window.setTitle(name + " - Level " + m.getLayer());
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        Image img = ImageManager.get(or, color);
        int pX, pY, pWidth, pHeight;
        if (or == Orientation.DOWN || or == Orientation.UP) {
            pX = (x - broadth / 2) * Configs.getConfigValue("scaleX");
            pY = (y - length / 2) * Configs.getConfigValue("scaleY");
            pWidth = broadth * Configs.getConfigValue("scaleX");
            pHeight = length * Configs.getConfigValue("scaleY");
        } else {
            pX = (x - length / 2) * Configs.getConfigValue("scaleX");
            pY = (y - broadth / 2) * Configs.getConfigValue("scaleY");
            pWidth = length * Configs.getConfigValue("scaleX");
            pHeight = broadth * Configs.getConfigValue("scaleY");
        }
        g.drawImage(img, pX, pY, pWidth, pHeight, null);
    }

    @Override
    public void undraw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.white);
        int pX, pY, pWidth, pHeight;
        if (lastor == Orientation.DOWN || lastor == Orientation.UP) {
            pX = (x - broadth / 2) * Configs.getConfigValue("scaleX");
            pY = (y - length / 2) * Configs.getConfigValue("scaleY");
            pWidth = broadth * Configs.getConfigValue("scaleX");
            pHeight = length * Configs.getConfigValue("scaleY");
        } else {
            pX = (x - length / 2) * Configs.getConfigValue("scaleX");
            pY = (y - broadth / 2) * Configs.getConfigValue("scaleY");
            pWidth = length * Configs.getConfigValue("scaleX");
            pHeight = broadth * Configs.getConfigValue("scaleY");
        }
        g.clearRect(pX, pY, pWidth, pHeight);
    }

    /**
     * @param or the or to set
     */
    public void setOr(Orientation or) {
        this.or = or;
    }

    public Orientation getOr() {
        return or;
    }

    public String getName() {
        return name;
    }

    public enum Orientation {

        UP, DOWN, RIGHT, LEFT
    }

    public void turnRight() {
        switch (or) {
            case UP:
                setOr(Orientation.RIGHT);
                break;
            case RIGHT:
                setOr(Orientation.DOWN);
                break;
            case DOWN:
                setOr(Orientation.LEFT);
                break;
            case LEFT:
                setOr(Orientation.UP);
                break;
        }
    }

    public void turnLeft() {
        switch (or) {
            case UP:
                setOr(Orientation.LEFT);
                break;
            case LEFT:
                setOr(Orientation.DOWN);
                break;
            case DOWN:
                setOr(Orientation.RIGHT);
                break;
            case RIGHT:
                setOr(Orientation.UP);
                break;
        }
    }

    private void updateBackground() {
        Field[][] ms = this.m.getFields();
        if (lastor == Orientation.DOWN || lastor == Orientation.UP) {
            for (int i = (x - broadth / 2); i < (x + broadth / 2) + 1; i++) {
                for (int j = (y - length / 2); j < (y + length / 2); j++) {
                    if (i >= 0 && j >= 0
                            && i < ms.length && j < ms[0].length
                            && ms[i][j] != null) {
                        ms[i][j].draw();
                    }
                }
            }
        } else {
            for (int i = (x - length / 2); i < (x + length / 2); i++) {
                for (int j = (y - broadth / 2); j < (y + broadth / 2) + 1; j++) {
                    if (i >= 0 && j >= 0
                            && i < ms.length && j < ms[0].length
                            && ms[i][j] != null) {
                        ms[i][j].draw();
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        undraw();
        updateBackground();
        switch (or) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case RIGHT:
                x++;
                break;
            case LEFT:
                x--;
                break;
        }
        draw();
        Field f = m.getFields()[x][y];
        if (f == null) {
            new LaserField(x, y, c, m, this);
        } else {
            f.collide(this);
        }
        this.lastor = or;

    }

    private int numberAlive() {
        int numberAllPlayers = Tron.getInstance().getBikes().size();
        int numberAlivePlayers = numberAllPlayers;
        for (Bike b : Tron.getInstance().getBikes()) {
            if (b.isDead()) {
                numberAlivePlayers--;
            }
        }
        return numberAlivePlayers;
    }

    private Bike getWinner() {
        if (numberAlive() == 1) {
            for (Bike b : Tron.getInstance().getBikes()) {
                if (!b.isDead()) {
                    return b;
                }
            }
        }
        return null;
    }

    public void die() {
        Clock.getInstance().logout(this);
        dead = true;
        length = broadth = Integer.max(length, broadth);
        undraw();
        updateBackground();
        window.changeView(new DeathView(this));
        Tron.getInstance().getScoreList().add(new GameSingleScore(name, score, false));

        for (Bike b : Tron.getInstance().getBikes()) {
            if (!b.isDead()) {
                b.score++;
            }
        }

        if (numberAlive() == 1) {
            Bike winner = getWinner();
            Clock.getInstance().logout(winner);
            winner.getWindow().changeView(new WinView(winner));
            Tron.getInstance().getScoreList().add(new GameSingleScore(winner.getName(), winner.getScore(), true));
        }
    }

    public void score(int score) {
        this.score += score;
    }

    public void unscore(int score) {
        this.score -= score;
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

}
