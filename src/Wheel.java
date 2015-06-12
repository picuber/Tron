
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author michael
 */
public class Wheel implements KeyListener {

    Bike b;
    int rightcode;
    int leftcode;
    int upcode;
    int downcode;

    private boolean control2KeyMode;

    public Wheel(Bike b, int rightcode, int leftcode, int upcode, int downcode) {
        this.b = b;
        this.rightcode = rightcode;
        this.leftcode = leftcode;
        this.upcode = upcode;
        this.downcode = downcode;
        this.control2KeyMode = false;
    }

    public Wheel(Bike b, int rightcode, int leftcode) {
        this.b = b;
        this.rightcode = rightcode;
        this.leftcode = leftcode;
        this.control2KeyMode = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (control2KeyMode) {
            if (e.getKeyCode() == rightcode) {
                b.turnRight();
            } else if (e.getKeyCode() == leftcode) {
                b.turnLeft();
            }
        } else {
            if (e.getKeyCode() == rightcode) {
                b.setOr(Bike.Orientation.RIGHT);
            } else if (e.getKeyCode() == leftcode) {
                b.setOr(Bike.Orientation.LEFT);
            } else if (e.getKeyCode() == upcode) {
                b.setOr(Bike.Orientation.UP);
            } else if (e.getKeyCode() == downcode) {
                b.setOr(Bike.Orientation.DOWN);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
