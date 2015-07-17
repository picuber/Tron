package tron.views.messageView;

import java.awt.Color;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class DeathView extends EndMessageView {

    public DeathView(Bike b) {
        super(Color.red, "YOU DIED!", b);
    }

    @Override
    public void tick() {
        repaint();
        if (counter++ >= 500)
            b.getWindow().dispose();
    }
}
