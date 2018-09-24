package com.example.kyleg.myfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    private Button currentRoutineLaunchActivity;
    private Button addExerciseLaunchActivity;
    private Button addWorkoutLaunchActivity;
    private Button addRoutineLaunchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity for Add Exercise
        addExerciseLaunchActivity = (Button) findViewById(R.id.bt_addExercise_activity);
        addExerciseLaunchActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchExerciseActivity();
            }
        });

        //Activity for Add Workout
        addWorkoutLaunchActivity = (Button) findViewById(R.id.bt_addWorkout_Activity);

        addWorkoutLaunchActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchWorkoutActivity();
            }
        });

        //Activity for Add Workout
        addRoutineLaunchActivity = (Button) findViewById(R.id.bt_editRoutine_Activity);

        addRoutineLaunchActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchRoutineActivity();
            }
        });


        //Activity for current Routine
        currentRoutineLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);

        currentRoutineLaunchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });

    }

    private void launchActivity(){
        Intent intent = new Intent(this, CurrentRoutine.class);
        startActivity(intent);
    }

    private void launchExerciseActivity(){
        Intent intent = new Intent(this, addExercise.class);
        startActivity(intent);
    }

    private void launchWorkoutActivity(){
        Intent intent = new Intent(this, addWorkout.class);
        startActivity(intent);
    }

    private void launchRoutineActivity(){
        Intent intent = new Intent(this, editRoutine.class);
        startActivity(intent);
    }
}
