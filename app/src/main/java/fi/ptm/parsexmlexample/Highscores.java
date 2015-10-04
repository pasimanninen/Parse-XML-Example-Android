package fi.ptm.parsexmlexample;

import java.util.ArrayList;

/**
 * Created by PTM on 04/10/15.
 */
public class Highscores {
    // highscores
    private ArrayList<Highscore> highscores;

    // constructor
    public Highscores() {
        highscores = new ArrayList<>();
    }

    // add a new highscore to arraylist
    public void addHighscore(String name, String score) {
        Highscore hs = new Highscore(name,Double.parseDouble(score));
        highscores.add(hs);
    }

    // get all scores in String (to display in textView in this example)
    public String getHighScores() {
        StringBuffer sb = new StringBuffer();
        for (Highscore hs : highscores) {
            sb.append(hs.getHighscore()+"\n");
        }
        return sb.toString();
    }
}
