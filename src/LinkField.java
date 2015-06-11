
import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Leon
 */
public class LinkField extends Field {

    private Matrix m;
    private int x, y;
    private LinkField link;

    public LinkField(Matrix m, int x, int y, Matrix linkM, int linkX, int linkY) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.link = new LinkField(linkM, linkX, linkY, this);
        this.m.setField(x, y, this);
        draw();
    }

    private LinkField(Matrix m, int x, int y, LinkField link) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.link = link;
        this.m.setField(x, y, this);
        draw();
    }

    public Matrix getM() {
        return m;
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
       b.goToLinkEnd(link);
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.red);
        g.fillRect(x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"));
    }

}
