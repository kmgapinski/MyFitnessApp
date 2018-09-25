package com.example.kyleg.myfitnessapp;
// Author Kyle Gapinski, Aaron Fairbanks, Henry Daise
// For CSE 682
// developed for educational purposes

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class modifyWorkout extends AppCompatActivity {

    private Button mainButtonBack;
    private Button newWorkout;
    private Button addWorkout;
    private Button removeWorkout;

    //TODO: Complete workout modification
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_workout);

        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        newWorkout = (Button)findViewById(R.id.bt_new_workout);
        newWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addWorkout = (Button)findViewById(R.id.bt_add_to_workout);
        addWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        removeWorkout = (Button)findViewById(R.id.bt_remove_from_workout);
        removeWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
