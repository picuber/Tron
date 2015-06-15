
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

public class MainMenue extends JFrame {

    private final JButton jButton1 = new JButton();
    private final JButton jButton2 = new JButton();
    private final JButton jButton3 = new JButton();
    private final JButton Beenden = new JButton();
    private final JLabel jLabel1 = new JLabel();
    private BufferedImage image = null;

    public MainMenue(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int frameWidth = 800;
        int frameHeight = 600;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(true);
        this.setLayout(null);
        try {
            image = ImageIO.read(new File("Raster.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Startpage.class.getName()).log(Level.SEVERE, null, ex);
        }

        Container c = new Container() {
            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, null);
                super.paint(g);
            }
        };
        c.setBackground(new Color(0, 0, 0, 0));
        this.setContentPane(c);
        
        jButton1.setBounds(300, 200, 150, 35);
        jButton1.setText("Start");
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });
        jButton1.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(jButton1);
        
        jButton2.setBounds(300, 300, 150, 35);
        jButton2.setText("Credits");
        jButton2.setMargin(new Insets(2, 2, 2, 2));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2_ActionPerformed(evt);
            }
        });
        jButton2.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(jButton2);
        
        jButton3.setBounds(300, 250, 150, 35);
        jButton3.setText("Highscore");
        jButton3.setMargin(new Insets(2, 2, 2, 2));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3_ActionPerformed(evt);
            }
        });
        jButton3.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(jButton3);
        
        Beenden.setBounds(300, 350, 150, 35);
        Beenden.setText("Beenden");
        Beenden.setMargin(new Insets(2, 2, 2, 2));
        Beenden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Beenden_ActionPerformed(evt);
            }
        });
        Beenden.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(Beenden);

        jLabel1.setBounds(290, 50, 164, 88);
        jLabel1.setText("TRON");
        jLabel1.setFont(new Font("Consolas", Font.BOLD, 72));
        jLabel1.setForeground(Color.WHITE);
        this.add(jLabel1);

        setVisible(true);
    }

    public void jButton1_ActionPerformed(ActionEvent evt) {

    }

    public void jButton2_ActionPerformed(ActionEvent evt) {

    }

    public void jButton3_ActionPerformed(ActionEvent evt) {

    }

    public void Beenden_ActionPerformed(ActionEvent evt) {

    }

    public void jButton4_ActionPerformed(ActionEvent evt) {

    }

    public static void main(String[] args) {
        new MainMenue("MainMenue");
    }

    protected ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
