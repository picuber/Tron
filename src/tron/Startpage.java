package tron;

/**
 *
 * @author Leon
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import tron.bikes.Bike;
import tron.graphic.ImageManager;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 18.05.2015
 * @author
 */
public class Startpage extends JFrame {

    private static final Startpage instance = new Startpage("Startpage");

    private final JLabel TRON = new JLabel();
    private final JButton Ok = new JButton();
    private final JButton Back = new JButton();
    private final JTextField[] names = new JTextField[4];
    private final JComboBox<PlayerStartConfig.MODE>[] mode = new JComboBox[4];
    private BufferedImage image = null;

    public static Startpage getInstance() {
        return instance;
    }

    private Startpage(String title) {
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
        image = (BufferedImage) ImageManager.get("Background");

        Container c = new Container() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, null);
                super.paint(g);
            }
        };
        c.setBackground(new Color(0, 0, 0, 0));
        this.setContentPane(c);

        names[0] = new JTextField();
        mode[0] = new JComboBox<>();
        names[1] = new JTextField();
        mode[1] = new JComboBox<>();
        names[2] = new JTextField();
        mode[2] = new JComboBox<>();
        names[3] = new JTextField();
        mode[3] = new JComboBox<>();

        names[0].setBounds(25, 300, 150, 25);
        names[0].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[0].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[0].setToolTipText("Enter your name, program!");
        names[0].addActionListener((ActionEvent evt) -> {
            Configs.setPlayerName(names[0].getText(), 1);
        });
        this.add(names[0]);

        mode[0].setBounds(25, 275, 150, 25);
        PlayerStartConfig player0 = Configs.getPlayers()[0];
        mode[0].setBackground(Bike.getColorFromString(player0.getColor()));
        mode[0].setToolTipText("<html>"
                + "TWOKEY: controling your bike with"
                + " left (" + KeyEvent.getKeyText(player0.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player0.getRightcode()) + ")"
                + "<br>"
                + "FOURKEY: controling your bike with"
                + " up (" + KeyEvent.getKeyText(player0.getUpcode()) + ")"
                + " down (" + KeyEvent.getKeyText(player0.getDowncode()) + ")"
                + " left (" + KeyEvent.getKeyText(player0.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player0.getRightcode()) + ")"
                + "<br>"
                + "BOT: the computer drives this bike"
                + "</html>");
        mode[0].addItem(PlayerStartConfig.MODE.TWOKEY);
        mode[0].addItem(PlayerStartConfig.MODE.FOURKEY);
        mode[0].addItem(PlayerStartConfig.MODE.BOT);
        this.add(mode[0]);

        names[1].setBounds(225, 300, 150, 25);
        names[1].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[1].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[1].setToolTipText("Enter your name, program!");
        names[1].addActionListener((ActionEvent evt) -> {
            Configs.setPlayerName(names[1].getText(), 2);
        });
        this.add(names[1]);

        mode[1].setBounds(225, 275, 150, 25);
        PlayerStartConfig player1 = Configs.getPlayers()[1];
        mode[1].setBackground(Bike.getColorFromString(player1.getColor()));
        mode[1].setToolTipText("<html>"
                + "TWOKEY: controling your bike with"
                + " left (" + KeyEvent.getKeyText(player1.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player1.getRightcode()) + ")"
                + "<br>"
                + "FOURKEY: controling your bike with"
                + " up (" + KeyEvent.getKeyText(player1.getUpcode()) + ")"
                + " down (" + KeyEvent.getKeyText(player1.getDowncode()) + ")"
                + " left (" + KeyEvent.getKeyText(player1.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player1.getRightcode()) + ")"
                + "<br>"
                + "BOT: the computer drives this bike"
                + "</html>");
        mode[1].addItem(PlayerStartConfig.MODE.TWOKEY);
        mode[1].addItem(PlayerStartConfig.MODE.FOURKEY);
        mode[1].addItem(PlayerStartConfig.MODE.BOT);
        this.add(mode[1]);

        names[2].setBounds(425, 300, 150, 25);
        names[2].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[2].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[2].setToolTipText("Enter your name, program!");
        names[2].addActionListener((ActionEvent evt) -> {
            Configs.setPlayerName(names[2].getText(), 3);
        });
        this.add(names[2]);

        mode[2].setBounds(425, 275, 150, 25);
        PlayerStartConfig player2 = Configs.getPlayers()[2];
        mode[2].setBackground(Bike.getColorFromString(player2.getColor()));
        mode[2].setToolTipText("<html>"
                + "TWOKEY: controling your bike with"
                + " left (" + KeyEvent.getKeyText(player2.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player2.getRightcode()) + ")"
                + "<br>"
                + "FOURKEY: controling your bike with"
                + " up (" + KeyEvent.getKeyText(player2.getUpcode()) + ")"
                + " down (" + KeyEvent.getKeyText(player2.getDowncode()) + ")"
                + " left (" + KeyEvent.getKeyText(player2.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player2.getRightcode()) + ")"
                + "<br>"
                + "BOT: the computer drives this bike"
                + "</html>");
        mode[2].addItem(PlayerStartConfig.MODE.TWOKEY);
        mode[2].addItem(PlayerStartConfig.MODE.FOURKEY);
        mode[2].addItem(PlayerStartConfig.MODE.BOT);
        this.add(mode[2]);

        names[3].setBounds(625, 300, 150, 25);
        names[3].setFont(new Font("Consolas", Font.PLAIN, 12));
        names[3].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        names[3].setToolTipText("Enter your name, program!");
        names[3].addActionListener((ActionEvent evt) -> {
            Configs.setPlayerName(names[3].getText(), 4);
        });
        this.add(names[3]);

        mode[3].setBounds(625, 275, 150, 25);
        PlayerStartConfig player3 = Configs.getPlayers()[3];
        mode[3].setBackground(Bike.getColorFromString(player3.getColor()));
        mode[3].setToolTipText("<html>"
                + "TWOKEY: controling your bike with"
                + " left (" + KeyEvent.getKeyText(player3.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player3.getRightcode()) + ")"
                + "<br>"
                + "FOURKEY: controling your bike with"
                + " up (" + KeyEvent.getKeyText(player3.getUpcode()) + ")"
                + " down (" + KeyEvent.getKeyText(player3.getDowncode()) + ")"
                + " left (" + KeyEvent.getKeyText(player3.getLeftcode()) + ")"
                + " and right (" + KeyEvent.getKeyText(player3.getRightcode()) + ")"
                + "<br>"
                + "BOT: the computer drives this bike"
                + "</html>");
        mode[3].addItem(PlayerStartConfig.MODE.TWOKEY);
        mode[3].addItem(PlayerStartConfig.MODE.FOURKEY);
        mode[3].addItem(PlayerStartConfig.MODE.BOT);
        this.add(mode[3]);

        Ok.setBounds(300, 352, 75, 25);
        Ok.setText("Ok");
        Ok.setMargin(new Insets(2, 2, 2, 2));
        Ok.addActionListener((ActionEvent evt) -> {
            for (int i = 0; i < 4; i++) {
                Configs.setPlayerName(names[i].getText(), i + 1);
                Configs.setControlMode((PlayerStartConfig.MODE) mode[i].getSelectedItem(), i + 1);
            }
            setVisible(false);
            Tron.getInstance().startGame();
        });
        this.add(Ok);

        Back.setBounds(425, 352, 75, 25);
        Back.setText("Back");
        Back.setMargin(new Insets(2, 2, 2, 2));
        Back.addActionListener((ActionEvent evt) -> {
            MainMenue.getInstance().setVisible(true);
            setVisible(false);
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
