
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Leon
 */
public class Bike implements Timed, Drawable {

    int x, y, length = Configs.getConfigValue("bikelength"), broadth = Configs.getConfigValue("bikebroadth");
    private Color c;
    private String name;
    static Image imgright, imgleft, imgup, imgdown;
    private Matrix m;

    static {
        try {
            imgright = ImageIO.read(new File("bikeright.png"));
            imgleft = ImageIO.read(new File("bikerleft.png"));
            imgdown = ImageIO.read(new File("bikerdown.png"));
            imgup = ImageIO.read(new File("bikerup.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bike.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Bike(int x, int y, Color c, String name, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.c = c;
        this.name = name;
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

    public void goThroughLink(LinkField linkStartPoint) {
        undraw();
        updateBackground();
        m = linkStartPoint.getLink().getCurrent();
        x = linkStartPoint.getLink().getX();
        y = linkStartPoint.getLink().getY();
        draw();
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        Image img = null;
        switch (or) {
            case UP:
                img = imgup;
                break;
            case DOWN:
                img = imgdown;
                break;
            case RIGHT:
                img = imgright;
                break;
            case LEFT:
                img = imgleft;
                break;
        }

        if (or == Orientation.DOWN || or == Orientation.UP) {
            g.drawImage(img, (x - broadth / 2) * Configs.getConfigValue("scaleX"), (y - length / 2) * Configs.getConfigValue("scaleY"), broadth * Configs.getConfigValue("scaleX"), length * Configs.getConfigValue("scaleY"), null);
        } else {
            g.drawImage(img, (x - length / 2) * Configs.getConfigValue("scaleX"), (y - broadth / 2) * Configs.getConfigValue("scaleY"), length * Configs.getConfigValue("scaleX"), broadth * Configs.getConfigValue("scaleY"), null);
        }
    }

    @Override
    public void undraw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.white);
        if (lastor == Orientation.DOWN || lastor == Orientation.UP) {
            g.clearRect((x - broadth / 2) * Configs.getConfigValue("scaleX"), (y - length / 2) * Configs.getConfigValue("scaleY"), broadth * Configs.getConfigValue("scaleX"), length * Configs.getConfigValue("scaleY"));
        } else {
            g.clearRect((x - length / 2) * Configs.getConfigValue("scaleX"), (y - broadth / 2) * Configs.getConfigValue("scaleY"), length * Configs.getConfigValue("scaleX"), broadth * Configs.getConfigValue("scaleY"));
        }

    }

    /**
     * @param or the or to set
     */
    public void setOr(Orientation or) {
        this.or = or;
    }

    enum Orientation {

        UP, DOWN, RIGHT, LEFT
    }
    private Orientation or = Orientation.UP;
    private Orientation lastor = Orientation.UP;

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
            switch (or) {
                case UP:
                    new LaserField(x, y, c, m);
                    break;
                case DOWN:
                    new LaserField(x, y, c, m);
                    break;
                case LEFT:
                    new LaserField(x, y, c, m);
                    break;
                case RIGHT:
                    new LaserField(x, y, c, m);
                    break;
            }
        } else {
            f.collide(this);
        }
        this.lastor = or;

    }

    void die() {
        Clock.getInstance().logout(this);
        Tron.getInstance().getBikes().remove(this);
        System.out.println("Bike \"" + name + "\" died");
        undraw();
        updateBackground();
    }

}
