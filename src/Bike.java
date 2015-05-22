
import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Leon
 */
public class Bike implements Timed,Drawable{
    int x,y,length=10,broadth=5;
    private final Matrix m;
    @Override
    public int getX() {
      return x;
    }

    @Override
    public int getY() {
       return y;
    }

    @Override
    public void draw() {
         Graphics g = m.getGraphic().getBufferGraphics();
        g.setColor(Color.red);
        g.fillRect((x-broadth/2)* Configs.getConfigValue("scaleX"), (y)* Configs.getConfigValue("scaleY"), broadth*Configs.getConfigValue("scaleX"), length*Configs.getConfigValue("scaleY"));
    }

    @Override
    public void undraw() {
         Graphics g = m.getGraphic().getBufferGraphics();
        g.clearRect((x-broadth/2)* Configs.getConfigValue("scaleX"), (y)* Configs.getConfigValue("scaleY"), broadth*Configs.getConfigValue("scaleX"), length*Configs.getConfigValue("scaleY"));
    
    }

    enum Orientation {

        UP, DOWN, RIGHT, LEFT
    }
    private Orientation or=Orientation.UP;

    public void turnRight() {
        System.out.println("right");
        switch (or) {
            case UP:
                or = Orientation.RIGHT;
                break;
            case RIGHT:
                or = Orientation.DOWN;
                break;
            case DOWN:
                or = Orientation.LEFT;
                break;
            case LEFT:
                or = Orientation.UP;
                break;
        }
    }
    
    public void turnLeft(){
        System.out.println("left");
        switch (or) {
            case UP:
                or = Orientation.LEFT;
                break;
            case LEFT:
                or = Orientation.DOWN;
                break;
            case DOWN:
                or = Orientation.RIGHT;
                break;
            case RIGHT:
                or = Orientation.UP;
                break;
        }
    }

    public Bike(int x,int y,Matrix m) {
        this.m=m;
        this.x=x;
        this.y=y;
        Clock.getInstance().login(this);
    }

    @Override
    public void tick() {
      undraw();
      y--;
      draw();
      Field f=m.getFields()[x][y];
      m.setField(x, y-1+length, new LaserField(x,y+length,m));
      if(f!=null){
      f.collide(this);
      }
      
    }

    void die() {
        Clock.getInstance().logout(this);
        System.out.println("Bike died");
        undraw();
        for(int i=x-broadth/2;i<=x+broadth/2;i++){
            m.getFields()[i][y].draw();
        }
    }

}
