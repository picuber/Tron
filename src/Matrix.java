
/**
 *
 * @author Leon
 */
public class Matrix{

    private Field[][] map;
    private MatrixGraphic graphic;

    public Matrix() {
        map = new Field[Configs.getConfigValue("sizeX")][Configs.getConfigValue("sizeY")];
    }

    public void setField(int x, int y, Field f) {
        map[x][y] = f;
    }

    public void deleteField(int x, int y) {
        Field f = map[x][y];
        if (f != null) {
            f.undraw();
        }
        map[x][y] = null;
    }

    public void setGraphic(MatrixGraphic mg) {
        graphic = mg;
    }
    public MatrixGraphic getGraphic(){
        return graphic;
    }

    public Field[][] getFields() {
     return map;
    }

}
