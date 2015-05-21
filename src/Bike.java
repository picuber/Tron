
/**
 *
 * @author Leon
 */
public class Bike implements Timed{
    enum Orientation{
        FORWARDS,BACKWARDS,RIGHTWARDS,LEFTWARDS
    }
    private Orientation or;
    public void driveRight(){
        switch(or){
           //TODO 
        }
    }
    public Bike(){
        
    }
    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
