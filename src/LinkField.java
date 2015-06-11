
/**
 *
 * @author Leon
 */
public class LinkField extends Field {

    private Matrix current;
    private int x, y;
    private LinkField link;

    public LinkField(Matrix current, int x, int y, Matrix linkCurrent, int linkX, int linkY) {
        this.current = current;
        this.x = x;
        this.y = y;
        this.link = new LinkField(linkCurrent, linkX, linkY, this);
    }

    private LinkField(Matrix current, int x, int y, LinkField link) {
        this.current = current;
        this.x = x;
        this.y = y;
        this.link = link;
    }

    public Matrix getCurrent() {
        return current;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public LinkField getLink() {
        return link;
    }

    @Override
    public void collide(Bike b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
