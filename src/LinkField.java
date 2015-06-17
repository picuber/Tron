
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Leon
 */
public class LinkField extends Field {

    private Matrix m;
    private int x, y;

    public LinkField(Matrix m, int x, int y) {
        this.m = m;
        this.x = x;
        this.y = y;
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

    @Override
    public void collide(Bike b) {
        List<LinkField> linkList = Tron.getInstance().getLinks();
        Random r = new Random();
        LinkField link = linkList.get(r.nextInt() % Configs.getConfigValue("numberLinks"));
        b.goToLinkEnd(link);
    }

    @Override
    public void draw() {
        Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.red);
        g.fillRect(x * Configs.getConfigValue("scaleX"), y * Configs.getConfigValue("scaleY"), Configs.getConfigValue("scaleX"), Configs.getConfigValue("scaleY"));
    }

}
