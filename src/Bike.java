
/**
 *
 * @author Leon
 */
public class Bike implements Timed,Drawable{

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    enum Orientation {

        UP, DOWN, RIGHT, LEFT
    }
    private Orientation or;

    public void turnRight() {
        switch (or) {
            case UP:
                or = Orientation.RIGHT;
                break;
            case RIGHT:
                or = Orientation.DOWN;
                break;
            case DOWN:
                or = Orientation.LEFT;
                break;
            case LEFT:
                or = Orientation.UP;
                break;
        }
    }
    
    public void trunLeft(){
        switch (or) {
            case UP:
                or = Orientation.LEFT;
                break;
            case LEFT:
                or = Orientation.DOWN;
                break;
            case DOWN:
                or = Orientation.RIGHT;
                break;
            case RIGHT:
                or = Orientation.UP;
                break;
        }
    }

    public Bike() {

    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
