
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JFrame for easy Testing It wrapps a JPanel
 *
 * @author michael
 */
public class TestWindow extends JFrame {
//
//    public GameWindow(List<Matrix> mList) {
//        System.out.println(Thread.currentThread());
//        int x = 0, y = 0;
//        int frameWidth = 0, frameHeight = 0;
//        int windowWidth = 0, windowHeight = 0;
//        for (Matrix m : mList) {
//            frameWidth = m.getWidth();
//            frameHeight = m.getHeight();
//            JPanel jp = m.getGraphic();
//            jp.setLocation(x, y);
//            System.out.println(jp.getSize());
//            this.add(jp);
//            windowWidth = x += frameWidth + 10;
//            windowHeight = Math.max(windowHeight, frameHeight);
//        }
//        this.setSize(windowWidth, windowHeight);
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent we) {
//                Tron.getInstance().stopGame();
//                dispose();
//            }
//        });
//        this.setVisible(true);
//        for (Matrix m : mList) {
//            m.init();
//
//        }
//    } 
   public TestWindow(Matrix m) {
       JPanel jp = m.getGraphic();
       jp.setLocation(0, 0);
       this.add(jp);
       this.setSize(jp.getSize().width, jp.getSize().height);
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent we){
               Tron.getInstance().stopGame();
               dispose();
           }
       });
       
       this.setVisible(true);
       m.init();
   }
}
