package alexandre.valin.tpone;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewContact extends AppCompatActivity {

    private ListView mListView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoe"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcontact);
        mListView = (ListView) findViewById(R.id.listView);

        afficherListeNoms();
        //afficherListeTweets();
    }

    private void afficherListeNoms(){


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ViewContact.this, android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }

    private List<Personne> genererTweets(){
        List<Personne> tweets = new ArrayList<Personne>();
        tweets.add(new Personne(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Personne(Color.BLUE, "Kevin", "C'est ici que ca se passe !"));
        tweets.add(new Personne(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Personne(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Personne(Color.GRAY, "Willy", "On y est presque"));
        return tweets;
    }

    private void afficherListeTweets(){
        List<Personne> tweets = genererTweets();

        TweetAdapter adapter = new TweetAdapter(ViewContact.this, tweets);
        mListView.setAdapter(adapter);
    }
}