package tron.highscore;

/**
 *
 * @author Leon
 */
public class GameSingleScore {

    private String name;
    private int score;
    private boolean won;

    public GameSingleScore(String name, int Score, boolean won) {
        this.name = name;
        this.score = Score;
        this.won = won;
    }

    public boolean hasWon() {
        return won;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

}
