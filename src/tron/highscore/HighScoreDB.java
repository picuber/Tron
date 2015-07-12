package tron.highscore;


import java.util.List;


/**
 *
 * @author michael
 */
public interface HighScoreDB {
    public void insert(int score,String name);
    public List<HighscoreDef> topten();
    public List<HighscoreDef> topten(String name);
}
