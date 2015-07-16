package tron;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import tron.views.View;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JFrame for easy Testing It wrapps a JPanel
 *
 * @author michael
 */
public class PlayerWindow extends JFrame {

    private JPanel jp;

    public PlayerWindow(View v, int playerNr) {
        jp = v;
        jp.setLocation(0, 0);
        if (Configs.getConfigValue("windowNotVisible") == 1) {
            this.setUndecorated(true);
        }
        this.add(jp);
        this.setSize(jp.getSize().width, jp.getSize().height);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(getPosition(playerNr));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                Tron.getInstance().getBikes().stream().forEach((b) -> {
                    b.getWindow().dispose();
                });
                Tron.getInstance().stopGame();
            }
        });

        this.setVisible(true);
    }

    private Point getPosition(int playerNr) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = this.getSize();
        int horiontalWindowNumber = screenSize.width / windowSize.width;
        int x = (playerNr % horiontalWindowNumber) * windowSize.width;
        int y = (playerNr / horiontalWindowNumber) * windowSize.height;
        return new Point(x, y);
    }

    public void changeView(View v) {
        this.remove(jp);
        jp = v;
        jp.setLocation(0, 0);
        this.add(jp);
    }
}
