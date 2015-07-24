package tron;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import tron.views.View;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * JFrame for easy Testing It wrapps a JPanel
 *
 * @author michael
 */
public class PlayerWindow extends JFrame {

    private View view;

    public PlayerWindow(View v, int playerNr) {
        view = v;
        view.setLocation(0, 0);
        if (Configs.getConfigValue("windowNotVisible") == 1) {
            this.setUndecorated(true);
        }
        this.add(view);
        this.getContentPane().setPreferredSize(new Dimension(view.getSize().width, view.getSize().height));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                Tron.getInstance().getBikes().stream().forEach((b) -> {
                    b.getWindow().dispose();
                });
                Tron.getInstance().stopGame(true);
            }
        });
        this.pack();
        this.setLocation(getPosition(playerNr));
        this.setVisible(true);
        this.setResizable(false);
    }

    private Point getPosition(int playerNr) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = this.getSize();
        int horiontalWindowNumber = screenSize.width / windowSize.width;
        int x = (playerNr % horiontalWindowNumber) * windowSize.width;
        int y = (playerNr / horiontalWindowNumber) * windowSize.height;
        return new Point(x, y);
    }

    public View getView() {
        return view;
    }

    public void changeView(View v) {
        this.remove(view);
        view = v;
        view.setLocation(0, 0);
        this.add(view);
    }
}
