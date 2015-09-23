package baasj005.ivmd.flicklist.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baasj005.ivmd.flicklist.models.MovieListItem;

/**
 * Created by Jesse on 23-9-2015.
 */
public class DataSource {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] assignmentAllColumns = { SQLiteHelper.COLUMN_MOVIE_ID, SQLiteHelper.COLUMN_TITLE};

    public DataSource(Context context){
        dbHelper = new SQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
        dbHelper.close();
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public long addMovie(MovieListItem movie) throws SQLException {
        if(!database.isOpen()) {
            open();
        }

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_TITLE, movie.getTitle());
        long insertId = database.insert(SQLiteHelper.TABLE_MOVIES, null, values);

        if(database.isOpen()){
            close();
        }

        return insertId;
    }

    public List<MovieListItem> getAllMovies() throws SQLException {
        if(!database.isOpen()){
            open();
        }

        List<MovieListItem> movies = new ArrayList<MovieListItem>();
        Cursor cursor = database.query(SQLiteHelper.TABLE_MOVIES, assignmentAllColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            MovieListItem movie = cursorToMovie(cursor);
            movies.add(movie);
            cursor.moveToNext();
        }

        cursor.close();

        if(database.isOpen()){
            close();
        }

        return movies;
    }

    private MovieListItem cursorToMovie(Cursor cursor){
        try{
            MovieListItem movie = new MovieListItem();
            movie.setId(cursor.getLong(cursor.getColumnIndexOrThrow(SQLiteHelper.COLUMN_MOVIE_ID)));
            movie.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(SQLiteHelper.COLUMN_TITLE)));
            return movie;
        }catch(CursorIndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
            return null;
        }

    }
}
