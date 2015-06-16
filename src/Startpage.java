
/**
 *
 * @author Leon
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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

    private final JLabel TRON = new JLabel();
    private final JButton Ok = new JButton();
    private final JTextField NamenEingabeFeld = new JTextField();
    private final JTextField NamenEingabeFeld2 = new JTextField();
    private final JTextField NamenEingabeFeld3 = new JTextField();
    private final JTextField NamenEingabeFeld4 = new JTextField();
    private BufferedImage image = null;
    

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

        Container c = new Container() {
            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, null);
                super.paint(g);
            }
        };
        c.setBackground(new Color(0, 0, 0, 0));
        this.setContentPane(c);

        NamenEingabeFeld.setBounds(25, 300, 150, 25);
        NamenEingabeFeld.setFont(new Font("Consolas", Font.PLAIN, 12));
        NamenEingabeFeld.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        NamenEingabeFeld.setBackground(Color.WHITE);
        NamenEingabeFeld.setToolTipText("Enter your name, program!");
        NamenEingabeFeld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.addPlayer(NamenEingabeFeld.getText(), 1);
            }
        });
        this.add(NamenEingabeFeld);
        
        NamenEingabeFeld2.setBounds(225, 300, 150, 25);
        NamenEingabeFeld2.setFont(new Font("Consolas", Font.PLAIN, 12));
        NamenEingabeFeld2.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        NamenEingabeFeld2.setBackground(Color.WHITE);
        NamenEingabeFeld2.setToolTipText("Enter your name, program!");
        NamenEingabeFeld2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.addPlayer(NamenEingabeFeld2.getText(), 2);
            }
        });
        this.add(NamenEingabeFeld2);
        
        NamenEingabeFeld3.setBounds(425, 300, 150, 25);
        NamenEingabeFeld3.setFont(new Font("Consolas", Font.PLAIN, 12));
        NamenEingabeFeld3.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        NamenEingabeFeld3.setBackground(Color.WHITE);
        NamenEingabeFeld3.setToolTipText("Enter your name, program!");
        NamenEingabeFeld3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.addPlayer(NamenEingabeFeld3.getText(), 3);
            }
        });
        this.add(NamenEingabeFeld3);
        
        NamenEingabeFeld4.setBounds(625, 300, 150, 25);
        NamenEingabeFeld4.setFont(new Font("Consolas", Font.PLAIN, 12));
        NamenEingabeFeld4.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        NamenEingabeFeld4.setBackground(Color.WHITE);
        NamenEingabeFeld4.setToolTipText("Enter your name, program!");
        NamenEingabeFeld4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.addPlayer(NamenEingabeFeld4.getText(), 4);
            }
        });
        this.add(NamenEingabeFeld4);

        Ok.setBounds(360, 352, 75, 25);
        Ok.setText("Ok");
        Ok.setMargin(new Insets(2, 2, 2, 2));
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.addPlayer(NamenEingabeFeld.getText(), 1);
                Configs.addPlayer(NamenEingabeFeld2.getText(), 2);
                Configs.addPlayer(NamenEingabeFeld3.getText(), 3);
                Configs.addPlayer(NamenEingabeFeld4.getText(), 4);
                System.out.println(Arrays.toString(Configs.getPlayerNames()));
            }
        });
        this.add(Ok);

        TRON.setBounds(296, 40, 216, 104);
        TRON.setText("TRON");
        TRON.setFont(new Font("Consolas", Font.BOLD, 72));
        TRON.setForeground(Color.WHITE);
        this.add(TRON);

        setVisible(true);
    }


    public static void main(String[] args) {
        new Startpage("Startseite");
    }
}
