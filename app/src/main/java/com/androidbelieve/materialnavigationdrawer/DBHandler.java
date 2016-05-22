package com.androidbelieve.materialnavigationdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by nRamirezP on 5/13/16.
 */
public class DBHandler extends SQLiteOpenHelper {


    private static DBHandler db;
    static Context con;
    static AppCompatActivity maAc;
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Exercises";
    // Contacts table name
    private static final String TABLE_EXERCISES = "ejercicios";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nombre";
    private static final String KEY_DESCRP = "des";
    private static final String KEY_TIP = "tip";
    private static final String KEY_IMG = "img";

    public static synchronized DBHandler getInstance() {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (db == null) {
            db = new DBHandler(con.getApplicationContext());
        }
        return db;
    }

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.con = context;
        //maAc = (AppCompatActivity) context.getApplicationContext();

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_EXERCISES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DESCRP + " TEXT,"
                +KEY_TIP+" TEXT,"+ KEY_IMG+" TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        // Creating tables again
        onCreate(db);
    }
/*
    public void quemado (SQLiteDatabase db)
    {

    }*/

    public void addExcersice (Exercise ejercicio)
    {
        if(traeEjercicio(ejercicio.getId())==null)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(KEY_ID, ejercicio.getId());
            values.put(KEY_NAME, ejercicio.getNombre());
            values.put(KEY_DESCRP, ejercicio.getDes());
            values.put(KEY_TIP, ejercicio.getTip());
            values.put(KEY_IMG, ejercicio.getImg());
            db.insert(TABLE_EXERCISES, null, values);
            db.close();
        }

    }
    public Exercise traeEjercicio(int id)
    {
        Exercise ejercicio = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_EXERCISES, new String[] { KEY_ID,
                        KEY_NAME, KEY_DESCRP,KEY_TIP, KEY_IMG }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        if(cursor.getCount() != 0)
        ejercicio = new Exercise(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
        return ejercicio;
    }

}
