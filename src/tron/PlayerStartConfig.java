package tron;

import tron.bikes.Bike;
import java.awt.Color;

/**
 *
 * @author Leon
 */
public class PlayerStartConfig {

    private String color;
    private int x, y, matrix, leftcode, rightcode, upcode, downcode;
    private String name;
    private MODE mode;
    private Bike.Orientation or;

    enum MODE {

        TWOKEY, FOURKEY, BOT
    }

    public PlayerStartConfig(String name, int x, int y, int matrix, int rightcode, int leftcode, int upcode, int downcode, String c, MODE mode, Bike.Orientation or) {
        this.color = c;
        this.x = x;
        this.y = y;
        this.matrix = matrix;
        this.leftcode = leftcode;
        this.rightcode = rightcode;
        this.upcode = upcode;
        this.downcode = downcode;
        this.name = name;
        this.mode = mode;
        this.or = or;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMatrix() {
        return matrix;
    }

    public int getLeftcode() {
        return leftcode;
    }

    public int getRightcode() {
        return rightcode;
    }

    public int getUpcode() {
        return upcode;
    }

    public int getDowncode() {
        return downcode;
    }

    public String getName() {
        return name;
    }

    public Bike.Orientation getOr() {
        return or;
    }

    public MODE getMode() {
        return mode;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMatrix(int matrix) {
        this.matrix = matrix;
    }

    public void setLeftcode(int leftcode) {
        this.leftcode = leftcode;
    }

    public void setRightcode(int rightcode) {
        this.rightcode = rightcode;
    }

    public void setUpcode(int upcode) {
        this.upcode = upcode;
    }

    public void setDowncode(int downcode) {
        this.downcode = downcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(MODE mode) {
        this.mode = mode;
    }

    public void setOr(Bike.Orientation or) {
        this.or = or;
    }

}
