
/**
 *
 * @author michael
 */
public class HighscoreDef implements Comparable<HighscoreDef>{
    private String name;
    private int score;
    
    public HighscoreDef(String name, int score){
        this.name=name;
        this.score=score;
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
    public int compareTo(HighscoreDef o) {
        return (int) Math.signum(score-o.score)*-1;
    }

    @Override
    public String toString() {
        return "HighscoreDef{" + "name=" + name + ", score=" + score + '}';
    }
    
    
}
