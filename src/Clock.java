
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Leon
 */
public class Clock implements ActionListener {

    private static Clock instance;
    private List<Timed> timedObjects;
    private Timer timer;

    private Clock() {
        timedObjects = new LinkedList<>();
        timer = new Timer(Configs.getConfigValue("gamespeed"), this);
        timer.start();
    }

    public static Clock getInstance() {
        return instance;
    }

    public void login(Timed t) {
        timedObjects.add(t);
    }

    public void logout(Timed t) {
        timedObjects.remove(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Timed timedObject : timedObjects) {
            timedObject.tick();
        }
    }

    public void stop() {
        timer.stop();
    }

    public void setGamespeed(int delay) {
        timer.setDelay(delay);
    }
}
