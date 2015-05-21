
/**
 *
 * @author Leon
 */
public interface Drawable {

    /**
     *
     * @return x-position for drawing
     */
    public int getX();

    /**
     *
     * @return y.position for drawing
     */
    public int getY();
    
    /**
     * draws the Object
     */
    public void draw();
    
    /**
     * removes the Drawing
     */
    public void undraw();
}
