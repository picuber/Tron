package tron.bikes.bots;

import tron.Matrix;
import tron.clock.Clock;
import tron.clock.Timed;
import tron.bikes.Bike;
import tron.views.ReadyView;

/**
 *
 * @author Leon
 */
public abstract class Bot implements Timed {

    protected final Bike b;

    public Bot(Bike b) {
        this.b = b;
        ((ReadyView) b.getWindow().getView()).setReadyState(true, b);
        Clock.getInstance().login(this);
    }

    protected void left() {
        b.turnLeft();
    }

    protected void right() {
        b.turnRight();
    }

    protected Matrix matrix() {
        return b.getMatrix();
    }

}
