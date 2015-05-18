
/**
 *
 * @author Leon
 */
public class Wall extends Field {

    private Matrix m;

    public Wall(Matrix m) {
        this.m = m;
    }

    @Override
    public void collide(Bike b) {
        b.die();
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
