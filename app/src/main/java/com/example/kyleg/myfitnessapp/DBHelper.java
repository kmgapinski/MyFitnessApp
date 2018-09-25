package com.example.kyleg.myfitnessapp;
// Author Kyle Gapinski, Aaron Fairbanks, Henry Daise
// For CSE 682
// developed for educational purposes

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 4;

    private static final String DATABASE_NAME = "exercise.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_EXERCISE = "CREATE TABLE " + Exercise.TABLE + "("
                +Exercise.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Exercise.KEY_name + " TEXT, "
                +Exercise.KEY_time + " INTEGER, "
                +Exercise.KEY_intensity + " INTEGER, "
                +Exercise.KEY_type + " TEXT,"
                +Exercise.KEY_sets + " INTEGER, "
                +Exercise.KEY_reps + " INTEGER)";

        db.execSQL(CREATE_TABLE_EXERCISE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //drop old table
        db.execSQL("DROP TABLE IF EXISTS " + Exercise.TABLE);

        onCreate(db);
    }
}
