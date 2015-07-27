package tron.highscore;

/**
 *
 * @author Leon
 */
public class ScoreUploadThread extends Thread {
    
    private final GameScore scores;

    public ScoreUploadThread(GameScore scores) {
        this.scores = scores;
        this.start();
    }

    @Override
    public void run() {
        scores.uploadToDB();
    }

}
