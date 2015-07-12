package tron;

import tron.graphic.MatrixGraphic;
import tron.fields.Wall;
import tron.fields.Field;

/**
 *
 * @author Leon
 */
public class Matrix {

    private MatrixGraphic graphic;
    private boolean initialized;

    private final Field[][] map;

    public Matrix() {
        map = new Field[Configs.getConfigValue("sizeX")][Configs.getConfigValue("sizeY")];
        initialized = false;
    }

    public void init() {
        if (!initialized) {
            graphic.init();
            setBorderWalls();
            initialized = true;
        }
    }

    public void setBorderWalls() {
        for (int i = 0; i < map.length; i++) {
            map[i][0] = new Wall(i, 0, this);
            map[i][map[i].length - 1] = new Wall(i, map[i].length - 1, this);
        }
        for (int i = 1; i < map[0].length - 1; i++) {
            map[0][i] = new Wall(0, i, this);
            map[map.length - 1][i] = new Wall(map.length - 1, i, this);
        }
    }

    public void setField(int x, int y, Field f) {
        map[x][y] = f;
    }

    /**
     * deletes a Field from the Matrix by undrawing it and removing it from map
     *
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

    public MatrixGraphic getGraphic() {
        return graphic;
    }

    /**
     *
     * @return internal Field[][]
     */
    public Field[][] getFields() {
        return map;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public int getWidth() {
        return map.length * Configs.getConfigs().get("scaleX");
    }

    public int getHeight() {
        return map[0].length * Configs.getConfigValue("scaleY");
    }
}
