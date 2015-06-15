
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JFrame for easy Testing It wrapps a JPanel
 *
 * @author michael
 */
public class TestWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public TestWindow(Matrix m) {
        JPanel jp = m.getGraphic();
        jp.setLocation(0, 0);
        this.add(jp);
        this.setSize(jp.size().width, jp.size().height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        if (!m.isInitialized()) {
            m.init();
        }
    }
}
  
    
