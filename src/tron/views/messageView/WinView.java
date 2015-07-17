package tron.views.messageView;

import java.awt.Color;
import tron.Tron;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class WinView extends EndMessageView {

    public WinView(Bike b) {
        super(Color.green, "YOU WON!", b);
    }

    @Override
    public void tick() {
        repaint();
        if (counter++ >= 510) {
            b.getWindow().dispose();
            Tron.getInstance().getBikes().remove(b);
            Tron.getInstance().stopGame();
        }
    }
}
