package baasj005.ivmd.flicklist.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jesse on 23-9-2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "flicklist.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_MOVIES = "movies";
    public static final String COLUMN_MOVIE_ID = "movie_id";
    public static final String COLUMN_TITLE = "movie_title";

    private static final String DATABASE_CREATE_MOVIES =
            "CREATE TABLE " + TABLE_MOVIES +
                    "(" +
                    COLUMN_MOVIE_ID + " integer primary key autoincrement, " +
                    COLUMN_TITLE + " text not null" +
                    ");";

    private static final String DATABASE_DROP_MOVIES = "DROP TABLE " + TABLE_MOVIES + ";";

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_MOVIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
