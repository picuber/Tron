
/**
 *
 * @author Leon
 */
public class Matrix{

    private final Field[][] map;
    private MatrixGraphic graphic;

    public Matrix() {
        map = new Field[Configs.getConfigValue("sizeX")][Configs.getConfigValue("sizeY")];
    }

    public void setField(int x, int y, Field f) {
        map[x][y] = f;
    }

    /**
     * deletes a Field from the Matrix
     * by undrawing it and removing it from map
     * @param x x-position of Field
     * @param y y-position of Field
     */
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

    /**
     * 
     * @return internal Field[][]
     */
    public Field[][] getFields() {
     return map;
    }

}
