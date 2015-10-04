package fi.ptm.parsexmlexample;

/**
 * Created by PTM on 04/10/15.
 */
public class Highscore {
    private String name;
    private double score;

    public Highscore(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getHighscore() {
        return this.name + " " + this.score;
    }
}
