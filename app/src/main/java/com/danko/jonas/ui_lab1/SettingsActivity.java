package com.danko.jonas.ui_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonConfirm;
    private RadioGroup radioGroup;
    private RadioButton r1,r2,r3;
    private EditText editTextPassingGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonHome = findViewById(R.id.buttonBackToMain);
        buttonConfirm = findViewById(R.id.buttonSettingsConfirm);
        radioGroup = findViewById(R.id.radioGroup);
        r1 = findViewById(R.id.radioButtonQ1);
        r2 = findViewById(R.id.radioButtonQ2);
        r3 = findViewById(R.id.radioButtonQ3);
        editTextPassingGrade = findViewById(R.id.editTextPassingGrade);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmSettings();
            }
        });
    }

    private void backToMain(){
        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void confirmSettings(){
        if(r1.isChecked() || r2.isChecked() || r3.isChecked()){
            RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
            String numQuestions = rbSelected.getText().toString();
            Log.d("tag", numQuestions);
            //int numQ = Integer.getInteger(numQuestions);

            String passingGrade = editTextPassingGrade.getText().toString();
            //double pG = Double.parseDouble(passingGrade);
            Log.d("tag", passingGrade);
            if(passingGrade.equals("50")){
                backToMain();
            }
            else{
                Toast.makeText(SettingsActivity.this, "Please enter value greater than 50 and less than 100.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(SettingsActivity.this, "Please select an option for number of questions.", Toast.LENGTH_SHORT).show();
        }
    }
}
