package tron.graphic;

import tron.Configs;
import tron.views.MatrixView;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author michael
 */
public class MatrixGraphic {

    private Graphics bufferGraphics;
    private Image image;

    public void init() {
        int pX = Configs.getConfigValue("sizeX") * Configs.getConfigValue("scaleX");
        int pY = Configs.getConfigValue("sizeY") * Configs.getConfigValue("scaleY");
        image = new BufferedImage(pX, pY, BufferedImage.TYPE_INT_RGB);
        bufferGraphics = image.getGraphics();
    }

    public MatrixView getView() {
        return new MatrixView(image);
    }

    public Graphics getBufferGraphics() {
        return bufferGraphics;
    }

}
