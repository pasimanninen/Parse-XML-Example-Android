package fi.ptm.parsexmlexample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by PTM on 04/10/15.
 */
public class MainActivity extends Activity {

    private Highscores highscores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchDataTask task = new FetchDataTask();
        task.execute("http://ptm.fi/android/highscore.xml");
    }

    class FetchDataTask extends AsyncTask<String, Void, Highscores> {
        Highscores highscores = null;
        @Override
        protected Highscores doInBackground(String... urls) {
            try {
                // get a SAXParser from the SAXParserFactory
                SAXParserFactory spf = SAXParserFactory.newInstance();
                SAXParser sp = spf.newSAXParser();
                // get the XMLReader of the SAXParser we created
                XMLReader xr = sp.getXMLReader();
                // create a new ContentHandler and apply it to the XML-Reader
                HighscoreHandler highscoreHandler = new HighscoreHandler();
                xr.setContentHandler(highscoreHandler);
                // Parse the xml-data from resource
                //xr.parse(new InputSource(getResources().openRawResource(R.raw.highscore)));
                // parse data from internet
                URL url = new URL("http://ptm.fi/android/highscore.xml");
                xr.parse(new InputSource(url.openStream()));
                // parsing has finished
                // highscoreHandler now provides the parsed highscore data
                highscores = highscoreHandler.getHighscores();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return highscores;
        }

        protected void onPostExecute(Highscores highscores) {
            this.highscores = highscores;
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(highscores.getHighScores());
        }
    }

}
