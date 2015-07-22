package tron.highscore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fischetobi
 */
public class DatabaseConnection implements HighScoreDB {

    private Connection conn;

    private static final DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net/sql484353", "sql484353", "wF4%rD1%");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("Unable to connect to the database");
        }
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Disconnected");
        } catch (Exception e) {
            System.out.println("Error while disconnecting");
        }
    }

    @Override
    public void insert(int score, String name) {
        try {
            Statement st;
            st = conn.createStatement();
            st.execute("INSERT INTO Highscores (spielername, score) VALUES ('" + name + "', " + score + ");");
        } catch (Exception ex) {
            System.out.println("Unable to upload scores!\n"
                    + "This game will not appear in the highscores");
        }

    }

    @Override
    public List<HighscoreEntry> getTopTen() {
        List<HighscoreEntry> topten = new ArrayList<>();
        try {
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT score, spielername, nummer FROM Highscores ORDER BY score DESC limit 10")) {
                while (rs.next()) {
                    topten.add(new HighscoreEntry(rs.getString(2), rs.getInt(1)));
                }
            }
        } catch (Exception e) {
            System.out.println("Could not get the TopTen");
        }
        return topten;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<HighscoreEntry> getTopTen(String name) {
        List<HighscoreEntry> topten = new ArrayList<>();
        try {
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT score, spielername, nummer FROM Highscores WHERE spielername = '" + name + "' ORDER BY score DESC limit 10")) {
                while (rs.next()) {
                    topten.add(new HighscoreEntry(rs.getString(2), rs.getInt(1)));
                }
            }
        } catch (Exception e) {
            System.out.println("Could not get the name specific TopTen");
        }
        return topten;

    }

    public static void main(String[] args) throws SQLException {
        try (Statement st = DatabaseConnection.getInstance().conn.createStatement(); ResultSet rs = st.executeQuery("SELECT score, spielername, nummer FROM Highscores ORDER BY score DESC")) {
            while (rs.next()) {
                System.out.println(rs.getString(2) + "|" + rs.getInt(1));
            }
        }
    }
}
