package tron.highscore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fischetobi
 */
class Datenbankverbindung implements HighScoreDB{

    private Connection conn;
    public static Datenbankverbindung dbv = new Datenbankverbindung();

    private Datenbankverbindung() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net/sql484353", "sql484353", "wF4%rD1%");
            System.out.println("Verbindung aufgebaut.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void VerbindungBeenden() {
        try {
            conn.close();
            System.out.println("Verbindung beendet.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insert(int score, String name) {
        try {
            Statement st;
            st = conn.createStatement();
            st.execute("INSERT INTO Highscores (spielername, score) VALUES ('" + name + "', " + score + ");");

        } catch (SQLException ex) {
            Logger.getLogger(Datenbankverbindung.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<HighscoreDef> topten() {
        List<HighscoreDef> topten = new ArrayList<HighscoreDef>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT score, spielername, nummer FROM Highscores ORDER BY score DESC limit 10");

            while (rs.next()) {

                topten.add(new HighscoreDef(rs.getString(2), rs.getInt(1)));
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topten;
    }

    public List<HighscoreDef> topten(String name) {
        List<HighscoreDef> topten = new ArrayList<HighscoreDef>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT score, spielername, nummer FROM Highscores WHERE spielername = '" + name + "' ORDER BY score DESC limit 10");

            while (rs.next()) {

                topten.add(new HighscoreDef(rs.getString(2), rs.getInt(1)));
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return topten;

    }
    public static void main(String[] args) {
        HighScoreDB hsdb=Datenbankverbindung.dbv;
        hsdb.insert(500, "Hans");
    }
}
