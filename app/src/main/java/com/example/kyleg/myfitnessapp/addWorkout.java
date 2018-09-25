package com.example.kyleg.myfitnessapp;
// Author Kyle Gapinski, Aaron Fairbanks, Henry Daise
// For CSE 682
// developed for educational purposes

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class addWorkout extends AppCompatActivity {

    private Button mainButtonBack;
    private Button editWorkout;
    private Button addNewWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_selector);

        mainButtonBack = (Button) findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editWorkout = (Button) findViewById(R.id.bt_edit_workout);
        editWorkout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchmodifyWorkout();
            }
        });

        addNewWorkout = (Button) findViewById(R.id.bt_new_workout);
        addNewWorkout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchaddNewWorkout();
            }
        });
    }

    private void launchmodifyWorkout(){
        Intent intent = new Intent (this, modifyWorkout.class);
        startActivity(intent);
    }

    private void launchaddNewWorkout(){
        Intent intent = new Intent (this, addWorkout.class);
        startActivity(intent);
    }
}
