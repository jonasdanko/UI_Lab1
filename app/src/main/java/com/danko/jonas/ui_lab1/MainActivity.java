package com.danko.jonas.ui_lab1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonStartTestOne;
    private ImageButton buttonSettings;
    private TextView textViewSlogan;
    private boolean settingsChanged;
    private String passingGrade, numQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            passingGrade = bundle.getString("PASSING_GRADE");
            numQuestions = bundle.getString("NUM_QUESTIONS");
        }
        else{
            passingGrade = "50";
            numQuestions = "10";
        }

        textViewSlogan = findViewById(R.id.appSlogan);
        //textViewSlogan.setBackgroundColor(Color.parseColor("#81A4CD"));
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSettings();
            }
        });

        buttonStartTestOne = findViewById(R.id.button_test1);
        buttonStartTestOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTestOne(passingGrade, numQuestions);
            }
        });

        Button buttonStartTestTwo = findViewById(R.id.button_test2);
        buttonStartTestTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTestTwo(passingGrade, numQuestions);
            }
        });


    }

    private void startSettings(){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private void startTestOne(String passingGrade, String numQuestions){
        Intent intent = new Intent(MainActivity.this, TestOneActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("PASSING_GRADE", passingGrade);
        //Log.d("tag", passingGrade);
        bundle.putString("NUM_QUESTIONS", numQuestions);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void startTestTwo(String passingGrade, String numQuestions){
        Intent intent = new Intent(MainActivity.this, TestOneActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("PASSING_GRADE", passingGrade);
        bundle.putString("NUM_QUESTIONS", numQuestions);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
