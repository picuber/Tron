
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
import javafx.scene.control.ComboBox;
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
    private final JButton Back = new JButton();
    private final JTextField[] names = new JTextField[4];
    private final JCheckBox[] mode = new JCheckBox[4];
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

        names[0] = new JTextField();
        mode[0] = new JCheckBox("2 Tasten-Steuerung");
        names[1] = new JTextField();
        mode[1] = new JCheckBox("2 Tasten-Steuerung");
        names[2] = new JTextField();
        mode[2] = new JCheckBox("2 Tasten-Steuerung");
        names[3] = new JTextField();
        mode[3] = new JCheckBox("2 Tasten-Steuerung");

        names[0].setBounds(25, 300, 150, 25);
        names[0].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[0].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[0].setBackground(Color.WHITE);
        names[0].setToolTipText("Enter your name, program!");
        names[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.setPlayerName(names[0].getText(), 1);
            }
        });
        this.add(names[0]);

        mode[0].setBounds(25, 275, 150, 25);
        this.add(mode[0]);

        names[1].setBounds(225, 300, 150, 25);
        names[1].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[1].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[1].setBackground(Color.WHITE);
        names[1].setToolTipText("Enter your name, program!");
        names[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.setPlayerName(names[1].getText(), 2);
            }
        });
        this.add(names[1]);

        mode[1].setBounds(225, 275, 150, 25);
        this.add(mode[1]);

        names[2].setBounds(425, 300, 150, 25);
        names[2].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[2].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[2].setBackground(Color.WHITE);
        names[2].setToolTipText("Enter your name, program!");
        names[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.setPlayerName(names[2].getText(), 3);
            }
        });
        this.add(names[2]);

        mode[2].setBounds(425, 275, 150, 25);
        this.add(mode[2]);

        names[3].setBounds(625, 300, 150, 25);
        names[3].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[3].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[3].setBackground(Color.WHITE);
        names[3].setToolTipText("Enter your name, program!");
        names[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.setPlayerName(names[3].getText(), 4);
            }
        });
        this.add(names[3]);

        mode[3].setBounds(625, 275, 150, 25);
        this.add(mode[3]);

        Ok.setBounds(300, 352, 75, 25);
        Ok.setText("Ok");
        Ok.setMargin(new Insets(2, 2, 2, 2));
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Configs.setPlayerName(names[0].getText(), 1);
                Configs.setControlMode(mode[0].isSelected(), 1);
                Configs.setPlayerName(names[1].getText(), 2);
                Configs.setControlMode(mode[1].isSelected(), 2);
                Configs.setPlayerName(names[2].getText(), 3);
                Configs.setControlMode(mode[2].isSelected(), 3);
                Configs.setPlayerName(names[3].getText(), 4);
                Configs.setControlMode(mode[3].isSelected(), 4);
                Tron.getInstance().startGame();
                dispose();
            }
        });
        this.add(Ok);

        Back.setBounds(425, 352, 75, 25);
        Back.setText("Back");
        Back.setMargin(new Insets(2, 2, 2, 2));
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenue.getInstance().setVisible(true);
                dispose();
            }
        });
        this.add(Back);

        TRON.setBounds(320, 50, 160, 90);
        TRON.setText("TRON");
        TRON.setFont(new Font("Consolas", Font.BOLD, 72));
        TRON.setForeground(Color.WHITE);
        this.add(TRON);

        setVisible(true);
    }
}
