package tron.bikes;

import tron.Tron;
import tron.Configs;
import tron.PlayerWindow;
import tron.Matrix;
import tron.clock.Clock;
import tron.clock.Timed;
import tron.graphic.Drawable;
import tron.fields.Field;
import tron.fields.LaserField;
import tron.fields.LinkField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class Bike implements Timed, Drawable {

    private int x, y;
    private int score;
    private int laserLength;
    private Color c;
    private Matrix m;
    private Orientation or, lastor;

    private final String name;
    private final String color;
    private final PlayerWindow window;

    private static int length = Configs.getConfigValue("bikelength");
    private static int broadth = Configs.getConfigValue("bikebroadth");

    public Bike(int x, int y, String color, String name, Matrix m, Orientation or, PlayerWindow window) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.color = color;
        switch (color) {
            case "lilac":
                c = new Color(110, 9, 103);
                break;
            case "green":
                c = Color.GREEN;
                break;
            case "blue":
                c = Color.BLUE;
                break;
            case "orange":
                c = Color.ORANGE;
                break;
            case "red":
                c = Color.red;
                break;
            default:
                throw new RuntimeException("Du dummer Idiot! Es gibt nur 5 Farben");
        }
        this.name = name;
        this.or = or;
        this.lastor = or;
        this.score = 0;
        this.window = window;
        this.laserLength = Configs.getConfigValue("laserlength");
        Clock.getInstance().login(this);
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
        window.changeMatrix(m.getGraphic().getView());
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

    public void die() {
        Clock.getInstance().logout(this);
        Tron.getInstance().getBikes().remove(this);
        JOptionPane.showMessageDialog(null, name + " died with a score of " + score, "Death", JOptionPane.PLAIN_MESSAGE, null);
        length = broadth = Integer.max(length, broadth);
        undraw();
        updateBackground();
        window.dispose();
        if (Tron.getInstance().getBikes().size() == 1) {
            JOptionPane.showMessageDialog(null, Tron.getInstance().getBikes().get(0).getName() + " won with a score of " + Tron.getInstance().getBikes().get(0).getScore(), "Win", JOptionPane.PLAIN_MESSAGE, null);
            Tron.getInstance().getBikes().get(0).getWindow().dispose();
            Tron.getInstance().stopGame();
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
