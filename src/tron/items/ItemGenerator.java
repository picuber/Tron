package tron.items;

import java.util.Random;
import tron.Configs;
import tron.Matrix;
import tron.Tron;
import tron.clock.Clock;
import tron.clock.Timed;

/**
 *
 * @author Leon
 */
public class ItemGenerator implements Timed {

    private final Random r;
    private int counter;

    public ItemGenerator() {
        r = new Random();
        counter = 0;
        Clock.getInstance().login(this);
    }

    @Override
    public void tick() {
        counter = (counter+1) % Configs.getConfigValue("itemSpawningFrequency");
        if (counter == 0) {
            int x = r.nextInt(Configs.getConfigValue("sizeX") - 2) + 1;
            int y = r.nextInt(Configs.getConfigValue("sizeY") - 2) + 1;
            Matrix m = Tron.getInstance().getWorld().get(r.nextInt(Configs.getConfigValue("height")));
            Item.Size s;
            {
                int poss = r.nextInt(100);
                if (poss >= 0 && poss < 20) {
                    s = Item.Size.SMALL;
                } else if (poss >= 20 && poss < 50) {
                    s = Item.Size.MEDIUM;
                } else {
                    s = Item.Size.LARGE;
                }
            }
            if (checkPosIsFree(x, y, m, s)) {
                int poss = r.nextInt(100);
                if (poss >= 0 && poss < 20) {
                    //new ShorterLaser(x, y, m, s);
                } else if (poss >= 20 && poss < 40) {
                    //new LongerLaser(x, y, m, s);
                } else {
                    new Coin(x, y, m, s);
                }
            }
        }
    }

    private boolean checkPosIsFree(int x, int y, Matrix m, Item.Size s) {
        for (int i = x; i < x + s.getSize(); i++) {
            for (int j = y; j < y + s.getSize(); j++) {
                if (Tron.getInstance().getWorld().get(m.getLayer()).getFields()[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
