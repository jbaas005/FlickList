package baasj005.ivmd.flicklist.adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import baasj005.ivmd.flicklist.R;
import baasj005.ivmd.flicklist.models.MovieListItem;

/**
 * Created by Jesse on 17-9-2015.
 */
public class MovieList extends BaseAdapter {
    private final Activity context;
    private ArrayList<MovieListItem> movies;
    private LayoutInflater inflater;

    public MovieList(Activity context, ArrayList<MovieListItem> movies) {
        this.context = context;
        this.movies = movies;
        this.inflater = LayoutInflater.from(context);
    }

    public void setMovies(ArrayList<MovieListItem> movies){
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public MovieListItem getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Bitmap placeHolder = BitmapFactory.decodeResource(context.getResources(), R.drawable.placeholder);
        View rowView = inflater.inflate(R.layout.movie_list, null, true);
        TextView movieTitle = (TextView) rowView.findViewById(R.id.movie_title);
        ImageView moviePoster = (ImageView) rowView.findViewById(R.id.thumbnail);
        MovieListItem rowItem = movies.get(position);
        movieTitle.setText(rowItem.getTitle());
        moviePoster.setImageBitmap(rowItem.getPosterThumbnail() == null ? placeHolder : rowItem.getPosterThumbnail());
        return rowView;
    }
}
