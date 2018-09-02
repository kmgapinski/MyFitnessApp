package com.example.kyleg.myfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;


public class CurrentRoutine extends AppCompatActivity {

    private Button mainButtonBack;
    public int counter;
    Button start_timer;
    TextView timerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_routine);

        start_timer = (Button)findViewById(R.id.bt_start_Exercise);
        timerView=(TextView) findViewById(R.id.exercise_timer); start_timer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(30000,1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timerView.setText(String.valueOf(counter));
                        counter++;
                    }

                    @Override
                    public void onFinish() {
                    timerView.setText("FINISHED!!!");
                    }
                }.start();
            }
        });

        //Exit Button
        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        mainButtonBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}
