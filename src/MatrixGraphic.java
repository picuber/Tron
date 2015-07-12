
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author michael
 */
public class MatrixGraphic {

    private static final long serialVersionUID = 1L;
    private Graphics bufferGraphics;
    private Image image;

    public MatrixGraphic() {

    }

    public void init() {
        image = new BufferedImage(Configs.getConfigValue("sizeX") * Configs.getConfigValue("scaleX") + 18, Configs.getConfigValue("sizeY") * Configs.getConfigValue("scaleY") + 47, BufferedImage.TYPE_INT_RGB);
        bufferGraphics = image.getGraphics();
    }
    
    
    public MatrixView getView(){
        return new MatrixView(image);
    }

    /**
     * @return the bufferGraphics
     */
    public Graphics getBufferGraphics() {
        return bufferGraphics;
    }

}
