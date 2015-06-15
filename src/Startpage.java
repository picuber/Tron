
/**
 *
 * @author Leon
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 18.05.2015
 * @author
 */
public class Startpage extends JFrame {

    private final JLabel Background = new JLabel();
    private final JLabel NamenEingeben = new JLabel();
    private final JLabel TRON = new JLabel();
    private final JButton Ok = new JButton();
    private final JTextField NamenEingabeFeld = new JTextField();
    private BufferedImage image=null;

    public Startpage(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int frameWidth = 800;
        int frameHeight = 600;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        this.setLayout(null);
        try {
            image = ImageIO.read(new File("BikeBackground.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Startpage.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        NamenEingabeFeld.setBounds(300, 300, 200, 25);
        NamenEingabeFeld.setFont(new Font("Consolas", Font.PLAIN, 12));
        NamenEingabeFeld.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        NamenEingabeFeld.setBackground(Color.WHITE);
        NamenEingabeFeld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NamenEingabeFeld_ActionPerformed(evt);
            }
        });
          
          Container c=new Container(){
                public void paint( Graphics g ) { 
                    g.drawImage(image, 0, 0, null);
    super.paint(g);
    
  }
          };
         
          
        c.setBackground(new Color(0,0,0,0));
        this.setContentPane(c);
        this.add(NamenEingabeFeld);

        NamenEingeben.setBounds(300, 240, 200, 20);
        NamenEingeben.setText("Enter your name, program!");
        NamenEingeben.setFont(new Font("Consolas", Font.BOLD, 12));
        this.add(NamenEingeben);

        Ok.setBounds(360, 352, 75, 25);
        Ok.setText("Ok");
        Ok.setMargin(new Insets(2, 2, 2, 2));
        TRON.setForeground(Color.WHITE);
        NamenEingeben.setForeground(Color.WHITE);
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Ok_ActionPerformed(evt);
            }
        });
        this.add(Ok);

        TRON.setBounds(296, 40, 216, 104);
        TRON.setText("TRON");
        TRON.setFont(new Font("Consolas", Font.BOLD, 72));
        this.add(TRON);
        
        TRON.setOpaque(true);
        
        setVisible(true);
    }

    public void Ok_ActionPerformed(ActionEvent evt) {
        setVisible(false);
    }

    public void NamenEingabeFeld_ActionPerformed(ActionEvent evt) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Startpage("Startseite");
    }
}
