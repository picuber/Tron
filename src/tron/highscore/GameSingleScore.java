package tron.highscore;

/**
 *
 * @author Leon
 */
public class GameSingleScore {

    private boolean uploaded;

    private final String name;
    private final int score;
    private final boolean won;

    public GameSingleScore(String name, int Score, boolean won) {
        this.name = name;
        this.score = Score;
        this.won = won;
        this.uploaded = false;
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

    public boolean isUploaded() {
        return uploaded;
    }

    public void uploadToDB() {
        if (uploaded) {
            return;
        }
        DatabaseConnection.getInstance().insert(score, name);
        uploaded = true;
    }
}
