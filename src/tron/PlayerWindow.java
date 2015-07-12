package tron;

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

    public PlayerWindow(View v) {
        jp = v;
        jp.setLocation(0, 0);
        this.add(jp);
        this.setSize(jp.getSize().width, jp.getSize().height);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                Tron.getInstance().stopGame();
                Tron.getInstance().getBikes().stream().forEach((b) -> {
                    b.getWindow().dispose();
                });
            }
        });

        this.setVisible(true);
    }

    public void changeMatrix(View v) {
        this.remove(jp);
        jp = v;
        jp.setLocation(0, 0);
        this.add(jp);
    }
}
