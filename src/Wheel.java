
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author michael
 */
public class Wheel implements KeyListener {
    Bike b;
    int rightcode;
    int leftcode;
    public Wheel(Bike b,int rightcode,int leftcode){
        this.b=b;
        this.rightcode=rightcode;
        this.leftcode=leftcode;
                
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==rightcode){
           b.turnRight();
       }else if(e.getKeyCode()==leftcode){
           b.turnLeft();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
    }
    
}
