package com.example.kyleg.myfitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class ExerciseRepo {
    public DBHelper dbHelper;

    public ExerciseRepo(Context context){
        dbHelper = new DBHelper(context);
    }

    public int insert (Exercise exercise){
        //open content to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Exercise.KEY_name, exercise.name);
        values.put(Exercise.KEY_time, exercise.time);
        values.put(Exercise.KEY_intensity, exercise.intensity);
        values.put(Exercise.KEY_type, exercise.type);
        values.put(Exercise.KEY_sets, exercise.sets);
        values.put(Exercise.KEY_reps, exercise.reps);

        //insert row
        long exercise_Id = db.insert(Exercise.TABLE, null, values);
        db.close();
        return (int) exercise_Id;
    }

    public void delete(int exercise_Id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Exercise.TABLE, Exercise.KEY_ID + "= ?", new String[] {String.valueOf(exercise_Id)});
        db.close();
    }

    public void update(Exercise exercise){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Exercise.KEY_name, exercise.name);
        values.put(Exercise.KEY_time, exercise.time);
        values.put(Exercise.KEY_intensity, exercise.intensity);
        values.put(Exercise.KEY_type, exercise.type);
        values.put(Exercise.KEY_sets, exercise.sets);
        values.put(Exercise.KEY_reps, exercise.reps);

        db.update(Exercise.TABLE, values, Exercise.KEY_ID + "= ?", new String[] {String.valueOf(exercise.exercise_ID)});
        db.close();
    }
    //convert SQL data to arraylist.

    public ArrayList<HashMap<String, String>> getExerciseList(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Exercise.KEY_ID + "," +
                Exercise.KEY_name + "," +
                Exercise.KEY_time + "," +
                Exercise.KEY_intensity + "," +
                Exercise.KEY_type + "," +
                Exercise.KEY_sets + "," +
                Exercise.KEY_reps +
                " FROM " + Exercise.TABLE;

        ArrayList<HashMap<String, String>> exerciseList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                HashMap<String, String> exercise = new HashMap<String, String>();
                exercise.put("id", cursor.getString(cursor.getColumnIndex(Exercise.KEY_ID)));
                exercise.put("name", cursor.getString(cursor.getColumnIndex(Exercise.KEY_name)));
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return exerciseList;
    }

    public Exercise getExercisebyID (int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                Exercise.KEY_ID + "," +
                Exercise.KEY_name + "," +
                Exercise.KEY_time + "," +
                Exercise.KEY_intensity + "," +
                Exercise.KEY_type + "," +
                Exercise.KEY_sets + "," +
                Exercise.KEY_reps +
                " FROM " + Exercise.TABLE
                + " WHERE " +
                Exercise.KEY_ID + "=?";

        int iCount =0;

        Exercise exercise = new Exercise();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(Id)});

        if (cursor.moveToFirst()){
            do{
                exercise.exercise_ID = cursor.getInt(cursor.getColumnIndex(Exercise.KEY_ID));
                exercise.name =cursor.getString(cursor.getColumnIndex(Exercise.KEY_name));
                exercise.time =cursor.getInt(cursor.getColumnIndex(Exercise.KEY_time));
                exercise.intensity =cursor.getInt(cursor.getColumnIndex(Exercise.KEY_name));
                exercise.type =cursor.getString(cursor.getColumnIndex(Exercise.KEY_type));
                exercise.sets =cursor.getInt(cursor.getColumnIndex(Exercise.KEY_sets));
                exercise.reps    =cursor.getInt(cursor.getColumnIndex(Exercise.KEY_reps));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return exercise;

    }
}
