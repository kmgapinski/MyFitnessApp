package com.example.kyleg.myfitnessapp;

// Author Kyle Gapinski, Aaron Fairbanks, Henry Daise
// For CSE 682
// developed for educational purposes


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private Button currentRoutineLaunchActivity;
    private Button addExerciseLaunchActivity;
    private Button addWorkoutLaunchActivity;
    private Button addRoutineLaunchActivity;
    private Button exitApp;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mydb = new DBHelper(this);

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

        exitApp = (Button) findViewById(R.id.bt_go_back);
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchExitActivity();
            }
        });

    }
    private void launchExitActivity(){
        finish();
    }
    private void launchActivity(){
        Intent intent = new Intent(this, Routine.class);
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
        Intent intent = new Intent(this, routineSelector.class);
        startActivity(intent);
    }
}
