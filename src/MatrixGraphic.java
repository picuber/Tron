
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

    private static final long serialVersionUID = 1L;
    private Graphics bufferGraphics;
    private Image offscreen;

    public MatrixGraphic() {
        this.setSize(Configs.getConfigValue("sizeX")*Configs.getConfigValue("scaleX")+10, Configs.getConfigValue("sizeY")*Configs.getConfigValue("scaleY")+30);
        Clock.getInstance().login(this);
    }

    @Override
    public void tick() {
        repaint();
    }

    public void init() {
        Dimension dim = getSize();
        offscreen = createImage(dim.width, dim.height);
        bufferGraphics = offscreen.getGraphics();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * @return the bufferGraphics
     */
    public Graphics getBufferGraphics() {
        return bufferGraphics;
    }

}
