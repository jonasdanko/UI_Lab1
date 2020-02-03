package com.danko.jonas.ui_lab1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonStartTestOne;
    private ImageButton buttonSettings;
    private TextView textViewSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                startTestOne();
            }
        });

        Button buttonStartTestTwo = findViewById(R.id.button_test2);
        buttonStartTestTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTestTwo();
            }
        });


    }

    private void startSettings(){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private void startTestOne(){
        Intent intent = new Intent(MainActivity.this, TestOneActivity.class);
        startActivity(intent);
    }

    private void startTestTwo(){
        Intent intent = new Intent(MainActivity.this, TestTwoActivity.class);
        startActivity(intent);
    }
}
