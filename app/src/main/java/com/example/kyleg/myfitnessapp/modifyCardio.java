package com.example.kyleg.myfitnessapp;
// Author Kyle Gapinski, Aaron Fairbanks, Henry Daise
// For CSE 682
// developed for educational purposes

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import  android.widget.Toast;

public class modifyCardio extends AppCompatActivity implements android.view.View.OnClickListener {

    private Button mainButtonBack;
    private Button addExercise;
    private Button deleteExercise;

    private int _Exercise_ID = 0;

    EditText editName, editTime, editIntesity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cardio_exercise);

        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(this);

        addExercise = (Button)findViewById(R.id.bt_add_exercise);
        addExercise.setOnClickListener(this);

        // TODO: add delete function
        //deleteExercise = (Button)findViewById(R.id.bt_delete_exercise);
        //deleteExercise.setOnClickListener(this);

        editName = (EditText) findViewById(R.id.name_field);
        editTime = (EditText) findViewById(R.id.time_field);
        editIntesity = (EditText) findViewById(R.id.intensity_field);

        Intent intent = getIntent();
        _Exercise_ID = intent.getIntExtra("exercise_ID", 0);
        ExerciseRepo repo = new ExerciseRepo(this);
        Exercise exercise = new Exercise();
        exercise = repo.getExercisebyID(_Exercise_ID);

        editName.setText(exercise.name);
        editTime.setText(String.valueOf(exercise.time));
        editIntesity.setText(String.valueOf(exercise.intensity));

    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.bt_add_exercise)) {
            ExerciseRepo repo = new ExerciseRepo(this);
            Exercise exercise = new Exercise();
            exercise.name = editName.getText().toString();
            exercise.time = Integer.parseInt(editTime.getText().toString());
            exercise.intensity = Integer.parseInt(editIntesity.getText().toString());
            exercise.type = "Cardio";

            if (_Exercise_ID == 0) {
                _Exercise_ID = repo.insert(exercise);
                Toast.makeText(this, "New Exercise Insert", Toast.LENGTH_SHORT).show();
            } else {
                repo.update(exercise);
                Toast.makeText(this, "Exercise Updated", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view==findViewById(R.id.bt_go_back)){
                finish();
            }
        }

    }

