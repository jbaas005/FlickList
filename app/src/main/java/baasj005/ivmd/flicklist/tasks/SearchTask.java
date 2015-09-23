package baasj005.ivmd.flicklist.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import baasj005.ivmd.flicklist.AddMovieActivity;
import baasj005.ivmd.flicklist.models.MovieListItem;

/**
 * Created by Jesse on 23-9-2015.
 */
public class SearchTask extends AsyncTask<String, Void, Void> {

    private AddMovieActivity addMovieActivity;
    private ArrayList<MovieListItem> movies = new ArrayList<>();
    private Gson gson = new Gson();
    private Type type = new TypeToken<ArrayList<MovieListItem>>(){}.getType();

    public SearchTask(AddMovieActivity addMovieActivity){
        this.addMovieActivity = addMovieActivity;
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            URL url = null;
            String response = null;
            url = new URL("http://www.omdbapi.com/?s=" + params[0] + "&type=movie&r=json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String jsonData = readStream(in);
            if(jsonData == null){
                movies.clear();
            }else if(jsonData.charAt(10) == '['){
                jsonData = jsonData.substring(10, jsonData.length()-1);
                movies = gson.fromJson(jsonData, type);
            }
            else{
                MovieListItem movie = gson.fromJson(jsonData, MovieListItem.class);
                movies.clear();
                movies.add(movie);
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        addMovieActivity.updateAdapter(movies);
    }


    private String readStream(InputStream inputStream){
        try {
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while((line = bufferedReader.readLine()) != null)
                result += line;

            inputStream.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
