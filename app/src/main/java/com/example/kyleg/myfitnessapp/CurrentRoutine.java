package com.example.kyleg.myfitnessapp;

import android.support.v7.app.AppCompatActivity;
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
import android.app.ListActivity;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.app.ListActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class CurrentRoutine extends ListActivity implements android.view.View.OnClickListener {

    private Button mainButtonBack, doExercise, exerciseDon;
    TextView exercise_Id;
    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.bt_do_exercise)) {
            finish();
        }
        else if(view == findViewById(R.id.bt_exercises_done)){
            finish();
        }
        else if(view == findViewById(R.id.bt_go_back)){
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_routine);

        //Exit Button
        mainButtonBack = (Button)findViewById(R.id.bt_go_back);
        doExercise = (Button) findViewById(R.id.bt_do_exercise);
        exerciseDon = (Button) findViewById(R.id.bt_exercises_done);

        mainButtonBack.setOnClickListener(this);
        doExercise.setOnClickListener(this);
        exerciseDon.setOnClickListener(this);

    }
}
