package tron.views;


import tron.Configs;
import tron.clock.Clock;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Leon
 */
public class MatrixView extends View {

    private Image image;

    public MatrixView(Image image) {
        this.image = image;
        this.setSize(Configs.getConfigValue("sizeX")*Configs.getConfigValue("scaleX")+18, Configs.getConfigValue("sizeY")*Configs.getConfigValue("scaleY")+47);
        Clock.getInstance().login(this);
    }

    @Override
    public void tick() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

}
