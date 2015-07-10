
/**
 *
 * @author Leon
 */
public abstract class Bot implements Timed {

    Bike b;

    public Bot(Bike b) {
        this.b = b;
        Clock.getInstance().login(this);
    }

    void left() {
        b.turnLeft();
    }

    void right() {
        b.turnRight();
    }

    Matrix matrix() {
        return b.getMatrix();
    }
}
