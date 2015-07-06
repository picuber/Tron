
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author michael
 */
public class HighScoreTestDB implements HighScoreDB {

    List<HighscoreDef> highscore;

    public HighScoreTestDB() {
        highscore = new ArrayList<>();
        highscore.add(new HighscoreDef("[1]", 1));
        highscore.add(new HighscoreDef("[1]", 2));
        highscore.add(new HighscoreDef("[1]", 4));
        highscore.add(new HighscoreDef("[2]", 1));
        highscore.add(new HighscoreDef("[2]", 2));
        highscore.add(new HighscoreDef("[2]", 4));
        highscore.add(new HighscoreDef("[3]", 1));
        highscore.add(new HighscoreDef("[3]", 2));
        highscore.add(new HighscoreDef("[3]", 4));
    }

    @Override
    public void insert(int score, String name) {
        highscore.add(new HighscoreDef(name, score));
    }

    @Override
    public List<HighscoreDef> topten() {
        List<HighscoreDef> res = new ArrayList<>();
        Collections.sort(highscore);
        int counter = 0;
        for (HighscoreDef hd : highscore) {
            if (counter++ == 10) {
                break;
            }
            res.add(hd);
        }
        return res;
    }

    @Override
    public List<HighscoreDef> topten(String name) {
        List<HighscoreDef> res = new ArrayList<>();
        Collections.sort(highscore);
        int counter = 0;
        for (HighscoreDef hd : highscore) {
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
