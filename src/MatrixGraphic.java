
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author michael
 */
public class MatrixGraphic extends JPanel {
    private int counter=0;
    private Graphics g;

    public MatrixGraphic() {
        this.setSize(500, 500);
        this.setBackground(Color.lightGray);

    }
    @Override
    public synchronized void paintComponent (Graphics g){
        if(++counter==2){
            this.g=g;
            notify();
        }

    }
    public synchronized Graphics getGraphics(){
        if(g==null){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MatrixGraphic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return g;
    }
}
