package com.example.kyleg.myfitnessapp;
// Author Kyle Gapinski, Aaron Fairbanks, Henry Daise
// For CSE 682
// developed for educational purposes

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class routineSelector extends AppCompatActivity {

    private Button mainButtonBack;
    private Button editRoutine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_selector);

        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        editRoutine = (Button)findViewById(R.id.bt_edit_routine);
        editRoutine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launcheditRoutine();
            }
        });
    }

    private void launcheditRoutine(){
        Intent intent = new Intent(this, editRoutine.class);
        startActivity(intent);
    }
}
