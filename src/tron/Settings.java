package tron;

/**
 *
 * @author Leon
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.TreeSet;
import javax.swing.*;
import tron.graphic.ImageManager;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 18.05.2015
 * @author
 */
public class Settings extends JFrame {

    private JComboBox<String> settings;
    private JTextField input;
    private BufferedImage image = null;
    
    private final JButton confirm;
    private final JButton Back;

    public Settings(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                Configs.resetDefaultConfigPlayers();
                dispose();
                MainMenue.getInstance().setVisible(true);
            }
        });
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

        settings = new JComboBox<>();
        settings.setBounds(75, 300, 300, 25);
        {
            TreeSet<String> sortedConfigKeys = new TreeSet(Configs.getConfigs().keySet());
            sortedConfigKeys.stream().forEach((s) -> {
                settings.addItem(s);
            });
        }
        this.add(settings);

        input = new JTextField();
        input.setBounds(425, 300, 175, 25);
        input.setFont(new Font("Consolas", Font.PLAIN, 12));
        input.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        input.setBackground(Color.WHITE);
        input.setToolTipText("Enter the whished integer");
        this.add(input);

        confirm = new JButton();
        confirm.setBounds(625, 300, 75, 25);
        confirm.setText("Confirm");
        confirm.setMargin(new Insets(2, 2, 2, 2));
        confirm.addActionListener((ActionEvent evt) -> {
            if (!input.getText().equals("")) {
                try {
                    Configs.setConfigValue((String) settings.getSelectedItem(), Integer.parseInt(input.getText()));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter an integer", "ERROR", JOptionPane.PLAIN_MESSAGE, null);
                }
            }
            input.setText("");
        });
        this.add(confirm);

        Back = new JButton();
        Back.setBounds(350, 350, 100, 25);
        Back.setText("Back");
        Back.setMargin(new Insets(2, 2, 2, 2));
        Back.addActionListener((ActionEvent evt) -> {
            Configs.resetDefaultConfigPlayers();
            dispose();
            MainMenue.getInstance().setVisible(true);
        });
        this.add(Back);
        setVisible(true);
    }
}
