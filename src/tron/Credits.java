package tron;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;
import tron.graphic.ImageManager;

/**
 *
 * @author michael
 */
public class Credits extends javax.swing.JFrame {

    private BufferedImage image = null;
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JButton Back = new JButton();

    private static final Credits instance = new Credits();

    public static Credits getInstance() {
        return instance;
    }

    private Credits() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                setVisible(false);
                MainMenue.getInstance().setVisible(true);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 24));
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("All Honor goes to ...");

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Fr. Seidel, Head of Slaves");

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Max Eichelbaum, Master of 9gag");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Maxi Maier, Superviosr of Goldfish");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Alex Lachner, Executive Cupholder");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Martin Didrich, Assisstant of Assassination");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Leonardo Fuchsloch, Main Producer of Nonsense");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Michael Jungmair, Most Annoying Programmer");

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 18));
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Tobias Fischer, Figurehead");

        Back.setText("Back");
        Back.setMargin(new Insets(2, 2, 2, 2));
        Back.addActionListener((ActionEvent evt) -> {
            setVisible(false);
            MainMenue.getInstance().setVisible(true);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(Back))))
                        .addContainerGap(308, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(Back)
                        .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }
}
