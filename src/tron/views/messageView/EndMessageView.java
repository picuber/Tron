package tron.views.messageView;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import tron.Configs;
import tron.bikes.Bike;
import tron.clock.Clock;
import tron.views.View;

/**
 *
 * @author Leon
 */
public abstract class EndMessageView extends View {

    protected int counter;

    private final JLabel MESSAGE = new JLabel();
    protected final Bike b;

    public EndMessageView(Color c, String message, Bike b) {
        super();
        counter = 0;
        this.b = b;
        this.setBackground(Color.black);
        int width = Configs.getConfigValue("sizeX") * Configs.getConfigValue("scaleX") ;
        int height = Configs.getConfigValue("sizeY") * Configs.getConfigValue("scaleY") ;
        this.setSize(width, height);

        MESSAGE.setLocation(0, 0);
        MESSAGE.setSize(width, height);
        MESSAGE.setText(message);
        MESSAGE.setForeground(c);
        MESSAGE.setFont(new Font("Consolas", Font.BOLD, 40));
        MESSAGE.setHorizontalAlignment(SwingConstants.CENTER);
        MESSAGE.setVerticalAlignment(SwingConstants.CENTER);
        this.add(MESSAGE);
        repaint();
        Clock.getInstance().login(this);
    }

}
