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
    private final boolean bot;

    public GameSingleScore(String name, int Score, boolean won, boolean bot) {
        this.name = name;
        this.score = Score;
        this.won = won;
        this.bot = bot;
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

    public boolean wasBot() {
        return bot;
    }

    public void uploadToDB() {
        if (wasBot() || uploaded) {
            return;
        }
        DatabaseConnection.getInstance().insert(score, name);
        uploaded = true;
    }
}
