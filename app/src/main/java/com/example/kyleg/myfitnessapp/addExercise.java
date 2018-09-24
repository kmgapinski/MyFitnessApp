package com.example.kyleg.myfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class addExercise extends AppCompatActivity {

    private Button mainButtonBack;
    private Button modifyCardio;
    private Button modifyWeightlifting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        //Activity to return to main menu
        mainButtonBack = (Button) findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Activity to modify Cardio
        modifyCardio = (Button) findViewById(R.id.bt_modifyCardio_activity);
        modifyCardio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchmodifyCardio();
            }
        });

        //Avtivity to modify weightlifting
        modifyWeightlifting = (Button) findViewById(R.id.bt_modifyWeightlifiting_activity);
        modifyWeightlifting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ launchmodifyWeightlifting();
            }
        });

    }

    private void launchmodifyCardio(){
        Intent intent = new Intent (this, modifyCardio.class);
        startActivity(intent);
    }

    private void launchmodifyWeightlifting(){
        Intent intent = new Intent (this, modifyWeightlifting.class);
        startActivity(intent);
    }
}

