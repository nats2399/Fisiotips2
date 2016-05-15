package com.fisiotips.unisabana.fisiotips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nRamirezP on 5/13/16.
 */
public class DBHandler extends SQLiteOpenHelper {

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

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_EXERCISES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " VARCHAR,"
                + KEY_DESCRP + " VARCHAR" + KEY_DESCRP+" VARCHAR"
                +KEY_TIP+" VARCHAR"+ KEY_IMG+" VARCHAR"+")";
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

    public Exercise traeEjercicio(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_EXERCISES, new String[] { KEY_ID,
                        KEY_NAME, KEY_DESCRP, KEY_DESCRP, KEY_TIP, KEY_IMG },
                        KEY_ID + "=?",
                        new String[]
                                {
                                        String.valueOf(id)
                                },
                        null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        Exercise ejercicio = new Exercise(Integer.parseInt(cursor.getString(0)),
                                            cursor.getString(1),
                                            cursor.getString(2),
                                            cursor.getString(3),
                                            cursor.getString(4));
        return ejercicio;
    }
}
