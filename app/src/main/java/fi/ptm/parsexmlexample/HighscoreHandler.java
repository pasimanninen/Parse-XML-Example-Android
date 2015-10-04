package fi.ptm.parsexmlexample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by PTM on 04/10/15.
 */
public class HighscoreHandler extends DefaultHandler {
    private Highscores highscores;

    public HighscoreHandler() {
        highscores = new Highscores();
    }

    public Highscores getHighscores() {
        return highscores;
    }

    @Override
    public void startDocument() throws SAXException {}

    @Override
    public void endDocument() throws SAXException {}

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if(localName.equals("highscore")) {
            // extract an attributes
            String name = atts.getValue("name");
            String score = atts.getValue("score");
            highscores.addHighscore(name,score);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {}

    @Override
    public void characters(char ch[], int start, int length) {}

}
