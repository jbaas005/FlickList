package baasj005.ivmd.flicklist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import baasj005.ivmd.flicklist.SQLite.DataSource;
import baasj005.ivmd.flicklist.adapters.MovieList;
import baasj005.ivmd.flicklist.models.MovieListItem;
import baasj005.ivmd.flicklist.tasks.SearchTask;

public class AddMovieActivity extends AppCompatActivity {
    EditText searchField;
    Button searchButton;
    private ListView searchList;
    private final String USER_AGENT = "Mozilla/5.0";
    private MovieList movieAdapter;
    private ArrayList<MovieListItem> movies;
    private TextView emptyView;
    private DataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        initializeViews();
        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    MovieListItem clickedItem = (MovieListItem) parent.getItemAtPosition(position);
                    dataSource.addMovie(clickedItem);
                    startMainActivity();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
                }
            }
        );
    }

    private void startMainActivity(){
        startActivityForResult(new Intent(this, MainActivity.class), 1);
    }

    private void initializeViews(){
        searchField = (EditText) findViewById(R.id.search_text);
        searchButton = (Button) findViewById(R.id.search_button);
        searchList = (ListView) findViewById(R.id.search_list);
        emptyView = (TextView) findViewById(R.id.search_list_empty);
        dataSource = new DataSource(this);
        movies = new ArrayList<MovieListItem>();
        searchList.setEmptyView(emptyView);
    }

    public void searchMovies(View view){
        String searchArg = searchField.getText().toString();
        if(!(TextUtils.isEmpty(searchArg))){
            new SearchTask(this).execute(searchArg);
        }
    }

    public void updateAdapter(ArrayList<MovieListItem> movies){
        movieAdapter = new MovieList(AddMovieActivity.this, movies);
        movieAdapter.setMovies(movies);
        movieAdapter.notifyDataSetChanged();
        searchList.setAdapter(movieAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
