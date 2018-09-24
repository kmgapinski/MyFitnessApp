package com.example.kyleg.myfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class addWorkout extends AppCompatActivity {

    private Button mainButtonBack;
    private Button modifyWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        mainButtonBack = (Button) findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        modifyWorkout = (Button) findViewById(R.id.bt_modifyWorkout_activity);
        modifyWorkout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchmodifyWorkout();
            }
        });
    }

    private void launchmodifyWorkout(){
        Intent intent = new Intent (this, modifyWorkout.class);
        startActivity(intent);
    }
}
