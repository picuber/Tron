package tron.highscore;

import java.util.List;

/**
 *
 * @author michael
 */
public interface HighScoreDB {

    public void insert(int score, String name);

    public List<HighscoreEntry> getTopTen();

    public List<HighscoreEntry> getTopTen(String name);
}
