
/**
 *
 * @author Leon
 */
public class LaserField extends Wall implements Timed {

    public LaserField(Matrix m) {
        super(m);
        Clock.getInstance().login(this);
    }

    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
