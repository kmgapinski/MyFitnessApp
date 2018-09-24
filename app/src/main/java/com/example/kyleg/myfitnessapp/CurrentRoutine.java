package com.example.kyleg.myfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;
import android.app.ListActivity;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.app.ListActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class CurrentRoutine extends AppCompatActivity implements android.view.View.OnClickListener {

    private Button mainButtonBack, doExercise, exerciseDon;
    TextView exercise_Id, currentWorkoutnameText, estimatedTimeText;

    private int _Exercise_ID = 0;
    int exercise_pointer = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_workout);


        Intent intent = getIntent();
        _Exercise_ID = intent.getIntExtra("exercise_ID", exercise_pointer);
        ExerciseRepo repo = new ExerciseRepo(this);
        Exercise exercise = new Exercise();
        exercise = repo.getExercisebyID(_Exercise_ID);

        //Exit Button
        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(this);

        doExercise = (Button) findViewById(R.id.bt_do_exercise);
        doExercise.setOnClickListener(this);

        exerciseDon = (Button) findViewById(R.id.bt_exercises_done);
        exerciseDon.setOnClickListener(this);

        currentWorkoutnameText = (TextView) findViewById(R.id.current_workout_name_text);
        estimatedTimeText = (TextView) findViewById(R.id.estimated_time_text);

        currentWorkoutnameText.setText(String.valueOf(exercise.name));
        //estimatedTimeText.setText(exercise.time);
    }


    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        _Exercise_ID = intent.getIntExtra("exercise_ID", exercise_pointer);
        ExerciseRepo repo = new ExerciseRepo(this);
        Exercise exercise = new Exercise();
        exercise = repo.getExercisebyID(_Exercise_ID);

        currentWorkoutnameText = (TextView) findViewById(R.id.current_workout_name_text);
        estimatedTimeText = (TextView) findViewById(R.id.estimated_time_text);

        currentWorkoutnameText.setText(String.valueOf(exercise.name));
        estimatedTimeText.setText(String.valueOf(exercise.time));



        if (view == findViewById(R.id.bt_do_exercise)) {
            exercise_pointer++;
        } else if (view == findViewById(R.id.bt_go_back)) {
            finish();
        } else if (view == findViewById(R.id.bt_exercises_done)) {
            finish();
        }

        else {

        }

    }

}
