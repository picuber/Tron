package tron.clock;

import tron.Configs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Leon
 */
public class Clock implements ActionListener {

    private final List<Timed> timedObjects;
    private final Timer timer;

    private static final Clock instance = new Clock();

    private Clock() {
        timedObjects = new LinkedList<>();
        timer = new Timer(Configs.getConfigValue("gamespeed"), this);
    }

    /**
     *
     * @return the actual Instance of the Clock
     */
    public static Clock getInstance() {
        return instance;
    }

    /**
     * registers the Timed-Object to get impulses
     *
     * @param t
     */
    public void login(Timed t) {
        timedObjects.add(t);
    }

    /**
     * unregisters the Timed-Object t
     *
     * @param t
     */
    public void logout(Timed t) {
        timedObjects.remove(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < timedObjects.size(); i++) {
            timedObjects.get(i).tick();
        }
    }

    /**
     * starts the Clock
     */
    public void start() {
        timer.start();
    }

    /**
     * stops the Clock
     */
    public void stop() {
        timer.stop();
    }

    /**
     * sets the time gap between two impulses
     */
    public void resetGamespeed() {
        timer.setDelay(Configs.getConfigValue("gamespeed"));
    }

    public void emptyClients() {
        timedObjects.removeAll(timedObjects);
    }
}
