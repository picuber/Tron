package tron.highscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author michael
 */
public class HighScoreTestDB implements HighScoreDB {

    List<HighscoreEntry> highscore;

    public HighScoreTestDB() {
        highscore = new ArrayList<>();
        highscore.add(new HighscoreEntry("[1]", 1));
        highscore.add(new HighscoreEntry("[1]", 2));
        highscore.add(new HighscoreEntry("[1]", 4));
        highscore.add(new HighscoreEntry("[2]", 1));
        highscore.add(new HighscoreEntry("[2]", 2));
        highscore.add(new HighscoreEntry("[2]", 4));
        highscore.add(new HighscoreEntry("[3]", 1));
        highscore.add(new HighscoreEntry("[3]", 2));
        highscore.add(new HighscoreEntry("[3]", 4));
    }

    @Override
    public void insert(int score, String name) {
        highscore.add(new HighscoreEntry(name, score));
    }

    @Override
    public List<HighscoreEntry> getTopTen() {
        List<HighscoreEntry> res = new ArrayList<>();
        Collections.sort(highscore);
        int counter = 0;
        for (HighscoreEntry hd : highscore) {
            if (counter++ == 10) {
                break;
            }
            res.add(hd);
        }
        return res;
    }

    @Override
    public List<HighscoreEntry> getTopTen(String name) {
        List<HighscoreEntry> res = new ArrayList<>();
        Collections.sort(highscore);
        int counter = 0;
        for (HighscoreEntry hd : highscore) {
            if (counter++ == 10) {
                break;
            }
            if (hd.getName() == name) {
                res.add(hd);
            }
        }
        return res;
    }

}
