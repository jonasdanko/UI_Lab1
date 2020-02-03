package com.danko.jonas.ui_lab1;

import android.util.Log;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jonas on 1/29/2020.
 */

public class Results implements Serializable{

    private List<Question> questionList;
    private boolean[] correct;
    private int questionNumber;
    private int index;
    private int numCorrect;

    public Results(List<Question> questionList){
        this.questionList = questionList;
        correct = new boolean[questionList.size()];
    }

    public void markQuestion(boolean answer){
        correct[index] = answer;
        ++index;
    }

    public int getGrade(){
        for(boolean i : correct){
            if(i) ++numCorrect;
        }

        return numCorrect;
    }

    public int testSize(){
        return questionList.size();
    }

    public void toConsole(){
        for(int i = 0 ; i<questionList.size() ; ++i){
            Log.d("myTag", "Question: " + questionList.get(i).getQuestion());
        }
    }

    public List<Question> getQuestionList(){
        return questionList;
    }

    public String toString(){
        double s = getGrade();
        double tS = testSize();
        double mark = (s/tS)*100.0;

        return "You have obtained " + (int)s + "/" + (int)tS + ". " + (int)mark +  "%";
    }

}
