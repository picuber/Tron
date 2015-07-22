package tron.highscore;

/**
 *
 * @author michael
 */
public class HighscoreEntry implements Comparable<HighscoreEntry> {

    private String name;
    private int score;

    public HighscoreEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(HighscoreEntry o) {
        return (int) Math.signum(score - o.score) * -1;
    }

    @Override
    public String toString() {
        return "HighscoreDef{" + "name=" + name + ", score=" + score + '}';
    }

}
