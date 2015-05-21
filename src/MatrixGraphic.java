
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author michael
 */
public class MatrixGraphic extends JPanel implements Timed {

    private Graphics g;
    private final Matrix m;

    public MatrixGraphic(Matrix m) {
        this.setSize(500, 500);
        this.setBackground(Color.lightGray);
        this.m = m;
        Clock.getInstance().login(this);

    }

    @Override
    public void tick() {
        repaint();
    }

    Graphics bufferGraphics;

    Image offscreen;

    Dimension dim;
    int curX, curY;

    public void init() {
        dim = getSize();
        offscreen = createImage(dim.width, dim.height);
        bufferGraphics = offscreen.getGraphics();

    }

    public void paint(Graphics g) {
        g.drawImage(offscreen, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

}
