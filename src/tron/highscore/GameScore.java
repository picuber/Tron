package tron.highscore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leon
 */
public class GameScore {

    private List<GameSingleScore> scoreList;

    public GameScore() {
        scoreList = new ArrayList<>();
    }

    public void add(GameSingleScore gss) {
        scoreList.add(gss);
    }

    public List<GameSingleScore> getScoreList() {
        return scoreList;
    }

    @Override
    public String toString() {
        String out = "This game ended with following result:\n";
        for (GameSingleScore gss : scoreList) {
            String ifWon;
            if (gss.hasWon()) {
                ifWon = "won";
            } else {
                ifWon = "lost";
            }
            out += gss.getName() + " " + ifWon + " this game with a score of " + gss.getScore() + "\n";
        }
        out += "-----";
        return out;
    }

}
