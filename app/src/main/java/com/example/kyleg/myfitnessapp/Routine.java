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
// Activity class for routine selection


public class Routine extends AppCompatActivity implements android.view.View.OnClickListener {

    private Button mainButtonBack, doExercise, skipexercise;
    TextView exercise_Id, currentWorkoutnameText, currentWorkoutnext;

    private int _Exercise_ID = 0;
    int exercise_pointer = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_routine);


        Intent intent = getIntent();
        //current routine
        _Exercise_ID = intent.getIntExtra("exercise_ID", exercise_pointer);
        ExerciseRepo repo = new ExerciseRepo(this);
        Exercise exercise = new Exercise();
        exercise = repo.getExercisebyID(_Exercise_ID);

        //next routine
        Exercise exercise_next = new Exercise();
        exercise_next = repo.getExercisebyID(_Exercise_ID+1);
        //Exit Button

        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(this);

        doExercise = (Button) findViewById(R.id.bt_confirm_workout);
        doExercise.setOnClickListener(this);

        skipexercise = (Button) findViewById(R.id.bt_skip_workout);
        skipexercise.setOnClickListener(this);

        currentWorkoutnameText = (TextView) findViewById(R.id.current_routine_name_text);
        currentWorkoutnext = (TextView) findViewById(R.id.next_workout_name_text);

        currentWorkoutnameText.setText(String.valueOf(exercise.name));
        currentWorkoutnext.setText(String.valueOf(exercise_next.name));

    }


    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        _Exercise_ID = intent.getIntExtra("exercise_ID", exercise_pointer);
        ExerciseRepo repo = new ExerciseRepo(this);
        Exercise exercise = new Exercise();
        exercise = repo.getExercisebyID(_Exercise_ID);

        //next routine
        Exercise exercise_next = new Exercise();
        exercise_next = repo.getExercisebyID(_Exercise_ID+1);

        currentWorkoutnameText = (TextView) findViewById(R.id.current_routine_name_text);
        currentWorkoutnext = (TextView) findViewById(R.id.next_workout_name_text);

        currentWorkoutnameText.setText(String.valueOf(exercise.name));
        currentWorkoutnext.setText(String.valueOf(exercise_next.name));


        if (view == findViewById(R.id.bt_confirm_workout)) {
            launchcurrentroutineActivity();
            exercise_pointer++;
        } else if (view == findViewById(R.id.bt_go_back)) {
            finish();
        } else if (view == findViewById(R.id.bt_skip_workout)) {
            exercise_pointer++;
        }
    }

    private void launchcurrentroutineActivity(){
        Intent intent = new Intent(this, CurrentRoutine.class);
        intent.putExtra("Current_Routine", exercise_pointer);
        startActivity(intent);
    }

}
