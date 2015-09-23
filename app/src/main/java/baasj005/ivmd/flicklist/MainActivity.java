package baasj005.ivmd.flicklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import baasj005.ivmd.flicklist.SQLite.DataSource;
import baasj005.ivmd.flicklist.adapters.MovieList;
import baasj005.ivmd.flicklist.models.MovieListItem;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView emptyView;
    private DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initializeViews();
            dataSource = new DataSource(this);
            ArrayList<MovieListItem> items = (ArrayList<MovieListItem>) dataSource.getAllMovies();
            MovieList movieAdapter = new MovieList(MainActivity.this, items);
            listView.setAdapter(movieAdapter);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initializeViews(){
        listView = (ListView) findViewById(R.id.main_list);
        emptyView = (TextView) findViewById(R.id.main_list_empty);
        listView.setEmptyView(emptyView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_menu_add) {
            startActivityForResult(new Intent(this, AddMovieActivity.class), 1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
