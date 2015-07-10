
/**
 *
 * @author Leon
 */
public class WallSurfer extends Bot{

    public WallSurfer(Bike b) {
        super(b);
    }
    
    @Override
    public void tick() {
        if (getNextField() instanceof Wall) {
            if (Math.random() >= 0.5) {
                left();
                if (getNextField() instanceof Wall) {
                    right();
                    right();
                }
            } else {
                right();
                if (getNextField() instanceof Wall) {
                    left();
                    left();
                }
            }
        } else {
            if (Math.random() <= (1.0/Configs.getConfigValue("botRandomness"))) {
                if (Math.random() >= 0.5) {
                    left();
                    if (getNextField() instanceof Wall) {
                        right();
                        right();
                        if (getNextField() instanceof Wall) {
                            left();
                        }
                    }
                } else {
                    right();
                    if (getNextField() instanceof Wall) {
                        left();
                        left();
                        if (getNextField() instanceof Wall) {
                            right();
                        }
                    }
                }
            }

        }
    }

    private Field getNextField() {
        switch (b.getOr()) {
            case UP:
                return matrix().getFields()[b.getX()][b.getY() - 1];
            case RIGHT:
                return matrix().getFields()[b.getX() + 1][b.getY()];
            case DOWN:
                return matrix().getFields()[b.getX()][b.getY() + 1];
            case LEFT:
                return matrix().getFields()[b.getX() - 1][b.getY()];
            default:
                return null;
        }
    }
    
}
