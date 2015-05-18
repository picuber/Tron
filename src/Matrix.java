
/**
 *
 * @author Leon
 */
public class Matrix {

    private Field[][] map;

    public Matrix() {
        map = new Field[Configs.getSizeX()][Configs.getSizeY()];
    }

    public void setField(int x, int y, Field f) {
        map[x][y] = f;
    }

    public void deleteField(int x, int y) {
        Field f = map[x][y];
        if (f != null) {
            f.undraw();
        }
        map[x][y]=null;

    }

}
