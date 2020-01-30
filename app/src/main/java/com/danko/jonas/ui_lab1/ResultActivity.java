package com.danko.jonas.ui_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewResultTitle;
    private TextView textViewResults;
    private Button buttonHome;
    private String grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        textViewResultTitle = findViewById(R.id.textViewTitle);
        textViewResults = findViewById(R.id.textViewResult);
        buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        Intent i = this.getIntent();

        grade = (String) i.getSerializableExtra("GRADE");

        Log.d("MyTag", "Results object passed: " + grade);
        displayResults();
    }

    private void displayResults(){
        textViewResultTitle.setText("Results");
        textViewResults.setText(grade);
    }

    private void backToMain(){
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
