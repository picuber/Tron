
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leon
 */
public class Tron {

    private static Tron instance = new Tron();
    private List<Matrix> world;
    private List<Bike> bikes;

    private Tron() {
        world = new ArrayList<>();
        bikes = new ArrayList<>();
    }

    public static Tron getInstance() {
        return instance;
    }

    public static void main(String[] args) {

    }

    public List<Matrix> getWorld() {
        return world;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

}
