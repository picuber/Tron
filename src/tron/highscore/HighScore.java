package tron.highscore;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import tron.MainMenue;
import tron.graphic.ImageManager;

/**
 *
 * @author Leon
 */
public class HighScore extends JFrame {

    private static final HighScore instance = new HighScore();

    private final JTextField playerName = new JTextField();
    private final JLabel[] rank = new JLabel[10];
    private final JLabel[] name = new JLabel[10];
    private final JLabel[] score = new JLabel[10];
    private final JButton Back = new JButton();
    private BufferedImage image = null;

    public static HighScore getInstance() {
        return instance;
    }

    private HighScore() {
        super("Highscores");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                setVisible(false);
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

        List<HighscoreEntry> topten = DatabaseConnection.getInstance().getTopTen();
        for (int i = 0; i < rank.length; i++) {
            rank[i] = new JLabel(i + 1 + ".");
            rank[i].setBounds(225, 200 + i * 25, 25, 25);
            rank[i].setFont(new Font("Consolas", Font.PLAIN, 12));
            rank[i].setOpaque(true);
            rank[i].setBackground(new Color(255, 255, 255));
            this.add(rank[i]);
        }
        for (int i = 0; i < name.length; i++) {
            name[i] = new JLabel(topten.get(i).getName());
            name[i].setBounds(250, 200 + i * 25, 150, 25);
            name[i].setFont(new Font("Consolas", Font.PLAIN, 12));
            name[i].setOpaque(true);
            name[i].setBackground(new Color(224, 224, 224));
            this.add(name[i]);
        }
        for (int i = 0; i < score.length; i++) {
            score[i] = new JLabel(topten.get(i).getScore() + "");
            score[i].setBounds(400, 200 + i * 25, 150, 25);
            score[i].setFont(new Font("Consolas", Font.PLAIN, 12));
            score[i].setOpaque(true);
            score[i].setBackground(new Color(255, 255, 255));
            this.add(score[i]);
        }

        playerName.setBounds(225, 150, 325, 25);
        playerName.addActionListener((ActionEvent e) -> {
            resetText(playerName.getText());
            playerName.setText("");
        });
        this.add(playerName);

        Back.setBounds(350, 475, 100, 25);
        Back.setText("Back");
        Back.setMargin(new Insets(2, 2, 2, 2));
        Back.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            MainMenue.getInstance().setVisible(true);
        });
        this.add(Back);

        setVisible(true);
    }

    private void resetText(String playername) {
        List<HighscoreEntry> topten;
        if (playername == null || playername.equals("")) {
            topten = DatabaseConnection.getInstance().getTopTen();
        } else {
            topten = DatabaseConnection.getInstance().getTopTen(playername);
        }
        for (int i = 0; i < name.length; i++) {
            try {
                name[i].setText(topten.get(i).getName());
            } catch (IndexOutOfBoundsException e) {
                name[i].setText("");
            }
        }
        for (int i = 0; i < score.length; i++) {
            try {
                score[i].setText(topten.get(i).getScore() + "");
            } catch (IndexOutOfBoundsException e) {
                score[i].setText("");
            }
        }
    }
}
