package tron.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import tron.Configs;
import tron.Tron;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class ReadyView extends View {

    private final JButton READY = new JButton();
    private final JButton UNREADY = new JButton();

    public ReadyView(Bike b) {
        super();
        this.setBackground(Color.black);
        int width = Configs.getConfigValue("sizeX") * Configs.getConfigValue("scaleX") + 6;
        int height = Configs.getConfigValue("sizeY") * Configs.getConfigValue("scaleY") + 35;
        this.setSize(width, height);

        READY.setLocation((width / 2) - (width / 5), (height / 2) - (height / 5));
        READY.setPreferredSize(new Dimension((width / 5) * 2, (height / 5) * 2));
        READY.setMargin(new Insets(2, 2, 2, 2));
        READY.setBackground(Color.red);
        READY.addActionListener((ActionEvent e) -> {
            setReadyState(true, b);
            if (allReady()) {
                Tron.getInstance().finallyStart();
            }

        });
        READY.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(READY);

        UNREADY.setVisible(false);
        UNREADY.setLocation((width / 2) - (width / 5), (height / 2) - (height / 5));
        UNREADY.setPreferredSize(new Dimension((width / 5) * 2, (height / 5) * 2));
        UNREADY.setMargin(new Insets(2, 2, 2, 2));
        UNREADY.setBackground(Color.green);
        UNREADY.addActionListener((ActionEvent e) -> {
            setReadyState(false, b);

        });
        UNREADY.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(UNREADY);
    }

    public void setReadyState(boolean ready, Bike b) {
        UNREADY.setVisible(ready);
        READY.setVisible(!ready);
        b.setReady(ready);
        if (ready == true && allReady()) {
            Tron.getInstance().finallyStart();
        }
    }

    private boolean allReady() {
        for (Bike b : Tron.getInstance().getBikes()) {
            if (!b.isReady()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void tick() {
    }

}
