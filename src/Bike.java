
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

    int x, y, length = 30, broadth = 15;
    static Image imgright, imgleft, imgup, imgdown;

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
    private final Matrix m;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
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

            int drawy = y * Configs.getConfigValue("scaleY");
            if (or == Orientation.DOWN) {
                drawy = (y - length) * Configs.getConfigValue("scaleY");
            }
               g.drawImage(img,(x - broadth / 2) * Configs.getConfigValue("scaleX"), drawy, broadth * Configs.getConfigValue("scaleX"), length * Configs.getConfigValue("scaleY"),null);
        
        } else {

            int drawx = x * Configs.getConfigValue("scaleX");
            if (or == Orientation.DOWN) {
                drawx = (x - length) * Configs.getConfigValue("scaleX");
            }
            g.drawImage(img, drawx, (y - broadth / 2) * Configs.getConfigValue("scaleY"), length * Configs.getConfigValue("scaleX"), broadth * Configs.getConfigValue("scaleY"), null);
        
        }
    }

    @Override
    public void undraw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.white);
        if (lastor == Orientation.DOWN || lastor == Orientation.UP) {
            int drawy = y * Configs.getConfigValue("scaleY");
            if (lastor == Orientation.DOWN) {
                drawy = (y - length) * Configs.getConfigValue("scaleY");
            }
            g.clearRect((x - broadth / 2) * Configs.getConfigValue("scaleX"), drawy, broadth * Configs.getConfigValue("scaleX"), length * Configs.getConfigValue("scaleY"));
        } else {
            int drawx = x * Configs.getConfigValue("scaleX");
            if (lastor == Orientation.DOWN) {
                drawx = (x - length) * Configs.getConfigValue("scaleX");
            }
            g.clearRect(drawx, (y - broadth / 2) * Configs.getConfigValue("scaleY"), length * Configs.getConfigValue("scaleX"), broadth * Configs.getConfigValue("scaleY"));

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

    @Deprecated
    public void turnRight() {
        System.out.println("right");
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

    @Deprecated
    public void turnLeft() {
        System.out.println("left");
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

    public Bike(int x, int y, Matrix m) {
        this.m = m;
        this.x = x;
        this.y = y;
        Clock.getInstance().login(this);
    }

    @Override
    public void tick() {
        undraw();
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
        switch (or) {
            case UP:
                new LaserField(x, y + length, m);
                break;
            case DOWN:
                new LaserField(x, y - length - 1, m);
                break;
            case LEFT:
                new LaserField(x + length, y, m);
                break;
            case RIGHT:
                new LaserField(x - 1, y, m);
                break;
        }

        if (f != null) {
            f.collide(this);
        }
        this.lastor = or;

    }

    void die() {
        Clock.getInstance().logout(this);
        System.out.println("Bike died");
        undraw();
        
    }

}
