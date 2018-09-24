package com.example.kyleg.myfitnessapp;

import android.database.sqlite.SQLiteDatabase;

public class Exercise {
    //label table name

    public static final String TABLE = "Exercise";
    //name time intensity type

    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_time = "time";
    public static final String KEY_intensity = "intensity";
    public static final String KEY_type = "type";
    public static final String KEY_sets = "sets";
    public static final String KEY_reps = "reps";

    //helper to keep data
    public int exercise_ID;
    public String name;
    public int time;
    public int intensity;
    public String type;

    public int sets;
    public int reps;



}