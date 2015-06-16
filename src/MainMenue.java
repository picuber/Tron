
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

    private static final MainMenue instance = new MainMenue("Tron");
    private final JButton START = new JButton();
    private final JButton CREDITS = new JButton();
    private final JButton HIGHSCORE = new JButton();
    private final JButton Beenden = new JButton();
    private final JLabel TRON = new JLabel();
    private BufferedImage image = null;

    public static MainMenue getInstance() {
        return instance;
    }

    private MainMenue(String title) {
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

        START.setBounds(300, 200, 150, 35);
        START.setText("Start");
        START.setMargin(new Insets(2, 2, 2, 2));
        START.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new Startpage("Startpage");
                setVisible(false);
            }
        });
        START.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(START);

        CREDITS.setBounds(300, 300, 150, 35);
        CREDITS.setText("Credits");
        CREDITS.setMargin(new Insets(2, 2, 2, 2));
        CREDITS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });
        CREDITS.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(CREDITS);

        HIGHSCORE.setBounds(300, 250, 150, 35);
        HIGHSCORE.setText("Highscore");
        HIGHSCORE.setMargin(new Insets(2, 2, 2, 2));
        HIGHSCORE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });
        HIGHSCORE.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(HIGHSCORE);

        Beenden.setBounds(300, 350, 150, 35);
        Beenden.setText("Beenden");
        Beenden.setMargin(new Insets(2, 2, 2, 2));
        Beenden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        Beenden.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(Beenden);

        TRON.setBounds(290, 50, 164, 88);
        TRON.setText("TRON");
        TRON.setFont(new Font("Consolas", Font.BOLD, 72));
        TRON.setForeground(Color.WHITE);
        this.add(TRON);

        setVisible(true);
    }

    public static void main(String[] args) {
    
    }
}