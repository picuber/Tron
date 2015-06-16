
/**
 *
 * @author Leon
 */
public class Bot implements Timed{

    private Bike b;

    public Bot(Bike b) {
        this.b = b;
        Clock.getInstance().login(this);
    }

    @Override
    public void tick() {
        while (Tron.getInstance().getBikes().contains(b)) {
            if (getNextField() instanceof Wall) {
                if (Math.random() >= 0.5) {
                    b.turnLeft();
                    if (getNextField() instanceof Wall) {
                        b.turnRight();
                        b.turnRight();
                    }
                } else {
                    b.turnRight();
                    if (getNextField() instanceof Wall) {
                        b.turnLeft();
                        b.turnLeft();
                    }
                }
            } else {
                if (Math.random() == 0.0) {
                    if (getNextField() instanceof Wall) {
                        if (Math.random() >= 0.5) {
                            b.turnLeft();
                            if (getNextField() instanceof Wall) {
                                b.turnRight();
                                b.turnRight();
                                if (getNextField() instanceof Wall) {
                                    b.turnLeft();
                                }
                            }
                        } else {
                            b.turnRight();
                            if (getNextField() instanceof Wall) {
                                b.turnLeft();
                                b.turnLeft();
                                if (getNextField() instanceof Wall) {
                                    b.turnRight();
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private Field getNextField() {
        switch (b.getOr()) {
            case UP:
                return b.getMatrix().getFields()[b.getX()][b.getY() - 1];
            case RIGHT:
                return b.getMatrix().getFields()[b.getX() + 1][b.getY()];
            case DOWN:
                return b.getMatrix().getFields()[b.getX()][b.getY() + 1];
            case LEFT:
                return b.getMatrix().getFields()[b.getX() - 1][b.getY()];
            default:
                return null;
        }
    }

}
