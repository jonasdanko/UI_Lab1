package com.danko.jonas.ui_lab1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class TestOneActivity extends AppCompatActivity {

    private TextView textViewQuestionNum;
    private TextView textViewQuestion;
    private RadioButton rb1, rb2, rb3, rb4;
    private RadioGroup radioGroup;
    private Button buttonConfirmAnswer;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCounterTotal;
    private Question currentQuestion;
    private boolean answered;
    private int numCorrect;
    private Results result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewQuestionNum = findViewById(R.id.textViewQuestionNum);
        radioGroup = findViewById(R.id.rbGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        buttonConfirmAnswer = findViewById(R.id.buttonConfirm);

        FakeDB db = new FakeDB();
        questionCounter = 0;
        questionList = db.getQuestions();
        result = new Results(questionList);
        questionCounterTotal = questionList.size();
        //Collections.shuffle(questionList);

        showNextQuestion();
    }

    private void showNextQuestion(){

        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);
        radioGroup.clearCheck();

        if(questionCounter < questionCounterTotal){
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            ++questionCounter;
            textViewQuestionNum.setText("Question: " + questionCounter);
            answered = false;
            buttonConfirmAnswer.setText("Confirm");
            buttonConfirmAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!answered){
                        if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                            checkAnswer();
                        }else{
                            Toast.makeText(TestOneActivity.this, "Please select an answer for the question.", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        showNextQuestion();
                    }
                }
            });
        }
        else{
            finishTest();
        }
    }

    private void checkAnswer(){
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNum = radioGroup.indexOfChild(rbSelected) + 1;
        if(answerNum == currentQuestion.getAnswerNum()){
            ++numCorrect;
            result.markQuestion(true);
        }
        else{
            result.markQuestion(false);
        }
        showSolution(answerNum);
    }

    private void showSolution(int selectedAnswer){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNum()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                if(selectedAnswer == 1){
                    textViewQuestion.setText("Answer A is Correct. Congrats!");
                }else{
                    textViewQuestion.setText("You were incorrect. Answer A is correct");
                }
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                if(selectedAnswer == 2){
                    textViewQuestion.setText("Answer B is Correct. Congrats!");
                }else{
                    textViewQuestion.setText("You were incorrect. Answer B is correct");
                }
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                if(selectedAnswer == 3){
                    textViewQuestion.setText("Answer C is Correct. Congrats!");
                }else{
                    textViewQuestion.setText("You were incorrect. Answer C is correct");
                }
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                if(selectedAnswer == 4){
                    textViewQuestion.setText("Answer D is Correct. Congrats!");
                }else{
                    textViewQuestion.setText("You were incorrect. Answer D is correct");
                }
                break;
        }
        if(questionCounter<questionCounterTotal){
            buttonConfirmAnswer.setText("Next Question");
        }else{
            buttonConfirmAnswer.setText("Finish Test");
        }

    }

    private void finishTest(){
        //result.toConsole();
        viewResult();
    }

    private void viewResult(){
        String grade = String.valueOf(result.toString());
        Intent intent = new Intent(TestOneActivity.this, ResultActivity.class);
        intent.putExtra("GRADE", grade);
        startActivity(intent);
    }

    private void backToMain(){
        Intent intent = new Intent(TestOneActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
