
/**
 *
 * @author Leon
 */
public class Wall extends Field{

    @Override
    public void collide(Bike b) {
       b.die();
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
