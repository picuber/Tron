package tron;

/**
 *
 * @author Leon
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import tron.graphic.ImageManager;
import tron.highscore.HighScore;

public class MainMenue extends JFrame {

    private BufferedImage image = null;

    private final JButton START = new JButton();
    private final JButton SETTINGS = new JButton();
    private final JButton CREDITS = new JButton();
    private final JButton HIGHSCORE = new JButton();
    private final JButton Beenden = new JButton();
    private final JLabel TRON = new JLabel();

    private static final MainMenue instance = new MainMenue("Tron");

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
        image = (BufferedImage) ImageManager.get("Raster");

        Container c = new Container() {
            @Override
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
        START.addActionListener((ActionEvent evt) -> {
            Startpage.getInstance().setVisible(true);
            setVisible(false);
        });
        START.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(START);

        SETTINGS.setBounds(300, 250, 150, 35);
        SETTINGS.setText("Settings");
        SETTINGS.setMargin(new Insets(2, 2, 2, 2));
        SETTINGS.addActionListener((ActionEvent evt) -> {
            new Settings("Settings");
            setVisible(false);
        });
        SETTINGS.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(SETTINGS);

        HIGHSCORE.setBounds(300, 300, 150, 35);
        HIGHSCORE.setText("Highscore");
        HIGHSCORE.setMargin(new Insets(2, 2, 2, 2));
        HIGHSCORE.addActionListener((ActionEvent evt) -> {
            HighScore.getInstance().setVisible(true);
            setVisible(false);
        });
        HIGHSCORE.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(HIGHSCORE);

        CREDITS.setBounds(300, 350, 150, 35);
        CREDITS.setText("Credits");
        CREDITS.setMargin(new Insets(2, 2, 2, 2));
        CREDITS.addActionListener((ActionEvent evt) -> {
            Credits.getInstance().setVisible(true);
            setVisible(false);
        });
        CREDITS.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(CREDITS);

        Beenden.setBounds(300, 400, 150, 35);
        Beenden.setText("Beenden");
        Beenden.setMargin(new Insets(2, 2, 2, 2));
        Beenden.addActionListener((ActionEvent evt) -> {
            System.exit(0);
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

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {}
                break;
            }
        }

    }
}
